package com.bupc.emath.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.bupc.emath.LessonQuizActivity;
import com.bupc.emath.R;
import com.bupc.emath.adapter.LessonAdapter;
import com.bupc.emath.model.Lesson;
import com.bupc.emath.utils.Prefs;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by casjohnpaul on 2/5/2018.
 */

public class LessonFragment extends Fragment implements LessonAdapter.OnItemClickListener {


    private RecyclerView rvLessons;
    private LessonAdapter lessonAdapter;

    public static LessonFragment newInstance() {

        Bundle args = new Bundle();

        LessonFragment fragment = new LessonFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_lesson, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initializeComponents(view);
    }

    private void initializeComponents(View view) {
        lessonAdapter = new LessonAdapter(getContext(), dummy(), this);

        rvLessons = view.findViewById(R.id.rvLessons);
        rvLessons.setLayoutManager(new LinearLayoutManager(getContext()));

        rvLessons.setAdapter(lessonAdapter);
    }

    @Override
    public void onItemClick(int position) {
        if (position == 0 || position == 1) {
            Prefs.setCurrentLesson(position + 1);
            ((LessonQuizActivity) getContext()).displayView(LessonQuizActivity.GRADE_LESSON_FRAGMENT);
        } else {
            Toast.makeText(getContext(), "This lesson is not yet available.", Toast.LENGTH_SHORT).show();
        }
    }


    public List<Lesson> dummy() {
        List<Lesson> lessons = new ArrayList<>();

        for (int i = 0; i < 9; i++) {
            lessons.add(new Lesson("Lesson " + (i + 1), "Grade " + (i + 1)));
        }
        return lessons;
    }


}
