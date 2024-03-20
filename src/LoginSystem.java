import jdk.incubator.vector.VectorOperators;

import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

//the login/signup menu, need to create an object in
//main and use player=object.run(); will return the current player.

public class LoginSystem {
    private static HashMap<String ,Operator> users=new HashMap<>();

    private static Operator operator;
    public static Operator run() {

        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("1. Login");
            System.out.println("2. Signup");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            int choice = 0;
            try {
                choice = scanner.nextInt();
            } catch(Exception error){
                System.out.println("Invalid Input! Please try again!");
                run();
            }
            scanner.nextLine(); // Consume newline
            System.out.println();

            switch (choice) {
                case 1:
                    operator=login(scanner);
                    break;
                case 2:
                    operator=signup(scanner);
                    break;
                case 3:
                    running = false;
                    operator=null;
                    break;

            }
            if(operator!=null)
                return operator;
        }
        scanner.close();
        return null;
    }

    private static Operator login(Scanner scanner) {
        System.out.print("Enter your username: ");
        String username = scanner.nextLine();
        System.out.print("Enter your password: ");
        String password = scanner.nextLine();

        if (users.containsKey(username) && users.get(username).isPassword(password)) {
            Operator operator = users.get(username);
            System.out.println("Signup successful! Welcome " + operator.getName());
            return operator;
        } else {
            System.out.println("Invalid username or password. Please try again.\n");
            return null;
        }
    }

    private static Operator signup(Scanner scanner) {
        boolean check, isAdmin = false;
        String name , password;
        do{
            System.out.print("Enter your name: ");
            name = scanner.nextLine();
            if(name.equals("")){
                System.out.println("Name cannot be null");
                check = true;
            }
            else{ check = false;}
        }
        while(check);
        do{
            check = false;
            System.out.print("Is this account an admin account (y/n): ");
            String response = scanner.nextLine();
            if(response.equals("Y") || response.equals("y")) isAdmin = true;
            else if(response.equals("N") || response.equals("n")) isAdmin = false;
            else{
                System.out.println("Input not recognised");
                check = true;
            }
        }
        while(check);


        do {
            System.out.print("Set a password: ");
            password = scanner.nextLine();
            if(password.equals("")){
                check = true;
            }
        }
        while(check);
        Operator newOperator = new Operator(name, password, isAdmin);
        users.put(newOperator.getUserName(), newOperator);

        System.out.println("Signup successful! Welcome " + newOperator.getName());
        SaveSystem.addOperator(newOperator);
        return newOperator;
    }

    public static void setOperatorData(List<Operator> operators){
        for(Operator savedOperator :operators){
            users.put(savedOperator.getUserName(),savedOperator);
        }
    }
}
