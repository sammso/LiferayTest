/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.squadd.receiptprinting;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author smoczyna
 */
public class Runner {
    
    public static void main(String[] args) {
        ReceiptPrintingController controller;
        try {
            controller = new ReceiptPrintingController(args[0]);
            controller.printFirstReceipt();
            controller.printSecondReceipt();
            controller.printThirdReceipt();
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(Runner.class.getName()).log(Level.SEVERE, null, ex);
        }        
    }
}
