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
        ajoute(new Exercice("Pompe",10,3,"Inspirer et fléchir les bras pour amener la cage thoracique près du sol sans creuser la région lornbaire. Un travail préalable de musculation statique en gainage permet de mieux sentir cette position \"corps droit\" sans cambrure et sans fesses pointant vers le haut.\n" +
                "Pousser jusqu'à l'extension cornplète des bras en gardant toujours le corps bien gainé et droit\n" +
                "Expirer profondément en fin de mouvement en rentrant le ventre sous le nombril pour renforcer aussi les muscles abdominaux profonds.",0));
    ajoute(new Exercice("Gainage",1,3,"Le gainage est un entraînement physique et de musculation qui permet de renforcer les muscles abdominaux et dorsaux. Réalisés en isométrie, ces exercices sollicitent les muscles de l'abdomen et du dos en profondeur, et participent au maintien et à la protection de la colonne vertébrale.",1));
    ajoute(new Exercice("Burpees",10,3,"Pompe + saut",2));
    ajoute(new Exercice("WallBall",10,3,"Lancer un ballon lourd en face de vous",3));
    ajoute(new Exercice("Traction",10,3,"La traction est un exercice physique consistant à hisser ses épaules au niveau d'une barre en la tenant par les mains. Les tractions ont pour objectif principal le développement des muscles du dos et des bras.",4));
    ajoute(new Exercice("Squat",10,3," Mouvement d'accroupi qui constitue un exercice poly-articulaire de force et de musculation ciblant les muscles de la cuisse et des fessiers",5));
}

public void ajoute(Exercice e){
        listeExo.add(e);
}
public ArrayList<Exercice>getListeExo(){
        return listeExo;
}
}

