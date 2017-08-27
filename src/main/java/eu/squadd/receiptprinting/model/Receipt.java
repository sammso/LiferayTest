/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.squadd.receiptprinting.model;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author smoczyna
 */
public class Receipt {
    
    private int receiptNo;
    private final List<ShoppingItem> shoppingList;
    
    public Receipt(int no) {
        this.receiptNo = no;
        this.shoppingList = new ArrayList();
    }
    
    public int getReceiptNo() {
        return receiptNo;
    }

    public List<ShoppingItem> getShoppingList() {
        return shoppingList;
    }

    public void addItemToShoppingList(Product product, int quantity) {        
        this.shoppingList.add(new ShoppingItem(product, quantity));
    }

    @Override
    public String toString() {
        return this.prettyPrint();
    }
    
    private String prettyPrint() {
        StringBuilder receipt = new StringBuilder();
        NumberFormat nf = NumberFormat.getInstance();
        receipt.append("Receipt number: ").append(receiptNo).append("\n");
        Double taxes = 0d;
        Double total = 0d;
        for (ShoppingItem item : this.shoppingList) {
            receipt.append(" - ").append(item.toString()).append("\n");
            taxes += (item.getTaxAmount() + item.getImportDutyAmount());
            total += item.getOverallPrice();
        }
        receipt.append("Sales Taxes : ").append(nf.format(taxes)).append("\n");
        receipt.append("Total : ").append(nf.format(total)).append("\n");
        receipt.append("***");
        return receipt.toString();
    }
}
