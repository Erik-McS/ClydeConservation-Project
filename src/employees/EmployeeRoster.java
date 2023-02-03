package employees;


import java.util.ArrayList;
import java.util.Iterator;

/**
 * Class that will hold the employees of Clyde Conservation
 */
public class EmployeeRoster {

    private static ArrayList<Employee> employees=new ArrayList<>();
    // using a private constructor to prevent the creation of EmployeeRoster objects
    public EmployeeRoster(){}
    /**
     * The method will display the details of all the employees in the collection.
     */
    public static void displayEmployees(){
        // local variable to display the Employee position in the collection.
        int index=0;
        // if empty, display status.
        if (employees.isEmpty())
            System.out.println("There is no animals stored");
        else{
            // using an iterator to loop over the employee collection.
            Iterator<Employee> iter=employees.iterator();
            while (iter.hasNext()){
                // displaying the index and the employee details.
                Employee employee= iter.next();
                System.out.println("Index: "+index);
                System.out.println(employee.getDetails());
                index++;
            }
        }
    }

    /**
     * Method to add a new employee to the collection
     * @param employee Employee to add to the roster
     */
    public static void addEmployee(Employee employee){
        employees.add(employee);
    }


// End of class
}
