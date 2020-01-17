package com.example.univeristyligthhousekeeper.DatabaseModel;

import android.content.Context;

import java.util.List;

public class JednostkaNadrzednaKN {
    int id;
    String jednostkaNadrzedna;
    private List<KoloNaukowe> kolaNaukowe;
    DatabaseAccess databaseAccess;
    Context context;

    public JednostkaNadrzednaKN() {

    }

    public JednostkaNadrzednaKN(int id, String jednostkaNadrzedna) {
        this.id = id;
        this.jednostkaNadrzedna = jednostkaNadrzedna;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getJednostkaNadrzedna() {
        return jednostkaNadrzedna;
    }

    public void setJednostkaNadrzedna(String jednostkaNadrzedna) {
        this.jednostkaNadrzedna = jednostkaNadrzedna;
    }

    public List<KoloNaukowe> getKolaNaukowe() {
        return kolaNaukowe;
    }

    public void setKolaNaukowe(List<KoloNaukowe> kolaNaukowe) {
        this.kolaNaukowe = kolaNaukowe;
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
