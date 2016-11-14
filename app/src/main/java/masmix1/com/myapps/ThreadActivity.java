package masmix1.com.myapps;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ThreadActivity extends AppCompatActivity {
    TextView display_from_last_activity;
    TextView loopTextView;
    Button startLoopButton;
    Button onStopLoopButton;
    Handler loopHandler;
    boolean running;
    boolean wasRunning;
    int randNumber;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thread);
        running = false;
        Intent intent = getIntent();
        String textToDisplay = intent.getStringExtra("textToDisplay");

        display_from_last_activity = (TextView) findViewById(R.id.displayFromLastActivityThread);
        display_from_last_activity.setText(textToDisplay);
        loopTextView = (TextView) findViewById(R.id.loopText);
        onStopLoopButton = (Button) findViewById(R.id.stopLoop);
        startLoopButton = (Button) findViewById(R.id.startLoop);
        loopTextView.setVisibility(View.INVISIBLE);

        if (savedInstanceState != null) {
            loopTextView.setVisibility(View.VISIBLE);
            randNumber = savedInstanceState.getInt("randNumber");
            running = savedInstanceState.getBoolean("running");

            if (running) {
                startLoopButton.setEnabled(false);
                onStopLoopButton.setEnabled(true);
                savedInstanceState.getBoolean("wasRunning");
            } else {
                startLoopButton.setEnabled(true);
                onStopLoopButton.setEnabled(false);
             }
        }
        runThread();
    }

    public void onStartLoop(View view) {
        loopTextView.setVisibility(View.VISIBLE);
        running = true;
        startLoopButton.setEnabled(false);
        onStopLoopButton.setEnabled(true);
    }

    public void onStopLoop(View view) {
        running = false;
        startLoopButton.setEnabled(true);
        onStopLoopButton.setEnabled(false);
    }

    private void runThread() {
        loopHandler = new Handler();
            loopHandler.post(new Runnable() {
                @Override
                public void run() {
                    if (running) {
                        randNumber = (int) (Math.random() * 1000);
                    }
                    loopTextView.setText(String.valueOf(randNumber));
                    loopHandler.postDelayed(this, 75);
                }
            });
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        savedInstanceState.putInt("randNumber", randNumber);
        savedInstanceState.putBoolean("running", running);
        savedInstanceState.putBoolean("wasRunning", wasRunning);
    }

    @Override
    protected void onStop() {
        super.onStop();
        wasRunning = running;
        if (running) {running = false;}
    }

    @Override
    protected void onStart() {
        super.onStart();
        if (wasRunning) {
            running = true;
        }
    }
}
