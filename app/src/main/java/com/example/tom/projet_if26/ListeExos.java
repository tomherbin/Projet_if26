package com.example.tom.projet_if26;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ListView;

import com.example.tom.projet_if26.ui.home.HomeFragment;

import java.util.ArrayList;

public class ListeExos extends AppCompatActivity {
    private ArrayList<Exercice> exos;
    private FloatingActionButton fba;
    private int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.exo_fragment);
        getSupportActionBar().setTitle("Exercices");
        Intent intent = getIntent();
        id = intent.getIntExtra("ID", 0);
        PersistanceTraining db = new PersistanceTraining(this);
        db.initData();
        exos=db.getExerciceProg(id);
        if(exos!=null){
            exos = db.getExerciceProg(id);
        }

        RecyclerView rv = (RecyclerView) findViewById(R.id.rv);
        rv.setAdapter(new AdapterListeExos(this, exos));
        rv.setLayoutManager(new LinearLayoutManager(this));

        fba = (FloatingActionButton) this.findViewById(R.id.addex);


        }
public void ajouter(View v){
        Intent intent = new Intent(this,ExercicePredefini.class);
        intent.putExtra("ID",id);
        startActivity(intent);
}
    }
