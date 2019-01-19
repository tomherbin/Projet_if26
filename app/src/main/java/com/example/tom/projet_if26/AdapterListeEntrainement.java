package com.example.tom.projet_if26;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class AdapterListeEntrainement extends ArrayAdapter<ListeEntrainement> {
    Context context;
    int resource;
    ArrayList<ListeEntrainement>liste;

    public AdapterListeEntrainement(Context context, int resource, ArrayList<ListeEntrainement> objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource=resource;
        this.liste=objects;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater=((Activity)context).getLayoutInflater();
        View v= inflater.inflate(resource,parent,false);

        ListeEntrainement listes = liste.get(position);
        TextView titre =(TextView) v.findViewById(R.id.nomEntrainement);

        TextView compteur=(TextView)v.findViewById(R.id.compteur);

        TextView description =(TextView) v.findViewById(R.id.description);

        return v;
    }
}
