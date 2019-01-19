package com.example.tom.projet_if26;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;

public class PersistanceTraining extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 1;
    // nom du fichier pour la base
    public static final String DATABASE_NAME = "Entrainement.db";
    // nom de la table
    private static final String TABLE_ENTRAINEMENT = "entrainement";
    // liste des attributs
    private static final String ATTRIBUT_TITRE_ENTRAINEMENT = "titreEntrainement";
    private static final String ATTRIBUT_KEY = "key";
    private static final String ATTRIBUT_REPETITION = "repetition";

    public PersistanceTraining(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public void onCreate(SQLiteDatabase db) {
        final String table_entrainement_create =
                "CREATE TABLE " + TABLE_ENTRAINEMENT + "(" +
                        ATTRIBUT_KEY + "INTEGER PRIMARY KEY ," +
                        ATTRIBUT_TITRE_ENTRAINEMENT + " VARCHAR," +
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

        db.insert(TABLE_ENTRAINEMENT, null, values);
        db.close();
    }

    public void initData(){
        PredefiniEntrainement liste = new PredefiniEntrainement();
        for (ListeEntrainement l : liste.getListe()){
            addEntrainement(l.getTitre());
        }
    }
    public ArrayList<ListeEntrainement> getAllEntrainements(){
        ArrayList<ListeEntrainement> listes = new ArrayList<ListeEntrainement>();
        String selectQuery = "SELECT * FROM "+ TABLE_ENTRAINEMENT;

        SQLiteDatabase bdd=  this.getReadableDatabase();
        Cursor cursor =bdd.rawQuery(selectQuery,null);

        if (cursor.moveToFirst()){
            do{
                listes.add(new ListeEntrainement(cursor.getString(1),0));
            }while(cursor.moveToNext());
        }
        bdd.close();
        return listes;
    }
}
