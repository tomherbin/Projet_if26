package com.example.tom.projet_if26;

import java.util.ArrayList;
import java.util.List;

/*private String titre;
private int reps;
private int serie;
private String ExerciceKey;
private String desc;*/
public class ExerciceGenerator {
    private static final String [] titre={
            "Pompe", "Gainage","Soulever de terre", "Burpees", "WallBall"
    };

    private static final int [] serie={
            3,3,3,3,3
    };

    private static final String[] desc ={
            "1. Inspirer et fléchir les bras pour amener la cage thoracique près du sol sans creuser " +
                    "la région lornbaire. Un travail préalable " +
                    "de musculation statique en gainage permet de mieux " +
                    "sentir cette position \"corps droit\" sans cambrure " +
                    "et sans fesses pointant vers le haut.\n " +
                    "2. Pousser jusqu'à l'extension" +
                    " cornplète des bras en gardant toujours le corps bien gainé et droit\n " +
                    "3.Expirer profondément en fin de mouvement en rentrant le ventre sous " +
                    "le nombril pour renforcer aussi les muscles abdominaux profonds." , "Test", "test","4","5"
    };

    private static final int []reps={
            15,1,5,10,5
    };

    public ExerciceGenerator(){

    }
    public static List<Exercice> getExercices(){
        ArrayList<Exercice> listeExos = new ArrayList<>();
        for (int i = 0;i<titre.length;i++){
            Exercice exo = new Exercice (titre[i], reps[i],serie[i],desc[i]);
            listeExos.add(exo);
        }
        return listeExos;

    }


}
