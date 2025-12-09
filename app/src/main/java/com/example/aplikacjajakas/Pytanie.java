package com.example.aplikacjajakas;

import com.google.gson.annotations.SerializedName;

public class Pytanie {
    @SerializedName("tresc")
    private String trescPytania;

    private String odp1;
    private String odp2;
    private String odp3;
    private int odp;

    public Pytanie(String trescPytania, String odp1, String odp2, String odp3, int odp) {
        this.trescPytania = trescPytania;
        this.odp1 = odp1;
        this.odp2 = odp2;
        this.odp3 = odp3;
        this.odp = odp;
    }

    public String getTrescPytania() {
        return trescPytania;
    }

    public void setTrescPytania(String trescPytania) {
        this.trescPytania = trescPytania;
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

    public int getOpd() {
        return odp;
    }

    public void setOpd(int opd) {
        this.odp = opd;
    }
}
