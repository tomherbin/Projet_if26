package com.example.tom.projet_if26;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.database.Cursor;
import android.graphics.Movie;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Adaptateur de la liste des exercices sélectionné dans un programme d'entrainement
 * Adapte les données dans un recyclerView
 */
public class AdapterListeExos extends RecyclerView.Adapter<AdapterListeExos.ViewHolder> {
    ArrayList<Exercice> exos;
    private Context context;
    private Cursor cursor;

    /**
     * Constructeur de l'adaptateur
     * @param context contexte
     * @param data Liste d'exercice
     */
    public AdapterListeExos (Context context, ArrayList<Exercice> data){
        this.exos=data;
        this.context=context;

    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.liste_exos, parent, false));
    }

    /**
     * Attribuer les valeurs aux composants de la vue avec les attributs de l'adaptateur.
     * @param viewHolder
     * @param position
     */
    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {

        final Exercice exercice = exos.get(position);

        viewHolder.nomExo.setText(exercice.getTitre());

        viewHolder.descExo.setText("Nombre de répétitions :"+exercice.getReps()+"\n Nombre de séries : " +exercice.getSerie());
        viewHolder.itemView.setTag(exercice.getID());
        AssetManager assetManager = context.getAssets();
        try {
            InputStream ims = assetManager.open(exercice.getTitre()+".png");
            Drawable d = Drawable.createFromStream(ims, null);
            viewHolder.image.setImageDrawable(d);
        } catch (IOException ex) {
            return;
        }


        viewHolder.parentView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (context ,DetailExo.class);
                intent.putExtra("exo",exercice);
                context.startActivity(intent);
            }
        });


    }

    /**
     * Compte le nombre d'objets dans une liste d'exercice
     * @return la taille de la liste
     */
    @Override
    public int getItemCount() {
        return (this.exos == null) ? 0 : this.exos.size();
    }

    /**
     * Attribution des attributs aux composants
     */
    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView nomExo;
        private TextView descExo;
        private ImageView image;
        private View parentView;

        public ViewHolder(View v) {
            super(v);
            this.parentView = v;
            this.descExo = (TextView) v.findViewById(R.id.desc_exo);
            this.nomExo = (TextView) v.findViewById(R.id.nomExo);
            this.image = (ImageView) v.findViewById(R.id.schema);
        }
    }
    public void removet(int position){
        exos.remove(position);
        notifyItemRemoved(position);
    }

}
