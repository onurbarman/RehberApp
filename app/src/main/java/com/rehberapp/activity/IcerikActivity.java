package com.rehberapp.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;

import com.rehberapp.R;

public class IcerikActivity extends AppCompatActivity {

    String adsoyad;
    String telefon;
    TextView lblAdSoyad,lblTelefon;
    Button btnYes,btnNo;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rehber_icerik);

        adsoyad=getIntent().getStringExtra("adsoyad");
        telefon=String.valueOf(getIntent().getStringExtra("telefon"));

        lblAdSoyad=(TextView)findViewById(R.id.lbl_adSoyad);
        lblTelefon=(TextView)findViewById(R.id.lbl_telefon);
        btnYes=(Button)findViewById(R.id.btnEvet);
        btnNo=(Button)findViewById(R.id.btnHayir);

        lblAdSoyad.setText(adsoyad);
        lblTelefon.setText(telefon);
    }
}
