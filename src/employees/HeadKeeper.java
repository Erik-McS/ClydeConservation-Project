package employees;
public class HeadKeeper extends Keeper{

    // this class will use the Builder design pattern
    // this pattern allows a modular approach to constructor
    // a HeadKeeper object has to have a name and surname attributes.
    // the rest is optional.

    // the constructor is private to force the use of the nested builder class
    // it will receive an object of the builder class and assign its parameters to the HeadKeeper object

    // the ID is made final ,as it doesn't need to change once assigned.
    private final int keeperID;
    private HeadKeeper(HdKBuilder build){
        // the constructor will assign each attributes of the nested Builder  class to the HeadKeeper object
        this.setFirstName(build.firstName);
        this.setLastName(build.lastName);
        this.setAddress(build.address);
        this.setContactNumber(build.contactNumber);
        // using a static variable from the parent class. this will assign a unique ID to the child object
        // also increment the static variable.
        this.keeperID=KEEPER_ID_BASE++;
    }

    // getter for the KeeperID, no setter as the ID is constant once created
    public int getKeeperID() {
        return keeperID;
    }

    // override the getDetails() method to include the KeeperID;
    @Override
    public String getDetails() {
        return "\nKeeper details:"+
                "\nKeeper ID: "+getKeeperID()+
                "\nFirst name: "+getFirstName()+
                "\nLast name:"+getLastName()+
                "\nAddress: "+getAddress()+
                "\nContact number: "+getContactNumber();
    }

    // the builder class is nested and static
    // being a static class allows to use its methods without having to create an oblject
    public static class HdKBuilder{
        // the class has the exact same attributes.
        private String firstName;
        private String lastName;
        private String address;
        private String contactNumber;

        // the class will have setters for each attribute
        // they will check if the parameter has the correct format or throw an exception
        // no getters needed for this class
        public HdKBuilder setName(String name) throws EmployeeValidation{
            // checking the name format
            if (name.equals(""))
                // if empty, throw exception
                throw new EmployeeValidation("Name cannot be empty");
            // using a regex to make sure there is no numbers or special characters
            else  if (name.matches("(\\p{Upper})(\\p{Lower}){1,10}")){
                // if format is ok, assign the value to the builder attribute
                this.firstName=name;
                return this;
            }
            else throw new EmployeeValidation("Invalid Name Format");

        }

        public HdKBuilder setLastName(String lastName) throws EmployeeValidation{
            // same logic and checks than for the name
            if (lastName.equals(""))
                throw new EmployeeValidation("Last Name cannot be empty");
            else if(lastName.matches("(\\p{Upper})(\\p{Lower}){1,20}")){
                this.lastName=lastName;
                return this;
            }
            else throw new EmployeeValidation("Invalid Last Name Format");
        }

        public HdKBuilder setAddress(String address){
                // no check for the address, to keep simple
                this.address=address;
                return this;
        }
        public HdKBuilder setContactNumber(String number){
                // no check for the number, to keep simple
                this.contactNumber=number;
                return this;
        }

        // the builder will return a HeadKeeper object
        public HeadKeeper HBuilder() throws EmployeeValidation{
            // check if a name is assigned
            if (this.firstName==null)
                throw new EmployeeValidation("Name cannot be empty");
            // check if a last name is assigned
            if (this.lastName==null)
                throw new EmployeeValidation("Name cannot be empty");
            // if no address was set, we assign a default value
            if (this.address==null)
                this.address="To be updated";
            // if no address was set, we assign a default value
            if (this.contactNumber==null)
                this.contactNumber="To be updated";
            // once all has been checked
            // we create a new HeadKeeper object, that will take this HdKBuilder object as parameter
            // and return it to the caller
            return new HeadKeeper(this);
        }

    }
}
