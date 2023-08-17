package a2.database.access.model;

//Model that defines the properties of CustomerCountry
public class CustomerCountry {
    private String country;

    public CustomerCountry(String country){
        this.country = country;
    }

    public String getCountry(){
        return country;
    }
}
