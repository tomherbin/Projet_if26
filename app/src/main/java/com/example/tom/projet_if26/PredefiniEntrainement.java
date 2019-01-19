package com.example.tom.projet_if26;

import com.example.tom.projet_if26.ListeEntrainement;

import java.util.ArrayList;
import java.util.Iterator;

public class PredefiniEntrainement {
    private ArrayList<ListeEntrainement>profil;

    public PredefiniEntrainement(){
        profil= new ArrayList<ListeEntrainement>();

        init();
    }
    public void init(){

        profil.add((new ListeEntrainement("Biceps", 15)));
        profil.add((new ListeEntrainement("Top", 154)));
        profil.add((new ListeEntrainement("Bas", 115)));
        profil.add((new ListeEntrainement("Cuisse", 15)));
        profil.add((new ListeEntrainement("Mollets", 112)));

    }

    public ArrayList<String>getTitre(){
        ArrayList res = new ArrayList();
        Iterator it = res.iterator();
        while (it.hasNext())
        {
            ListeEntrainement l = (ListeEntrainement) (it.next());
            res.add(l.getTitre());

        }
        return res;
    }

    public ArrayList<Integer>getRepetition(){
        ArrayList res = new ArrayList();
        Iterator it = res.iterator();
        while (it.hasNext())
        {
            ListeEntrainement l = (ListeEntrainement) (it.next());
            res.add(l.getRepetition());

        }
        return res;
    }

    public ArrayList<ListeEntrainement>getListe(){
        return profil;
    }
}
