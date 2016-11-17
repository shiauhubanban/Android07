package com.org.iii.shine07;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Button left,right;
    private TextView clock;
    boolean isRunning;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        left = (Button)findViewById(R.id.btnleft);
        right = (Button)findViewById(R.id.btnright);
        clock=(TextView)findViewById(R.id.timer);
    }
    public void doLeft(View v){

    }
    public void doRight(View v){
        isRunning = !isRunning;
        right.setText(isRunning?"Stop":"Start");
        left.setText(isRunning?"Lap":"Reset");
        
        if(isRunning){
            doStart();
        }else {
            doStop();
        }
    }
    private void doStart(){

    }
    private void doStop(){

    }
    private void doReset(){

    }
    private void doLap(){

    }
}
