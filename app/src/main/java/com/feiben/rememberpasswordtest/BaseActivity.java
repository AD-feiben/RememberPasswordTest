package com.feiben.rememberpasswordtest;

import android.app.Activity;
import android.os.Bundle;

/**
 * Created by ${FeiBen} on 2016/6/13.
 */
public class BaseActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityCollector.addActivity(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ActivityCollector.removeActivity(this);
    }
}
