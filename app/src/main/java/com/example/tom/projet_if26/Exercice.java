package com.example.tom.projet_if26;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

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

    public Exercice(Parcel in){
        readFromParcel(in);
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public int getReps() {
        return reps;
    }

    public void setReps(int reps) {
        this.reps = reps;
    }

    public int getSerie() {
        return serie;
    }

    public void setSerie(int serie) {
        this.serie = serie;
    }

    public String getDesc(){
        return desc;
    }
    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(titre);
        dest.writeInt(reps);
        dest.writeInt(serie);
        dest.writeString(desc);
        dest.writeInt(ID);
    }
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
