package com.aobri.omaccollection.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.widget.ArrayAdapter;

import com.aobri.omaccollection.R;

import java.util.ArrayList;
import java.util.Locale;

/**
 * Class to prepare application configurations and then launch the _MainActivity
 */
public class _LauncherActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        showLocaleAlertDialog();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    private void showLocaleAlertDialog() {

        AlertDialog.Builder builderSingle;
        builderSingle = new AlertDialog.Builder(this, R.style.LocaleDialogTheme);
        builderSingle.setTitle(R.string.select_locale);

        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("English");
        arrayList.add("العربية");

        final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, R.layout.custom_dialog_list_item, arrayList);

        builderSingle.setAdapter(arrayAdapter, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String languageChoice = arrayAdapter.getItem(which);
                assert languageChoice != null;
                switch (languageChoice) {
                    case "English":
                        setApplicationLocale(new Locale("en"));
                        startActivity(new Intent(_LauncherActivity.this, _MainActivity.class));
                        finish();
                        break;
                    case "العربية":
                        setApplicationLocale(new Locale("ar"));
                        startActivity(new Intent(_LauncherActivity.this, _MainActivity.class));
                        finish();
                        break;
                }
            }
        });
        builderSingle.show();
    }

    private void setApplicationLocale(Locale locale) {

        Configuration configuration = getResources().getConfiguration();
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            configuration.setLocale(locale);
        } else {
            configuration.locale = locale;
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            getApplicationContext().createConfigurationContext(configuration);
        } else {
            getApplicationContext().getResources().updateConfiguration(configuration, displayMetrics);
        }
    }

}
