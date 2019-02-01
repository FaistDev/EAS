package Anlagen_pack;

import java.io.Serializable;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Matthias
 */
public class ANLAGENVZ_Anlage implements Serializable {
    private String bezeichnung;
    private double aw;
    private double inbetriebnahme;
    private double nd;
    private double bis_nd;
    private double bis_afa;
    private double bw;
    private double afaDJ;
    private double bwEnde;
    
    public ANLAGENVZ_Anlage(String line) {
        String[] parts = line.split(";");
        this.bezeichnung = parts[0];
        this.aw = Integer.parseInt(parts[1].replace(".", ""));
        this.inbetriebnahme = Double.parseDouble(parts[2].replace(",", "."));
        this.nd = Double.parseDouble(parts[3].replace(",","."));
    }

    public ANLAGENVZ_Anlage(String bezeichnung, double ak, double inbetriebnahme, double nd) {
        this.bezeichnung = bezeichnung;
        this.aw = ak;
        this.inbetriebnahme = inbetriebnahme;
        this.nd = nd;
    }
    
    

    public double getBwEnde() {
        return bwEnde;
    }

    public String getBezeichnung() {
        return bezeichnung;
    }

    public Double getAk() {
        return aw;
    }

    public double getInbetriebnahme() {
        return inbetriebnahme;
    }

    public double getNd() {
        return nd;
    }

    public double getBis_nd() {
        return bis_nd;
    }

    public double getBis_afa() {
        return bis_afa;
    }

    public double getBw() {
        return bw;
    }

    public double getAfaDJ() {
        return afaDJ;
    }

    public void setBis_nd(double bis_nd) {
        this.bis_nd = bis_nd;
    }

    public void setBis_afa(double bis_afa) {
        this.bis_afa = bis_afa;
    }

    public void setBw(double bw) {
        this.bw = bw;
    }

    public void setAfaDJ(double afaDJ) {
        this.afaDJ = afaDJ;
    }

    public void setBwEnde(double bwEnde) {
        this.bwEnde = bwEnde;
    }
}
