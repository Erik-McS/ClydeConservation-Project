package clydeconservationsystem;

import animals.Animal;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * This class will contain all the AllocationsTable objects created by the Head Keeper
 * @author Erik
 */
public class AllocationsCollection {

    private static ArrayList<AllocationTable>assignments=new ArrayList<>();
    private static final String fileName="assignments.dat";

    // using a private constructor to prevent the creation of Assignment objects
    private AllocationsCollection(){}

    /**
     * Function to return the filename for the assignments
     * @return File name
     */
    public static String getFileName(){
        return fileName;
    }

    /**
     * This method will save the assignment ArrayList in a file
     * Link to resource found while searching for how-to
     * <p>
     * <a href="https://stackoverflow.com/questions/16111496/java-how-can-i-write-my-arraylist-to-a-file-and-read-load-that-file-to-the">Java - How Can I Write My ArrayList to a file</a>
     * @see FileOutputStream
     * @see ObjectOutputStream
     *
     */
    public static void saveAssigment(){
        // try-catch to get any IO errors
        try{
            // initialise an output stream for the file
            FileOutputStream fos=new FileOutputStream(fileName);
            ObjectOutputStream oos=new ObjectOutputStream(fos);
            oos.writeObject(assignments);
            oos.close();
        }
        catch (IOException e){
            System.out.println(e.getMessage());
        }
    }

    /**
     * Method to load a saved Assignments from a file
     * @see FileInputStream
     * @see ObjectInputStream
     */
    public static void loadAssignment(){

        try{

            FileInputStream fis=new FileInputStream(fileName);
            ObjectInputStream ois=new ObjectInputStream(fis);
            assignments.clear();
            try{
                assignments=(ArrayList<AllocationTable>) ois.readObject();
            }
            catch (ClassNotFoundException e){
                System.out.println(e.getMessage());
            }
        }
        catch (IOException e){
            System.out.println(e.getMessage());
        }
    }

    /**
     * Method do display all the assignments and their details.
     */
    public void displayAssignments(){

        if (assignments.isEmpty())
            System.out.println("There is no assignments stored");
        else {
            Iterator<AllocationTable> iter= assignments.iterator();
            while (iter.hasNext()){
                AllocationTable assign=iter.next();
                System.out.println("----- Keeper "+assign.getAssignedKeeper().getFirstName()+
                        " "+assign.getAssignedKeeper().getLastName()+" -----");
                assign.displayAssignment();
            }
        }
    }
//End of class
}
