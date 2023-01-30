public class ValidationException extends Exception{
    public ValidationException(String message){
        // pass the message to the parent getMessage() method
        super("\n"+message);
    }
}
