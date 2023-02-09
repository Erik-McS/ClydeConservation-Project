package clydeconservationsystem;

import employees.Keeper;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

/**
 * This class holds the Cages-Keepers allocation.
 * <p>
 * An allocation needs to be assigned a Keeper(mandatory) and can be assigned up to 4 cages.
 * <p>
 * A keeper cannot be assigned to an allocation if he's already in another one.
 * <p>
 * all allocations are stored in an AllocationCollection object.
 * @author Erik
 */
public class AllocationTable implements Serializable {

    // Variable to hold the Keeper
    private Keeper assignedKeeper;
    // Variable to hold the maximum number of cage a keeper can have
    private final int MAX_ASSIGMENTS=4;
    // arraylist to store the assigned cages.
    private ArrayList<Cage> assignedCages=new ArrayList<>();
    // static variable to create an ID;
    private static int ASSIGNMENT_ID_BASE=500;
    private final int assignmentID;


    /**
     * Constructor for the Allocation object.
     * <p>
     * A table must be created with a Keeper, even if it can be changed later if needed.
     * @param keeper Keeper to assign to the table
     */
    public AllocationTable(Keeper keeper){
        this.assignedKeeper=keeper;
        assignmentID=ASSIGNMENT_ID_BASE++;
    }
    /**
     * Method to get the assigned Keeper of to allocation table
     * @return The assigned Keeper.
     */
    public Keeper getAssignedKeeper() {
        return assignedKeeper;
    }

    /**
     * Method to return the assignment ID
     * @return assignment ID
     */
    public int getAssignmentID() {
        return assignmentID;
    }

    /**
     * Method to assign a Keeper to the allocation table
     * <p>
     * This should only be used if the existing keeper need to be replaced
     * @param assignedKeeper Keeper to assign
     */
    public void setAssignedKeeper(Keeper assignedKeeper) {
        this.assignedKeeper = assignedKeeper;
    }
    private boolean isMaxedOut(){
        // test if the keeper has room for more cage assignments.
        // returns true if the size of the arraylist is greater or equal than the MAX_ASSIGNMENT constant
        return assignedCages.size()>=MAX_ASSIGMENTS;
    }
    // function to check is the list is empty
    private boolean isEmpty(){
        return assignedCages.isEmpty();
    }

    /**
     * Method to add a cage to a Keeper assignment
     * @param cage Cage to add
     */
    public void assignCage(Cage cage){
        // we first test if the cage is empty
        // if not, we check if the assigned cages of this keeper is not greater or equal than 4
        if (cage.isEmpty())
            System.out.println("This cage is empty. it cannot be assigned yet.");
        else if(isMaxedOut())
            System.out.println("This keeper cannot care for any more cages");
        else
            assignedCages.add(cage);
    }

    /**
     * Method to remove a Cage from the Assignment
     */
    public void removeCage(){
        System.out.println("----- Remove a cage from the assignment -----");
        displayAssignment();
        System.out.println("Please enter the Cage number to remove: ");
        assignedCages.remove(new Scanner(System.in).nextInt()-1);
    }

    /**
     * Method to display the cages assigned in this Allocation Table
     */
    public void displayAssignment(){
        int index=1;
        if (isEmpty())
            System.out.println("This keeper has no cages assigned");
        else{
            Iterator<Cage> iter= assignedCages.iterator();
            System.out.println("----- Assignment ID: "+getAssignmentID()+" -----");
            System.out.println("Keeper: "+assignedKeeper.getFirstName()+" "+assignedKeeper.getLastName());
            while (iter.hasNext()){
                Cage cge=iter.next();
                System.out.println("----- Cage ID"+cge.getCageID()+" -----");
                System.out.println(cge.getCageDetails());
            }
        }
    }

    /**
     * Method to return the number of cages assigned to the table.
     * @return Number of cage (0-4).
     */
    public int assignedCages(){
        if (assignedCages.isEmpty())
            return 0;
        else
            return assignedCages.size();
    }

    /**
     * Method to check if a Cage is already assigned in the table
     * @param cage
     * @return True or False
     */
    public boolean cageIsPresent(Cage cage){

        if (assignedCages.isEmpty())
            return false;
        else{
            Iterator<Cage> it=assignedCages.iterator();
            while (it.hasNext()){
                Cage cage1=it.next();
                if (cage1.getCageID()==cage.getCageID())
                    return true;
            }
            return false;
        }

    }

// End of class
}
