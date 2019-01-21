package com.example.tom.projet_if26;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class AdapterListeEntrainement extends RecyclerView.Adapter<AdapterListeEntrainement.ViewHolder> {
    private Context context;
    int resource;
    ArrayList<ListeEntrainement>liste;
    private int id;

    public AdapterListeEntrainement(Context context, ArrayList<ListeEntrainement> objects) {
        this.context = context;
        this.liste=objects;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.liste_entrainements,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {


        final ListeEntrainement listes = liste.get(position);
        viewHolder.titre.setText(listes.getTitre());
        viewHolder.compteur.setText(String.valueOf(listes.getRepetition()));
        viewHolder.description.setText(listes.getDescription());
        viewHolder.itemView.setTag(listes.getID());

        viewHolder.view.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                id = listes.getID();
                passData(id);
            }
        });

    }
    public void passData(int id){
        Intent intent = new Intent (context ,ListeExos.class);
        intent.putExtra("ID",id);
        context.startActivity(intent);
    }

    @Override
    public int getItemCount() {
        return (this.liste == null) ? 0 : this.liste.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView titre;
        private TextView compteur;
        private TextView description;
        private View view;

        public ViewHolder(@NonNull View v) {
            super(v);
            this.view=v;
            this.titre =(TextView) v.findViewById(R.id.nomEntrainement);
           this.compteur=(TextView)v.findViewById(R.id.compteur);
            this.description =(TextView) v.findViewById(R.id.description);
        }
    }
    public void removeAt(int position){
        liste.remove(position);
        notifyItemRemoved(position);
    }
}
