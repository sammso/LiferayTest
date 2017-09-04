package eu.squadd.receiptprinting;


import eu.squadd.receiptprinting.model.Product;
import eu.squadd.receiptprinting.SerializationUtil;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author smoczyna
 */
public class SerializationTest {
       
    public static void main(String[] args) {        
        try {
            String fileLocation = null;
            if (args.length>0 && !args[0].isEmpty())
                fileLocation = args[0] + "/products.dat";
            else
                fileLocation = "/home/smoczyna/Public/temp/products.dat";
            
            /**
             * Serializing products to file
             */
            SerializationUtil.serialize(Generator.setUpItems(), fileLocation);

            /**
             * Deserializing products from file
             */
            Map<Integer, Product> newItems = (TreeMap) SerializationUtil.deserialize(fileLocation);
            System.out.println(newItems.toString());

        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error: "+e.getMessage());
        }
    }
}
