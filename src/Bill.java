import java.util.*;
import  java.io.Serializable;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
public class Bill implements Serializable{
    private String cashierName;
    private String branch;
    private String customerName;
    private HashMap<GloceryItem,Float> itemList; //hashmap
    private float totalDiscount;
    private float totalPrice;
    private LocalDateTime dateTime; //should output this as dtf.format(dateTime)


    public Bill(Operator operator,Customer customer){
        this.cashierName= operator.getName();
        this.customerName=getCustomerName();
        this.dateTime= LocalDateTime.now();
    }
    public float getTotalDiscount() {
        return totalDiscount;
    }

    public float getTotalPrice() {
        return totalPrice;
    }

    public String getDateTime() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedDateTime = dtf.format(dateTime);
        return formattedDateTime;
    }



    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void addItem(GloceryItem product,Float quantity){
        itemList.put(product,quantity);
        totalDiscount+= product.getDiscount()*quantity;
        totalPrice+= (product.getUnit_price()- product.getDiscount())*quantity;

    }




    public void print() {
        float unitPrice, discount, netPrice,quantity;
        //DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        //String formattedDateTime = dtf.format(dateTime);

        System.out.println("-------- Bill --------");
        System.out.println("Cashier: " + cashierName);
        System.out.println("Branch: " + branch);
        System.out.println("Customer: " + customerName);
        System.out.println("Date and Time: " + this.getDateTime());
        System.out.println("Items:");
        for (HashMap.Entry<GloceryItem, Float> entry : itemList.entrySet()) {
            unitPrice=entry.getKey().getUnit_price();
            quantity=entry.getValue();
            discount=entry.getKey().getDiscount()*entry.getValue();
            netPrice=unitPrice*quantity-discount;
            System.out.println(entry.getKey().getName() +" - Unit Price: " + unitPrice + " - Quantity: " +quantity +" - discount: " + discount +" - net price: " + netPrice);
        }
        System.out.println("Total Discount: " + totalDiscount);
        System.out.println("Total Price: " + totalPrice);
        System.out.println("----------------------");
    }
}



