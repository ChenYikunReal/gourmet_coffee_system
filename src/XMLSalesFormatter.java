import java.util.Iterator;

public class XMLSalesFormatter implements SalesFormatter {
    
    private static XMLSalesFormatter singletonInstance;   
    
    private XMLSalesFormatter() {   
    }   
       
    public static synchronized XMLSalesFormatter getSingletonInstance() {   
        if (singletonInstance == null)   
            singletonInstance = new XMLSalesFormatter();   
        return singletonInstance;   
    }   
       
    public String formatSales(Sales sales) {   
        String string = "";   
        string +="<Sales>\r\n"; 
        Iterator<Order> iterator1 = sales.iterator();
        while(iterator1.hasNext()) {
            Order order = iterator1.next();
            string += "  <Order total=\""+order.getTotalCost()+"\">\r\n";  
            Iterator<OrderItem> iterator2 = order.iterator();
            while(iterator2.hasNext()) {
                OrderItem orderItem = iterator2.next();
                string += "    <OrderItem quantity=\""+orderItem.getQuantity()+"\" price=\""+orderItem.getProduct().getPrice()+"\">"+orderItem.getProduct().getCode()+"</OrderItem>\r\n";
            }  
            string += "  </Order>\r\n";
        }  
        string += "</Sales>\r\n";
        return string;     
    }   

}
