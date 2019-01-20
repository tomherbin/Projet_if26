package com.example.tom.projet_if26;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;

public class PersistanceTraining extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 2;
    // nom du fichier pour la base
    public static final String DATABASE_NAME = "Entrainement.db";
    // nom de la table
    private static final String TABLE_ENTRAINEMENT = "entrainement";
    // liste des attributs
    private static final String ATTRIBUT_TITRE_ENTRAINEMENT = "titreEntrainement";
    private static final String ATTRIBUT_KEY = "cle";
    private static final String ATTRIBUT_REPETITION = "reps";
    private static final String ATTRIBUT_DESCRIPTION_ENT = "des_entre";

    private static final String TABLE_PROGRAMME ="programme";
    private static final String ATTRIBUT_ID_EPROG = "cleE";
    private static final String ATTRIBUT_ID_EXPROG = "cleEX";


    // nom de la table
    private static final String TABLE_EXERCICE = "exercice";
    //attributs
    private static final String ATTRIBUT_TITRE_EXERCICE = "titreExercice";
    private static final String ATTRIBUT_EXERCICEKEY = "exerciceKey";
    private static final String ATTRIBUT_REPS = "reps";
    private static final String ATTRIBUT_SERIE = "serie";
    private static final String ATTRIBUT_DESCRIPTION_EXO="des_exo";


    public PersistanceTraining(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    public void onCreate(SQLiteDatabase db) {
        final String table_entrainement_create =
                "CREATE TABLE " + TABLE_ENTRAINEMENT + "(" +
                        ATTRIBUT_KEY + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        ATTRIBUT_TITRE_ENTRAINEMENT + " VARCHAR," +
                        ATTRIBUT_REPETITION + " INTEGER," +
                        ATTRIBUT_DESCRIPTION_ENT + " VARCHAR)";

        db.execSQL(table_entrainement_create);

     final String table_exercice_create =
                "CREATE TABLE " + TABLE_EXERCICE + "(" +
                        ATTRIBUT_EXERCICEKEY + " INTEGER primary key autoincrement,"  +
                        ATTRIBUT_TITRE_EXERCICE + " TEXT, " +
                        ATTRIBUT_REPS + " INTEGER, " +
                        ATTRIBUT_SERIE + " INTEGER," +
                        ATTRIBUT_DESCRIPTION_EXO + "VARCHAR" +
                        ")";
        db.execSQL(table_exercice_create);

        final String table_programme_create =

                "CREATE TABLE "+ TABLE_PROGRAMME + "(cleE INTEGER, cleEX INTEGER, " +
                        "PRIMARY KEY(cleE, cleEX ), FOREIGN KEY (cleE) references entrainement (cle)" +
                        ",FOREIGN KEY (cleEx) references exercice (exerciceKey))";
        db.execSQL(table_programme_create);
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE  " + TABLE_ENTRAINEMENT);
        db.execSQL("DROP TABLE " + TABLE_EXERCICE);
        db.execSQL("DROP TABLE " + TABLE_PROGRAMME);
        onCreate(db);
    }

    public void addEntrainement(String nom, String desc) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(ATTRIBUT_TITRE_ENTRAINEMENT, nom);
        values.put(ATTRIBUT_DESCRIPTION_ENT, desc);
        values.put(ATTRIBUT_REPETITION,0);
        db.insert(TABLE_ENTRAINEMENT, null, values);
        db.close();
    }

    public void generateExos(Exercice exo){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(ATTRIBUT_TITRE_EXERCICE,exo.getTitre());
        values.put(ATTRIBUT_REPS,exo.getReps());
        values.put(ATTRIBUT_DESCRIPTION_EXO,exo.getDesc());
        values.put(ATTRIBUT_SERIE,exo.getSerie());

        db.insert(TABLE_EXERCICE, null, values);
        db.close();
    }

    public void initData(){
        PredefiniEntrainement liste = new PredefiniEntrainement();
        for (ListeEntrainement l : liste.getListe()){
            addEntrainement(l.getTitre(),l.getDescription());
        }
       ExerciceGenerator listeExo = new ExerciceGenerator();
        for(Exercice exo: listeExo.getExercices()){
            generateExos(exo);
        }

    }
    public ArrayList<ListeEntrainement>getAllEntrainements(){
        ArrayList<ListeEntrainement> listes = new ArrayList<ListeEntrainement>();
        String selectQuery = "SELECT * FROM "+ TABLE_ENTRAINEMENT;

        SQLiteDatabase bdd=  this.getReadableDatabase();
        Cursor cursor =bdd.rawQuery(selectQuery,null);

        if (cursor.moveToFirst()){
            do{
                listes.add(new ListeEntrainement(cursor.getString(1),cursor.getInt(2),cursor.getString(3),cursor.getInt(0)));
            }while(cursor.moveToNext());
        }
        bdd.close();
        return listes;
    }

    public ArrayList<Exercice>getAllExercices(){
        ArrayList<Exercice> listes = new ArrayList<>();
        String selectQuery ="SELECT * FROM " +TABLE_EXERCICE;
        SQLiteDatabase bdd= this.getReadableDatabase();
        Cursor cursor = bdd.rawQuery(selectQuery,null);

        if (cursor.moveToFirst()){
            do{
                listes.add(new Exercice(cursor.getString(1),cursor.getInt(2),cursor.getInt(3),cursor.getString(4)));
            }while(cursor.moveToNext());
        }
        bdd.close();
        return listes;
    }

}
