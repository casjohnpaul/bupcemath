package com.bupc.emath.utils;

import android.content.Context;
import android.content.SharedPreferences;

import com.bupc.emath.AppClass;


public class Prefs {

    private static final String SHARED_PREFS = "bupc_quiz_prefs";
    private static final String PREFS_SETTINGS_SOUND = "settings_sound";
    private static final String PREFS_QUIZ_DIFFICULTY = "quiz_difficulty";
    private static final String PREFS_QUESTION_INDEX = "question_num";
    private static final String PREFS_TOTAL_ITEMS = "total_items";
    private static final String PREFS_SCORE = "score";

    private static final String PREFS_CURRENT_LESSON = "current_lesson";

    private static final SharedPreferences prefs =
            AppClass.getInstance().getSharedPreferences(SHARED_PREFS, Context.MODE_PRIVATE);
    private static final SharedPreferences.Editor editor = prefs.edit();

    public static void setSoundStatus(boolean active) {
        editor.putBoolean(PREFS_SETTINGS_SOUND, active);
        editor.commit();
    }

    public static boolean isSoundActive() {
        return prefs.getBoolean(PREFS_SETTINGS_SOUND, false);
    }

    public static void setQuestionIndex(int diff) {
        editor.putInt(PREFS_QUESTION_INDEX, diff);
        editor.commit();
    }

    public static int getQuestionIndex() {
        return prefs.getInt(PREFS_QUESTION_INDEX, 0);
    }

    public static void setScore(int score) {
        editor.putInt(PREFS_SCORE, score);
        editor.commit();
    }

    public static void setCurrentLesson(int currentLesson) {
        editor.putInt(PREFS_CURRENT_LESSON, currentLesson);
        editor.commit();
    }

    public static int getCurrentLesson() {
        return prefs.getInt(PREFS_CURRENT_LESSON, 0);
    }

    public static int getScore() {
        return prefs.getInt(PREFS_SCORE, 0);
    }
}
