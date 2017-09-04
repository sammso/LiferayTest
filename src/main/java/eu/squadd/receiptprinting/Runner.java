/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.squadd.receiptprinting;

import java.io.IOException;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import eu.squadd.receiptprinting.model.Product;

/**
 *
 * @author smoczyna
 */
public class Runner {
    
    public static void main(String[] args) {
        ReceiptPrintingController controller;
        try {
        	Map<Integer, Product> products = (Map<Integer, Product>)SerializationUtil.deserialize(args[0]);
            controller = new ReceiptPrintingController(products);
            controller.printFirstReceipt();
            controller.printSecondReceipt();
            controller.printThirdReceipt();
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(Runner.class.getName()).log(Level.SEVERE, null, ex);
        }        
    }
}
