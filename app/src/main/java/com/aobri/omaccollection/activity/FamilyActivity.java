/*
 *
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

public class FamilyActivity extends AppCompatActivity {

    private AudioPlaybackManager mAudioPlaybackManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_word_list);
        setTitle(R.string.miwok_category_family);

        mAudioPlaybackManager = new AudioPlaybackManager(this);
        mAudioPlaybackManager.initialize();

        // Create a list of words
        final ArrayList<Word> familyWords = new ArrayList<>();
        familyWords.add(new Word(getString(R.string.father), "әpә", R.drawable.family_father, R.raw.family_father));
        familyWords.add(new Word(getString(R.string.mother), "әṭa", R.drawable.family_mother, R.raw.family_mother));
        familyWords.add(new Word(getString(R.string.son), "angsi", R.drawable.family_son, R.raw.family_son));
        familyWords.add(new Word(getString(R.string.daughter), "tune", R.drawable.family_daughter, R.raw.family_daughter));
        familyWords.add(new Word(getString(R.string.older_brother), "taachi", R.drawable.family_older_brother, R.raw.family_older_brother));
        familyWords.add(new Word(getString(R.string.younger_brother), "chalitti", R.drawable.family_younger_brother, R.raw.family_younger_brother));
        familyWords.add(new Word(getString(R.string.older_sister), "teṭe", R.drawable.family_older_sister, R.raw.family_older_sister));
        familyWords.add(new Word(getString(R.string.younger_sister), "kolliti", R.drawable.family_younger_sister, R.raw.family_younger_sister));
        familyWords.add(new Word(getString(R.string.grandmother), "ama", R.drawable.family_grandmother, R.raw.family_grandmother));
        familyWords.add(new Word(getString(R.string.grandfather), "paapa", R.drawable.family_grandfather, R.raw.family_grandfather));

        WordAdapter adapter = new WordAdapter(this, familyWords);
        ListView listView = findViewById(R.id.words_list_view);
        listView.setAdapter(adapter);
        listView.setBackgroundResource(R.color.category_family);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                mAudioPlaybackManager.playAudio(familyWords.get(i).getAudioResourceId());
            }
        });

    }

    @Override
    protected void onStop() {
        super.onStop();
        mAudioPlaybackManager.releaseMediaPlayer();
    }
}
