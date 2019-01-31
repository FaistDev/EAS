/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Booking_pack;

import java.io.Serializable;
import java.time.LocalDate;

/**
 *
 * @author Ben
 */
public class BOOKING_BS implements Serializable {
    private LocalDate date;
    private String text;
    private String accountShould;
    private String accountHave;
    private double amountShould;
    private double amountHave;

    public BOOKING_BS(LocalDate date, String text, String accountShould, String accountHave, double amountShould, double amountHave) {
        this.date = date;
        this.text = text;
        this.accountShould = accountShould;
        this.accountHave = accountHave;
        this.amountShould = amountShould;
        this.amountHave = amountHave;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getText() {
        return text;
    }

    public String getAccountShould() {
        return accountShould;
    }

    public String getAccountHave() {
        return accountHave;
    }

    public double getAmountShould() {
        return amountShould;
    }

    public double getAmountHave() {
        return amountHave;
    }
    
    
}
