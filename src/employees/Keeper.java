package employees;
public class Keeper implements Employee{

    // attributes of the Keeper class
    private String firstName;
    private String lastName;
    private String address;
    private String contactNumber;

    public static int KEEPER_ID_BASE=100;

    // getter and setters
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    // custom version of the toString() method
    @Override
    public String getDetails() {
        return "\nKeeper details:"+
                "\nFirst name: "+getFirstName()+
                "\nLast name:"+getLastName()+
                "\nAddress: "+getAddress()+
                "\nContact number: "+getContactNumber();
    }
}
