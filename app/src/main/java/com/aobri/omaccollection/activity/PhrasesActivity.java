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

public class PhrasesActivity extends AppCompatActivity {

    AudioPlaybackManager mAudioPlaybackManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_word_list);

        mAudioPlaybackManager = new AudioPlaybackManager(this);
        mAudioPlaybackManager.initialize();

        // Create a list of words
        final ArrayList<Word> phraseWords = new ArrayList<>();
        phraseWords.add(new Word("Where are you going?", "minto wuksus", R.raw.phrase_where_are_you_going));
        phraseWords.add(new Word("What is your name?", "tinnә oyaase'nә", R.raw.phrase_what_is_your_name));
        phraseWords.add(new Word("My name is...", "oyaaset...", R.raw.phrase_my_name_is));
        phraseWords.add(new Word("How are you feeling?", "michәksәs?", R.raw.phrase_how_are_you_feeling));
        phraseWords.add(new Word("I’m feeling good.", "kuchi achit", R.raw.phrase_im_feeling_good));
        phraseWords.add(new Word("Are you coming?", "әәnәs'aa?", R.raw.phrase_are_you_coming));
        phraseWords.add(new Word("Yes, I’m coming.", "hәә’ әәnәm", R.raw.phrase_yes_im_coming));
        phraseWords.add(new Word("I’m coming.", "әәnәm", R.raw.phrase_im_coming));
        phraseWords.add(new Word("Let’s go.", "yoowutis", R.raw.phrase_lets_go));
        phraseWords.add(new Word("Come here.", "әnni'nem", R.raw.phrase_come_here));

        WordAdapter adapter = new WordAdapter(this, phraseWords);
        ListView listView = findViewById(R.id.words_list_view);
        listView.setAdapter(adapter);
        listView.setBackgroundResource(R.color.category_phrases);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                mAudioPlaybackManager.playAudio(phraseWords.get(i).getAudioResourceId());
            }
        });
    }

    @Override
    protected void onStop() {
        super.onStop();
        mAudioPlaybackManager.releaseMediaPlayer();
    }
}
