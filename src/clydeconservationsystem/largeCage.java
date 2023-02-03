package clydeconservationsystem;

import animals.Animal;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Class to represent the large cages used at Clyde Conservation
 * the class also implements the Serializable interface so objects can be saved via a stream in a file
 * @author Erik
 */
public class largeCage extends Cage implements Serializable {

    // defining the cage capacity
    private final int CAPACITY=10;
    // arraylist to contains the assigned animals
    private ArrayList<Animal> assignedAnimals=new ArrayList<>();
    // variable to store the category of the first animal assigned to it
    // this will allow to check if the animals added later are compatible
    private String cageCategory;
    private int cageID;

    public largeCage(){
        // assign a cageID to the new cage
        this.cageID=CAGE_ID_BASE++;
    }

    /**
     * Method to return the cage Category
     * <p>
     * the Category is determined by the first animal placed in the cage.
     * <p>
     * it can be:
     * <p>
     * - null: the cage has no animals assigned yet
     * <p>
     * - 'Predator': the first assigned animal was a predator type, cage can only house predators now
     * <p>
     * - 'Prey': the first assigned animal was a prey type, cage can only house prey now
     *
     * @return 'Predator', 'Prey', null
     */
    public String getCageCategory(){
        return cageCategory;
    }

    /**
     * Method to get the cage ID
     * @return the cage ID
     */
    public int getCageID() {
        return cageID;
    }

    @Override
    public boolean isEmpty() {
        return assignedAnimals.isEmpty();
    }

    @Override
    public void assignAnimal(Animal animal) {
        // we check if the cage is empty
        if (assignedAnimals.isEmpty()){
            // if empty, we set the category of the cage to the animal category
            cageCategory= animal.getCategory();
            // we then add the animal to the cage
            assignedAnimals.add(animal);
            // we confirm the assignment
            System.out.println("The following animal has successfully been added to the cage:");
            System.out.println(animal.getDetails());
        }
        // if not empty, we check if full
        else if (isFull())
            System.out.println("There is no room left in this cage for a new animal");
        // otherwise, there is room for another animal
        else{
            // checking if the new animal will be compatible with the others in the cage.
            if (animal.getCategory().equals(this.cageCategory))
                // if yes, adding it to the cage
                assignedAnimals.add(animal);
            else
                // otherwise, error message
                System.out.println("This animal is a "+animal.getCategory()+" and is incompatible with the others in the cage");
        }
    }
    @Override
    public boolean isFull() {
        return assignedAnimals.size()==CAPACITY;
    }

    @Override
    public String getCageDetails() {
        return "\nCage ID: "+cageID+
                "\n Cage Capacity: "+CAPACITY+
                "\n Number of animals in the cage: "+assignedAnimals.size()+
                "\n Cage Category: "+getCageCategory();
    }
// End of class
}
