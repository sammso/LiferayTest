
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

//    private Map<Integer, Product> items;
//    
//    @Before
//    public void setUp() throws IOException, ClassNotFoundException {
//        this.items = this.setUpItems();
//    }
    
    private static Map<Integer, Product> setUpItems() {
        Map<Integer, Product> items = new TreeMap();
        Product product = new Product();
        
        product.setName("Book");
        product.setPrice(12.49);
        product.setTax(0);
        product.setImportDuty(0);        
        items.put(1, product);
        
        product = new Product();
        product.setName("Music CD");
        product.setPrice(14.99);
        product.setTax(10);
        product.setImportDuty(0);
        items.put(2, product);
        
        product = new Product();
        product.setName("Chocolate bar");
        product.setPrice(0.85);
        product.setTax(0);
        product.setImportDuty(0);
        items.put(3, product);
        
        product = new Product();
        product.setName("Imported box of chocolates");
        product.setPrice(10);
        product.setTax(0);
        product.setImportDuty(5);
        items.put(4, product);
        
        product = new Product();
        product.setName("Imported bottle of perfume");
        product.setPrice(47.50);
        product.setTax(10);
        product.setImportDuty(5);
        items.put(5, product);
        
        product = new Product();
        product.setName("Imported bottle of perfume");
        product.setPrice(27.99);
        product.setTax(10);
        product.setImportDuty(5);
        items.put(6, product);
        
        product = new Product();
        product.setName("Bottle of perfume");
        product.setPrice(18.99);
        product.setTax(10);
        product.setImportDuty(0);
        items.put(7, product);
        
        product = new Product();
        product.setName("Headache pills");
        product.setPrice(9.75);
        product.setTax(0);
        product.setImportDuty(0);
        items.put(8, product);

        product = new Product();
        product.setName("Imported box of chocolates");
        product.setPrice(11.25);
        product.setTax(0);
        product.setImportDuty(5);
        items.put(9, product);
        
        return items;
    }
    
//    @Test
//    public void testSerialize() throws IOException {        
//        SerializationUtil.serialize(setUpItems(), "/home/smoczyna/Public/temp/products.dat");
//    }
    
    public static void main(String[] args) {        
        try {
            String fileLocation = null;
            if (args.length>0 && !args[0].isEmpty())
                fileLocation = args[0] + "/products.dat";
            else
                fileLocation = "/home/smoczyna/Public/temp/products.dat";
            
            SerializationUtil.serialize(setUpItems(), fileLocation);

            /**
             * Deserializing the object
             */
            Map<Integer, Product> newItems = (TreeMap) SerializationUtil.deserialize(fileLocation);
            System.out.println(newItems.toString());

        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error: "+e.getMessage());
        }
    }
}
