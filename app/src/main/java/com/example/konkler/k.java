package com.example.konkler;

import com.google.gson.annotations.SerializedName;

public class k {
    @SerializedName("tresc")
    private String tP;
    private String oA;
    private String oB;
    private String oC;
    private int Poprawne;
    //private String uO;
    //private String czyPoprawne;

    public k(String tP, String oA, String oB, String oC, int Poprawne ) {
        this.tP = tP;
        this.oA = oA;
        this.oB = oB;
        this.oC = oC;
        this.Poprawne = Poprawne;
        //this.uO = uO;
        //this.czyPoprawne = czyPoprawne;  String uO, String czyPoprawne
    }

    public String gettP() {
        return tP;
    }

    public void settP(String tP) {
        this.tP = tP;
    }

    public String getoA() {
        return oA;
    }

    public void setoA(String oA) {
        this.oA = oA;
    }

    public String getoB() {
        return oB;
    }

    public void setoB(String oB) {
        this.oB = oB;
    }

    public String getoC() {
        return oC;
    }

    public void setoC(String oC) {
        this.oC = oC;
    }

    public int getPoprawne() {
        return Poprawne;
    }

    public void setPoprawne(int poprawne) {
        Poprawne = poprawne;
    }
}
