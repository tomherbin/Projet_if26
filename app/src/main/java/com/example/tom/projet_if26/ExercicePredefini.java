package com.example.tom.projet_if26;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Affichage de la liste prédéfinie des exercices. Récupère les informations dans la base de données;
 * Laisse l'adapteur placer chaque exercice pour la recyclerView.
 */
public class ExercicePredefini extends AppCompatActivity {
private ArrayList<Exercice>exos;
private RecyclerView rv;
private int id;
private TextView txt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercice_predefini);
        getSupportActionBar().setTitle("Listes exercices");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Intent intent =getIntent();
        id= intent.getIntExtra("ID",0);
        PersistanceTraining db = new PersistanceTraining(this);
        db.initData();
        exos = db.getAllExercices();
        rv = (RecyclerView) this.findViewById(R.id.rv);
        rv.setAdapter(new AdapterExercicePredefini(this, exos,id));
        rv.setLayoutManager(new LinearLayoutManager(this));
    }
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {

            case android.R.id.home:
                onBackPressed();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
