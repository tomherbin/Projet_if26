package com.example.tom.projet_if26;

import android.content.res.AssetManager;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tom.projet_if26.ui.profil.ProfilFragment;

import java.io.IOException;
import java.io.InputStream;

public class Profil extends AppCompatActivity {
    private TextView txt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profil_activity);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, ProfilFragment.newInstance())
                    .commitNow();

    }
    txt= findViewById(R.id.propos);
    }
}
