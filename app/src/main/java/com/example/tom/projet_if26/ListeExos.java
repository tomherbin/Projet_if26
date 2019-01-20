package com.example.tom.projet_if26;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ListView;

import com.example.tom.projet_if26.ui.home.HomeFragment;

import java.util.ArrayList;

public class ListeExos extends AppCompatActivity {
private ArrayList<Exercice> exos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.exo_fragment);
        getSupportActionBar().setTitle("Exercices");
        PersistanceTraining db = new PersistanceTraining(this);
        db.initData();
        RecyclerView rv = (RecyclerView) findViewById(R.id.rv);
        rv.setAdapter(new AdapterListeExos(this,exos));
        rv.setLayoutManager(new LinearLayoutManager(this));
    }



}