package employees;

/**
 * Generic class, not used in the program as there is no requirements in the project for Assistant Keepers actions.
 * <p>
 * No methods implemented to keep simple
 * @author Erik
 */
public class AssistantKeeper extends Keeper{

    // the ID is made final ,as it doesn't need to change once assigned.
    private final int KEEPER_ID;

    /**
     * Generic constructor
     * @param name Assistant Keeper's name
     * @param lastName Assistant Keeper's lastname
     * @param number Assistant Keeper's phone number
     * @param Address Assistant Keeper's address
     */
    public AssistantKeeper(String name,String lastName,String number, String Address){
        // assigning class variables
        this.setAddress(Address);
        this.setFirstName(name);
        this.setLastName(lastName);
        this.setContactNumber(number);
        // using a static variable from the parent class. this will assign a unique ID to the child object
        // also increment the static variable.
        this.KEEPER_ID =KEEPER_ID_BASE++;

    }

    /**
     * Custom version of toString() to implement in child classes.
     * @return The details of the employee.
     */
    public int getKEEPER_ID() {
        return KEEPER_ID;
    }


}
