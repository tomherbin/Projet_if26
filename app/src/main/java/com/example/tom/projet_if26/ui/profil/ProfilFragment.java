package com.example.tom.projet_if26.ui.profil;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tom.projet_if26.ExercicePredefini;
import com.example.tom.projet_if26.Propos;
import com.example.tom.projet_if26.R;

import java.io.IOException;
import java.io.InputStream;

public class ProfilFragment extends Fragment {

    private ProfilViewModel mViewModel;
    private ImageView image;
    private ImageView imgProfil;
    private TextView txt;
    private TextView identite;

    public static ProfilFragment newInstance() {
        return new ProfilFragment();
    }

    public ProfilFragment() {
        // Required empty public constructor
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        return inflater.inflate(R.layout.profil_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(ProfilViewModel.class);
        txt = (TextView)getView().findViewById(R.id.apropos);
        txt.setText("À propos");
        identite =(TextView)getView().findViewById(R.id.identite);
        identite.setText("Prenom Nom");
        txt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(),Propos.class);
                getContext().startActivity(intent);
            }
        });
        image = (ImageView)getActivity().findViewById(R.id.logo);
        imgProfil = (ImageView)getActivity().findViewById(R.id.profilimg);
        AssetManager assetManager = getActivity().getAssets();
        try {
            InputStream ims = assetManager.open("fitmeetlogo.png");
            Drawable d = Drawable.createFromStream(ims, null);
            image.setImageDrawable(d);
            InputStream ims1 = assetManager.open("iconApp.png");
            Drawable d1 = Drawable.createFromStream(ims1, null);
            imgProfil.setImageDrawable(d1);
        } catch (IOException e) {
            return;
        }
        // TODO: Use the ViewModel
    }

}
