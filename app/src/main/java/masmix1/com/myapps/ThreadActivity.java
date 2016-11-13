package masmix1.com.myapps;

import android.os.AsyncTask;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ThreadActivity extends AppCompatActivity {
    TextView loopTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thread);
    }

    protected void onStartLoop(View view) {
        runThread();
    }

    private void runThread() {
        new Thread() {
            int randNumber;
            public void run() {
                int i = 0;
                while (i++ < 1000) {
                    randNumber = (int) (Math.random() * 100);
                    loopTextView.setText(String.valueOf(randNumber));
                    try {
                        Thread.sleep(300);
                    }
                    catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();
    }
}
