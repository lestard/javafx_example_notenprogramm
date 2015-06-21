package de.hszg.notenprogramm.model;

public class Fach extends Identity {

    private String titel;

    private int ectsPoints;

    private Double note;

    private int semester;

    public Fach(String titel, int ectsPoints, int semester) {
        this.titel = titel;
        this.ectsPoints = ectsPoints;
        this.semester = semester;
    }


    @Override
    public String toString() {
        return "Fach " + titel + "[ects=" + ectsPoints + ", note:" + note + "]";
    }

    public String getTitel() {
        return titel;
    }

    public void setTitel(String titel) {
        this.titel = titel;
    }

    public int getEctsPoints() {
        return ectsPoints;
    }

    public void setEctsPoints(int ectsPoints) {
        this.ectsPoints = ectsPoints;
    }

    public Double getNote() {
        return note;
    }

    public void setNote(Double note) {
        this.note = note;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }
}
