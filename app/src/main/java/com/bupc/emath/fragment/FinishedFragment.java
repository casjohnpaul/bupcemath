package com.bupc.emath.fragment;

import android.content.Context;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bupc.emath.AppClass;
import com.bupc.emath.LessonQuizActivity;
import com.bupc.emath.MainActivity;
import com.bupc.emath.R;
import com.bupc.emath.datas.DataHolder;
import com.bupc.emath.utils.Prefs;

/**
 * Created by casjohnpaul on 2/13/2018.
 */

public class FinishedFragment extends Fragment {

    private AppClass mAppClass;
    private Context mContext;
    private View mView;

    private TextView mScore, mRemarks, mDone, mShow;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_finished, container, false);
        mAppClass = AppClass.getInstance();
        mContext = mAppClass.getAppContext();

        mScore = (TextView) mView.findViewById(R.id.score);
        mRemarks = (TextView) mView.findViewById(R.id.remarks);
        mDone = (TextView) mView.findViewById(R.id.done);
        mShow = mView.findViewById(R.id.result);

        int score = Prefs.getScore(),
                totalItems = DataHolder.getInstance().getTotalItems();

        mScore.setText(score + "/" + totalItems);

        Double grade = ((double) score / totalItems) * 100;
        Boolean didPass = grade > 60;
        String remark = (didPass) ? "You Passed!" : "You Failed!";
        mRemarks.setText(remark);

        setupSound(didPass);

        mDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((LessonQuizActivity) getActivity()).finish();

            }
        });

        mShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((LessonQuizActivity) getActivity()).displayView(LessonQuizActivity.PREVIEW_FRAGMENT);
            }
        });

        return mView;
    }

    private void setupSound(Boolean didPass) {
        if (!Prefs.isSoundActive())
            return;

        MediaPlayer finishedSound;
        if (didPass)
            finishedSound = MediaPlayer.create(mContext, R.raw.passed);
        else
            finishedSound = MediaPlayer.create(mContext, R.raw.failed);
        finishedSound.start();
    }


}
