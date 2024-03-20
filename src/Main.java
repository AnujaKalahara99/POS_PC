import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {

    private static String branch = "Moratuwa";

    public static String getBranch() {
        return branch;
    }

    public static void main(String[] args) {
        resetDataBase(); // RUN ONLY ONCE

        System.out.println("\nWelcome to POS");

        Scanner scanner = new Scanner(System.in);//Create root Scanner

        ArrayList<Operator> operators;
        operators = SaveSystem.deserializeOperator();//Get Operator
        LoginSystem.setOperatorData(operators); //Set all deserialized operator data
        Operator activeOp = LoginSystem.run();

        ArrayList<Customer> customers;
        customers = SaveSystem.deserializeCustomers();//Get Cutomers

        ArrayList<GloceryItem> items = SaveSystem.deserializeItems(); //Get Inventory
        HashMap<String, GloceryItem> inventory = new HashMap<>();
        for(var item : items){
            inventory.put(item.getItemCode(),item);
        }
        POS pos = new POS(activeOp,inventory, customers);

        while(activeOp  != null){
            System.out.println();
            activeOp = pos.run(scanner);
            if (activeOp == null)
                activeOp =LoginSystem.run();
        }

        SaveSystem.serializeOperatorProfiles();
    }

    private static void resetDataBase() {
        SaveSystem.addCustomer(new Customer());
        SaveSystem.addCustomer(new Customer("Anuja"));
        SaveSystem.addCustomer(new Customer("Pulindu"));
        SaveSystem.serializeCustomers();

        SaveSystem.addItem(new GloceryItem("V000","Pumpkin", 150f));
        SaveSystem.addItem(new GloceryItem("V001","Carrot", 400f));
        SaveSystem.addItem(new GloceryItem("V002","Leeks", 100f));
        SaveSystem.addItem(new GloceryItem("V003","BeetRoots", 150f));
        SaveSystem.addItem(new GloceryItem("V004","Beans", 200f));
        SaveSystem.addItem(new GloceryItem("M000","Chicken", 800f));
        SaveSystem.addItem(new GloceryItem("M001","Fish", 600f));
        SaveSystem.addItem(new GloceryItem("M002","Egg", 60f));
        SaveSystem.serializeItems();
    }
}