package com.example.tom.projet_if26.ui.home;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.tom.projet_if26.Entrainement;
import com.example.tom.projet_if26.EntrainementPersistance;
import com.example.tom.projet_if26.Home;
import com.example.tom.projet_if26.MainActivity;
import com.example.tom.projet_if26.R;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    private HomeViewModel mViewModel;
    private EntrainementPersistance db ;

    public static HomeFragment newInstance() {
        return new HomeFragment();
    }



    public HomeFragment() {
        // Required empty public constructor
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.home_fragment, container, false);
        db= new EntrainementPersistance(getContext());
        initUI(v);
        return v;


    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(HomeViewModel.class);
        // TODO: Use the ViewModel
    }


    private void initUI(View v){
        ListView lv = v.findViewById(R.id.lv);
        FloatingActionButton add = (FloatingActionButton) v.findViewById(R.id.fba);
        add.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder mBuilder= new AlertDialog.Builder(getActivity());
                View mView= getLayoutInflater().inflate(R.layout.dialog_entre,null);
                final EditText nom= (EditText) mView.findViewById(R.id.editNom);
                Button ok = (Button) mView.findViewById(R.id.btnOk);

                ok.setOnClickListener(new View.OnClickListener(){
                    @Override
                    public void onClick(View v) {
                        if(!nom.getText().toString().isEmpty()){

                            Toast.makeText(getActivity(),
                                    "Ajout réussi",Toast.LENGTH_SHORT).show();
                            db.addEntrainement(nom.getText().toString());

                        }else{
                            Toast.makeText(getActivity(),
                                    "Insérer un nom",Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                mBuilder.setView(mView);
                AlertDialog dialog =mBuilder.create();
                dialog.show();
            }
        });
        ArrayList<String> list = new ArrayList<>();
        Cursor data = db.getListEntrainement();
    }


}
