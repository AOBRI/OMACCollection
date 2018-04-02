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

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.aobri.omaccollection.R;
import com.aobri.omaccollection.helper.AudioPlaybackManager;
import com.aobri.omaccollection.helper.WordAdapter;
import com.aobri.omaccollection.model.Word;

import java.util.ArrayList;

public class NumbersActivity extends AppCompatActivity {

    AudioPlaybackManager mAudioPlaybackManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_word_list);
        setTitle(R.string.miwok_category_numbers);

        mAudioPlaybackManager = new AudioPlaybackManager(this);
        mAudioPlaybackManager.initialize();

        // Create a list of words
        final ArrayList<Word> numberWords = new ArrayList<>();
        numberWords.add(new Word(getString(R.string.one), "lutti", R.drawable.number_one, R.raw.number_one));
        numberWords.add(new Word(getString(R.string.two), "otiiko", R.drawable.number_two, R.raw.number_two));
        numberWords.add(new Word(getString(R.string.three), "tolookosu", R.drawable.number_three, R.raw.number_three));
        numberWords.add(new Word(getString(R.string.four), "oyyisa", R.drawable.number_four, R.raw.number_four));
        numberWords.add(new Word(getString(R.string.five), "massokka", R.drawable.number_five, R.raw.number_five));
        numberWords.add(new Word(getString(R.string.six), "temmokka", R.drawable.number_six, R.raw.number_six));
        numberWords.add(new Word(getString(R.string.seven), "kenekaku", R.drawable.number_seven, R.raw.number_seven));
        numberWords.add(new Word(getString(R.string.eight), "kawinta", R.drawable.number_eight, R.raw.number_eight));
        numberWords.add(new Word(getString(R.string.nine), "wo’e", R.drawable.number_nine, R.raw.number_nine));
        numberWords.add(new Word(getString(R.string.ten), "na’aacha", R.drawable.number_ten, R.raw.number_ten));

        WordAdapter adapter = new WordAdapter(this, numberWords);
        ListView listView = findViewById(R.id.words_list_view);
        listView.setBackgroundResource(R.color.category_numbers);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                mAudioPlaybackManager.playAudio(numberWords.get(i).getAudioResourceId());
            }
        });
    }


    @Override
    protected void onStop() {
        super.onStop();
        mAudioPlaybackManager.releaseMediaPlayer();
    }

}
