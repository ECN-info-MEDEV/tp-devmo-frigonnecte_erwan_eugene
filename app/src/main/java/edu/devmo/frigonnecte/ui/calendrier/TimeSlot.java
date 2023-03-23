package edu.devmo.frigonnecte.ui.calendrier;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import edu.devmo.frigonnecte.ui.recettes.Recipe;

@Entity(tableName = "timeslot_table")
public class TimeSlot {

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "day")
    private String day;

    @NonNull
    @ColumnInfo(name = "time")
    private String time;

    @ColumnInfo(name = "recipe")
    private String recipe;

    public TimeSlot(@NonNull String day,
                         @NonNull String time,
                         String recipe) {
        this.day = day;
        this.time = time;
        this.recipe = recipe;}

    public String getDay(){return this.day;}
    public String getTime(){return this.time;}
    public String getRecipe(){return this.recipe;}

    public void setDay(String day){this.day = day;}
    public void setTime(String time){this.time = time;}
    public void setRecipe(String recipe){this.recipe = recipe;}
}
