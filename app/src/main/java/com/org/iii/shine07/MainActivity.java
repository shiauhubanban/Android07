package com.org.iii.shine07;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    private Button left, right;
    private TextView clock;
    private boolean isRunning;
    private int Counter;
    private Timer timer;
    private ClockTask clockTask;
    private UIHandler uiHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        timer = new Timer();
        uiHandler = new UIHandler();

        left = (Button)findViewById(R.id.btnLeft);
        right = (Button)findViewById(R.id.btnRight);
        clock = (TextView)findViewById(R.id.timer);

    }

    @Override
    public void finish() {
        if (timer != null){
            timer.purge();
            timer.cancel();
            timer = null;
        }
        super.finish();
    }

    public void doLeft(View v){
        if (isRunning){
            doLap();
        }else{
            doReset();
        }
    }
    public void doRight(View v){
        isRunning = !isRunning;
        right.setText(isRunning?"Stop":"Start");
        left.setText(isRunning?"Lap":"Reset");

        if (isRunning){
            doStart();
        }else{
            doStop();
        }
    }
    private void doStart(){
        clockTask = new ClockTask();
        timer.schedule(clockTask, 10, 10);
    }
    private void doStop(){
        clockTask.cancel();
    }
    private void doReset(){
        Counter = 0;
        uiHandler.sendEmptyMessage(0);
    }
    private void doLap(){

    }

    private class ClockTask extends TimerTask {
        @Override
        public void run() {
            Counter++;
            uiHandler.sendEmptyMessage(0);
        }
    }
    private class UIHandler extends Handler {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            clock.setText("" + Counter);
        }
    }

    static String counter2Clock(int counter){

        return "00:01:02.12";
    }

}