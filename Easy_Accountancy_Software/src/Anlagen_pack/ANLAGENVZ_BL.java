package Anlagen_pack;

import Anlagen_pack.ANLAGENVZ_Anlage;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Matthias
 */
public class ANLAGENVZ_BL extends AbstractTableModel{
    
    private ArrayList<ANLAGENVZ_Anlage> alleAnlagen = new ArrayList();
    private ArrayList<ANLAGENVZ_Anlage> anlagen = new ArrayList();
    private static String[] COLNAMES = {"Bezeichnung","AK","Inbetriebnahme","ND","bisherige ND","AfA bisher","Wert vor AfA","AfA d. J.","BW 31.12."};
    
    public void update(){
        calculate();
        fireTableDataChanged();
    }
    
    public void add(ANLAGENVZ_Anlage a){
        alleAnlagen.add(a);
        update();
    }
    
    public void delete(int... idx){
        for(int i=idx.length-1;i>=0;i--){
            alleAnlagen.remove(idx[i]);
        }
        update();
    }
    
    @Override
    public int getRowCount() {
        return anlagen.size();
    }

    @Override
    public int getColumnCount() {
        return 9;
    }
    
    public void calculate(){
        anlagen.clear();
        for (ANLAGENVZ_Anlage a : alleAnlagen) {
            
            a.setBis_nd(ANLAGENVZ_GUI.getYear()-a.getInbetriebnahme());
            a.setBis_afa(a.getAk()/a.getNd()*a.getBis_nd());
            a.setBw(a.getAk()-a.getBis_afa());
            if(a.getBis_nd()!=a.getNd())
                a.setAfaDJ(a.getAk()/a.getNd());
            else
                a.setAfaDJ(a.getBw());
            a.setBwEnde(a.getBw()-a.getAfaDJ());
            
            if(a.getInbetriebnahme()<=ANLAGENVZ_GUI.getYear()){
                anlagen.add(a);
            }
        }
    }

    @Override
    public String getColumnName(int i) {
        return COLNAMES[i];
    }

    
    
    @Override
    public Object getValueAt(int i, int i1) {
        ANLAGENVZ_Anlage a = anlagen.get(i);
        
        
        
        switch (i1) {
            case 0: return a.getBezeichnung();
            case 1: return a.getAk();
            case 2: return a.getInbetriebnahme();
            case 3: return a.getNd();
            case 4: return a.getBis_nd();
            case 5: return a.getBis_afa();
            case 6: return a.getBw();
            case 7: return a.getAfaDJ();
            case 8: return a.getBwEnde();
            default:
                return "???";
        }
    }
    
    /*public void load(File f){
        try(BufferedReader reader = new BufferedReader(new FileReader(f))){
            String line =reader.readLine();
            while((line = reader.readLine()) != null){
                
                    ANLAGENVZ_Anlage a = new ANLAGENVZ_Anlage(line);
                    alleAnlagen.add(a);
                
                
            }
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
    }*/
    
    public void load(File f) throws Exception {
        alleAnlagen.clear();
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f));
        Object o=null;
        while((o=ois.readObject())!=null){
            alleAnlagen.add((ANLAGENVZ_Anlage)o);
        }
    }
    
    public void save(File f) throws Exception {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(f));
        for (ANLAGENVZ_Anlage a : alleAnlagen) {
            oos.writeObject(a);
        }
        oos.flush();
        oos.close();
    }
    
}
