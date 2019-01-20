package com.example.tom.projet_if26;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/*private String titre;
private int reps;
private int serie;
private String ExerciceKey;
private String desc;*/
public class ExerciceGenerator {
private ArrayList<Exercice> listeExo;
    public ExerciceGenerator(){
        listeExo = new ArrayList<>();
        init();

}
public void init(){
        ajoute(new Exercice("Pompe",10,3,"Baisse",0));
    ajoute(new Exercice("Gainage",1,3,"Baisse",1));
    ajoute(new Exercice("Burpees",10,3,"Baisse",2));
    ajoute(new Exercice("WallBall",10,3,"Baisse",3));
    ajoute(new Exercice("Traction",10,3,"Baisse",4));
    ajoute(new Exercice("Squat",10,3,"Baisse",5));
}

public void ajoute(Exercice e){
        listeExo.add(e);
}
public ArrayList<Exercice>getListeExo(){
        return listeExo;
}
}

