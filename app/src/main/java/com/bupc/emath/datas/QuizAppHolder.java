package com.bupc.emath.datas;

import com.bupc.emath.R;
import com.bupc.emath.model.Quiz;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by casjohnpaul on 2/12/2018.
 */

public class QuizAppHolder {

    public static List<Quiz> getLessonOne() {
        List<Quiz> quizzes = new ArrayList<>();

        quizzes.add(new Quiz.Builder().quesionImg(R.drawable.lesson_one_quiz1).explanation(R.drawable.lesson_one_quiz1_explain).optionImg1(R.drawable.lesson_one_a).optionImg2(R.drawable.lesson_one_b).optionImg3(R.drawable.lesson_one_c).answerImg(2).build());
        quizzes.add(new Quiz.Builder().quesionImg(R.drawable.lesson_one_quiz2).explanation(R.drawable.lesson_one_quiz2_explain).optionImg1(R.drawable.lesson_one_a2).optionImg2(R.drawable.lesson_one_b2).optionImg3(R.drawable.lesson_one_c2).answerImg(1).build());
        quizzes.add(new Quiz.Builder().quesionImg(R.drawable.lesson_one_quiz3).explanation(R.drawable.lesson_one_quiz3_explain).optionImg1(R.drawable.lesson_one_a3).optionImg2(R.drawable.lesson_one_b3).optionImg3(R.drawable.lesson_one_c3).answerImg(2).build());
        quizzes.add(new Quiz.Builder().quesionImg(R.drawable.lesson_one_quiz4).explanation(R.drawable.lesson_one_quiz4_explain).optionImg1(R.drawable.lesson_one_a4).optionImg2(R.drawable.lesson_one_b4).optionImg3(R.drawable.lesson_one_c4).answerImg(1).build());
        quizzes.add(new Quiz.Builder().quesionImg(R.drawable.lesson_one_quiz5).explanation(R.drawable.lesson_one_quiz5_explain).optionImg1(R.drawable.lesson_one_a5).optionImg2(R.drawable.lesson_one_b5).optionImg3(R.drawable.lesson_one_c5).answerImg(2).build());
        quizzes.add(new Quiz.Builder().quesionImg(R.drawable.lesson_one_quiz6).explanation(R.drawable.lesson_one_quiz6_explain).optionImg1(R.drawable.lesson_one_a6).optionImg2(R.drawable.lesson_one_b6).optionImg3(R.drawable.lesson_one_c6).answerImg(2).build());
        quizzes.add(new Quiz.Builder().quesionImg(R.drawable.lesson_one_quiz7).explanation(R.drawable.lesson_one_quiz7_explain).optionImg1(R.drawable.lesson_one_a7).optionImg2(R.drawable.lesson_one_b7).optionImg3(R.drawable.lesson_one_c7).answerImg(1).build());

        return quizzes;
    }

    public static List<Quiz> getLessonTwo() {
        List<Quiz> quizzes = new ArrayList<>();

        quizzes.add(new Quiz.Builder().quesionImg(R.drawable.lesson2_q1).explanation(R.drawable.lesson2_b1).optionImg1(R.drawable.lesson2_a1).optionImg2(R.drawable.lesson2_b1).optionImg3(R.drawable.lesson2_c1).answerImg(1).build());
        quizzes.add(new Quiz.Builder().quesionImg(R.drawable.lesson2_q2).explanation(R.drawable.lesson2_c2).optionImg1(R.drawable.lesson2_a2).optionImg2(R.drawable.lesson2_b2).optionImg3(R.drawable.lesson2_c2).answerImg(2).build());
        quizzes.add(new Quiz.Builder().quesionImg(R.drawable.lesson2_q3).explanation(R.drawable.lesson2_a3).optionImg1(R.drawable.lesson2_a3).optionImg2(R.drawable.lesson2_b3).optionImg3(R.drawable.lesson2_c3).answerImg(0).build());
        quizzes.add(new Quiz.Builder().quesionImg(R.drawable.lesson2_q4).explanation(R.drawable.lesson2_a4).optionImg1(R.drawable.lesson2_a4).optionImg2(R.drawable.lesson2_b4).optionImg3(R.drawable.lesson2_c4).answerImg(2).build());
        quizzes.add(new Quiz.Builder().quesionImg(R.drawable.lesson2_q5).explanation(R.drawable.lesson2_a5).optionImg1(R.drawable.lesson2_a5).optionImg2(R.drawable.lesson2_b5).optionImg3(R.drawable.lesson2_c5).answerImg(0).build());


        return quizzes;
    }

}
