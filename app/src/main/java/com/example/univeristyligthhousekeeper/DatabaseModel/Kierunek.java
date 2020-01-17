package com.example.univeristyligthhousekeeper.DatabaseModel;

public class Kierunek {
    int id;
    int wydzialId;
    String kierunek;
    String opisKierunku;

    public Kierunek() {
    }

    public Kierunek(int id, int wydzialId, String kierunek, String opisKierunku) {
        this.id = id;
        this.wydzialId = wydzialId;
        this.kierunek = kierunek;
        this.opisKierunku = opisKierunku;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getWydzialId() {
        return wydzialId;
    }

    public void setWydzialId(int wydzialId) {
        this.wydzialId = wydzialId;
    }

    public String getKierunek() {
        return kierunek;
    }

    public void setKierunek(String kierunek) {
        this.kierunek = kierunek;
    }

    public String getOpisKierunku() {
        return opisKierunku;
    }

    public void setOpisKierunku(String opisKierunku) {
        this.opisKierunku = opisKierunku;
    }
}
