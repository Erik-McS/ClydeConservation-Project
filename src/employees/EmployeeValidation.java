package employees;

public class EmployeeValidation extends Exception{

    public EmployeeValidation(String message){
        super("\n"+message);
    }
}
