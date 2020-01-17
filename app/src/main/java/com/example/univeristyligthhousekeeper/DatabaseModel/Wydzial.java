package com.example.univeristyligthhousekeeper.DatabaseModel;

import android.content.Context;
import android.database.Cursor;
import android.util.Log;

import java.util.List;

public class Wydzial {

    private int id;
    private String wydzial;
    private List<Kierunek> kierunki;
    DatabaseAccess databaseAccess;
    Context context;

    public Wydzial() { }

    public Wydzial(int id, String wydzial, Context context) {
        this.id = id;
        this.wydzial = wydzial;
        this.context = context;
        databaseAccess = DatabaseAccess.getInstance(context);
        databaseAccess.open();
        this.kierunki = databaseAccess.getKierunkidlaWydzialu(id);
        databaseAccess.close();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getWydzial() {
        return wydzial;
    }

    public void setWydzial(String wydzial) {
        this.wydzial = wydzial;
    }

    public List<Kierunek> getKierunki() {
        return kierunki;
    }

    public void setKierunki(List<Kierunek> kierunki) {
        this.kierunki = kierunki;
    }

    public DatabaseAccess getDatabaseAccess() {
        return databaseAccess;
    }

    public void setDatabaseAccess(DatabaseAccess databaseAccess) {
        this.databaseAccess = databaseAccess;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }
}
