package com.example.tom.projet_if26;

public class ListeEntrainement {
    private String titre;
    private int repetition;

    public int getRepetition() {
        return repetition;
    }

    public void setRepétition(int repétition) {
        this.repetition = repetition;
    }

    public ListeEntrainement(String titre, int repetition){
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
