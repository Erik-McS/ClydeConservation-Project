package animals;

import clydeconservationsystem.CagesCollection;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * The Menagerie class will store all the animals in Clyde Conservation's care.
 * <p>
 * This class have static methods that will handle the collection of animals.
 * <p>
 * To check: seems I actually designed by chance a class using a Singleton design pattern:
 * <p>
 * <a href="https://www.javatpoint.com/singleton-design-pattern-in-java">Singleton design pattern in Java</a>
 * <p>
 * Missing a method to return the array though, but
 *  it is not needed in my design
 *
 */
public class Menagerie {

    // ArrayList to store the animals
    private static ArrayList<Animal> menagerie=new ArrayList<>();
    // constant to hold the name of the menagerie file
    private static final String fileN="menagerie.dat";
    // using a private constructor to prevent the creation of Menagerie objects
    private Menagerie(){}
    /**
     * The method will display the details of all the animals in the collection.
     */
    public static void displayAllAnimals(){
        // local variable to display the animal position in the collection.
        int index=0;
        // if empty, display status.
        if (menagerie.isEmpty())
            System.out.println("There is no animals stored");
        else{
            // using an iterator to loop over the animal collection.
            Iterator<Animal> iter=menagerie.iterator();
            while (iter.hasNext()){
                // displaying the index and the animal details.
                Animal animal= iter.next();
                System.out.println("Index: "+index);
                System.out.println(animal.getDetails());
                index++;
            }
        }
    }

    /**
     * Method to display all the unassigned animals
     */
    public static void displayUnassignedAnimals(){
        Iterator<Animal>iter= menagerie.iterator();
        while (iter.hasNext()){
            Animal an= iter.next();
            if (!CagesCollection.isAssigned(an))
                an.getDetails();
        }
    }

    /**
     * Method to add a new animal to the collection
     * @param newAnimal Animal to add.
     */
    public static void addAnimal(Animal newAnimal){
        menagerie.add(newAnimal);
    }

    /**
     * Method to remove an animal from the collection using its index
     * @param index Position of the animal in the collection
     */
    public static void  removeAnimal(int index){
        menagerie.remove(index);
    }

    /**
     * Method to remove an animal from the collection using its name
     * @param name Name of the animal
     */
    public static void  removeAnimal(String name){

        Iterator<Animal> iter=menagerie.iterator();
        while (iter.hasNext()){
            Animal animal= iter.next();
            if (animal.getName().equals(name))
                menagerie.remove(animal);
        }
    }

    /**
     * This method will save the Menagerie ArrayList in a file
     * Link to resource found while searching for how-to:
     * <p>
     * <a href="https://stackoverflow.com/questions/16111496/java-how-can-i-write-my-arraylist-to-a-file-and-read-load-that-file-to-the">Java - How Can I Write My ArrayList to a file</a>
     * @see FileOutputStream
     * @see ObjectOutputStream
     *
     */
    public static void saveMenagerie(){
        // try-catch to get any IO errors
        try{
            // initialise an output stream for the file
            FileOutputStream fos=new FileOutputStream(fileN);
            ObjectOutputStream oos=new ObjectOutputStream(fos);
            oos.writeObject(menagerie);
            oos.close();
        }
        catch (IOException e){
            System.out.println("Save_Menagerie: "+e.getMessage());
        }
    }
    /**
     * Method to load a saved menagerie from a file
     * @see FileInputStream
     * @see ObjectInputStream
     */
    public static void loadMenagerie(){

        try{

            FileInputStream fis=new FileInputStream(fileN);
            ObjectInputStream ois=new ObjectInputStream(fis);
            menagerie.clear();
            try{
                menagerie=(ArrayList<Animal>)ois.readObject();
            }
            catch (ClassNotFoundException e){
                System.out.println("Load_Menagerie1: "+e.getMessage());
            }
        }
        catch (IOException e){
            System.out.println("Load_Menagerie2: "+e.getMessage());
        }
    }

    /**
     * Method to check if an animal exists in the menagerie
     * @param animal Animal to check
     * @return True or False
     */
    public static boolean isPresent(Animal animal){
        if (menagerie.isEmpty())
            return false;
        else{
            Iterator<Animal> iter= menagerie.iterator();
            while (iter.hasNext()){
                Animal an= iter.next();
                if (an.getAnimalID()==animal.getAnimalID())
                    return true;
            }
            return false;
        }
    }
    public static Animal getAnimal(int animalID){
        if (menagerie.isEmpty())
            return null;
        else{
            Iterator<Animal> iter= menagerie.iterator();
            while (iter.hasNext()){
                Animal an= iter.next();
                if (an.getAnimalID()==animalID)
                    return an;
            }
            return null;
        }
    }
// end of class
}
