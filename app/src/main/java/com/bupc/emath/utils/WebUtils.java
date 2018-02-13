package com.bupc.emath.utils;

import com.bupc.emath.datas.WebLesson;

/**
 * Created by casjohnpaul on 2/13/2018.
 */

public class WebUtils {

    public static String getLessonActivity(int lesson) {
        String lessonUrl = "";
        switch (lesson) {
            case 1:
                lessonUrl = WebLesson.URL_LESSON_ONE;
                break;
            case 2:
                lessonUrl = WebLesson.URL_LESSON_TWO;
                break;
            case 3:
                lessonUrl = WebLesson.URL_LESSON_THREE;
                break;
        }

        return lessonUrl;
    }

}
