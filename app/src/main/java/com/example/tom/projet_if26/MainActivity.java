package com.example.tom.projet_if26;

import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.design.widget.BottomNavigationView;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tom.projet_if26.ui.home.HomeFragment;
import com.example.tom.projet_if26.ui.profil.ProfilFragment;
import com.example.tom.projet_if26.ui.search.SearchFragment;

import java.util.ArrayList;

/**
 * Classe pour la barre de navigation. Activité qui affiche les fragments Entrainements,
 * REchercher et Profil
 */
public class MainActivity extends AppCompatActivity {


    private TextView mTextMessage;



    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_exercices:
                    mTextMessage.setText("Lol");
                    showFragment(new HomeFragment());
                    getSupportActionBar().setTitle("Mes entraînements");
                    return true;
                case R.id.navigation_search:
                    mTextMessage.setText("mfds");
                    getSupportActionBar().setTitle("Rechercher");
                    showFragment(new SearchFragment());

                    return true;
                case R.id.navigation_account:
                    mTextMessage.setText("SFMD");
                    getSupportActionBar().setTitle("Mon compte");
                    showFragment(new ProfilFragment());
                    return true;
            }
            return false;
        }

    };




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        getSupportActionBar().setTitle("Mes entraînements");
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        showFragment(new HomeFragment());
    }

    private void showFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.content, fragment)
                .commit();
    }

}
