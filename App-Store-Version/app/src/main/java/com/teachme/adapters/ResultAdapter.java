package com.teachme.adapters;

import android.app.Activity;
import android.content.Context;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.teachme.R;
import com.teachme.database.constant.AppConstant;
import com.teachme.listeners.ListItemClickListener;
import com.teachme.models.quiz.ResultModel;

import java.util.ArrayList;

public class ResultAdapter extends RecyclerView.Adapter<ResultAdapter.ViewHolder> {

    private Context mContext;
    private Activity mActivity;

    private ArrayList<ResultModel> mItemList;
    private ListItemClickListener mItemClickListener;

    public ResultAdapter(Context mContext, Activity mActivity, ArrayList<ResultModel> mItemList) {
        this.mContext = mContext;
        this.mActivity = mActivity;
        this.mItemList = mItemList;
    }

    public void setItemClickListener(ListItemClickListener itemClickListener) {
        this.mItemClickListener = itemClickListener;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_result, parent, false);
        return new ViewHolder(view, viewType, mItemClickListener);
    }

    @Override
    public int getItemCount() {
        return (null != mItemList ? mItemList.size() : 0);

    }

    @Override
    public void onBindViewHolder(ViewHolder mainHolder, int position) {
        final ResultModel model = mItemList.get(position);

        // setting data over views
        mainHolder.tvQuestion.setText(Html.fromHtml(model.getQuestion()));
        mainHolder.tvCorrectAns.setText(Html.fromHtml(model.getCorrectAns()));

        if (model.isCorrect()) {
            mainHolder.lytAnsContainer.setVisibility(View.GONE);
        } else {
            mainHolder.tvGivenAns.setText(Html.fromHtml(model.getGivenAns()));
        }

        int imgPosition;
        if (model.isSkip()) {
            imgPosition = AppConstant.BUNDLE_KEY_ZERO_INDEX;
        } else if (model.isCorrect()) {
            imgPosition = AppConstant.BUNDLE_KEY_FIRST_INDEX;
        } else {
            imgPosition = AppConstant.BUNDLE_KEY_SECOND_INDEX;
        }

        Glide.with(mContext)
                .load(mContext.getResources().getIdentifier(AppConstant.DIRECTORY + imgPosition, null, mContext.getPackageName()))
                .into(mainHolder.imgAns);

    }

    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private ImageView imgAns;
        private TextView tvQuestion, tvGivenAns, tvCorrectAns;
        private RelativeLayout lytAnsContainer;
        private ListItemClickListener itemClickListener;


        public ViewHolder(View itemView, int viewType, ListItemClickListener itemClickListener) {
            super(itemView);

            this.itemClickListener = itemClickListener;
            // Find all views ids
            imgAns = itemView.findViewById(R.id.ans_icon);
            tvQuestion = itemView.findViewById(R.id.question_text);
            tvGivenAns = itemView.findViewById(R.id.given_ans_text);
            tvCorrectAns = itemView.findViewById(R.id.correct_ans_text);
            lytAnsContainer = itemView.findViewById(R.id.your_ans_container);

            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View view) {
            if (itemClickListener != null) {
                itemClickListener.onItemClick(getLayoutPosition(), view);
            }
        }
    }
}