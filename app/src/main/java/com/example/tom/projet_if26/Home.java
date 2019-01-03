package com.example.tom.projet_if26;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tom.projet_if26.ui.home.HomeFragment;

public class Home extends AppCompatActivity {

    private Button training;
    private TextView mTextMessage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_activity);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, HomeFragment.newInstance())
                    .commitNow();




            ListView maListe = (ListView) findViewById(R.id.module_liste_lv);
            ModulePersistance persistance = new ModulePersistance(this, "modules.db", null, 1);
            persistance.initData();
            ArrayList<Module> modules = persistance.getAllModules();




        }
    }





}
