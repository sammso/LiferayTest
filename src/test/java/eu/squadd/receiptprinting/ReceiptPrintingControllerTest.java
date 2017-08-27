/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.squadd.receiptprinting;

import java.io.IOException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author smoczyna
 */
public class ReceiptPrintingControllerTest {
    
    private ReceiptPrintingController controller;
    
    public ReceiptPrintingControllerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() throws IOException, ClassNotFoundException {
        this.controller = new ReceiptPrintingController("/home/smoczyna/Public/temp");
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of printFirstReceipt method, of class ReceiptPrintingController.
     */
    @Test
    public void testPrintFirstReceipt() {
        System.out.println("printFirstReceipt");
        assertNotNull(controller);
        
        controller.printFirstReceipt();
        assertNotNull(controller);
        
    }
    
}
