package employees;

import java.io.Serializable;

/**
 * This is the generic class for Clyde Conservation Keepers
 * <p>
 * This class do not have a specific constructor as it is designed with inheritance in mind.
 * <p>
 * Because this class is used as a Parent class, it does not allow the use of a private constructor to restrict
 * object creation
 * @author Erik
 */
public class Keeper implements Employee, Serializable {

    // attributes of the Keeper class
    private String firstName;
    private String lastName;
    private String address;
    private String contactNumber;

    // protected variable that will be used to create an ID
    protected int keeperID;
    // static variable used in child classes to generate unique ID
    public static int KEEPER_ID_BASE=100;

    @Override
    public int getID() {
        return keeperID;
    }

    /**
     * getter for the KeeperID, no setter as the ID is constant once created
     * @return the Employee number of the Keeper
     */
    public int getKeeperID() {return keeperID;}

    // getter and setters

    /**
     * Returns the Keeper firstname.
     * @return firstname
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Set the Keeper's firstname.
     * @param firstName Keeper's firstname.
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Returns the Keeper's last name
     * @return lastname
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Set the Keeper's lastname
     * @param lastName Keeper's lastname
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Get the Keeper's address
     * @return address
     */
    public String getAddress() {
        return address;
    }

    /**
     * Set the Keeper address
     * @param address Keeper's address
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Get the Keeper's contact member
     * @return contactNumber
     */
    public String getContactNumber() {
        return contactNumber;
    }

    /**
     * Set the Keeper's contact number
     * @param contactNumber Contact number
     */
    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    /**
     * Dummy method to differentiate from Admin.
     * <p>
     * Keepers are supposed to also care for the cages
     */
    public void cageCare(){
        System.out.println("Cage cleaned");
        System.out.println("Animals fed");
    }

    // custom version of the toString() method

    /**
     * This function will create a Keeper's profile, including the Keeper's employee number
     * and return it as a string
     * @return The Keeper's profile
     */
    @Override
    public String getDetails() {
        return "\nKeeper details:"+
                "\nFirst name: "+getFirstName()+
                "\nLast name:"+getLastName()+
                "\nAddress: "+getAddress()+
                "\nContact number: "+getContactNumber();
    }
}
