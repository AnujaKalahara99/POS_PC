import java.util.ArrayList;
import java.util.HashMap;

public class Main {
    private String branch = "Moratuwa";
    public static void main(String[] args) {
        System.out.println("\nWelcome to POS");

        LoginSystem.setOperatorData(null); //Set all deserialized operator data
        Operator activeOp = LoginSystem.run();

        ArrayList<GloceryItem> items = SaveSystem.deserializeItems(); //Get Inventory
        HashMap<String, GloceryItem> inventory = new HashMap<>();
        for(var item : items){
            inventory.put(item.getItemCode(),item);
        }
        POS pos = new POS(activeOp,inventory);

        while(activeOp  != null){
            System.out.println();
            activeOp = pos.run();
//            activeOp =Menu.displayMenu(activeOp, operators);
            if (activeOp == null)
                activeOp =LoginSystem.run();
        }
    }
}