package com.example.tom.projet_if26;

public class ListeEntrainement {
    private String titre;
    private int repetition;

    public int getRepetition() {
        return repetition;
    }

    public void setRepétition(int repétition) {
        this.repetition = repétition;
    }

    public ListeEntrainement(String titre, int repétition){
        this.titre=titre;
        this.repetition=repetition;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

}
