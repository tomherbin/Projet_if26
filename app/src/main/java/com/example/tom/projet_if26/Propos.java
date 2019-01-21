package com.example.tom.projet_if26;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Propos extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_propos);
        getSupportActionBar().setTitle("À propos");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
