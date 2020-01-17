package com.example.univeristyligthhousekeeper.DatabaseModel;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class DatabaseAccess {
    private SQLiteOpenHelper openHelper;
    private SQLiteDatabase database;
    private static DatabaseAccess instance;
    Cursor c = null;

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
        c = database.rawQuery(selectQuery, null);

        if (c.moveToFirst()) {
            do {
                Wydzial wydzial = new Wydzial();
                wydzial.setId(c.getInt(0));
                wydzial.setWydzial(c.getString(1));
                // Adding contact to list
                wydzialy.add(wydzial);
            } while (c.moveToNext());
        }
        return wydzialy;
    }

    public List<Kierunek> getKierunki()
    {
        List<Kierunek> kierunki = new ArrayList<Kierunek>();

        String selectQuery = "SELECT * FROM kierunki";
        c = database.rawQuery(selectQuery, null);

        if (c.moveToFirst()) {
            do {
                Kierunek kierunek = new Kierunek();
                kierunek.setId(c.getInt(0));
                kierunek.setWydzialId(c.getInt(1));
                kierunek.setKierunek(c.getString(2));
                kierunek.setOpisKierunku(c.getString(3));
                // Adding contact to list
                kierunki.add(kierunek);
            } while (c.moveToNext());
        }
        return kierunki;
    }
}
