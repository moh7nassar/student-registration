
package OOP20192;

public class CollegeAddress extends Address {
    private String collegeName;
    
    public CollegeAddress(String city, String street, int building, String collegeName)
    {
        super(city,street,building);
        this.collegeName=collegeName;
    }
    public String toString()
    {
        return "College Name : "+collegeName+"\n"+super.toString();
    }
}
