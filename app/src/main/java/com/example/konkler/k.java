package com.example.konkler;

import com.google.gson.annotations.SerializedName;

public class k {
    @SerializedName("tresc")
    private String tP;
    private String oA;
    private String oB;
    private String oC;
    private String Poprawne;
    private String uO;
    private String czyPoprawne;

    public k(String tP, String oA, String oB, String oC, String Poprawne, String uO, String czyPoprawne) {
        this.tP = tP;
        this.oA = oA;
        this.oB = oB;
        this.oC = oC;
        this.Poprawne = Poprawne;
        this.uO = uO;
        this.czyPoprawne = czyPoprawne;
    }
}
