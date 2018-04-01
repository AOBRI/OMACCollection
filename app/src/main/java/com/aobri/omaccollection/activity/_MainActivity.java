/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.aobri.omaccollection.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;

import com.aobri.omaccollection.R;

import java.util.Locale;


public class _MainActivity extends AppCompatActivity implements OnClickListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Set the content of the activity to use the activity_main.xml layout file
        setContentView(R.layout.activity_main);

        findViewById(R.id.happy_birthday_card_button).setOnClickListener(this);
        findViewById(R.id.just_because_card_button).setOnClickListener(this);
        findViewById(R.id.cookie_button).setOnClickListener(this);
        findViewById(R.id.just_java_button).setOnClickListener(this);
        findViewById(R.id.court_counter_button).setOnClickListener(this);
        findViewById(R.id.music_player_button).setOnClickListener(this);
        findViewById(R.id.miwok_button).setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.happy_birthday_card_button:
                startHappyBirthdayCardActivity();
                break;
            case R.id.just_because_card_button:
                startJustBecauseCardActivity();
                break;
            case R.id.cookie_button:
                startCookieActivity();
                break;
            case R.id.just_java_button:
                startJustJavaActivity();
                break;
            case R.id.court_counter_button:
                startCourtCounterActivity();
                break;
            case R.id.music_player_button:
                startMusicPlayerActivity();
                break;
            case R.id.miwok_button:
                startMiwokActivity();
                break;
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    private void startHappyBirthdayCardActivity() {
        Intent happyBirthDayCardIntent = new Intent(this, AppHappyBirthdayCardActivity.class);
        startActivity(happyBirthDayCardIntent);
    }

    private void startJustBecauseCardActivity() {
        Intent justBecauseCardIntent = new Intent(this, AppJustBecauseCardActivity.class);
        startActivity(justBecauseCardIntent);
    }

    private void startCookieActivity() {
        Intent cookieIntent = new Intent(this, AppCookieActivity.class);
        startActivity(cookieIntent);
    }

    private void startJustJavaActivity() {
        Intent justJavaIntent = new Intent(this, AppJustJavaActivity.class);
        startActivity(justJavaIntent);
    }

    private void startCourtCounterActivity() {
        Intent courtCounterIntent = new Intent(this, AppCourtCounterActivity.class);
        startActivity(courtCounterIntent);
    }

    private void startMusicPlayerActivity() {
        Intent musicPlayerIntent = new Intent(this, AppMusicPlayerActivity.class);
        startActivity(musicPlayerIntent);
    }

    private void startMiwokActivity() {
        Intent miwokIntent = new Intent(this, AppMiwokActivity.class);
        startActivity(miwokIntent);
    }

}
