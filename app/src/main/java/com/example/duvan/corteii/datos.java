package com.example.duvan.corteii;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;


public class datos extends AppCompatActivity {

    TextView TextView2;
    TextView txt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datos);

        TextView2 = (TextView) findViewById(R.id.textView2);
        txt = (TextView) findViewById(R.id.txt);
        Intent intent = getIntent();
        Bundle extraN = intent.getExtras();
        if (extraN != null) {

            String datoN = extraN.getString("DatoUsu");
            TextView2.setText(datoN);
        }
        Intent intentC = getIntent();
        Bundle extraC = intent.getExtras();
        if (extraC != null) {

            String datoC = extraC.getString("DatoCon");
            txt.setText(datoC);
        }


    }
}



