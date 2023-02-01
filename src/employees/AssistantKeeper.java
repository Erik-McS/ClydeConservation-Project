package employees;
public class AssistantKeeper extends Keeper{

    // generic class, not used in the program as there is no requirements in the project for Assistant Keepers actions
    // no methods to keep simple
    public AssistantKeeper(String name,String lastName,String number, String Address){

        this.setAddress(Address);
        this.setFirstName(name);
        this.setLastName(lastName);
        this.setContactNumber(number);

    }

}
