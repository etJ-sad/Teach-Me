package de.hsworms.inf3032.activity;

import android.content.Intent;
import android.os.Bundle;
import android.preference.ListPreference;
import android.preference.PreferenceFragment;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import de.hsworms.inf3032.R;
import de.hsworms.inf3032.data.constant.AppConstant;
import de.hsworms.inf3032.data.preference.AppPreference;
import de.hsworms.inf3032.utility.ActivityUtilities;


public class SettingsActivity extends BaseActivity {

    private Button settingsApplyButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
    }

    private void initView() {
        setContentView(R.layout.activity_settings);

        // replace linear layout by preference screen
        getFragmentManager().beginTransaction().replace(R.id.content, new MyPreferenceFragment()).commit();

        initToolbar(true);
        setToolbarTitle(getString(R.string.settings));
        enableUpButton();
        final String _done = getString(R.string.done);
        settingsApplyButton = findViewById(R.id.settingsApplyButton);
        settingsApplyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (AppPreference.getInstance(AppPreference.mContext).isExperimentalOn() == true ){
                    AppConstant.LAYOUT_MANAGER = true;
                }else{
                    AppConstant.LAYOUT_MANAGER = false;
                }
                AppConstant.DEVICE_LANGUAGE_FLAG = true;
                Toast toast = Toast.makeText(getApplicationContext(),
                        _done, Toast.LENGTH_SHORT); toast.show();
                ActivityUtilities.getInstance().invokeNewActivity(MainActivity.mActivity, MainActivity.class, true);
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public static class MyPreferenceFragment extends PreferenceFragment {
        @Override
        public void onCreate(final Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            addPreferencesFromResource(R.xml.settings_preference);
        }
    }
}