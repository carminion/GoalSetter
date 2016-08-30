package com.catrops.goals.goalsetter;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;
import android.widget.Button;
import android.util.Log;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d("DEBUG", "OnCreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_main);
        /*
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        */
        Button newGoalButton = (Button)findViewById(R.id.newGoalButton);
        newGoalButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){goToNewGoalActivity();
            }
        });

        Button viewGoalsButton = (Button)findViewById(R.id.viewGoalsButton);
        viewGoalsButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){goToSavedGoalsActivity();
            }
        });
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

    private void goToNewGoalActivity(){
        Intent intent = new Intent(this, NewGoalActivity.class);
        startActivity(intent);
    }

    private void goToSavedGoalsActivity(){
        Intent intent = new Intent(this, SavedGoalsActivity.class);
        startActivity(intent);
    }
}
