package com.example.junijepalmotic.zavrsniaplikacijakviz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {
    public int b, a;
    TextView text,link;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        link=findViewById(R.id.link);
        text = findViewById(R.id.tekst);
        Intent mintent = getIntent();
        b = mintent.getIntExtra("ba", b);
        if (b < 20 && b > 15) {
            text.setText("Vaše znanje o sigurnosti je solidno, međutim trebali biste malo pripaziti, u nastavku Vam preporučamo link o edukaciji");
            link.setText("https://preporucamo.com/sigurnost-pametnih-telefona-korisnih-savjeta/2017/05/15/");
    }
        if(b>25 && b<31){
            text.setText("Vi ste osvješteni o sigurnosti Vaših mobilnih uređaja, u nastavku Vam dostavljamo link ako žželite znati nešto više");
            link.setText("pritisnutiovdje");
        }

    }
}