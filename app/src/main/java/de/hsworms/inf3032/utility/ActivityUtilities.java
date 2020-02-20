package de.hsworms.inf3032.utility;

import android.app.Activity;
import android.content.Intent;

import java.util.ArrayList;

import de.hsworms.inf3032.data.constant.AppConstant;
import de.hsworms.inf3032.models.content.Contents;
import de.hsworms.inf3032.models.content.Item;
import de.hsworms.inf3032.models.quiz.ResultModel;

public class ActivityUtilities {

    private static ActivityUtilities sActivityUtilities = null;

    public static ActivityUtilities getInstance() {
        if (sActivityUtilities == null) {
            sActivityUtilities = new ActivityUtilities();
        }
        return sActivityUtilities;
    }

    public void invokeNewActivity(Activity activity, Class<?> tClass, boolean shouldFinish) {
        Intent intent = new Intent(activity, tClass);
        activity.startActivity(intent);
        if (shouldFinish) {
            activity.finish();
        }
    }

    public void invokeCustomUrlActivity(Activity activity, Class<?> tClass, String pageTitle, String pageUrl, boolean shouldFinish) {
        Intent intent = new Intent(activity, tClass);
        intent.putExtra(AppConstant.BUNDLE_KEY_TITLE, pageTitle);
        intent.putExtra(AppConstant.BUNDLE_KEY_URL, pageUrl);
        activity.startActivity(intent);
        if (shouldFinish) {
            activity.finish();
        }
    }

    public void invokeItemListActiviy(Activity activity, Class<?> tClass, Contents model, boolean shouldFinish) {
        Intent intent = new Intent(activity, tClass);
        intent.putExtra(AppConstant.BUNDLE_KEY_ITEM, model);
        activity.startActivity(intent);
        if (shouldFinish) {
            activity.finish();
        }
    }

    public void invokeDetailsListActiviy(Activity activity, Class<?> tClass, Item model, boolean shouldFinish) {
        Intent intent = new Intent(activity, tClass);
        intent.putExtra(AppConstant.BUNDLE_KEY_ITEM, model);
        activity.startActivity(intent);
        if (shouldFinish) {
            activity.finish();
        }
    }

    public void invokeDetailsActiviy(Activity activity, Class<?> tClass, int position, ArrayList<String> itemList, boolean shouldFinish) {
        Intent intent = new Intent(activity, tClass);
        intent.putExtra(AppConstant.BUNDLE_KEY_INDEX, position);
        intent.putExtra(AppConstant.BUNDLE_KEY_ITEM, itemList);
        activity.startActivity(intent);
        if (shouldFinish) {
            activity.finish();
        }
    }

    public void invokeScoreCardActivity(Activity activity, Class<?> tClass, int score, int wrongAns, int skip, ArrayList<ResultModel> resultList, boolean shouldFinish) {
        Intent intent = new Intent(activity, tClass);
        intent.putExtra(AppConstant.BUNDLE_KEY_SCORE, score);
        intent.putExtra(AppConstant.BUNDLE_KEY_WRONG_ANS, wrongAns);
        intent.putExtra(AppConstant.BUNDLE_KEY_SKIP, skip);
        intent.putParcelableArrayListExtra(AppConstant.BUNDLE_KEY_ITEM, resultList);
        activity.startActivity(intent);
        if (shouldFinish) {
            activity.finish();
        }
    }

}
