import java.util.ArrayList;

public class Customer {
    private String name;
    private ArrayList<Bill> purchaseHis;

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
