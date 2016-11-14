package masmix1.com.myapps;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.Locale;

public class TimerActivity extends AppCompatActivity {
    private int seconds;
    private boolean timerRunning;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer);

        if (savedInstanceState != null) {
            seconds = savedInstanceState.getInt("seconds");
            timerRunning = savedInstanceState.getBoolean("timerRunning");
        }

        TextView display_from_last_activity = (TextView) findViewById(R.id.displayFromLastActivityTimer);
        Intent intent = getIntent();
        String textToDisplay = intent.getStringExtra("textToDisplay");
        display_from_last_activity.setText(textToDisplay);
        Timer();
    }

    public void onStart(View view) {
        timerRunning = true;
    }

    public void onPause(View view) {
        timerRunning = false;
    }

    public void onReset(View view) {
        timerRunning = false;
        seconds = 0;
    }

    private void Timer() {

        final Handler handler = new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                TextView timer = (TextView) findViewById(R.id.timerView);
                int hours = seconds / 3600;
                int minutes = (seconds % 3600) / 60;
                int secs = seconds % 60;
                String time = String.format("%d:%02d:%02d", hours, minutes, secs);
                timer.setText(time);

                if (timerRunning) {
                    seconds++;
                }
                handler.postDelayed(this, 1000);
            }
            });
        }

    @Override
    public void onSaveInstanceState (Bundle savedInstanceState ) {
        savedInstanceState.putInt("seconds", seconds);
        savedInstanceState.putBoolean("timerRunning", timerRunning);
    }
}
