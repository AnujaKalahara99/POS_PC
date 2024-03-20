import java.util.ArrayList;
import java.io.Serializable;

public class Customer implements Serializable{

    private String name="Unregistered Customer";
    private ArrayList<Bill> purchaseHis;

    public Customer() {
    }
    public Customer(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Bill> getPurchaseHistory() {
        return purchaseHis;
    }

    public void setPurchaseHistory(Bill purchase) {
        this.purchaseHis.add(purchase);
    }
}
