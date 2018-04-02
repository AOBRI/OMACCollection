package com.aobri.omaccollection.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.aobri.omaccollection.R;

public class AppHappyBirthdayCardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_happy_birthday_card);
        setTitle(R.string.app_happy_birthday_card_name);
    }
}
