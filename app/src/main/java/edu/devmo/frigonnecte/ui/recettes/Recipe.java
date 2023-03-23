package edu.devmo.frigonnecte.ui.recettes;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "recipe_table")
public class Recipe {

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "name")
    private String name;

    public Recipe(@NonNull String name) {this.name = name;}

    public String getName(){return this.name;}

    public void setName(String name){this.name = name;}
}
