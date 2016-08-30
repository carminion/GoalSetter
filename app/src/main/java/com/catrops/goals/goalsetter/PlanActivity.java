package com.catrops.goals.goalsetter;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class PlanActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_plan);

        Button button = (Button) findViewById(R.id.button6to7);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                goToNextActivity();
            }
        });
    }



    private void goToNextActivity(){
        Intent intent = new Intent(this, CompletionActivity.class);
        startActivity(intent);
    }
}
