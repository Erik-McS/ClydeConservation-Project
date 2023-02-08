package employees;


import animals.Animal;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Class that will hold the employees of Clyde Conservation
 */
public class EmployeeRoster implements Serializable{
    private static ArrayList<Employee> employees=new ArrayList<>();
    // setting a filename for the employee roster file
    private static final String fileName="roster.dat";
    // using a private constructor to prevent the creation of EmployeeRoster objects
    public EmployeeRoster(){}
    /**
     * The method will display the details of all the employees in the collection.
     */
    public static void displayEmployees(){
        // local variable to display the Employee position in the collection.
        // if empty, display status.
        if (employees.isEmpty())
            System.out.println("There is no employees stored");
        else{
            // using an iterator to loop over the employee collection.
            Iterator<Employee> iter=employees.iterator();
            while (iter.hasNext()){
                // displaying the index and the employee details.
                Employee employee= iter.next();
                System.out.println("Employee ID: "+employee.getID());
                System.out.println(employee.getDetails());
            }
        }
    }
    /**
     * Method do display the keepers present in the Employee roster
     */
    public static void  displayKeepers(){
        // if empty, display status.
        if (employees.isEmpty()){
            System.out.println("There is no employees stored in the system");}
        else{
            // using an iterator to loop over the employee collection.
            Iterator<Employee> iter=employees.iterator();
            while (iter.hasNext()){
                // displaying the index and the employee details.
                Employee employee= iter.next();
                System.out.println("-----------------------------------------------------");
                if (employee instanceof Keeper){
                    Keeper emp=(Keeper) employee;
                    System.out.println("----- Keeper ID: "+emp.getKeeperID()+" -----");
                    System.out.println("Name: "+emp.getFirstName()+"\nSurname: "+emp.getLastName());
                }
            }
        }
    }
    /**
     * Method to search the employee roster and return a keeper ogject corresponding to the passed keeperID
     * @param keeperID
     * @return the searched Keeper, or null if not found
     */
    public static Keeper getKeeper(int keeperID){
        Iterator<Employee> iter= employees.iterator();
        while (iter.hasNext()){
            Employee employee=iter.next();
            if (employee instanceof Keeper){
               Keeper kp=(Keeper) employee;
               if (kp.getKeeperID()==keeperID)
                   return kp;
            }
        }
        return null;
    }

    /**
     * Function to return the filename for the roster
     * @return File name
     */
    public static String getFileName(){
        return fileName;
    }

    /**
     * Method to add a new employee to the collection
     * @param employee Employee to add to the roster
     */
    public static void addEmployee(Employee employee){
        employees.add(employee);
    }

    /**
     * This method will save the Roster ArrayList in a file
     * <p>
     * Link to resource found while searching for how-to:
     * <p>
     * <a href="https://stackoverflow.com/questions/16111496/java-how-can-i-write-my-arraylist-to-a-file-and-read-load-that-file-to-the">Saving ArrayList in a file</a>
     * @see FileOutputStream
     * @see ObjectOutputStream
     *
     */
    public static void saveRoster(){
        // try-catch to get any IO errors
        try{
            // initialise a file output stream for the file
            FileOutputStream fos=new FileOutputStream(fileName);
            // create an object stream to write in the file stream
            ObjectOutputStream oos=new ObjectOutputStream(fos);
            // writing the employee ArrayList in the file
            oos.writeObject(employees);
            oos.close();
        }
        catch (IOException e){
            System.out.println(e.getMessage());
        }
    }

    /**
     * Method to load a saved roster from a file
     * @see FileInputStream
     * @see ObjectInputStream
     */
    public static void loadRoster(){

        try{
            FileInputStream fis=new FileInputStream(fileName);
            ObjectInputStream ois=new ObjectInputStream(fis);
            employees.clear();
            try{
                employees=(ArrayList<Employee>) ois.readObject();
            }
            catch (ClassNotFoundException e){
                System.out.println(e.getMessage());
            }
        }
        catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
// End of class
}
