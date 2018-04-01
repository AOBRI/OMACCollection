package com.aobri.omaccollection.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.aobri.omaccollection.R;


public class AppCookieActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_cookie);
    }

    /**
     * Called when the cookie should be eaten.
     */
    public void eatCookie(View view) {
        // TODO: Find a reference to the ImageView in the layout. Change the image.
        ImageView imageView = findViewById(R.id.android_cookie_image_view);
        imageView.setImageResource(R.drawable.after_cookie);
        // TODO: Find a reference to the TextView in the layout. Change the text.
        TextView textView = findViewById(R.id.status_text_view);
        textView.setText(R.string.cookie_im_so_full);
    }
}