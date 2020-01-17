package com.example.univeristyligthhousekeeper.DatabaseModel;

public class KoloNaukowe {
    int id;
    int JNid;
    String koloNaukowe;
    String opisKolaNaukowego;

    public KoloNaukowe() {}

    public KoloNaukowe(int id, int JNid, String koloNaukowe, String opisKolaNaukowego) {
        this.id = id;
        this.JNid = JNid;
        this.koloNaukowe = koloNaukowe;
        this.opisKolaNaukowego = opisKolaNaukowego;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getJNid() {
        return JNid;
    }

    public void setJNid(int JNid) {
        this.JNid = JNid;
    }

    public String getKoloNaukowe() {
        return koloNaukowe;
    }

    public void setKoloNaukowe(String koloNaukowe) {
        this.koloNaukowe = koloNaukowe;
    }

    public String getOpisKolaNaukowego() {
        return opisKolaNaukowego;
    }

    public void setOpisKolaNaukowego(String opisKolaNaukowego) {
        this.opisKolaNaukowego = opisKolaNaukowego;
    }
}
