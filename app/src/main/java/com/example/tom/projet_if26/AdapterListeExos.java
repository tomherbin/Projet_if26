package com.example.tom.projet_if26;

import android.app.Activity;
import android.content.Context;
import android.graphics.Movie;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class AdapterListeExos extends ArrayAdapter<Exercice> {
    private ArrayList<Exercice> exos;
    private Context context;
    private int resource;
    private  LayoutInflater inflater;


    public AdapterListeExos (Context context, int resource, ArrayList<Exercice> data){
        super(context,resource,data);

        this.exos=data;
        this.context=context;
        this.resource=resource;


    }

    public View getView(int position, View v, ViewGroup parent) {
        if (v==null){
             inflater = ((Activity) context).getLayoutInflater();
             v= inflater.inflate(resource, parent, false);

        }

        Exercice exercice = exos.get(position);
        TextView nomExo = (TextView) v.findViewById(R.id.nomExo);
        nomExo.setText(exercice.getTitre());

        TextView descExo = (TextView) v.findViewById(R.id.desc_exo);
        descExo.setText(exercice.getDesc());

        ImageView image = v.findViewById(R.id.schema);



        return v;
    }



}
