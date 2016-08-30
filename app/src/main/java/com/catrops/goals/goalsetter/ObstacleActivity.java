package com.catrops.goals.goalsetter;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmResults;
import io.realm.RealmObject;

public class ObstacleActivity extends AppCompatActivity {

    private Realm goalsDB;
    private RealmConfiguration realmConfig;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_obstacle);


        Button button = (Button) findViewById(R.id.button4to5);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                goToNextActivity();
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        goalsDB.close();
    }

    private void goToNextActivity(){
        Intent intent = new Intent(this, VizObstacleActivity.class);
        startActivity(intent);
    }
}
