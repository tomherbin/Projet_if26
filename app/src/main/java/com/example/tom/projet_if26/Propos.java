package com.example.tom.projet_if26;

import android.content.res.AssetManager;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;

public class Propos extends AppCompatActivity {
    private ImageView banniere;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_propos);
        getSupportActionBar().setTitle("À propos");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        banniere = findViewById(R.id.banniere);
        AssetManager assetManager = getAssets();
        try {
            InputStream ims = assetManager.open("fitmeetlogo.png");
            Drawable d = Drawable.createFromStream(ims, null);
            banniere.setImageDrawable(d);
        } catch (IOException e) {
            return;
        }
    }
}
