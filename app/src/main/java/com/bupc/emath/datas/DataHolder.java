package com.bupc.emath.datas;

import com.bupc.emath.model.Quiz;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by casjohnpaul on 2/13/2018.
 */

public class DataHolder {

    private List<Quiz> mQuestions = new ArrayList<>();
    private static final DataHolder mInstance = new DataHolder();

    public static synchronized DataHolder getInstance() {
        return mInstance;
    }

    public void addQuestion(Quiz question) {
        mQuestions.add(question);
    }

    public void addQuestions(List<Quiz> Questions) {
        mQuestions.addAll(Questions);
    }



    public void setQuestions(List<Quiz> Questions) {
        mQuestions.clear();
        addQuestions(Questions);
    }

    public Quiz getQuestion(int index) {
        return mQuestions.get(index);
    }

    public List<Quiz> getQuestions() {
        return mQuestions;
    }

    public int getTotalItems() {
        return mQuestions.size();
    }

}
