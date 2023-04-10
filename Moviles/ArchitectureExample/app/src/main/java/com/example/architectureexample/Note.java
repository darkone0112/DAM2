package com.example.architectureexample;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;
//SQL lite declaration
@Entity(tableName = "note_table")
public class Note {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String title;
    private String description;
    private int priority;
    //Constructor
    public Note(int id, String title, String description, int priority) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.priority = priority;
    }
    //getters
    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public int getPriority() {
        return priority;
    }
    //setters
    public void setId(int id) {
        this.id = id;
    }
}
/*
“Adding Components” page with dependencies & instructions:
https://developer.android.com/topic/l...

CardView & Design Support Library dependencies:
https://developer.android.com/topic/l...
https://developer.android.com/topic/l...

Example code for this part:
https://gist.github.com/codinginflow/...

AndroidX refactoring table:
https://developer.android.com/topic/l...

Entity documentation:
https://developer.android.com/trainin...
*/
