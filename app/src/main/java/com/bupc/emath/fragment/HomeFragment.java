package com.bupc.emath.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.bupc.emath.LessonQuizActivity;
import com.bupc.emath.R;
import com.bupc.emath.utils.Prefs;

/**
 * Created by casjohnpaul on 2/4/2018.
 */

public class HomeFragment extends Fragment {


    private Button btnStartQuiz;

    public static HomeFragment newInstance() {

        Bundle args = new Bundle();

        HomeFragment fragment = new HomeFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initializeComponents(view);
    }

    private void initializeComponents(View view) {
        Prefs.setQuestionIndex(0);
        Prefs.setScore(0);

        btnStartQuiz = view.findViewById(R.id.btnStartQuiz);

        btnStartQuiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getContext(), LessonQuizActivity.class));
            }
        });
    }

}
