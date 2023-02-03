package clydeconservationsystem;

import animals.Animal;

/**
 * The Cage interface is used so cages objects can be store in one place
 * @author Erik
 */
public abstract class Cage {

    public static int CAGE_ID_BASE=300;
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

    public abstract String getCageDetails();

}
