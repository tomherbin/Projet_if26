package com.example.tom.projet_if26.ui.home;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.tom.projet_if26.AdapterListeEntrainement;
import com.example.tom.projet_if26.Entrainement;
import com.example.tom.projet_if26.EntrainementPersistance;
import com.example.tom.projet_if26.Home;
import com.example.tom.projet_if26.ListeEntrainement;
import com.example.tom.projet_if26.ListeExos;
import com.example.tom.projet_if26.MainActivity;
import com.example.tom.projet_if26.PersistanceTraining;
import com.example.tom.projet_if26.PredefiniEntrainement;
import com.example.tom.projet_if26.R;

import java.util.ArrayList;

public class HomeFragment extends ListFragment {

    private HomeViewModel mViewModel;
    private  AdapterListeEntrainement adaptateur;
    public static HomeFragment newInstance() {
        return new HomeFragment();
    }
    private ArrayList<ListeEntrainement> listes;


    public HomeFragment() {
        // Required empty public constructor
    }

    @Nullable
    @Override
    public View onCreateView( LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        listes = new ArrayList<>();
        View v = inflater.inflate(R.layout.home_fragment, container, false);

        return v;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        RecyclerView lv = (RecyclerView) getView().findViewById(R.id.lv);


        final PersistanceTraining db = new PersistanceTraining(getContext());
        db.initData();
        listes.clear();
        listes=db.getAllEntrainements();

        final AdapterListeEntrainement adapt = new AdapterListeEntrainement(getActivity(),listes);
        lv.setLayoutManager(new LinearLayoutManager(getActivity()));


        lv.setAdapter(adapt);

        FloatingActionButton add = (FloatingActionButton) view.findViewById(R.id.fba);
        add.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final AlertDialog.Builder mBuilder= new AlertDialog.Builder(getActivity());
                View mView= getLayoutInflater().inflate(R.layout.dialog_entre,null);
                final EditText nom= (EditText) mView.findViewById(R.id.editNom);
                final EditText desc = (EditText) mView.findViewById(R.id.editDesc);
                mBuilder.setView(mView).setTitle("Ajouter entrainement").setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                }).setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        db.addEntrainement(nom.getText().toString(),desc.getText().toString());
                        dialog.dismiss();
                        adapt.notifyDataSetChanged();
                        Intent myIntent = new Intent(getContext(), ListeExos.class);
                        myIntent.putExtra("ID",""+getId());
                        getContext().startActivity(myIntent);


                    }
                });
                AlertDialog dialog =mBuilder.create();
                dialog.show();
            }
        });

    }

}
