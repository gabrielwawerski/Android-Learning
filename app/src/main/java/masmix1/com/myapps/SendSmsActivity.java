package masmix1.com.myapps;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class SendSmsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_sms);

        TextView displayFromLastActivity = (TextView) findViewById(R.id.display_from_last_activity_sms);
        Intent intent = getIntent();
        String textToDisplay = intent.getStringExtra("textToDisplay");
        displayFromLastActivity.setText(textToDisplay);
    }

    public void onSendSms(View view) {
        EditText sms_editText = (EditText) findViewById(R.id.sms_editText);
        if (sms_editText.length() == 0) {
            sms_editText.setHint("Musisz coś tutaj wpisać!");
        }
        else {
            String sms_userMessage = sms_editText.getText().toString();
            Intent intent = new Intent(Intent.ACTION_SEND);
            intent.setType("text/plain");
            intent.putExtra(Intent.EXTRA_TEXT, sms_userMessage);
            String choosenTitle = getString(R.string.chooser);
            Intent chosenIntent = Intent.createChooser(intent, choosenTitle);
            startActivity(chosenIntent);
        }
    }
}
