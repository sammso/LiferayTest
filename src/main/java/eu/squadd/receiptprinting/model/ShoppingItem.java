/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.squadd.receiptprinting.model;

import java.text.NumberFormat;

/**
 *
 * @author smoczyna
 */
public final class ShoppingItem extends Product {
    
    private final Integer quantity;
    private final Double overallPrice;
    private final Double taxAmount;
    private final Double importDutyAmount;

    public ShoppingItem(Product product, int quantity) {
        super(product.getName(), product.getPrice(), product.getTax(), product.getImportDuty());
        this.quantity = quantity;
        this.taxAmount = this.getTax()>0 ? (Math.round((this.getPrice()*this.getTax()/100) * 20.0) / 20.0) * this.getQuantity() : 0d;
        this.importDutyAmount = this.getImportDuty()>0 ? (Math.round((this.getPrice()*this.getImportDuty()/100) * 20.0) / 20.0) * this.getQuantity() : 0d;        
        this.overallPrice = this.getPrice() + this.taxAmount + this.importDutyAmount;
    }
    
    public Integer getQuantity() {
        return this.quantity;
    }

    public Double getOverallPrice() {
        return this.overallPrice;
    }

    public Double getTaxAmount() {
        return this.taxAmount;
    }

    public Double getImportDutyAmount() {
        return importDutyAmount;
    }
    
    @Override
    public String toString() {
        return this.prettyPrint();
    }
    
    private String prettyPrint() {
        StringBuilder item = new StringBuilder();
        NumberFormat nf = NumberFormat.getInstance();
        item.append(this.quantity).append(" ").append(this.getName()).append(" : ").append(nf.format(this.overallPrice));
        return item.toString();
    }
}
