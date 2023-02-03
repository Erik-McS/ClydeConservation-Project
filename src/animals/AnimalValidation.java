package animals;
/**
 * Custom exception class to catch incorrect formats for the Employee package
 * @author Erik
 */
public class AnimalValidation extends Exception{
    /**
     * pass the string message to the parent class for the getMessage() method
     * @param message Error message to display
     */
    public AnimalValidation(String message){super("\n"+message);
    }
}
