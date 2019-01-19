package com.example.tom.projet_if26;

import java.util.ArrayList;

public class ProgrammeEntrainement {


    private String titre;
    private int key;
    private int repetition;
    private ArrayList<Exercice> exercice;


    public ProgrammeEntrainement(String titre) {
        this.titre = titre;
    }

    public ProgrammeEntrainement(String titre, int key, ArrayList<Exercice> exercice,int repetition) {
        this.titre = titre;
        this.key = key;
        this.exercice = exercice;
        this.repetition=repetition;
        this.init();
    }

    public String getTitre() {
        return titre;
    }
    public int getRepetition(){ return repetition;}

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
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
        


    }
}
