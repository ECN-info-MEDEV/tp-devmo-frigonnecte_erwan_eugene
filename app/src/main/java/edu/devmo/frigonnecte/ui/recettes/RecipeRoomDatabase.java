package edu.devmo.frigonnecte.ui.recettes;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import edu.devmo.frigonnecte.ui.calendrier.TimeSlot;
import edu.devmo.frigonnecte.ui.calendrier.TimeSlotDAO;

@Database(entities = {Recipe.class, TimeSlot.class}, version = 1, exportSchema = false)
public abstract class RecipeRoomDatabase extends RoomDatabase {

    public abstract RecipeDAO recipeDao();
    public abstract TimeSlotDAO timeSlotDao();

    private static volatile RecipeRoomDatabase INSTANCE;
    private static final int NUMBER_OF_THREADS = 4;
    public static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    public static RecipeRoomDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (RecipeRoomDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                                    RecipeRoomDatabase.class, "recipe_database")
                            .addCallback(sRoomDatabaseCallback)
                            .build();
                }
            }
        }
        return INSTANCE;
    }

    private static RoomDatabase.Callback sRoomDatabaseCallback = new RoomDatabase.Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);

            // If you want to keep data through app restarts,
            // comment out the following block
            databaseWriteExecutor.execute(() -> {
                // Populate the database in the background.
                // If you want to start with more words, just add them.
                RecipeDAO dao = INSTANCE.recipeDao();
                dao.deleteAll();

                Recipe recipe = new Recipe("Pâtes bolo");
                dao.insert(recipe);
                recipe = new Recipe("Soupe aux légumes");
                dao.insert(recipe);
            });

            databaseWriteExecutor.execute(() -> {
                // Populate the database in the background.
                // If you want to start with more words, just add them.
                TimeSlotDAO dao = INSTANCE.timeSlotDao();
                dao.deleteAll();

                TimeSlot timeSlot = new TimeSlot("Lundi", "midi", null);
                dao.insert(timeSlot);
                timeSlot = new TimeSlot("Mardi", "midi", null);
                dao.insert(timeSlot);
                timeSlot = new TimeSlot("Mercredi", "midi", "Pâtes bolo");
                dao.insert(timeSlot);
            });
        }
    };

}

