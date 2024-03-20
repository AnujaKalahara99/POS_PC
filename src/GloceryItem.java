import java.io.Serializable;
public class GloceryItem implements Serializable{

    private String item_code , item;
    private float unit_price , discount;


    public GloceryItem(String item_code , String item , float unit_price){
        this.item_code = item_code;
        this.item = item;
        this.unit_price = unit_price;
    }

    public  String getItemCode(){
        return this.item_code;
    }
    public String getName(){
        return this.item;
    }

    public  float getUnit_price(){
        return this.unit_price;
    }

    public void setDiscount(float newDiscount){
        this.discount = newDiscount;
    }

    public float getDiscount(){
        return this.discount;
    }



}

