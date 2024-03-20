import Exceptions.ItemCodeNotFoundException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

class POS {

    private HashMap<String, GloceryItem> inventory;
    private Operator operator;
    private ArrayList<Bill> draftedBills;
    private ArrayList<Customer> registeredCustomers;
    private Bill currentBill;

    public POS(Operator operator, HashMap<String, GloceryItem> inventory, ArrayList<Customer> registeredCustomers) {
        this.inventory = inventory;
        this.operator = operator;
        this.registeredCustomers = registeredCustomers;
    }

    public Operator run(Scanner scanner){
        //this method is called when running the POS system
        //the main menu should be implemented here
        //when terminating the process null should be returned;
        boolean terminate = false;
        while(!terminate){
            terminate = mainMenu(scanner);
        }

        return null;
    }

    public boolean mainMenu(Scanner scanner){
        System.out.println("\n This is the main menu");
        System.out.println("1. New Bill");
        System.out.println("2. Drafted Bills");
        System.out.println("98. Back");
        System.out.print("Choose an option: ");
        var input = scanner.nextLine();

        return switch (input) {
            case "1" -> {
                System.out.println("Customer is already chosen FIFO");
                var customer = ChooseCustomer();
                currentBill = new Bill(operator , customer);
                CreateBill();
                yield false;
            }
            case "2" -> {
                DraftedBills();
                yield false;
            }
            case "98" -> true;
            default -> {
                System.out.println("Invalid input! Please try again.");
                yield false;
            }
        };
    }

    public GloceryItem getItemDetails() {
        InputStreamReader r = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(r);
        GloceryItem item = null;

        while(true){
            try {

                System.out.println("Enter item code: ");
                System.out.println("Enter -1 to terminate.");
                String item_code = br.readLine();
                br.close();
                r.close();

                if(inventory.containsKey(item_code)){
                    return inventory.get(item_code);
                }
                else if(item_code.equals("-1")) {
                    return null;
                }
                else{
                    throw new ItemCodeNotFoundException();

                }
            } catch (ItemCodeNotFoundException e) {
                System.out.println("Item code not found.");

            }
            catch (IOException e1){

            }


            return item;
        }

    }

    private Customer ChooseCustomer(){
        return registeredCustomers.get(0);
    }

    private void CreateBill(){
        GloceryItem item = getItemDetails();
        while(item != null){
            System.out.println("Quantity : ");
            Scanner scanner = new Scanner(System.in);
            float quantity = scanner.nextFloat();
            currentBill.addItem(item , quantity);
            item = getItemDetails();
        }
    }

    private void DraftedBills(){
        if (draftedBills.isEmpty()){
            System.out.println("No Drafted Bills Available");
        }
        else{
            for(int i=0;i<draftedBills.size();i++){
                System.out.println(i+1 +". "+draftedBills.get(i).getCustomerName()+ "  "+draftedBills.get(i).getDateTime());
            };
            System.out.print("Select a Bill: ");
            Scanner scanner = new Scanner(System.in);
            Integer choose= scanner.nextInt();
            currentBill=draftedBills.get(choose-1);
            CreateBill();


        }
    }
}





