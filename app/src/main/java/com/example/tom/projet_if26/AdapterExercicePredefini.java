package com.example.tom.projet_if26;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class AdapterExercicePredefini extends RecyclerView.Adapter<AdapterExercicePredefini.ViewHolder>{
    private Context context;
    private ArrayList<Exercice> liste;
    private int idEntrainement;
    Exercice listes;

    public AdapterExercicePredefini(Context context, ArrayList<Exercice> objects,int id) {
        this.context = context;
        this.liste=objects;
        this.idEntrainement=id;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.liste_ajouterexo,parent,false));
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position) {
       final Exercice listes = liste.get(position);
        viewHolder.titre.setText(listes.getTitre());
        viewHolder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final PersistanceTraining db = new PersistanceTraining(context);
                db.addExerciceList(listes, idEntrainement);
                Toast.makeText(context,"Ajout réussi",Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return (this.liste == null) ? 0 : this.liste.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView titre;
        private TextView ajouter;
        private ImageView viewImage;
        private View view;


        public ViewHolder(View v) {
            super(v);
            this.view=v;
            this.titre =(TextView) v.findViewById(R.id.nomExo);
            this.viewImage = v.findViewById(R.id.schema);
            this.ajouter =(TextView) v.findViewById(R.id.ajo);
        }
    }

}
