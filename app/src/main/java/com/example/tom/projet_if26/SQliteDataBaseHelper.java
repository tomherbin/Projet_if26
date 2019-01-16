package com.example.tom.projet_if26;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class SQliteDataBaseHelper extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "Entrainement.db";
    // nom du fichier pour la base
    private static final String TABLE_ENTRAINEMENT = "entrainement";
    // liste des attributs
    private static final String ATTRIBUT_TITRE_ENTRAINEMENT = "titreEntrainement";
    private static final String ATTRIBUT_KEY = "key";


    // nom de la table
    private static final String TABLE_EXERCICE = "exercice";
    //attributs
    private static final String ATTRIBUT_TITRE_EXERCICE = "titreExercice";
    private static final String ATTRIBUT_EXERCICEKEY = "exerciceKey";
    private static final String ATTRIBUT_REPS = "reps";
    private static final String ATTRIBUT_SERIE = "serie";


    public SQliteDataBaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        System.out.println("Banzaiiiii");
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        final String table_entrainement_create =
                "CREATE TABLE " + TABLE_ENTRAINEMENT + "(" +
                        ATTRIBUT_KEY + "TEXT primary key,"  +
                        ATTRIBUT_TITRE_ENTRAINEMENT + " TEXT)";
        db.execSQL(table_entrainement_create);


        final String table_exercice_create =
                "CREATE TABLE " + TABLE_EXERCICE + "(" +
                        ATTRIBUT_EXERCICEKEY + " TEXT primary key,"  +
                        ATTRIBUT_KEY + " TEXT primary key,"  +
                        ATTRIBUT_TITRE_EXERCICE + " TEXT, " +
                        ATTRIBUT_REPS + " INTEGER, " +
                        ATTRIBUT_SERIE + " INTEGER)";
        db.execSQL(table_exercice_create);
        System.out.println("Banzaiiiii");
        System.out.println("Banzaiiiii");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
