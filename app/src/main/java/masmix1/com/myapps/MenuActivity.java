package masmix1.com.myapps;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }

    public void onClickStartPiwnik(View view) {
        Intent intent = new Intent(this, PiwnikActivity.class);
        EditText sendToNextActivity = (EditText) findViewById(R.id.send_to_next_activity);
        String sendtonext_activity = sendToNextActivity.getText().toString();
        intent.putExtra("textToDisplay", sendtonext_activity);
        startActivity(intent);
    }

    public void onClickStartSendSms(View view) {
        Intent intent = new Intent(this, SendSmsActivity.class);
        EditText sendToNextActivity = (EditText) findViewById(R.id.send_to_next_activity);
        String sendtonext_activity = sendToNextActivity.getText().toString();
        intent.putExtra("textToDisplay", sendtonext_activity);
        startActivity(intent);
    }

    public void onClickStartThread(View view) {
        Intent intent = new Intent(this, ThreadActivity.class);
        EditText sendToNextActivity = (EditText) findViewById(R.id.send_to_next_activity);
        String sendtonext_activity = sendToNextActivity.getText().toString();
        intent.putExtra("textToDisplay", sendtonext_activity);
        startActivity(intent);
    }
}