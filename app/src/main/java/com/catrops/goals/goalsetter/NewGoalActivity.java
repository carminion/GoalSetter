package com.catrops.goals.goalsetter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.content.Context;
import android.widget.EditText;

import com.catrops.goals.goalsetter.model.Goal;

import java.util.Random;
import java.util.UUID;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmResults;

//this activity should contain a fragment that defines the action of adding a goal
//database: need to add a new goal to database

public class NewGoalActivity extends AppCompatActivity {

    private Realm goalsDB;
    private RealmConfiguration realmConfig;
    private Button button1to2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_new_goal);
        button1to2 = (Button)findViewById(R.id.button1to2);

        // Create the Realm configuration
        realmConfig = new RealmConfiguration.Builder(this).build();
        // Open the Realm for the UI thread.
        goalsDB = Realm.getInstance(realmConfig);

        //button1to2 = (Button)findViewById(R.id.button1to2);
        button1to2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                goToSecondActivity();
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        goalsDB.close();
    }
    /*
    //@OnClick(button1to2)
    public void onAddClick() {
        goalNameToAdd= "I want to climb Everest";
        goalsDB.beginTransaction();
        Goal goal = goalsDB.createObject(Goal.class);
        goal.setName(goalNameToAdd);
        goalsDB.commitTransaction();
    }
    */
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

    private void goToSecondActivity(){
        String error = "";
        Random rand = new Random();
        int id = rand.nextInt();
        EditText input = (EditText)findViewById(R.id.editText1);

        try {
            goalsDB.beginTransaction();
            Log.d("Realm", "I'm in the try block!");
            //Goal goal = goalsDB.createObject(Goal.class);
            Goal goal = new Goal();
            goal.setId(id); //change later to randomized ID
            String goalText = input.getText().toString();
            goal.setName(goalText);

            goalsDB.copyToRealmOrUpdate(goal);
            goalsDB.commitTransaction();

            Intent intent = new Intent(this, OutcomeActivity.class);
            startActivity(intent);


        } catch(Exception ex){
            error += "Something failed, I'm in the catch block "+ ex.getMessage() + "cause: "+ ex.getCause() + " "+ ex.toString();
            Log.d("Realm", error);
            Log.d("Realm", "goal id is: "+ id);
            goalsDB.cancelTransaction();
        }

        RealmResults<Goal> goals = goalsDB.where(Goal.class).findAll();
        for (Goal g: goals){
            Log.d("Realm", g.getName());
        }
    }
}
