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

/**
 * Interface qui affiche la liste d'exercices que l'on choisit précédemment.
 * Affiche la liste d'exercice d'un entrainement dont nous avons récupéré l'ID
 */
public class ListeExos extends AppCompatActivity {
    private ArrayList<Exercice> exos;
    private RecyclerView rv;
    private FloatingActionButton fba;
    private int id;
    private PersistanceTraining db;
    private AdapterListeExos adapt;
    private SQLiteDatabase sqLiteDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.exo_fragment);
        getSupportActionBar().setTitle("Exercices");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Intent intent = getIntent();
        id = intent.getIntExtra("ID", 0);
        db = new PersistanceTraining(this);
        sqLiteDatabase=db.getWritableDatabase();
        db.initData();
        exos=db.getExerciceProg(id);
        if(exos!=null){
            exos = db.getExerciceProg(id);
        }
        rv = (RecyclerView) findViewById(R.id.rv);
        adapt = new AdapterListeExos(this,exos);
        rv.setAdapter(adapt);
        rv.setLayoutManager(new LinearLayoutManager(this));

        new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0,ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder viewHolder1) {
                return false;
            }

            @Override
            public void onSwiped(RecyclerView.ViewHolder viewHolder, int i) {
                int idE= (int) viewHolder.itemView.getTag();
                removeExercice(idE,id);
                adapt.removet(viewHolder.getAdapterPosition());

            }
        }).attachToRecyclerView(rv);



        fba = (FloatingActionButton) this.findViewById(R.id.addex);


        }

    /**
     * Appel à cette méthode quand l'utilisateur appuie sur le bouton ajouter
     * Affiche la liste d'exercice prédéfini
     * @param v vue
     */
    public void ajouter(View v){
        Intent intent = new Intent(this,ExercicePredefini.class);
        intent.putExtra("ID",id);
        startActivity(intent);
    }

    /**
     * Dès lors que l'on retourne à cette fenêtre depuis la description de l'exercice ou la liste
     * prédéfinie
     */
    public void onResume(){
        super.onResume();
        Intent intent = getIntent();
        id = intent.getIntExtra("ID", 0);
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

    /**
     * Swipe gauche ou droite pour le retirer de la table Programme
     * @param idE ID de l'exercice
     * @param id ID de l'entrainement
     * @return true si la requete fonctionne
     */
    public boolean removeExercice(int idE,int id){
        sqLiteDatabase = db.getWritableDatabase();
        return sqLiteDatabase.delete(PersistanceTraining.TABLE_PROGRAMME,PersistanceTraining.ATTRIBUT_ID_EXPROG+"="+idE
                +" AND "+PersistanceTraining.ATTRIBUT_ID_EPROG+"="+id,null)>0;
}
    }
