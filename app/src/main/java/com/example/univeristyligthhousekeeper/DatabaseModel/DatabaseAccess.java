package com.example.univeristyligthhousekeeper.DatabaseModel;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class DatabaseAccess {
    private SQLiteOpenHelper openHelper;
    private SQLiteDatabase database;
    private static DatabaseAccess instance;

    private DatabaseAccess(Context context){
        this.openHelper = new Database(context);
    }

    public static DatabaseAccess getInstance(Context context){
        if(instance == null) instance = new DatabaseAccess(context);
        return instance;
    }

    public void open(){
        this.database = openHelper.getWritableDatabase();
    }

    public void close() {
        if(database != null)
            this.database.close();
    }

    public List<Wydzial> getWydzialy(){

        List<Wydzial> wydzialy = new ArrayList<Wydzial>();

        String selectQuery = "SELECT * FROM wydzialy";
        Cursor cursor = database.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                Wydzial wydzial = new Wydzial();
                wydzial.setId(cursor.getInt(0));
                wydzial.setWydzial(cursor.getString(1));
                wydzial.setKierunki(getKierunkidlaWydzialu(wydzial.getId()));
                wydzialy.add(wydzial);
                Log.d("Wydzial dodany: ", wydzial.getWydzial());
            } while (cursor.moveToNext());
        }
        return wydzialy;
    }

    public List<Kierunek> getKierunki()
    {
        List<Kierunek> kierunki = new ArrayList<Kierunek>();

        String selectQuery = "SELECT * FROM kierunki";
        Cursor cursor = database.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                Kierunek kierunek = new Kierunek();
                kierunek.setId(cursor.getInt(0));
                kierunek.setWydzialId(cursor.getInt(1));
                kierunek.setKierunek(cursor.getString(2));
                kierunek.setOpisKierunku(cursor.getString(3));
                // Adding contact to list
                kierunki.add(kierunek);
            } while (cursor.moveToNext());
        }
        return kierunki;
    }

    public List<JednostkaNadrzednaKN> getJednostkiNadrzedne()
    {
        List<JednostkaNadrzednaKN> jednostkaNadrzedne = new ArrayList<JednostkaNadrzednaKN>();

        String selectQuery = "SELECT * FROM jednostki_nadrzedne";
        Cursor cursor = database.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                JednostkaNadrzednaKN jednostkaNadrzednaKN = new JednostkaNadrzednaKN();
                jednostkaNadrzednaKN.setId(cursor.getInt(0));
                jednostkaNadrzednaKN.setJednostkaNadrzedna(cursor.getString(1));
                jednostkaNadrzednaKN.setKolaNaukowe(getKolaNaukoweDlaJN(jednostkaNadrzednaKN.getId()));
                jednostkaNadrzedne.add(jednostkaNadrzednaKN);
            } while (cursor.moveToNext());
        }
        return jednostkaNadrzedne;
    }

    public List<KoloNaukowe> getKolaNaukowe()
    {
        List<KoloNaukowe> kolaNaukowe = new ArrayList<KoloNaukowe>();

        String selectQuery = "SELECT * FROM kola_naukowe";
        Cursor cursor = database.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                KoloNaukowe koloNaukowe = new KoloNaukowe();
                koloNaukowe.setId(cursor.getInt(0));
                koloNaukowe.setJNid(cursor.getInt(1));
                koloNaukowe.setKoloNaukowe(cursor.getString(2));
                koloNaukowe.setOpisKolaNaukowego(cursor.getString(3));
                // Adding contact to list
                kolaNaukowe.add(koloNaukowe);
            } while (cursor.moveToNext());
        }
        return kolaNaukowe;
    }

    public List<Kierunek> getKierunkidlaWydzialu(int id)
    {
        List<Kierunek> kierunkiDlaWydzialu = new ArrayList<Kierunek>();
        String selectQuery = "SELECT * FROM kierunki WHERE wydzialID ='" + id + "';";
        Cursor cursor = database.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                Kierunek kierunek = new Kierunek();
                kierunek.setId(cursor.getInt(0));
                kierunek.setWydzialId(cursor.getInt(1));
                kierunek.setKierunek(cursor.getString(2));
                kierunek.setOpisKierunku(cursor.getString(3));
                // Adding contact to list
                kierunkiDlaWydzialu.add(kierunek);
                Log.d("Kierunek dodany: ", kierunek.getKierunek());
            } while (cursor.moveToNext());
        }

        return kierunkiDlaWydzialu;
    }

    public Kierunek getKierunek(int id)
    {
        List<Kierunek> kierunki = new ArrayList<Kierunek>();
        String selectQuery = "SELECT * FROM kierunki WHERE id ='" + id + "';";
        Cursor cursor = database.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                Kierunek kierunek = new Kierunek();
                kierunek.setId(cursor.getInt(0));
                kierunek.setWydzialId(cursor.getInt(1));
                kierunek.setKierunek(cursor.getString(2));
                kierunek.setOpisKierunku(cursor.getString(3));
                // Adding contact to list
                kierunki.add(kierunek);
                Log.d("Kierunek dodany: ", kierunek.getKierunek());
            } while (cursor.moveToNext());
        }

        return kierunki.get(0);
    }

    public KoloNaukowe getKoloNaukowe(int id)
    {
        List<KoloNaukowe> kolaNaukowes = new ArrayList<KoloNaukowe>();
        String selectQuery = "SELECT * FROM kola_naukowe WHERE id ='" + id + "';";
        Cursor cursor = database.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                KoloNaukowe koloNaukowe = new KoloNaukowe();
                koloNaukowe.setId(cursor.getInt(0));
                koloNaukowe.setJNid(cursor.getInt(1));
                koloNaukowe.setKoloNaukowe(cursor.getString(2));
                koloNaukowe.setOpisKolaNaukowego(cursor.getString(3));
                // Adding contact to list
                kolaNaukowes.add(koloNaukowe);
                Log.d("Kierunek dodany: ", koloNaukowe.getKoloNaukowe());
            } while (cursor.moveToNext());
        }

        return kolaNaukowes.get(0);
    }

    public Wydzial getWydzial(int id){

        List<Wydzial> wydzialy = new ArrayList<Wydzial>();

        String selectQuery = "SELECT * FROM wydzialy WHERE id ='" + id + "';";
        Cursor cursor = database.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                Wydzial wydzial = new Wydzial();
                wydzial.setId(cursor.getInt(0));
                wydzial.setWydzial(cursor.getString(1));
                wydzial.setKierunki(getKierunkidlaWydzialu(wydzial.getId()));
                wydzialy.add(wydzial);
                Log.d("Wydzial dodany: ", wydzial.getWydzial());
            } while (cursor.moveToNext());
        }
        return wydzialy.get(0);
    }

    public List<KoloNaukowe> getKolaNaukoweDlaJN(int id)
    {
        List<KoloNaukowe> kolaNaukoweDlaJN = new ArrayList<KoloNaukowe>();
        String selectQuery = "SELECT * FROM kola_naukowe WHERE jn_id ='" + id + "';";
        Cursor cursor = database.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                KoloNaukowe koloNaukowe = new KoloNaukowe();
                koloNaukowe.setId(cursor.getInt(0));
                koloNaukowe.setJNid(cursor.getInt(1));
                koloNaukowe.setKoloNaukowe(cursor.getString(2));
                koloNaukowe.setOpisKolaNaukowego(cursor.getString(3));
                // Adding contact to list
                kolaNaukoweDlaJN.add(koloNaukowe);
            } while (cursor.moveToNext());
        }

        return kolaNaukoweDlaJN;
    }

}
