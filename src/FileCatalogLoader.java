import java.util.StringTokenizer; 
import java.io.*;

/**
 * This class implements interface CatalogLoader. It is used to obtain a product catalog from a file.
 * @see DataFormatException
 */
public class FileCatalogLoader implements CatalogLoader {
    private final String split = "_";

    /**
     * This method reads a line of coffee-accessory data.
     * It uses the class StringTokenizer to extract the accessory data in the specified line.
     * If the line is error free, this method returns a Product object that encapsulates the accessory data.
     * If the line has errors, that is, if it does not have the expected number of tokens or the token that should contain a double does not.
     * This method throws a DataFormatException that contains the line of malformed data. 
     * @param line
     * @return an new object of Coffee
     * @throws DataFormatException, which contains the line of malformed data
     */
    private Product readProduct(String line) throws DataFormatException {   
        String code = null;   
        String description = null;   
        double price = 0.0;   
        StringTokenizer token = new StringTokenizer(line, split);   
        while (token.hasMoreTokens()) {   
            token.nextToken();   
            code = token.nextToken();   
            description = token.nextToken();   
            price = Double.parseDouble(token.nextToken());   
        }   
        return new Product(code, description, price);   
    }   
    
    /**
     * This method reads a line of coffee data. It uses the class StringTokenizer to extract the coffee data in the specified line.
     * If the line is error free, this method returns a Coffee object that encapsulates the coffee data.
     * If the line has errors, that is, if it does not have the expected number of tokens or the token that should contain a double does not.
     * This method throws a DataFormatException that contains the line of malformed data. 
     * @param line
     * @return an new object of Coffee
     * @throws DataFormatException, which contains the line of malformed data
     */
    private Coffee readCoffee(String line) throws DataFormatException {   
        String code = null;   
        String description = null;   
        double price = 0.0;   
        String origin = null;   
        String roast = null;   
        String flavor = null;   
        String aroma = null;   
        String acidity = null;   
        String body = null;   
        StringTokenizer token = new StringTokenizer(line, split);   
        while (token.hasMoreTokens()) {   
            token.nextToken();   
            code = token.nextToken();   
            description = token.nextToken();   
            price = Double.parseDouble(token.nextToken());   
            origin = token.nextToken();   
            roast = token.nextToken();   
            flavor = token.nextToken();   
            aroma = token.nextToken();   
            acidity = token.nextToken();   
            body = token.nextToken();   
               
        }   
        return new Coffee(code, description, price, origin, roast, flavor, aroma, acidity, body);   
    }
    
   /**
    * This method reads a line of coffee-brewer data.
    * It uses the class StringTokenizer to extract the brewer data in the specified line. 
    * If the line is error free, this method returns a CoffeeBrewer object that encapsulates the brewer data.
    * If the line has errors, that is, if it does not have the expected number of tokens or the tokens that should contain a number do not.
    * This method throws a DataFormatException that contains the line of malformed data. 
    * @param line
    * @return an new object of Coffee
    * @throws DataFormatException, which contains the line of malformed data
    */
    private CoffeeBrewer readCoffeeBrewer(String line) throws DataFormatException {   
        String code = null;   
        String description = null;   
        double price = 0.0;   
        String model = null;   
        String waterSupply = null;   
        int numberOfCups = 0;   
        StringTokenizer token = new StringTokenizer(line, split);   
        while (token.hasMoreTokens()) {   
            token.nextToken();   
            code = token.nextToken();   
            description = token.nextToken();   
            price = Double.parseDouble(token.nextToken());   
            model = token.nextToken();   
            waterSupply = token.nextToken();   
            numberOfCups = Integer.parseInt(token.nextToken());               
        }   
        return new CoffeeBrewer(code, description, price, model, waterSupply, numberOfCups);   
    }   
    
    @Override
    public Catalog loadCatalog(String filename) throws FileNotFoundException, IOException, DataFormatException {   
        Catalog catalog = new Catalog();   
        BufferedReader buffer = new BufferedReader(new FileReader(filename));    
        String line = buffer.readLine();
        
        while (line != null) {   
            if (line.startsWith("Product")) {   
                catalog.addProduct(readProduct(line));   
            } else if(line.startsWith("Coffee")) {   
                catalog.addProduct(readCoffee(line));   
            } else if(line.startsWith("Brewer")) {   
                catalog.addProduct(readCoffeeBrewer(line));   
            }   
            line = buffer.readLine();   
        }   
        buffer.close();   
        return catalog;   
    }   

}
