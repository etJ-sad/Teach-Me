package de.hsworms.inf3032.engine;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;

import com.google.android.material.navigation.NavigationView;

import de.hsworms.inf3032.R;
import de.hsworms.inf3032.activity.AboutDevActivity;
import de.hsworms.inf3032.activity.CustomUrlActivity;
import de.hsworms.inf3032.activity.FavoriteActivity;
import de.hsworms.inf3032.activity.NotificationListActivity;
import de.hsworms.inf3032.activity.QuestionSelectActivity;
import de.hsworms.inf3032.activity.QuestionsInterviewActivity;
import de.hsworms.inf3032.activity.SettingsActivity;
import de.hsworms.inf3032.data.constant.AppConstant;
import de.hsworms.inf3032.utility.ActivityUtilities;
import de.hsworms.inf3032.utility.AppUtilities;
import de.hsworms.inf3032.utility.DialogUtilities;


public class Provider extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, DialogUtilities.OnCompleteListener {

    private static LinearLayout mLoadingView, mNoDataView;
    private Activity mActivity;
    private Context mContext;
    private Toolbar mToolbar;
    private DrawerLayout mDrawerLayout;
    private NavigationView mNavigationView;

    public static void hideLoader() {
        if (mLoadingView != null) {
            mLoadingView.setVisibility(View.GONE);
        }
        if (mNoDataView != null) {
            mNoDataView.setVisibility(View.GONE);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mActivity = Provider.this;
        mContext = mActivity.getApplicationContext();

    }

    public NavigationView getNavigationView() {
        return mNavigationView;
    }

    public void initDrawer() {

        mDrawerLayout = findViewById(R.id.drawer_layout);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle
                (this, mDrawerLayout, mToolbar, R.string.openDrawer, R.string.closeDrawer) {

            public void onDrawerClosed(View view) {
                super.onDrawerClosed(view);

            }

            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);

            }
        };


        mDrawerLayout.setDrawerListener(toggle);
        toggle.syncState();

        mNavigationView = findViewById(R.id.navigationView);
        mNavigationView.setItemIconTintList(null);
        getNavigationView().setNavigationItemSelectedListener(this);
    }

    public void initToolbar(boolean isTitleEnabled) {
        mToolbar = findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(isTitleEnabled);
    }

    public void setToolbarTitle(String title) {
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(title);
        }
    }

    public void enableUpButton() {
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
    }

    public void initLoader() {
        mLoadingView = findViewById(R.id.loadingView);
        mNoDataView = findViewById(R.id.noDataView);
    }

    public void showLoader() {
        if (mLoadingView != null) {
            mLoadingView.setVisibility(View.VISIBLE);
        }

        if (mNoDataView != null) {
            mNoDataView.setVisibility(View.GONE);
        }
    }

    public void showEmptyView() {
        if (mLoadingView != null) {
            mLoadingView.setVisibility(View.GONE);
        }
        if (mNoDataView != null) {
            mNoDataView.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_questions) {
            ActivityUtilities.getInstance().invokeNewActivity(mActivity, QuestionSelectActivity.class, true);
        } else if (id == R.id.action_interview_questions) {
            ActivityUtilities.getInstance().invokeNewActivity(mActivity, QuestionsInterviewActivity.class, false);
        } else if (id == R.id.action_fav) {
            ActivityUtilities.getInstance().invokeNewActivity(mActivity, FavoriteActivity.class, false);
        } else if (id == R.id.action_settings) {
            ActivityUtilities.getInstance().invokeNewActivity(mActivity, SettingsActivity.class, false);
        } else if (id == R.id.action_about_dev) {
            ActivityUtilities.getInstance().invokeNewActivity(mActivity, AboutDevActivity.class, false);
        } else if (id == R.id.action_share) {
            AppUtilities.shareApp(mActivity);
        } else if (id == R.id.notification) {
            ActivityUtilities.getInstance().invokeNewActivity(mActivity, NotificationListActivity.class, false);
        } else if (id == R.id.action_rate_app) {
            AppUtilities.rateThisApp(mActivity);
        } else if (id == R.id.privacy_policy) {
            ActivityUtilities.getInstance().invokeCustomUrlActivity(mActivity, CustomUrlActivity.class, getResources().getString(R.string.privacy), getResources().getString(R.string.privacy_url), false);
        } else if (id == R.id.action_exit) {
            FragmentManager manager = getSupportFragmentManager();
            DialogUtilities dialog = DialogUtilities.newInstance(getString(R.string.exit), getString(R.string.close_prompt), getString(R.string.yes), getString(R.string.no), AppConstant.BUNDLE_KEY_EXIT_OPTION);
            dialog.show(manager, AppConstant.BUNDLE_KEY_DIALOG_FRAGMENT);
        }

        if (mDrawerLayout != null && mDrawerLayout.isDrawerOpen(GravityCompat.START)) {
            mDrawerLayout.closeDrawer(GravityCompat.START);
        }

        return true;

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override
    public void onComplete(Boolean isOkPressed, String viewIdText) {
        if (isOkPressed) {
            if (viewIdText.equals(AppConstant.BUNDLE_KEY_EXIT_OPTION)) {
                mActivity.finishAffinity();
            }
        }
    }

}