package com.example.tom.projet_if26;

public class Exercice {

    private String titre;
    private int reps;
    private int serie;
    private String ExerciceKey;
    private String desc;

    public Exercice(String titre) {
        this.titre = titre;
    }

    public Exercice(String titre, int reps, int serie, String exerciceKey, String desc) {
        this.titre = titre;
        this.reps = reps;
        this.serie = serie;
        this.ExerciceKey = exerciceKey;
        this.desc=desc;
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

    public String getExerciceKey() {
        return ExerciceKey;
    }

    public void setExerciceKey(String exerciceKey) {
        ExerciceKey = exerciceKey;
    }

    public String getDesc(){
        return desc;
    }

    @Override
    public String toString() {
        return "Exercice{" +
                "titre='" + titre + '\'' +
                ", reps=" + reps +
                ", serie=" + serie +
                '}';
    }
}
