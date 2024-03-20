public class Operator {

    private static int operatorCount;
    private String username;
    private String name;
    private final String password;

    public Operator(String name, String password, boolean isAdmin) {
        operatorCount++;
        this.username = (isAdmin ? "admin" : "cashier") + operatorCount;
        this.name = name;
        this.password = password;
    }

    public boolean isAdmin(){
        return username.startsWith("admin");
    }

    public String getUserName() {
        return username;
    }

    public void setUserName(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isPassword(String password) {
        return this.password.equals(password);
    }

}
