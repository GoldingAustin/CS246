package com.cs246.prove05;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static android.widget.Toast.LENGTH_SHORT;
import static android.widget.Toast.makeText;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

    }

    public void makeScripture(View view) {

        EditText chapter = (EditText) findViewById(R.id.chapter);
        EditText book = (EditText) findViewById(R.id.book);
        EditText verse = (EditText) findViewById(R.id.verse);
        String scripture = book.getText().toString().trim() + " " + chapter.getText().toString().trim() + ":" + verse.getText().toString().trim();
        displayScrip(scripture);
    }

    public void displayScrip(String scripture) {
        Intent intent = new Intent(this, DisplayScripture.class);
        intent.putExtra("REFERENCE", scripture);
        Log.d("CREATE", "About to create intent with " + scripture);
        startActivity(intent);
    }


    public void loadScripture(View view) {

        SharedPreferences prefs = getSharedPreferences(getString(R.string.PREFS_NAME), 0);
        if (prefs.contains("Refer")) {
            String def = "";
            String scripture = prefs.getString("Refer", def);
            displayScrip(scripture);
        } else {
            Context context = getApplicationContext();
            CharSequence text = "No Scriptures Saved";

            Toast toast = makeText(context, text, LENGTH_SHORT);
            toast.show();
        }
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
