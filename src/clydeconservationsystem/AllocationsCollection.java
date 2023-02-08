package clydeconservationsystem;

import employees.Keeper;

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
            System.out.println("AllocationCollection: "+e.getMessage());
        }
    }

    /**
     * Method do display all the assignments and their details.
     */
    public static void displayAssignments(){

        if (assignments.isEmpty())
            System.out.println("There is no assignments stored");
        else {
            Iterator<AllocationTable> iter= assignments.iterator();
            while (iter.hasNext()){
                AllocationTable assign=iter.next();
                System.out.println("----- Assignment ID "+assign.getAssignmentID()+", Keeper "+assign.getAssignedKeeper().getFirstName()+
                        " "+assign.getAssignedKeeper().getLastName()+" -----");
                assign.displayAssignment();
            }
        }
    }
    /**
     * Method to create a new Assignment. it needs the keeper passed as parameter.
     * The method will create a new AllocationTable object with the Keeper
     * @param keeper The keeper to assign to the AllocationTable
     */
    public static void addAssignment(Keeper keeper){

        if (isPresent(keeper))
            System.out.println("This keeper already has an assignment");
        else {
            assignments.add(new AllocationTable(keeper));
            saveAssigment();
            System.out.println("The new assignment is now created");
        }
    }
    // method to check if a keeper already has an assignment.
    private static boolean isPresent(Keeper keeper){

        Iterator<AllocationTable> iter=assignments.iterator();
        if (assignments.isEmpty())
            return false;
        else {
            while (iter.hasNext()){
                AllocationTable assignment=iter.next();
                Keeper kp=assignment.getAssignedKeeper();
                if (keeper.getKeeperID()== kp.getKeeperID())
                    return true;
            }
        }
        return false;
    }

    /**
     * This method will check if the cage is already assigned somewhere
     * @param cage Cage to check
     * @return True or false
     */
    public static boolean isAssigned(Cage cage){
        if (assignments.isEmpty())
            return false;
        else {
            Iterator<AllocationTable> iter=assignments.iterator();
            while (iter.hasNext()){
                AllocationTable assign=iter.next();
                if (assign.cageIsPresent(cage))
                    return true;
            }
            return false;
        }
    }

    /**
     * Method to get the index of an assignment in the collection
     * will return -1 if not found
     * @param at Assigment
     * @return -1 or the index in the ArrayList
     */
    public static int getAssignmentIndex(AllocationTable at){
        if (assignments.isEmpty())
            return -1;
        else{
            int index=0;
            Iterator<AllocationTable> iter=assignments.iterator();
            while (iter.hasNext()){
                AllocationTable assign=iter.next();
                if (assign.getAssignmentID()==at.getAssignmentID())
                    return index;
                else
                    index++;
            }
            return -1;
        }
    }

    /**
     * Method to assign a cage to an existing assignment
     * @param assignmentIndex index of the assignment
     * @param cage Cage to add
     */
    public static void addCageToAssignment(int assignmentIndex,Cage cage){
        assignments.get(assignmentIndex).assignCage(cage);
    }

    /**
     * Method to return an assignment by its ID
     * @param assignmentID ID of the assigment
     * @return The searched assignment
     */
    public static AllocationTable getAssigment(int assignmentID){

        if (assignments.isEmpty())
            return null;
        else{
            Iterator<AllocationTable> iter=assignments.iterator();
            while (iter.hasNext()){
                AllocationTable assign=iter.next();
                if (assign.getAssignmentID()==assignmentID)
                    return assign;
            }
            return null;
        }

    }
//End of class
}
