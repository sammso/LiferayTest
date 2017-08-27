/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.squadd.receiptprinting.model;

import java.io.Serializable;

/**
 *
 * @author smoczyna
 */
public class Product implements Serializable {
    
    private String name;
    private double price;
    private double tax;
    private double importDuty;

    public Product() {        
    }
    
    public Product(String name, double price, double tax, double importDuty) {
        this.name = name;
        this.price = price;
        this.tax = tax;
        this.importDuty = importDuty;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getTax() {
        return tax;
    }

    public void setTax(double tax) {
        this.tax = tax;
    }

    public double getImportDuty() {
        return importDuty;
    }

    public void setImportDuty(double importDuty) {
        this.importDuty = importDuty;
    }

    @Override
    public String toString() {
        return this.name + " at " + this.price;
    }


}
