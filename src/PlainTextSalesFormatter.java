import java.util.Iterator;

public class PlainTextSalesFormatter implements SalesFormatter {
    
    private static PlainTextSalesFormatter singletonInstance;   
    
    private PlainTextSalesFormatter() {   
    }   
       
    public static synchronized PlainTextSalesFormatter getSingletonInstance() {   
        if (singletonInstance == null)   
            singletonInstance = new PlainTextSalesFormatter();   
        return singletonInstance;   
    }   
       
    public String formatSales(Sales sales) {   
        String string = "";   
        int i = 1;
        Iterator<Order> iterator1 = sales.iterator();
        while(iterator1.hasNext()) {
            Order order = iterator1.next();
            string +="---------------------\r\n";   
            string += "Order " + i + "\r\n\r\n"; 
            Iterator<OrderItem> iterator2 = order.iterator();
            while(iterator2.hasNext()) {
                OrderItem orderItem = iterator2.next();
                string += orderItem.getQuantity() + " " + orderItem.getProduct().getCode() + " " +orderItem.getProduct().getPrice() + "\r\n";
            }
            i++;   
            string += "\r\n" + "Total = " + order.getTotalCost() + "\r\n"; 
        }  
        return string;   
    }   

}
