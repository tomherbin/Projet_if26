package com.example.tom.projet_if26;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.View;
import android.widget.ListView;

import com.example.tom.projet_if26.ui.home.HomeFragment;

import java.util.ArrayList;

public class ListeExos extends AppCompatActivity {
    private ArrayList<Exercice> exos;
    private FloatingActionButton fba;
    private int id;
    private PersistanceTraining db;
    private Cursor cursor;
    private AdapterListeExos adapt;
    private SQLiteDatabase sqLiteDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.exo_fragment);
        getSupportActionBar().setTitle("Exercices");
        Intent intent = getIntent();
        id = intent.getIntExtra("ID", 0);
        db = new PersistanceTraining(this);
        sqLiteDatabase=db.getWritableDatabase();
        db.initData();
        exos=db.getExerciceProg(id);
        if(exos!=null){
            exos = db.getExerciceProg(id);
        }
        RecyclerView rv = (RecyclerView) findViewById(R.id.rv);
        adapt = new AdapterListeExos(this,exos);
        rv.setAdapter(adapt);
        new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0,ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder viewHolder1) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
                int idE= (int) viewHolder.itemView.getTag();
                removeExercice(idE,id);
            }
        }).attachToRecyclerView(rv);
        rv.setLayoutManager(new LinearLayoutManager(this));


        fba = (FloatingActionButton) this.findViewById(R.id.addex);


        }
public void ajouter(View v){
        Intent intent = new Intent(this,ExercicePredefini.class);
        intent.putExtra("ID",id);
        startActivity(intent);
    }
    public void onResume(){
        super.onResume();
        db = new PersistanceTraining(this);
        db.initData();
        exos=db.getExerciceProg(id);
        if(exos!=null){
            exos = db.getExerciceProg(id);
        }
        RecyclerView rv = (RecyclerView) findViewById(R.id.rv);
        rv.setAdapter(new AdapterListeExos(this,exos));
        rv.setLayoutManager(new LinearLayoutManager(this));
    }
public boolean removeExercice(int idE,int id){
        sqLiteDatabase = db.getWritableDatabase();
        return sqLiteDatabase.delete(PersistanceTraining.TABLE_PROGRAMME,PersistanceTraining.ATTRIBUT_ID_EXPROG+"="+idE
                +" AND "+PersistanceTraining.ATTRIBUT_ID_EPROG+"="+id,null)>0;
}
    }
