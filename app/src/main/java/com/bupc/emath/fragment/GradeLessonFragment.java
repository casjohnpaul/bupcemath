package com.bupc.emath.fragment;

import android.content.Context;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

import com.bupc.emath.LessonQuizActivity;
import com.bupc.emath.MainActivity;
import com.bupc.emath.R;
import com.bupc.emath.datas.DataHolder;
import com.bupc.emath.datas.QuizAppHolder;
import com.bupc.emath.datas.WebLesson;
import com.bupc.emath.utils.Prefs;
import com.bupc.emath.utils.WebUtils;

/**
 * Created by casjohnpaul on 2/12/2018.
 */

public class GradeLessonFragment extends Fragment {


    TextView tvLessonTitle;
    WebView webview;


    public static GradeLessonFragment newInstance() {

        Bundle args = new Bundle();

        GradeLessonFragment fragment = new GradeLessonFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_grade_lesson, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initializeComponents(view);
    }

    private void initializeComponents(View view) {
        tvLessonTitle = view.findViewById(R.id.tvLessonTitle);
        tvLessonTitle.setText("Lesson " + String.valueOf(Prefs.getCurrentLesson()));

        webview = view.findViewById(R.id.webview);
        webview.setWebViewClient(new WebClient());
        webview.setWebChromeClient(new WebChromeClient());
        webview.setInitialScale(175);

        WebSettings webviewSettings = webview.getSettings();
        webviewSettings.setJavaScriptEnabled(true);
        webviewSettings.setBuiltInZoomControls(true);
        webviewSettings.setDomStorageEnabled(true);
        webviewSettings.setLoadsImagesAutomatically(true);
        webviewSettings.setJavaScriptCanOpenWindowsAutomatically(true);
        webviewSettings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NORMAL);

        webviewSettings.setLoadWithOverviewMode(true);
        webviewSettings.setUseWideViewPort(true);

        webview.loadUrl(WebUtils.getLessonActivity(Prefs.getCurrentLesson()));
//        webview.loadData(WebLesson.URL_LESSON_ONE, "text/html; charset=utf-8",null);

        view.findViewById(R.id.btnStartQuiz).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startQuiz();
            }
        });
    }

    private void startQuiz() {
        switch (Prefs.getCurrentLesson()) {
            case 1:
                DataHolder.getInstance().setQuestions(QuizAppHolder.getLessonOne());
                break;
            case 2:
                DataHolder.getInstance().setQuestions(QuizAppHolder.getLessonTwo());
                break;
        }

        ((LessonQuizActivity)getActivity()).displayView(LessonQuizActivity.QUIZ_FRAGMENT);
    }


    public class WebClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
    }

}
