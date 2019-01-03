package com.example.tom.projet_if26;

import java.util.ArrayList;

public class ProgrammeEntrainement {


    private String titre;
    private String key;
    private ArrayList<Exercice> exercice;


    public ProgrammeEntrainement(String titre) {
        this.titre = titre;
    }

    public ProgrammeEntrainement(String titre, String key, ArrayList<Exercice> exercice) {
        this.titre = titre;
        this.key = key;
        this.exercice = exercice;
        this.init();
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public ArrayList<Exercice> getExercice() {
        return exercice;
    }

    public void setExercice(ArrayList<Exercice> exercice) {
        this.exercice = exercice;
    }

    @Override
    public String toString() {
        return "ProgrammeEntrainement{" +
                "titre='" + titre + '\'' +
                ", key=" + key +
                ", exercice=" + exercice +
                '}';
    }


    public void ajoute(Exercice e) {
        exercice.add(e);
    }

    public void init() {
        ajoute(new Exercice("Pompe", 3, 4, "AXA1"));
        ajoute(new Exercice("Tractions", 3, 4, "AXA2"));
        ajoute(new Exercice("Dips", 3, 4, "AXA3"));
        ajoute(new Exercice("Gainage", 3, 4, "AXA4"));



    }
}
