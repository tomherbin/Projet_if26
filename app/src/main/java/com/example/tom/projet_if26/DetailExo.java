package com.example.tom.projet_if26;

import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.support.v7.widget.Toolbar;

import java.io.Serializable;

public class DetailExo extends AppCompatActivity implements Serializable {
    private ImageView img;
    private TextView desc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_entrainement);
        Intent intent = getIntent();
        intent.getSerializableExtra("exo");



        desc=this.findViewById(R.id.tvdesc);

        img = this.findViewById(R.id.img);
        Bundle b = getIntent().getExtras();
        Exercice ex = b.getParcelable("exo");
        getSupportActionBar().setTitle(ex.getTitre());

        desc.setText(ex.getDesc());


    }
}
