package com.example.tom.projet_if26;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.tom.projet_if26.ui.home.HomeFragment;

public class ListeExos extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.exo_fragment);
        getSupportActionBar().setTitle("Exercices");
        PersistanceTraining db = new PersistanceTraining(this);

        ListView lv = (ListView) findViewById(R.id.lv_exo);
    }



}