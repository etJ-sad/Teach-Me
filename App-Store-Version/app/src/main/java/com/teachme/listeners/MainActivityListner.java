package com.teachme.listeners;

import android.content.Context;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.TextView;

import com.teachme.R;
import com.teachme.database.constant.AppConstant;
import com.teachme.ui.MainActivity;

public class MainActivityListner implements OnItemClickListener {

    private MainActivity mainActivity = null;
    private String selectedItemText = null;

    @Override
    public void onItemClick(AdapterView<?> arg0, View v, int arg2, long arg3) {

        Context mContext = v.getContext();
        this.mainActivity = ((MainActivity) mContext);

        Animation fadeInAnimation = AnimationUtils.loadAnimation(v.getContext(), android.R.anim.fade_in);
        fadeInAnimation.setDuration(10);
        v.startAnimation(fadeInAnimation);

        mainActivity.popupWindow.dismiss();

        selectedItemText = ((TextView) v).getText().toString();
        String selectedItemTag = v.getTag().toString();


        if (selectedItemText.equals(mContext.getString(R.string.content_selector_1).substring(0, mContext.getString(R.string.content_selector_1).length() - 3))) {
            AppConstant.SELECTED_CONTENT = Integer.parseInt(selectedItemTag);
            MainActivity.loadJson();
            mainActivity.mContentSelectorButton.setText(selectedItemText);
        } else if (selectedItemText.equals(mContext.getString(R.string.content_selector_2).substring(0, mContext.getString(R.string.content_selector_2).length() - 3))) {
            AppConstant.SELECTED_CONTENT = Integer.parseInt(selectedItemTag);
            MainActivity.loadJson();
            mainActivity.mContentSelectorButton.setText(selectedItemText);
        }
    }

    private void doIt() {
        MainActivity.loadJson();
        mainActivity.mContentSelectorButton.setText(selectedItemText);
    }

}