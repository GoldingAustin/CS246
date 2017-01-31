package com.cs246.prove05;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import static android.widget.Toast.LENGTH_SHORT;
import static android.widget.Toast.makeText;

public class DisplayScripture extends AppCompatActivity {
    private String scripture;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_scripture);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Intent intent = getIntent();
        TextView display = (TextView) findViewById(R.id.scripture);
        scripture = intent.getStringExtra("REFERENCE");
        Log.d("RECEIVED", "Received intent with " + scripture);
        display.setText(scripture);

    }

    public void saveScripture(View view) {

        SharedPreferences prefs = getSharedPreferences(getString(R.string.PREFS_NAME), 0);
        SharedPreferences.Editor editor = prefs.edit();

       editor.putString("Refer", scripture);

        editor.commit();


        Context context = getApplicationContext();
        CharSequence text = "Scripture saved successfully!";

        Toast toast = makeText(context, text, LENGTH_SHORT);
        toast.show();
    }

}
