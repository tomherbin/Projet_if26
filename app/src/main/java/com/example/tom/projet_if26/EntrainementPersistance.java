package com.example.tom.projet_if26;

import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.tom.projet_if26.PersistanceInterface;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.Iterator;


public class EntrainementPersistance extends SQLiteOpenHelper implements PersistanceInterface {


    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "Entrainement.db";
    // nom du fichier pour la base
    private static final String TABLE_ENTRAINEMENT = "entrainement";
    // liste des attributs
    private static final String ATTRIBUT_TITRE_ENTRAINEMENT = "titreEntrainement";
    private static final String ATTRIBUT_KEY = "key";
    private static final String ATTRIBUT_REPETITION = "repetition";

/*
    // nom de la table
    private static final String TABLE_EXERCICE = "exercice";
    //attributs
    private static final String ATTRIBUT_TITRE_EXERCICE = "titreExercice";
    private static final String ATTRIBUT_EXERCICEKEY = "exerciceKey";
    private static final String ATTRIBUT_REPS = "reps";
    private static final String ATTRIBUT_SERIE = "serie";
*/


    public EntrainementPersistance(Context context ) {
        super(context, DATABASE_NAME, null, 1);
    }

    public void onCreate(SQLiteDatabase db) {
        final String table_entrainement_create =
                "CREATE TABLE " + TABLE_ENTRAINEMENT + "(" +
                        ATTRIBUT_KEY + "INTEGER PRIMARY KEY AUTOINCREMENT," +
                        ATTRIBUT_TITRE_ENTRAINEMENT + " TEXT," +
                        ATTRIBUT_REPETITION + "INTEGER)";
        db.execSQL(table_entrainement_create);

    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE " + TABLE_ENTRAINEMENT);
        onCreate(db);
    }

    public void addEntrainement(String nom) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(ATTRIBUT_TITRE_ENTRAINEMENT, nom);
        values.put(ATTRIBUT_REPETITION,0);

        db.insert(TABLE_ENTRAINEMENT, null, values);
        db.close();
    }

    public Cursor getListEntrainement() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor data = db.rawQuery("SELECT titreEntrainement FROM " + TABLE_ENTRAINEMENT,null);
        return  data;

    }
    public void initData(){
        PredefiniEntrainement liste = new PredefiniEntrainement();
        for (ListeEntrainement l : liste.getListe()){
            addEntrainement(l.getTitre());
        }
    }

/*--------------------
    @Override
    public void onCreate(SQLiteDatabase db) {

       /* final String table_exercice_create =
                "CREATE TABLE " + TABLE_EXERCICE + "(" +
                        ATTRIBUT_EXERCICEKEY + " TEXT primary key,"  +
                        ATTRIBUT_KEY + " TEXT primary key,"  +
                        ATTRIBUT_TITRE_EXERCICE + " TEXT, " +
                        ATTRIBUT_REPS + " INTEGER, " +
                        ATTRIBUT_SERIE + " INTEGER)";

        final String table_entrainement_create =
                "CREATE TABLE " + TABLE_ENTRAINEMENT + "(" +
                        ATTRIBUT_KEY + "TEXT primary key,"  +
                        ATTRIBUT_TITRE_ENTRAINEMENT + " TEXT, +" +
                        ATTRIBUT_REPETITION +"INTEGER)";


       // final String fk = "ALTER TABLE" + TABLE_EXERCICE + "\n" +
        //        "ADD CONSTRAINT fk_exercice_key FOREIGN KEY ("+ATTRIBUT_EXERCICEKEY+") REFERENCES "+TABLE_ENTRAINEMENT+"("+ATTRIBUT_EXERCICEKEY+"); ";
        db.execSQL(table_entrainement_create);
        //db.execSQL(table_exercice_create);
       // db.execSQL(fk);
       //System.out.println("Table créé : "+table_exercice_create);
        System.out.println("Table créé : "+table_entrainement_create);
      //  System.out.println("Clé étrangère créée : "+fk);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

     //   db.execSQL("DROP TABLE "+TABLE_EXERCICE);
        db.execSQL("DROP TABLE "+TABLE_ENTRAINEMENT);
        onCreate(db);
    }

    @Override
    public void addEntrainement(ProgrammeEntrainement p) {

        SQLiteDatabase db = this.getWritableDatabase();

        Iterator it = p.getExercice().iterator();
        while(it.hasNext()) {
            Exercice exo = (Exercice) it.next();
            ContentValues values = new ContentValues();
            values.put(ATTRIBUT_TITRE_ENTRAINEMENT, p.getTitre());
            values.put(ATTRIBUT_KEY, p.getKey());
            values.put(ATTRIBUT_EXERCICEKEY, exo.getExerciceKey());

            db.insert(TABLE_ENTRAINEMENT, null, values);

        }


        db.close();
        System.out.println("Ajout du module : "+p.toString());

    }

    @Override
    public void initData() {
System.out.println("Création");



    }

    @Override
    public void delEntrainement(ProgrammeEntrainement p) {

    }

    @Override
    public void updateEntrainement(ProgrammeEntrainement p) {

    }

    @Override
    public ProgrammeEntrainement getEntrainement(String key) {
        return null;
    }

    /*
    @Override
    public ProgrammeEntrainement getEntrainement(String key) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM "+TABLE_ENTRAINEMENT+" WHERE "+ATTRIBUT_KEY+"=?",new String[]{key});
        ProgrammeEntrainement p = new ProgrammeEntrainement(c.getString(0), c.getString(3), c.g(2));
        db.close();
        return p;
    }




    @Override
    public int countEntrainement() {
        return 0;
    }

    @Override
    public ArrayList<ProgrammeEntrainement> getAllEntrainements() {
        return null;
    }


    public ArrayList<Exercice> getAllExercice() {

        ArrayList<Exercice> exercices = new ArrayList<>();

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM "+TABLE_EXERCICE ,null);
        if(c.moveToFirst()){
            do{
                exercices.add(new Exercice(c.getString(0),  c.getInt(1) , c.getInt(2) ,c.getString(3)));
            }while(c.moveToNext());
        }
        db.close();
        return exercices;

    }

  ---------------------  */
}
