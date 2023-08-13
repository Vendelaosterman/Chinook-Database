package a2.database.access.model;

public class Customer {
    private int id;
    private String firstName;
    private String lastName;
    private String country; 
    private String postalCode; 
    private String phone;
    private String mail; 

    public Customer(int id, String firstName, String lastName, String country, String postalCode, String phone, String mail ){
        this.id=id;
        this.firstName=firstName;
        this.lastName = lastName;
        this.country = country;
        this.postalCode = postalCode;
        this.phone = phone;
        this.mail = mail;
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

    public String getCountry(){
        return country;
    }

    public String getPostalCode(){
        return postalCode;
    }

    public String getPhone(){
        return phone;
    }

    public String getEmail(){
        return mail;
    }
}
