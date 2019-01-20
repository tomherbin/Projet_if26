package com.example.tom.projet_if26;

import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.tom.projet_if26.PersistanceInterface;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Iterator;


public class EntrainementPersistance extends SQLiteOpenHelper {


    public static final int DATABASE_VERSION = 2;
    // nom du fichier pour la base
    public static final String DATABASE_NAME = "Training.db";
    // nom de la table
    private static final String TABLE_ENTRAINEMENT = "entrainement";
    // liste des attributs
    private static final String ATTRIBUT_TITRE_ENTRAINEMENT = "titreEntrainement";
    private static final String ATTRIBUT_KEY = "cle";
    private static final String ATTRIBUT_REPETITION = "reps";
    private static final String ATTRIBUT_KEY_ID_EXERCICES ="id_cle";
    private static final String ATTRIBUT_DESCRIPTION_ENT = "des_entre";


    // nom de la table
    private static final String TABLE_EXERCICE = "exercice";
    //attributs
    private static final String ATTRIBUT_TITRE_EXERCICE = "titreExercice";
    private static final String ATTRIBUT_EXERCICEKEY = "exerciceKey";
    private static final String ATTRIBUT_REPS = "reps";
    private static final String ATTRIBUT_SERIE = "serie";
    private static final String ATTRIBUT_DESCRIPTION_EXO="des_exo";

    private static final String TABLE_PROGRAMME ="programme";




    public EntrainementPersistance(Context context ) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    public EntrainementPersistance(Context context, String name, SQLiteDatabase.CursorFactory factory,
                                    int version) {
        super(context, name, factory, version);}

    public void onCreate(SQLiteDatabase db) {
        final String table_entrainement_create =
                "CREATE TABLE " + TABLE_ENTRAINEMENT + "(" +
                        ATTRIBUT_KEY + "INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        ATTRIBUT_TITRE_ENTRAINEMENT + " VARCHAR," +
                        ATTRIBUT_REPETITION + "INTEGER," +
                        ATTRIBUT_KEY_ID_EXERCICES + "INTEGER,"+
                        ATTRIBUT_DESCRIPTION_ENT + "VARCHAR)";

        db.execSQL(table_entrainement_create);

        final String table_exercice_create =
                "CREATE TABLE " + TABLE_EXERCICE + "(" +
                        ATTRIBUT_EXERCICEKEY + " TEXT primary key,"  +
                        ATTRIBUT_KEY + " TEXT primary key,"  +
                        ATTRIBUT_TITRE_EXERCICE + " TEXT, " +
                        ATTRIBUT_REPS + " INTEGER, " +
                        ATTRIBUT_SERIE + " INTEGER," +
                        ATTRIBUT_DESCRIPTION_EXO + "VARCHAR)";
        db.execSQL(table_exercice_create);

        final String table_programme_create =
                "CREATE TABLE "+ TABLE_PROGRAMME +"("+
                        ATTRIBUT_KEY + "INTEGER, "+
                        ATTRIBUT_KEY_ID_EXERCICES + "INTERGER)";
        db.execSQL(table_programme_create);


    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE  " + TABLE_ENTRAINEMENT);
        db.execSQL("DROP TABLE " + TABLE_EXERCICE);
        db.execSQL("DROP TABLE " + TABLE_PROGRAMME);
        onCreate(db);
    }

    public void addEntrainement(ListeEntrainement nom) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(ATTRIBUT_TITRE_ENTRAINEMENT, nom.getTitre());
        values.put(ATTRIBUT_DESCRIPTION_ENT, nom.getDescription());
        values.put(ATTRIBUT_REPETITION,0);
        db.insert(TABLE_ENTRAINEMENT, null, values);
        db.close();
    }

    public void initData(){
        PredefiniEntrainement liste = new PredefiniEntrainement();
        for (ListeEntrainement l : liste.getListe()){
            addEntrainement(l);
        }
    }


    public ArrayList<ListeEntrainement>getAllEntrainements(){
        ArrayList<ListeEntrainement> listes = new ArrayList<ListeEntrainement>();
        String selectQuery = "SELECT * FROM "+ TABLE_ENTRAINEMENT;

        SQLiteDatabase bdd=  this.getReadableDatabase();
        Cursor cursor =bdd.rawQuery(selectQuery,null);

        if (cursor.moveToFirst()){
            do{
                listes.add(new ListeEntrainement(cursor.getString(1),cursor.getInt(2),cursor.getString(4)));
                listes.get(listes.size()-1).setID(cursor.getInt(0));            }while(cursor.moveToNext());
        }
        bdd.close();
        return listes;
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
