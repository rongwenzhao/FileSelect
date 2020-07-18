package com.nick.libfileselect.ui;

import android.os.Bundle;

import com.nick.libfileselect.R;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    //private FilePickerFragment mFilePickerFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addFilePickFragment(savedInstanceState);
    }

    private void addFilePickFragment(Bundle savedInstanceState) {
        //添加Fragment应以这种方式,当旋转屏幕和被系统杀掉重启时,才不会出问题
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.fragment_container, FilePickerFragment.newInstance("", ""))
                    //.addToBackStack("fname")
                    .commit();

        }
    }
}