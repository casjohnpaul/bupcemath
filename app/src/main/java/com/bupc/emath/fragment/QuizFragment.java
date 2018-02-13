package com.bupc.emath.fragment;

import android.content.Context;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bupc.emath.AppClass;
import com.bupc.emath.LessonQuizActivity;
import com.bupc.emath.R;
import com.bupc.emath.datas.DataHolder;
import com.bupc.emath.model.Quiz;
import com.bupc.emath.utils.Prefs;

/**
 * Created by casjohnpaul on 2/5/2018.
 */

public class QuizFragment extends Fragment implements View.OnClickListener {


    private static final int TIME_LIMIT = 10;

    private View mView;
    private AppClass mAppClass;
    private Context mContext;
    private DataHolder mDataHolder;

    private TextView mScoreText, mTimeText, mQuestion, mOption1, mOption2, mOption3, mOption4;
    private int mScore = 0, mTime = 10, mQuestionCtr = 0;
    private String mAnswer;
    private int imageAnswerIndex = -1;

    private ImageView questionImage, option1Image, option2Image, option3Image;

    private MediaPlayer mCorrectSound, mIncorrectSound;

    private CountDownTimer mTimeCountdown = new CountDownTimer(TIME_LIMIT * 1000, 1000) {
        int secs = 0;

        @Override
        public void onTick(long millisUntilFinished) {
            secs = (int) (millisUntilFinished / 1000);
            mTimeText.setText(secs + "s");
        }

        @Override
        public void onFinish() {
            mTimeText.setText(0 + "s");
            mAppClass.toaster("Time's up!");
            questionDone();
        }
    };



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View mView = inflater.inflate(R.layout.fragment_quiz, container, false);

        Log.e("as", "shdjfhajkdshfjkasdhfjka");

        mAppClass = AppClass.getInstance();
        mContext = mAppClass.getAppContext();
        mDataHolder = DataHolder.getInstance();

        mScoreText = (TextView) mView.findViewById(R.id.score);
        mTimeText = (TextView) mView.findViewById(R.id.time);
        mQuestion = (TextView) mView.findViewById(R.id.question);
        mOption1 = (TextView) mView.findViewById(R.id.option1);
        mOption2 = (TextView) mView.findViewById(R.id.option2);
        mOption3 = (TextView) mView.findViewById(R.id.option3);
        mOption4 = (TextView) mView.findViewById(R.id.option4);

        questionImage = mView.findViewById(R.id.questionImage);
        option1Image = mView.findViewById(R.id.option1Image);
        option2Image = mView.findViewById(R.id.option2Image);
        option3Image = mView.findViewById(R.id.option3Image);

        mScore = Prefs.getScore();
        mScoreText.setText(mScore + "");
        mTimeText.setText(mTime + "s");

        listenersToggle(true);
        updateQuestion();

        mCorrectSound = MediaPlayer.create(mContext, R.raw.correct);
        mIncorrectSound = MediaPlayer.create(mContext, R.raw.incorrect);

        return mView;
    }


    @Override
    public void onClick(View view) {
        questionDone();
        mTimeCountdown.cancel();
//        String selected = ((TextView) view).getText().toString();
        int id = view.getId();
        int answer = -1;
        if (id == R.id.option1Image) {
            answer = 0;
        } else if (id == R.id.option2Image) {
            answer = 1;
        } else if (id == R.id.option3Image) {
            answer = 2;
        }

        if (answer == imageAnswerIndex) {
            view.setBackgroundColor(ContextCompat.getColor(mContext, R.color.Green));
            mScore++;
            mScoreText.setText(mScore + "");
            Prefs.setScore(mScore);
            if (Prefs.isSoundActive())
                mCorrectSound.start();
        } else {
            view.setBackgroundColor(ContextCompat.getColor(mContext, R.color.Red));
            if (Prefs.isSoundActive())
                mIncorrectSound.start();
        }
    }

    private void updateQuestion() {
        mTimeCountdown.start();
        mQuestionCtr = Prefs.getQuestionIndex();
        Quiz question = mDataHolder.getQuestion(mQuestionCtr);

//        mQuestion.setText(question.getQuesionImg());
        questionImage.setBackground(ContextCompat.getDrawable(getContext(), question.getQuesionImg()));
        option1Image.setBackground(ContextCompat.getDrawable(getContext(), question.getOptionImg1()));
        option2Image.setBackground(ContextCompat.getDrawable(getContext(), question.getOptionImg2()));
        option3Image.setBackground(ContextCompat.getDrawable(getContext(), question.getOptionImg3()));


//        mOption1.setText(question.getOption1());
//        mOption2.setText(question.getOption2());
//        mOption3.setText(question.getOption3());
//        mOption4.setText(question.getOption4());
//        mAnswer = question.getAnswer();
        imageAnswerIndex = question.getAnswerImg();

        Prefs.setQuestionIndex(mQuestionCtr + 1);
    }

    private void questionDone() {
        listenersToggle(false);
        if (mQuestionCtr == mDataHolder.getTotalItems() - 1) {
//            jumpTo(new FinishedFragment());
            jumpTo(LessonQuizActivity.FINISHED_FRAGMENT);
        } else {
            ((LessonQuizActivity) getActivity()).displayView(new QuizFragment());
        }
    }

    private void listenersToggle(boolean on) {
        if (on) {
            mOption1.setOnClickListener(this);
            mOption2.setOnClickListener(this);
            mOption3.setOnClickListener(this);
            mOption4.setOnClickListener(this);

            option1Image.setOnClickListener(this);
            option2Image.setOnClickListener(this);
            option3Image.setOnClickListener(this);
        } else {
            mOption1.setClickable(false);
            mOption2.setClickable(false);
            mOption3.setClickable(false);
            mOption4.setClickable(false);

            option1Image.setClickable(false);
            option2Image.setClickable(false);
            option3Image.setClickable(false);
        }
    }

    private void jumpTo(final int fragment) {
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                ((LessonQuizActivity) getActivity()).displayView(fragment);
            }
        }, 1500);
    }

}
