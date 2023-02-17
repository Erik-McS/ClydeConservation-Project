package clydeconservationsystem;

import animals.Animal;

import java.io.Serializable;


/**
 * The Cage class defines the basics of cages in the application.
 *
 * @author Erik
 */
public abstract class Cage implements Serializable {

    /**
     * Base to create unique IDs for cages.
     * <p>
     * it is public and has setters as it needs to be modified when loading the Cage collection file
     */
    protected static int CAGE_ID_BASE=300;

    public int getCAGE_ID_BASE() {
        return CAGE_ID_BASE;
    }

    public void setCAGE_ID_BASE(int CAGE_ID_BASE) {
        this.CAGE_ID_BASE = CAGE_ID_BASE;
    }


    protected int cageID;

    /**
     * Method to get the cageID
     * @return the Cage ID
     */
    public int getCageID(){return cageID;}
    /**
     * Method to test if any animal has been assigned to the cage
     * @return True or False
     */
    public abstract boolean isEmpty();

    /**
     * add an animal to a cage
     * @param animal Animal to add to the cage
     */
    public abstract void assignAnimal(Animal animal);

    /**
     * Method to test if the cage is at full capacity
     * @return True or False
     */
    public abstract boolean isFull();

    /**
     * The Method will display the details of the cage
     * @return Cage details
     */
    public abstract String getCageDetails();

    /**
     * This method will tell if a specific Animal is present in the cage
     * @param animal Animal to look for
     * @return True or False
     */
    public abstract boolean isPresent(Animal animal);
    /**
     * The method will display the details of all the animals in the collection.
     */
    public abstract void displayAssignedAnimals();

}
