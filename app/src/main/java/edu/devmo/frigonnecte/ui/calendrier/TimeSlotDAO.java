package edu.devmo.frigonnecte.ui.calendrier;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import edu.devmo.frigonnecte.ui.recettes.Recipe;

@Dao
public interface TimeSlotDAO {
    // allowing the insert of the same word multiple times by passing a
    // conflict resolution strategy
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(TimeSlot recipe);

    @Query("DELETE FROM timeslot_table")
    void deleteAll();

//    @Query("UPDATE timeslot_table SET recipe = :recipe WHERE day LIKE :day AND time LIKE :time")
//    void updateRecipe(String day, String time, Recipe recipe);

    @Query("SELECT day FROM timeslot_table WHERE day LIKE :day AND time LIKE :time")
    String getWithDayTime(String day, String time);
    @Query("SELECT recipe FROM timeslot_table")
    List<String> getWith();

    @Query("SELECT * FROM timeslot_table ORDER BY day ASC")
    LiveData<List<TimeSlot>> getAlphabetizedWords();

}
