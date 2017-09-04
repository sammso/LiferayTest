/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.squadd.receiptprinting;

import eu.squadd.receiptprinting.model.Product;
import eu.squadd.receiptprinting.model.Receipt;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

/**
 *
 * @author smoczyna
 */
public class ReceiptPrintingController {
    private final Map<Integer, Product> products;
    private final Map<Integer, Receipt> receipts;
    
    private String prettyPrintProducts() {
        StringBuilder allproducts = new StringBuilder();
        for (Product product : this.products.values()) {
            allproducts.append(product.toString()).append("\n");
        }
        return allproducts.toString();
    }

    public Map<Integer, Product> getProducts() {
        return products;
    }

    public Map<Integer, Receipt> getReceipts() {
        return receipts;
    }
    
    public ReceiptPrintingController(Map<Integer, Product> products) {
    	this.products = products;
    	 this.receipts = new TreeMap();
        System.out.println("*** Available products ***");
        System.out.println(this.prettyPrintProducts());
        System.out.println("*** purchases ***");
    }
    
    public ReceiptPrintingController(String fileLocation) throws IOException, ClassNotFoundException {
       
    	this((Map<Integer, Product>)SerializationUtil.deserialize(fileLocation+"/products.dat"));

    }
    
    public void printFirstReceipt() {
        Receipt receipt = new Receipt(1);
        receipt.addItemToShoppingList(this.products.get(1), 1);
        receipt.addItemToShoppingList(this.products.get(2), 1);        
        receipt.addItemToShoppingList(this.products.get(3), 1);
        this.receipts.put(1, receipt);
        System.out.println(receipt.toString());
    }
    
    public void printSecondReceipt() {
        Receipt receipt = new Receipt(2);
        receipt.addItemToShoppingList(this.products.get(4), 1);
        receipt.addItemToShoppingList(this.products.get(5), 1); 
        this.receipts.put(2, receipt);
        System.out.println(receipt.toString());
    }
    
    public void printThirdReceipt() {
        Receipt receipt = new Receipt(3);
        receipt.addItemToShoppingList(this.products.get(6), 1);
        receipt.addItemToShoppingList(this.products.get(7), 1);
        receipt.addItemToShoppingList(this.products.get(8), 1);
        receipt.addItemToShoppingList(this.products.get(9), 1);
        this.receipts.put(3, receipt);
        System.out.println(receipt.toString());
    }
}
