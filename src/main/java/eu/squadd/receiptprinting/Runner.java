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
        try {
        	if (args.length==1 ) {
        		Map<Integer, Product> products = (Map<Integer, Product>)SerializationUtil.deserialize(args[0]);
        		ReceiptPrintingController controller = new ReceiptPrintingController(products);
	            controller.printFirstReceipt();
	            controller.printSecondReceipt();
	            controller.printThirdReceipt();
        	}        		
            else if (args.length == 2 && args[0].equals("--generate")) {
    			SerializationUtil.serialize(Generator.setUpItems(), args[1]);
            }
        	else {
        		System.out.println("Usage:");
        		System.out.println("Generate input file");
        		System.out.println(" java -jar ReceiptPrinting.jar --generate <output filename>");
        		System.out.println("Print out results");
        		System.out.println(" java -jar ReceiptPrinting.jar <input filename>");
        	}
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(Runner.class.getName()).log(Level.SEVERE, null, ex);
        }        
    }
}
