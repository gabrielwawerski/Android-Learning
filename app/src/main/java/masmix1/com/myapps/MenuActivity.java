package masmix1.com.myapps;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }

    public void onClickStartPiwnik(View view) {
        Intent intent = new Intent(this, PiwnikActivity.class);
        startActivity(intent);
    }

    public void onClickStartSendSms(View view) {
        Intent intent = new Intent(this, SendSmsActivity.class);
        startActivity(intent);
    }
}
