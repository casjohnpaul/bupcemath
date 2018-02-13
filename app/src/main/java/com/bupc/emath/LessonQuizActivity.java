package com.bupc.emath;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bupc.emath.fragment.FinishedFragment;
import com.bupc.emath.fragment.GradeLessonFragment;
import com.bupc.emath.fragment.LessonFragment;
import com.bupc.emath.fragment.PreviewResultFragment;
import com.bupc.emath.fragment.QuizFragment;
import com.bupc.emath.utils.Prefs;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by casjohnpaul on 2/5/2018.
 */

public class LessonQuizActivity extends AppCompatActivity {



    public static final int LESSON_FRAGMENT = 0;
    public static final int QUIZ_FRAGMENT = 1;
    public static final int GRADE_LESSON_FRAGMENT = 2;
    public static final int FINISHED_FRAGMENT = 3;
    public static final int PREVIEW_FRAGMENT = 4;

    private TextView tvTitle;
    private ImageView ivBack;

    List<Fragment> fragments = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson_quiz);
        initializeComponents();
    }

    private void initializeComponents() {
        Prefs.setQuestionIndex(0);

        fragments.add(LessonFragment.newInstance());
        fragments.add(new QuizFragment());
        fragments.add(GradeLessonFragment.newInstance());
        fragments.add(new FinishedFragment());
        fragments.add(new PreviewResultFragment());

        tvTitle = findViewById(R.id.tvTitle);
        ivBack = findViewById(R.id.ivBack);

        displayView(LESSON_FRAGMENT);

        ivBack.setVisibility(View.VISIBLE);
        ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }

    public void displayView(int viewIndex) {

        changeTitle(viewIndex);

        Fragment fragment = fragments.get(viewIndex);

        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.setCustomAnimations(R.anim.abc_fade_in, R.anim.abc_fade_out);
        ft.replace(R.id.flLessonQuizContainer, fragment);
        ft.addToBackStack(null);
        ft.commit();
    }
    
    public void changeTitle(int viewType) {
        switch (viewType) {
            case LESSON_FRAGMENT:
                tvTitle.setText("Lessons");
                break;
            case QUIZ_FRAGMENT:
                tvTitle.setText("Quiz");
                break;
        }
    }

    public void displayView(Fragment fragment) {

        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.setCustomAnimations(R.anim.abc_fade_in, R.anim.abc_fade_out);
        ft.replace(R.id.flLessonQuizContainer, fragment);
        ft.addToBackStack(null);
        ft.commit();
    }


}
