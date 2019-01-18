package com.example.tom.projet_if26;

public class ListeEntrainement {
    private String titre;
    private int repétition;

    public int getRepétition() {
        return repétition;
    }

    public void setRepétition(int repétition) {
        this.repétition = repétition;
    }

    public ListeEntrainement(String titre, int repétition){
        this.titre=titre;
        this.repétition=repétition;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

}
