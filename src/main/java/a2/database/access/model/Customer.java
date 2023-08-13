package a2.database.access.model;

public class Customer {
    public int id;
    public String firstName;
    public String lastName;
    public String country; 
    public String postalCode; 
    public String phone;
    public String mail; 

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
