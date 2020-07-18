package com.nick.libfileselect.ui;

import android.content.Intent;
import android.os.Bundle;

import com.nick.libfileselect.R;

public class LauncherActivity extends BasePermissionActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launcher);
    }

    @Override
    protected void onPermissionSuccess() {
        startActivity(new Intent(LauncherActivity.this, MainActivity.class));
    }
}