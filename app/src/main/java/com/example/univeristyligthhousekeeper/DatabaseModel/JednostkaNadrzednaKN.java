package com.example.univeristyligthhousekeeper.DatabaseModel;

public class JednostkaNadrzednaKN {
    int id;
    String jednostkaNadrzedna;

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
}
