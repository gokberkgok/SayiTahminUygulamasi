package com.example.sayitahminuygulamas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Random;

public class Activity_Game extends AppCompatActivity {
    private TextView textViewHak;
    private EditText editTextTahminGir;
    private Button buttonTahminEt;
    private TextView textViewArttırAzalt;
    private int rastgeleSayi;
    int sayac = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__game);

        textViewHak = findViewById(R.id.textViewHak);
        editTextTahminGir = findViewById(R.id.EditTextTahminGir);
        buttonTahminEt = findViewById(R.id.buttonTahminEt);
        textViewArttırAzalt = findViewById(R.id.textViewArttırAzalt);

        Random r = new Random();
        rastgeleSayi = r.nextInt(101); // 0 - 100
        Log.e("Rastgele Sayı : ",String.valueOf(rastgeleSayi));


        buttonTahminEt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sayac = sayac - 1;
                int tahmin = Integer.parseInt(editTextTahminGir.getText().toString());
                if (tahmin == rastgeleSayi){
                    Intent i = new Intent(Activity_Game.this,Activity_Finish.class);
                    i.putExtra("sonuc",true);
                    startActivity(i);
                    finish();
                    return;
                }if(tahmin > rastgeleSayi){
                    textViewArttırAzalt.setText("AZALT");
                    textViewHak.setText("Kalan Hak : "+sayac);
                }if(tahmin < rastgeleSayi){
                    textViewArttırAzalt.setText("ARTTIR");
                    textViewHak.setText("Kalan Hak : "+sayac);
                }if(sayac == 0){
                    textViewArttırAzalt.setText("OYUN BİTTİ");
                    Intent i2 = new Intent(Activity_Game.this,Activity_Finish.class);
                    i2.putExtra("sonuc",false);
                    startActivity(i2);
                    finish();
                }
                editTextTahminGir.setText("");
            }
        });

    }
}