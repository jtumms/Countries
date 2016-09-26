package com.company;

/**
 * Created by john.tumminelli on 9/25/16.
 */
public class Capital
{
    public double dLST;
    public double tD;
    public int flg;
    public String name;
    public String[] geoPt;

    public Capital() {
    }

    public Capital(double dLST, double tD, int flg, String name, String[] geoPt) {
        this.dLST = dLST;
        this.tD = tD;
        this.flg = flg;
        this.name = name;
        this.geoPt = geoPt;
    }

    public double getdLST() {
        return dLST;
    }

    public double gettD() {
        return tD;
    }

    public int getFlg() {
        return flg;
    }

    public String getName() {
        return name;
    }

    public String[] getGeoPt() {
        return geoPt;
    }

    public void setdLST(double dLST) {
        this.dLST = dLST;
    }

    public void settD(double tD) {
        this.tD = tD;
    }

    public void setFlg(int flg) {
        this.flg = flg;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGeoPt(String[] geoPt) {
        this.geoPt = geoPt;
    }
}



