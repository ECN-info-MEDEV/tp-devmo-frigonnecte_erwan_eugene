package edu.devmo.frigonnecte.ui.calendrier;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface TimeSlotDAO {
    // allowing the insert of the same word multiple times by passing a
    // conflict resolution strategy
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(TimeSlot recipe);

    @Query("DELETE FROM timeslot_table")
    void deleteAll();

    @Query("SELECT * FROM timeslot_table ORDER BY day ASC")
    LiveData<List<TimeSlot>> getAlphabetizedWords();

}
