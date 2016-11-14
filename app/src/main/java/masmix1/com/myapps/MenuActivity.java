package masmix1.com.myapps;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MenuActivity extends AppCompatActivity {
    EditText sendToNextActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        sendToNextActivity = (EditText) findViewById(R.id.send_to_next_activity);
    }

    public void onClickStartPiwnik(View view) {
        Intent intent = new Intent(this, PiwnikActivity.class);
        toNextAcivity(intent);
    }

    public void onClickStartSendSms(View view) {
        Intent intent = new Intent(this, SendSmsActivity.class);
        toNextAcivity(intent);
    }

    public void onClickStartThread(View view) {
        Intent intent = new Intent(this, ThreadActivity.class);
        String sendtonext_activity = sendToNextActivity.getText().toString();
        intent.putExtra("textToDisplay", sendtonext_activity);
        startActivity(intent);
//        toNextAcivity(intent);
    }

    public void onClickStartTimer(View view) {
        Intent intent = new Intent(this, TimerActivity.class);
        toNextAcivity(intent);
    }

    private void toNextAcivity(Intent intent) {
        String sendtonext_activity = sendToNextActivity.getText().toString();
        intent.putExtra("textToDisplay", sendtonext_activity);
        startActivity(intent);
    }
}