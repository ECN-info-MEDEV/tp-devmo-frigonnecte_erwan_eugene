package edu.devmo.frigonnecte.ui.calendrier;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

import edu.devmo.frigonnecte.ui.recettes.RecipeRoomDatabase;

public class TimeSlotRepository {

    private TimeSlotDAO timeSlotDao;
    private LiveData<List<TimeSlot>> mAllTimeSlots;

    // Note that in order to unit test the WordRepository, you have to remove the Application
    // dependency. This adds complexity and much more code, and this sample is not about testing.
    // See the BasicSample in the android-architecture-components repository at
    // https://github.com/googlesamples
    public TimeSlotRepository(Application application) {
        RecipeRoomDatabase db = RecipeRoomDatabase.getDatabase(application);
        timeSlotDao = db.timeSlotDao();
        mAllTimeSlots = timeSlotDao.getAlphabetizedWords();
    }

    // Room executes all queries on a separate thread.
    // Observed LiveData will notify the observer when the data has changed.
    public LiveData<List<TimeSlot>> getAllRecipes() {
        return mAllTimeSlots;
    }

    // You must call this on a non-UI thread or your app will throw an exception. Room ensures
    // that you're not doing any long running operations on the main thread, blocking the UI.
    public void insert(TimeSlot timeSlot) {
        RecipeRoomDatabase.databaseWriteExecutor.execute(() -> {
            timeSlotDao.insert(timeSlot);
        });
    }
}

