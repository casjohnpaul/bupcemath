package com.bupc.emath.adapter;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bupc.emath.R;
import com.bupc.emath.model.Lesson;
import com.bupc.emath.model.Quiz;

import java.util.List;

/**
 * Created by casjohnpaul on 2/13/2018.
 */

public class ResultsAdapter extends RecyclerView.Adapter<ResultsAdapter.ViewHolder> {



    private Context context;

    private List<Quiz> quizzes;
    private LayoutInflater inflater;

    private OnItemClickListener listener;

    public ResultsAdapter(Context context, List<Quiz> quizzes, OnItemClickListener listener) {
        this.context = context;

        this.quizzes = quizzes;
        this.inflater = LayoutInflater.from(context);

        this.listener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View row = inflater.inflate(R.layout.item_result, parent, false);
        return new ViewHolder(row);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Quiz quiz = quizzes.get(position);
        holder.bindData(quiz);
    }

    @Override
    public int getItemCount() {
        return quizzes.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private ImageView ivQuiz, ivAnswer;

        public ViewHolder(View itemView) {
            super(itemView);
            ivQuiz = itemView.findViewById(R.id.ivQuiz);
            ivAnswer = itemView.findViewById(R.id.ivAnswer);

            itemView.setOnClickListener(this);
        }

        public void bindData(Quiz quiz) {
            ivQuiz.setBackground(ContextCompat.getDrawable(context, quiz.getQuesionImg()));
            ivAnswer.setBackground(ContextCompat.getDrawable(context, quiz.getExplanation()));
//            tvTitle.setText(lesson.getTitle());
//            tvDescription.setText(lesson.getDescription());
        }

        @Override
        public void onClick(View view) {
            listener.onItemClick(getAdapterPosition());
        }
    }

    public interface OnItemClickListener {
        void onItemClick(int position);
    }
}
