package com.example.tom.projet_if26;

import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailExo extends AppCompatActivity {
    private TextView tv;
    private ImageView img;
    public static final String EXTRA_EXERCICE = "exercice";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_entrainement);
        Intent intent = getIntent();


        tv= this.findViewById(R.id.tvdesc);

        img = this.findViewById(R.id.img);

        Exercice exercice=getIntent().getExtras().getParcelable(EXTRA_EXERCICE);
        assert exercice!=null;
    }
}
