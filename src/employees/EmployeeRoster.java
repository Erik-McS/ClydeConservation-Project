package employees;


import animals.Animal;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Class that will hold the employees of Clyde Conservation
 */
public class EmployeeRoster {

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
     * Function to return the filename for the Menagerie
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
     * Link to resource found while searching for how-to
     * <p>
     * <a href="https://stackoverflow.com/questions/16111496/java-how-can-i-write-my-arraylist-to-a-file-and-read-load-that-file-to-the">Saving ArrayList in a file</a>
     * @param filename Name of the file
     * @see FileOutputStream
     * @see ObjectOutputStream
     *
     */
    public static void saveRoster(String filename){
        // try-catch to get any IO errors
        try{
            // initialise a file output stream for the file
            FileOutputStream fos=new FileOutputStream(filename);
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
     * @param filename Name fo the file to load
     * @see FileInputStream
     * @see ObjectInputStream
     */
    public static void loadRoster(String filename){

        try{

            FileInputStream fis=new FileInputStream(filename);
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
