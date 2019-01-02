package com.example.tom.projet_if26;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.tom.projet_if26.ui.message.MessageFragment;

public class Message extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.message_activity);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, MessageFragment.newInstance())
                    .commitNow();
        }
    }
}
