import java.io.*;
import java.util.ArrayList;


public class SaveSystem {
    private static ArrayList<Operator> operators = new ArrayList<>();
    private static ArrayList<GloceryItem> items = new ArrayList<>();
    private static ArrayList<Customer> customers = new ArrayList<>();


    public static void addOperator(Operator newOp){
    operators.add(newOp);
    }
    public  static  void serializeOperatorProfiles(){

       try (FileOutputStream fileOut = new FileOutputStream("operators "+Main.getBranch()+" .ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
            out.writeObject(operators);
            System.out.println("System saved successfully!");

       } catch (IOException error){
       }
    }

    public static ArrayList<Operator> deserializeOperator() {
        try (FileInputStream fileIn = new FileInputStream("operators "+Main.getBranch()+" .ser");
             ObjectInputStream in = new ObjectInputStream(fileIn)) {
            operators = (ArrayList<Operator>)in.readObject();
            System.out.println("Game loaded successfully!\n");
        } catch (IOException | ClassNotFoundException e) {
        }
        return operators;
    }


    public static void addItem(GloceryItem item){
        items.add(item);
    }
    public  static  void serializeItems(){

        try (FileOutputStream fileOut = new FileOutputStream("inventory "+Main.getBranch()+" .ser");
             ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
            out.writeObject(items);
            System.out.println("Inventory saved successfully!");

        } catch (IOException error){
        }
    }

    public static ArrayList<GloceryItem> deserializeItems() {
        try (FileInputStream fileIn = new FileInputStream("inventory "+Main.getBranch()+" .ser");
             ObjectInputStream in = new ObjectInputStream(fileIn)) {
            items = (ArrayList<GloceryItem>)in.readObject();
            System.out.println("Inventory loaded successfully!\n");
        } catch (IOException | ClassNotFoundException e) {
        }
        return items;
    }



    public static void addCustomer(Customer customer){
        customers.add(customer);
    }
    public  static  void serializeCustomers(){

        try (FileOutputStream fileOut = new FileOutputStream("customers "+Main.getBranch()+" .ser");
             ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
            out.writeObject(customers);
            System.out.println("Customers saved successfully!");

        } catch (IOException error){
        }
    }

    public static ArrayList<Customer> deserializeCustomers() {
        try (FileInputStream fileIn = new FileInputStream("customers "+Main.getBranch()+" .ser");
             ObjectInputStream in = new ObjectInputStream(fileIn)) {
            customers = (ArrayList<Customer>)in.readObject();
            System.out.println("Customers loaded successfully!\n");
        } catch (IOException | ClassNotFoundException e) {
        }
        return customers;
    }
}
