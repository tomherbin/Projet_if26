package com.example.tom.projet_if26;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe qui génère les exercices prédéfinies de l'application
 */
public class ExerciceGenerator {
private ArrayList<Exercice> listeExo;
    public ExerciceGenerator(){
        listeExo = new ArrayList<>();
        init();

}

    /**
     * Initialise les objets.
     */
    public void init(){
        ajoute(new Exercice("Pompe",10,3,"Inspirer et fléchir les bras pour amener la cage thoracique près du sol sans creuser la région lornbaire. Un travail préalable de musculation statique en gainage permet de mieux sentir cette position \"corps droit\" sans cambrure et sans fesses pointant vers le haut.\n" +
                "Pousser jusqu'à l'extension cornplète des bras en gardant toujours le corps bien gainé et droit\n" +
                "Expirer profondément en fin de mouvement en rentrant le ventre sous le nombril pour renforcer aussi les muscles abdominaux profonds.",0));
    ajoute(new Exercice("Gainage",1,3,"Le gainage est un entraînement physique et de musculation qui permet de renforcer les muscles abdominaux et dorsaux. Réalisés en isométrie, ces exercices sollicitent les muscles de l'abdomen et du dos en profondeur, et participent au maintien et à la protection de la colonne vertébrale.",1));
    ajoute(new Exercice("Burpees",10,4,"Le burpee est un exercice de musculation et d'aérobic sollicitant l'ensemble du corps" +
            " L'exercice consiste en un enchaînement très simple à répéter en boucle : une flexion des jambes les mains au sol, suivi d'une lancer des pieds en arrière pour arriver en position de planche, tout en gardant les bras tendus, puis d'un retour en position de squat avant de finalement se relever.",2));
    ajoute(new Exercice("WallBall",12,3,"Face à un mur, faire un squat puis revenir droite et lancer la balle",3));
    ajoute(new Exercice("Traction",14,6,"La traction est un exercice physique consistant à hisser ses épaules au niveau d'une barre en la tenant par les mains. Les tractions ont pour objectif principal le développement des muscles du dos et des bras.",4));
    ajoute(new Exercice("Squat",7,3," Mouvement d'accroupi qui constitue un exercice poly-articulaire de force et de musculation ciblant les muscles de la cuisse et des fessiers",5));
    ajoute((new Exercice("Abdominaux",15,5,"Exercices pour muscler les abdominaux",6)));
}

    /**
     * Ajoute dans une liste d'exercice un exercice créé
     * @param e l'exercice à ajouter
     */
    public void ajoute(Exercice e){
        listeExo.add(e);
}

    /**
     * Récupère la liste d'exercice
     * @return liste d'exercice
     */
    public ArrayList<Exercice>getListeExo(){
        return listeExo;
}
}

