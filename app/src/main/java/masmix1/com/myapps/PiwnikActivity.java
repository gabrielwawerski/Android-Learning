package masmix1.com.myapps;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.List;

public class PiwnikActivity extends AppCompatActivity {
    Piwnik piwnik = new Piwnik();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_piwnik);

        TextView display_from_last_activity = (TextView) findViewById(R.id.display_from_last_activity);
        Intent intent = getIntent();
        String textToDisplay = intent.getStringExtra("textToDisplay");
        display_from_last_activity.setText(textToDisplay);
    }

    public void onFindBeers (View view) {
        Spinner piwnik_spinner = (Spinner) findViewById(R.id.piwnik_spinner);
        TextView wyswietl_piwa = (TextView) findViewById(R.id.wyswietl_piwa);

        String wybrane_piwa = String.valueOf(piwnik_spinner.getSelectedItem());
        List<String> wyswietl_wybrane_piwa = piwnik.getBrand(wybrane_piwa);

        StringBuilder sB = new StringBuilder();
        for (String x : wyswietl_wybrane_piwa) {
            sB.append(x).append("\n");
        }
        wyswietl_piwa.setText(sB);
    }
}