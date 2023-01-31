public class Administrator implements Employee{
    private String firstName;
    private String lastName;
    private String address;
    private String contactNumber;
    private static int ADMIN_ID_BASE=200;

    private int adminID;

    // constructor

    public Administrator(String name,String lastName,String number, String Address){

        this.setAddress(Address);
        this.setFirstName(name);
        this.setLastName(lastName);
        this.setContactNumber(number);
        this.adminID=ADMIN_ID_BASE++;

    }

    // getter and setters
    public String getFirstName() {
        return firstName;
    }
    // only a getter for the ID since it should not be changed once assigned
    public int getAdminID() {
        return adminID;
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
                "\nContact number: "+getContactNumber()
                ;
    }
}
