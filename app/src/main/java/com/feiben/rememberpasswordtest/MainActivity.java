package com.feiben.rememberpasswordtest;

import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends BaseActivity {

    private Button forceOffline;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_main);

        forceOffline = (Button) findViewById(R.id.force_offline);

    }
}
