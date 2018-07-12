package com.rehberapp.model;

public class Rehber {
    String adsoyad;
    Long telefon;

    public Rehber(){

    }

    public Rehber(String adsoyad, Long telefon) {
        this.adsoyad = adsoyad;
        this.telefon = telefon;
    }


    public String getAdsoyad() {
        return adsoyad;
    }

    public void setAdsoyad(String adsoyad) {
        this.adsoyad = adsoyad;
    }

    public Long getTelefon() {
        return telefon;
    }

    public void setTelefon(Long telefon) {
        this.telefon = telefon;
    }
}
