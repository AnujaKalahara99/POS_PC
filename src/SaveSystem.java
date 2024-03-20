import java.io.*;
import java.util.ArrayList;


public class SaveSystem {
    private static ArrayList<Operator> players = new ArrayList<>();
    private static ArrayList<GloceryItem> items = new ArrayList<>();

    public static void addOperator(Operator newOp){
        players.add(newOp);
    }
    public  static  void serializeOperatorProfiles(){

       try (FileOutputStream fileOut = new FileOutputStream("operators.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
            out.writeObject(players);
            System.out.println("System saved successfully!");

       } catch (IOException error){
       }
    }

    public static ArrayList<Operator> deserializeOperator() {
        try (FileInputStream fileIn = new FileInputStream("players.ser");
             ObjectInputStream in = new ObjectInputStream(fileIn)) {
            players = (ArrayList<Operator>)in.readObject();
            System.out.println("Game loaded successfully!\n");
        } catch (IOException | ClassNotFoundException e) {
        }
        return players;
    }


    public static void addItem(GloceryItem item){
        items.add(item);
    }
    public  static  void serializeItems(){

        try (FileOutputStream fileOut = new FileOutputStream("inventory.ser");
             ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
            out.writeObject(items);
            System.out.println("Inventory saved successfully!");

        } catch (IOException error){
        }
    }

    public static ArrayList<GloceryItem> deserializeItems() {
        try (FileInputStream fileIn = new FileInputStream("inventory.ser");
             ObjectInputStream in = new ObjectInputStream(fileIn)) {
            items = (ArrayList<GloceryItem>)in.readObject();
            System.out.println("Inventory loaded successfully!\n");
        } catch (IOException | ClassNotFoundException e) {
        }
        return items;
    }
}
