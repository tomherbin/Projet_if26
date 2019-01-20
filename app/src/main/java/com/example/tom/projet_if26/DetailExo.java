package com.example.tom.projet_if26;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class DetailExo extends AppCompatActivity {
    public static final String EXTRA_EXERCICE = "exercice";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_entrainement);

        Exercice exercice=getIntent().getExtras().getParcelable(EXTRA_EXERCICE);
        assert exercice!=null;
    }
}
