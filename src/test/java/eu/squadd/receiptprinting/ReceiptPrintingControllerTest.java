/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.squadd.receiptprinting;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.IOException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

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
        this.controller = new ReceiptPrintingController(Generator.setUpItems());
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of printFirstReceipt method, of class ReceiptPrintingController.
     */
    @Test
    public void testPrintFirstReceipt() {
        System.out.println("testing printFirstReceipt");
        assertNotNull(controller.getProducts());
        
        controller.printFirstReceipt();
        assertNotNull(controller.getReceipts());
        assertEquals(1, controller.getReceipts().size());
    }
    
    @Test
    public void testPrintSecondReceipt() {
        System.out.println("testing printSecondReceipt");
        assertNotNull(controller.getProducts());
        
        controller.printSecondReceipt();
        assertNotNull(controller.getReceipts());
        assertEquals(1, controller.getReceipts().size());
    }
    
    @Test
    public void testPrintThirdReceipt() {
        System.out.println("testing printThirdsReceipt");
        assertNotNull(controller.getProducts());
        
        controller.printThirdReceipt();
        assertNotNull(controller.getReceipts());
        assertEquals(1, controller.getReceipts().size());
    }
}
