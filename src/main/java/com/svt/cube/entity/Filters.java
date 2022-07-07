package com.svt.cube.entity;

public class Filters {

    private String tag;
    private String dateDebut;
    private String dateFin;

    public Filters(String tag, String dateDebut, String dateFin) {
        this.tag = tag;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
    }

    public String getTag() {
        return this.tag;
    }

    public String getDateDebut() {
        return this.dateDebut;
    }

    public String getDateFin() {
        return this.dateFin;
    }
}
