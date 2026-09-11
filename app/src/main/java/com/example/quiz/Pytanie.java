package com.example.quiz;

public class Pytanie {
    public int idObrazka;
    public String trescPytania;
    public String odp1, odp2, odp3;
    public int poprawnaOdpIndex;

    public Pytanie(int idObrazka, String trescPytania, String odp1, String odp2, String odp3, int poprawnaOdpIndex) {
        this.idObrazka = idObrazka;
        this.trescPytania = trescPytania;
        this.odp1 = odp1;
        this.odp2 = odp2;
        this.odp3 = odp3;
        this.poprawnaOdpIndex = poprawnaOdpIndex;
    }
}