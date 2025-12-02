package com.example.aplikacjajakas;

import com.google.gson.annotations.SerializedName;
public class Pytanie {
    @SerializedName("tresc")
    private String tresc_pytania;
    private String odp1;
    private String odp2;
    private String odp3;
    private Integer poprawnao_odp;
    private Integer udzielona_odp;
    private boolean czy_poprawna;

    public Pytanie(String tresc_pytania, String odp1, String odp2, String odp3, Integer poprawnao_odp, Integer udzielona_odp, boolean czy_poprawna) {
        this.tresc_pytania = tresc_pytania;
        this.odp1 = odp1;
        this.odp2 = odp2;
        this.odp3 = odp3;
        this.poprawnao_odp = poprawnao_odp;
        this.udzielona_odp = udzielona_odp;
        this.czy_poprawna = czy_poprawna;
    }

    public String getTresc_pytania() {
        return tresc_pytania;
    }

    public void setTresc_pytania(String tresc_pytania) {
        this.tresc_pytania = tresc_pytania;
    }

    public String getOdp1() {
        return odp1;
    }

    public void setOdp1(String odp1) {
        this.odp1 = odp1;
    }

    public String getOdp2() {
        return odp2;
    }

    public void setOdp2(String odp2) {
        this.odp2 = odp2;
    }

    public String getOdp3() {
        return odp3;
    }

    public void setOdp3(String odp3) {
        this.odp3 = odp3;
    }

    public Integer getPoprawnao_odp() {
        return poprawnao_odp;
    }

    public void setPoprawnao_odp(Integer poprawnao_odp) {
        this.poprawnao_odp = poprawnao_odp;
    }

    public Integer getUdzielona_odp() {
        return udzielona_odp;
    }

    public void setUdzielona_odp(Integer udzielona_odp) {
        this.udzielona_odp = udzielona_odp;
    }

    public boolean isCzy_poprawna() {
        return czy_poprawna;
    }

    public void setCzy_poprawna(boolean czy_poprawna) {
        this.czy_poprawna = czy_poprawna;
    }
}
