package a2.database.access.model;

//Model that defines the properties of CustomerSpender
public class CustomerSpender {
    private int id;
    private String firstName;
    private String lastName;
    private double totalSpent;

    public CustomerSpender(int id, String firstName, String lastName, double totalSpent){
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.totalSpent = totalSpent;
    }

    public int getId(){
        return id;
    }

    public String getFirstName(){
        return firstName;
    }

    public String getLastName(){
        return lastName;
    }

    public double getTotalSpent(){
        return totalSpent;
    }
}
