package com.example.univeristyligthhousekeeper.DatabaseModel;

public class Wydzial {

    private int id;
    private String wydzial;

    public Wydzial() { }

    public Wydzial(int id, String wydzial) {
        this.id = id;
        this.wydzial = wydzial;
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


}
