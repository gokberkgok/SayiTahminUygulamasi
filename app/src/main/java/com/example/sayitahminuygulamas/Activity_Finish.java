package com.example.sayitahminuygulamas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Activity_Finish extends AppCompatActivity {
    private Button buttonPlayAgain;
    private TextView textViewWinLose;
    private ImageView imageViewSonuc;
    private boolean sonuc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__finish);

        buttonPlayAgain = findViewById(R.id.buttonPlayAgain);
        textViewWinLose = findViewById(R.id.textViewWinLose);
        imageViewSonuc = findViewById(R.id.imageViewSonuc);

         sonuc = getIntent().getBooleanExtra("sonuc",false);
         if (sonuc){
             textViewWinLose.setText("KAZANDINIZ");
             imageViewSonuc.setImageResource(R.drawable.youwon);
         }else{
             textViewWinLose.setText("KAYBETTİNİZ");
             imageViewSonuc.setImageResource(R.drawable.youlose);
         }

        buttonPlayAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Activity_Finish.this,MainActivity.class));
                finish();
            }
        });


    }
}