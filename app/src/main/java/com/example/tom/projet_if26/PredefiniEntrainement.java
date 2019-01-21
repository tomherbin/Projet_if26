package com.example.tom.projet_if26;

import com.example.tom.projet_if26.ListeEntrainement;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Classe des entrainements
 */
public class PredefiniEntrainement {
    private ArrayList<ListeEntrainement>profil;

    public PredefiniEntrainement(){
        profil= new ArrayList<ListeEntrainement>();

        init();
    }
    public void init(){


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
