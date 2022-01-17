
package OOP20192;

public class Address {
    private String street,city;
    private int building;
    public Address(String city, String street, int building)
    {
        this.street=street;
        this.city=city;
        this.building=building;
    }
    public String toString()
    {
        return "City : "+city+"\n"+
                "Street : "+street+"\n"+
                "Building : "+building;
    }
}
