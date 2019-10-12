package org.teachme.adapters;

import android.app.Activity;
import android.content.Context;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import org.teachme.R;
import org.teachme.listeners.ListItemClickListener;
import org.teachme.models.content.Contents;

import java.util.ArrayList;
import java.util.Random;

public class ContentAdapter extends RecyclerView.Adapter<ContentAdapter.ViewHolder> {

    private Context mContext;
    private Activity mActivity;

    private ArrayList<Contents> mContentList;
    private ListItemClickListener mItemClickListener;

    public ContentAdapter(Context mContext, Activity mActivity, ArrayList<Contents> mContentList) {
        this.mContext = mContext;
        this.mActivity = mActivity;
        this.mContentList = mContentList;
    }

    public void setItemClickListener(ListItemClickListener mItemClickListener) {
        this.mItemClickListener = mItemClickListener;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_home_recycler, parent, false);
        return new ViewHolder(view, viewType, mItemClickListener);
    }

    @Override
    public int getItemCount() {
        return (null != mContentList ? mContentList.size() : 0);

    }

    @Override
    public void onBindViewHolder(ContentAdapter.ViewHolder mainHolder, int position) {
        final Contents model = mContentList.get(position);

        // setting data over views
        String title = model.getTitle();
        mainHolder.tvTitleText.setText(Html.fromHtml(title));
        mainHolder.tvTitleText.setTextSize(20);


        Random rand = new Random();
        int i = rand.nextInt(7) + 1;


        switch (i) {
            case 1:
                mainHolder.lytContainer.setBackground(ContextCompat.getDrawable(mContext, R.drawable.rectangle_blue));
                break;
            case 2:
                mainHolder.lytContainer.setBackground(ContextCompat.getDrawable(mContext, R.drawable.rectangle_red));
                break;
            case 3:
                mainHolder.lytContainer.setBackground(ContextCompat.getDrawable(mContext, R.drawable.rectangle_orange));
                break;
            case 4:
                mainHolder.lytContainer.setBackground(ContextCompat.getDrawable(mContext, R.drawable.rectangle_purple));
                break;
            case 5:
                mainHolder.lytContainer.setBackground(ContextCompat.getDrawable(mContext, R.drawable.rectangle_green));
                break;
            case 6:
                mainHolder.lytContainer.setBackground(ContextCompat.getDrawable(mContext, R.drawable.rectangle_deep_blue));
                break;
            case 7:
                mainHolder.lytContainer.setBackground(ContextCompat.getDrawable(mContext, R.drawable.rectangle_black));
                break;
            default:
                break;
        }

    }

    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private RelativeLayout lytContainer;
        private TextView tvTitleText;
        private ListItemClickListener itemClickListener;


        public ViewHolder(View itemView, int viewType, ListItemClickListener itemClickListener) {
            super(itemView);

            this.itemClickListener = itemClickListener;
            // Find all views ids
            lytContainer = itemView.findViewById(R.id.lyt_container);
            tvTitleText = itemView.findViewById(R.id.title_text);

            lytContainer.setOnClickListener(this);

        }

        @Override
        public void onClick(View view) {
            if (itemClickListener != null) {
                itemClickListener.onItemClick(getLayoutPosition(), view);
            }
        }
    }
}
