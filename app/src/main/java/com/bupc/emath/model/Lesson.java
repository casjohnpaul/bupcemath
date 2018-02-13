package com.bupc.emath.model;

/**
 * Created by casjohnpaul on 2/5/2018.
 */

public class Lesson {

    private String title;
    private String description;

    public Lesson(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getShortDescription() {
        return new StringBuilder(this.description.substring(0, 50)).append("...").toString();
    }

}
