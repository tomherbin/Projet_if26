package com.example.tom.projet_if26;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

/**
 * Classe Exercice contient les attributs d'un exercice. Implémente Parcelable
 * pour mieux transiter les informations.
 */
public class Exercice implements Parcelable {

    private String titre;
    private int reps;
    private int serie;
    private String desc;
    private int ID;


    public Exercice(String titre, int reps, int serie, String desc,int ID)  {
        this.titre = titre;
        this.reps = reps;
        this.serie = serie;
        this.desc=desc;
        this.ID=ID;
    }

    /**
     * Constructeur iterface Parcelable
     * @param in
     */
    public Exercice(Parcel in){
        readFromParcel(in);
    }

    /**
     * Getter titre
     * @return le titre de l'exercice
     */
    public String getTitre() {
        return titre;
    }

    /**
     * Getter Répétition
     * @return le nombre de répétition d'un exercice
     */
    public int getReps() {
        return reps;
    }

    /**
     * Getter série
     * @return le nombre de séries d'un exercice
     */
    public int getSerie() {
        return serie;
    }

    /**
     * Getter description
     * @return la description d'un exercice
     */
    public String getDesc(){
        return desc;
    }
    /**
     * Getter id
     * @return l'id d'un exercice
     */
    public int getID() {
        return ID;
    }

    /**
     * Méthode Parcelable
     * @return 0
     */
    @Override
    public int describeContents() {
        return 0;
    }

    /**
     * Ajoute dans parcel, les valeurs que nous voulons envoyer
     * @param dest
     * @param flags
     */
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(titre);
        dest.writeInt(reps);
        dest.writeInt(serie);
        dest.writeString(desc);
        dest.writeInt(ID);
    }

    /**
     * Lit le contenu de l'attribut
     * @param in
     */
    public void readFromParcel(Parcel in){
        titre = in.readString();
        reps =  in.readInt();
        serie=in.readInt();
        desc= in.readString();
        ID=in.readInt();
    }
    public static final Parcelable.Creator CREATOR =
            new Parcelable.Creator() {
                public Exercice createFromParcel(Parcel in) {
                    return new Exercice(in);
                }

                public Exercice[] newArray(int size) {
                    return new Exercice[size];
                }
            };
}
