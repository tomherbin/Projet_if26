package com.example.tom.projet_if26;

public class Exercice {

    private String titre;
    private int reps;
    private int serie;
    private String desc;
    private int ID;


    public Exercice(String titre, int reps, int serie, String desc,int ID) {
        this.titre = titre;
        this.reps = reps;
        this.serie = serie;
        this.desc=desc;
        this.ID=ID;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public int getReps() {
        return reps;
    }

    public void setReps(int reps) {
        this.reps = reps;
    }

    public int getSerie() {
        return serie;
    }

    public void setSerie(int serie) {
        this.serie = serie;
    }

    public String getDesc(){
        return desc;
    }
    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

}
