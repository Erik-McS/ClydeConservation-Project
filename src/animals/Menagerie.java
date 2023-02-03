package animals;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * The Menagerie class will store all the animals in Clyde Conservation's care.
 * <p>
 * This class have static methods that will handle the collection of animals.
 */
public class Menagerie {

    private static ArrayList<Animal> menagerie=new ArrayList<>();
    private static final String fileName="menagerie.dat";
    // using a private constructor to prevent the creation of Menagerie objects
    private Menagerie(){}
    /**
     * The method will display the details of all the animals in the collection.
     */
    public static void displayAnimals(){
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
     * Function to return the filename for the Menagerie
     * @return File name
     */
    public static String getFileName(){
        return fileName;
    }
    /**
     * This method will save the Menagerie ArrayList in a file
     * Link to resource found while searching for how-to
     * <a href="https://stackoverflow.com/questions/16111496/java-how-can-i-write-my-arraylist-to-a-file-and-read-load-that-file-to-the">...</a>
     * @param filename Name of the file
     * @see FileOutputStream
     * @see ObjectOutputStream
     *
     */
    public static void saveMenagerie(String filename){
        // try-catch to get any IO errors
        try{
            // initialise an output stream for the file
            FileOutputStream fos=new FileOutputStream(filename);
            ObjectOutputStream oos=new ObjectOutputStream(fos);
            oos.writeObject(menagerie);
            oos.close();
        }
        catch (IOException e){
            System.out.println(e.getMessage());
        }
    }

    /**
     * Method to load a saved menagerie from a file
     * @param filename Name fo the file to load
     * @see FileInputStream
     * @see ObjectInputStream
     */
    public static void loadMenagerie(String filename){

        try{

            FileInputStream fis=new FileInputStream(filename);
            ObjectInputStream ois=new ObjectInputStream(fis);
            menagerie.clear();
            try{
                menagerie=(ArrayList<Animal>) ois.readObject();
            }
            catch (ClassNotFoundException e){
                System.out.println(e.getMessage());
            }
        }
        catch (IOException e){
            System.out.println(e.getMessage());
        }

    }

// end of class
}
