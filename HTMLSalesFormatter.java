import java.util.Iterator;

public class HTMLSalesFormatter implements SalesFormatter {
    
    private static HTMLSalesFormatter singletonInstance;   
    
    private HTMLSalesFormatter() {   
    }   
        
    public static synchronized HTMLSalesFormatter getSingletonInstance() {   
        if (singletonInstance == null)   
            singletonInstance = new HTMLSalesFormatter();   
        return singletonInstance;   
    }   
       
    public String formatSales(Sales sales) {   
        String string = "";   
        string +="<html>\r\n  <body>\r\n    <center><h2>Orders</h2></center>\r\n";
        Iterator<Order> iterator1 = sales.iterator();
        while(iterator1.hasNext()) {
            Order order = iterator1.next();
            string += "    <hr>\r\n    <h4>Total = " + order.getTotalCost() + "</h4>\r\n      <p>\r\n";  
            Iterator<OrderItem> iterator2 = order.iterator();
            while(iterator2.hasNext()) {
                OrderItem orderItem = iterator2.next();
                string += "        <b>code:</b> "+orderItem.getProduct().getCode()+"<br>\r\n" + "        <b>quantity:</b> "+orderItem.getQuantity()+"<br>\r\n"+"        <b>price:</b> "+orderItem.getProduct().getPrice()+"\r\n";
            }  
            string += "      </p>\r\n";
        }  
        string += "  </body>\r\n</html>\r\n";
        return string;  
    }

}
