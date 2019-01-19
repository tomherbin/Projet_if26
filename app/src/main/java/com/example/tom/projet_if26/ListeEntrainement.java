package com.example.tom.projet_if26;

public class ListeEntrainement {
    private String titre;
    private int repetition;
    private String description;

    public int getRepetition() {
        return repetition;
    }

    public void setRepétition(int repétition) {
        this.repetition = repetition;
    }

    public ListeEntrainement(String titre, int repetition,String description){
        this.titre=titre;
        this.repetition=repetition;
        this.description=description;
    }

    public String getTitre() {
        return titre;
    }

    public String getDescription(){
        return description;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

}
