/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Booking_pack;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Ben
 */
public class BOOKING_BL extends AbstractTableModel {
    private ArrayList<BOOKING_BS> bookingSets = new ArrayList<>();
    private String[] colnames = {"Datum","Anmerkung","Konto Soll","Konto Haben","Betrag Soll","Betrag Haben"};
    
    public void add(BOOKING_BS bs){
        bookingSets.add(bs);
        fireTableDataChanged();
    }
    
    public void delete(int index){
        bookingSets.remove(index);
        fireTableDataChanged();
    }

    @Override
    public int getRowCount() {
        return bookingSets.size();
    }

    @Override
    public int getColumnCount() {
        return colnames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex){
            case 0: return bookingSets.get(rowIndex).getDate();
            case 1: return bookingSets.get(rowIndex).getText();
            case 2: return bookingSets.get(rowIndex).getAccountShould();
            case 3: return bookingSets.get(rowIndex).getAccountHave();
            case 4: return bookingSets.get(rowIndex).getAmountShould();
            case 5: return bookingSets.get(rowIndex).getAmountHave();
        }
        return null;
    }

    @Override
    public String getColumnName(int column) {
        return colnames[column]; //To change body of generated methods, choose Tools | Templates.
    }
    
    public BOOKING_BS get(int index){
        return bookingSets.get(index);
    }
    
    public void save() throws Exception {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File("booking_data.bin")));
        for (BOOKING_BS bs : bookingSets) {
            oos.writeObject(bs);
        }
        oos.flush();
        oos.close();
    }
    
    public void load() throws Exception {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File("booking_data.bin")));
        BOOKING_BS o;
        while((o=(BOOKING_BS)ois.readObject())!=null){
            bookingSets.add(o);
        }
    }
}
