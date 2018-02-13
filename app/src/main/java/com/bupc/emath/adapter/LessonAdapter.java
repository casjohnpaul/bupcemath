package com.bupc.emath.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bupc.emath.R;
import com.bupc.emath.model.Lesson;

import java.util.List;

/**
 * Created by casjohnpaul on 2/5/2018.
 */

public class LessonAdapter extends RecyclerView.Adapter<LessonAdapter.ViewHolder> {


    private Context context;

    private List<Lesson> lessons;
    private LayoutInflater inflater;

    private OnItemClickListener listener;

    public LessonAdapter(Context context, List<Lesson> lessons, OnItemClickListener listener) {
        this.context = context;

        this.lessons = lessons;
        this.inflater = LayoutInflater.from(context);

        this.listener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View row = inflater.inflate(R.layout.item_lesson, parent, false);
        return new ViewHolder(row);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Lesson lesson = lessons.get(position);
        holder.bindData(lesson);
    }

    @Override
    public int getItemCount() {
        return lessons.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView tvTitle, tvDescription;

        public ViewHolder(View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tvTitle);
            tvDescription = itemView.findViewById(R.id.tvDescription);

            itemView.setOnClickListener(this);
        }

        public void bindData(Lesson lesson) {
            tvTitle.setText(lesson.getTitle());
            tvDescription.setText(lesson.getDescription());
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
