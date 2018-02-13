package com.bupc.emath.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.bupc.emath.LessonQuizActivity;
import com.bupc.emath.R;
import com.bupc.emath.adapter.ResultsAdapter;
import com.bupc.emath.datas.DataHolder;
import com.bupc.emath.model.Quiz;

import java.util.List;

/**
 * Created by casjohnpaul on 2/13/2018.
 */

public class PreviewResultFragment extends Fragment implements ResultsAdapter.OnItemClickListener {



    RecyclerView rvResults;

    ResultsAdapter adapter;
    Button btnBackToHome;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_preview_result, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initializeComponents(view);
    }

    private void initializeComponents(View view) {
        List<Quiz> questions = DataHolder.getInstance().getQuestions();
        adapter = new ResultsAdapter(getContext(), questions, this);

        rvResults = view.findViewById(R.id.rvResults);
        rvResults.setLayoutManager(new LinearLayoutManager(getContext()));
        rvResults.setAdapter(adapter);

        btnBackToHome = view.findViewById(R.id.btnBackToHome);
        btnBackToHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((LessonQuizActivity) getActivity()).finish();
            }
        });

    }

    @Override
    public void onItemClick(int position) {

    }
}
