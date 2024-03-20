import Exceptions.ItemCodeNotFoundException;

import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.Buffer;
import java.util.ArrayList;
import java.util.HashMap;

class POS {

    private HashMap<String, GloceryItem> inventory;
    private Operator operator;

    public POS(Operator operator, HashMap<String, GloceryItem> inventory) {
        this.inventory = inventory;
        this.operator = operator;
    }

    public Operator run(){
        //this method is called when running the POS system
        //the main menu should be implemented here
        //when terminating the process null should be returned;
        return operator;
    }

    public GloceryItem getItemDetails() {
        InputStreamReader r = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(r);
        GloceryItem item = null;


            try {
                System.out.println("Enter item code: ");
                String item_code = br.readLine();
                if(// search item_code*/){
                // }
                throw new ItemCodeNotFoundException();

                // Fetch item details from the database
                br.close();
                r.close();
            } catch (ItemCodeNotFoundException e) {
                System.out.println("Error reading input. Please try again.");
            }
            catch (IOException e1){

            }


        return item;
    }

}


