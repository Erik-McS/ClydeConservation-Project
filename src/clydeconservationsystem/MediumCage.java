package clydeconservationsystem;

import animals.Animal;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Class to represent the medium cages used at Clyde Conservation
 * the class also implements the Serializable interface so objects can be saved via a stream in a file
 * @author Erik
 */
public class MediumCage extends Cage implements Serializable {


    // defining the cage capacity
    private final int CAPACITY=5;
    // arraylist to contains the assigned animals
    private ArrayList<Animal> assignedAnimals;

    /**
     * Default Constructor
     */
    public MediumCage(){
        // initialising the arraylist
        assignedAnimals=new ArrayList<>();
        // creating the ID
        this.cageID=CAGE_ID_BASE++;
    }


    @Override
    public void displayAssignedAnimals() {
        // local variable to display the animal position in the collection.
        int index=0;
        // if empty, display status.
        if (isEmpty())
            System.out.println("There is no animals assigned to this Medium cage");
        else{
            // using an iterator to loop over the animal collection.
            Iterator<Animal> iter=assignedAnimals.iterator();
            while (iter.hasNext()){
                // displaying the index and the animal details.
                Animal animal= iter.next();
                System.out.println("Index: "+index);
                System.out.println(animal.getDetails());
                index++;
            }
        }
    }
    @Override
    public boolean isEmpty() {
        return assignedAnimals.isEmpty();
    }

    @Override
    public void assignAnimal(Animal animal) {
        // we check if the cage is empty
        if (assignedAnimals.isEmpty()){
            // if empty, we set the category of the cage to the animal's category
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
    public boolean isPresent(Animal animal) {
        if (assignedAnimals.isEmpty())
            return false;
        else {
            Iterator<Animal> iter= assignedAnimals.iterator();
            while(iter.hasNext()){
                Animal an= iter.next();
                if (an.getAnimalID()==animal.getAnimalID())
                    return true;
            }
            return false;
        }
    }
    @Override
    public boolean isFull() {
        return assignedAnimals.size()==CAPACITY;
    }

    @Override
    public String getCageDetails() {
        return "\n Cage Size: "+getCageSize()+
                " ----- Number of animals in the cage: "+assignedAnimals.size()+
                " ----- Cage Category: "+getCageCategory();
    }

    @Override
    public String getCageSize(){return "Medium";}

//End of Class
}
