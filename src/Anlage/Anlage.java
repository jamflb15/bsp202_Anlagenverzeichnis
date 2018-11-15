/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Anlage;

/**
 *
 * @author floha
 */
public class Anlage {
    private String bezeichnung;
    private int ak;
    private float inbetriebnahme;
    private float nd;
    private float bnd;
    private float afan;
    private float wert;
    private float afadj;
    private float bwende;

    public String getBezeichnung() {
        return bezeichnung;
    }

    public int getAk() {
        return ak;
    }

    public float getInbetriebnahme() {
        return inbetriebnahme;
    }

    public float getNd() {
        return nd;
    }

    public float getBnd() {
        return bnd;
    }

    public float getAfan() {
        return afan;
    }

    public float getWert() {
        return wert;
    }

    public float getAfadj() {
        return afadj;
    }

    public float getBwende() {
        return bwende;
    }

    public Anlage(String bezeichnung, int ak, float inbetriebnahme, float nd, float bnd, float afan, float wert, float afadj, float bwende) {
        this.bezeichnung = bezeichnung;
        this.ak = ak;
        this.inbetriebnahme = inbetriebnahme;
        this.nd = nd;
        this.bnd = bnd;
        this.afan = afan;
        this.wert = wert;
        this.afadj = afadj;
        this.bwende = bwende;
    }

    public Anlage() {
    }

    public Anlage(String bezeichnung, int ak, float inbetriebnahme, float nd) {
        this.bezeichnung = bezeichnung;
        this.ak = ak;
        this.inbetriebnahme = inbetriebnahme;
        this.nd = nd;
    }
    
    
    
    
    
}
