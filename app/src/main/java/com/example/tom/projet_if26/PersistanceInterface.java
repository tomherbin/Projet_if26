package com.example.tom.projet_if26;

import java.util.ArrayList;

public interface PersistanceInterface {


    // ajoute un Programme d'entrainement dans la base
    public void addEntrainement(ProgrammeEntrainement p);

    // ajoute l'ensemble des Entrainements via la méthode getEntrainement
    public void initData();

    // supprime un entrainement dans la base
    public void delEntrainement(ProgrammeEntrainement p);

    // mise à jour un Entrainement dans la base
    public void updateEntrainement(ProgrammeEntrainement p);

    // recherche d'un Entrainement dans la base via la clé primaire (titre)
    public ProgrammeEntrainement getEntrainement(String key);

    // retourne le nombre d'entrainement
    public int countEntrainement();

    // retourne l'ensemble des modules de la base
    public ArrayList<ProgrammeEntrainement> getAllEntrainements();


}
