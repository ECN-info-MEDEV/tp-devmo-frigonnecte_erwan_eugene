package edu.devmo.frigonnecte.ui.calendrier;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

import edu.devmo.frigonnecte.ui.recettes.Recipe;

public class TimeSlotViewModel extends AndroidViewModel {
    private static TimeSlotRepository mRepository;

    public TimeSlotViewModel(Application application) {
        super(application);
        mRepository = new TimeSlotRepository(application);
    }

    public static void addRecipeInCalendar(String day, String time, Recipe recipe) {
        mRepository.addRecipeInCalendarDb(day, time, recipe);
    }
    public String getWithDayTime(String day, String time) {
        return mRepository.getWithDayTime(day, time);
    }
}
