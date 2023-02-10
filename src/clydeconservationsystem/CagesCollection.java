package clydeconservationsystem;

import animals.Animal;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Class to hold the cages owned by Clyde Conservation
 */
public class CagesCollection {

    private static final String fileName="cages.dat";
    private static ArrayList<Cage> cagesCollection=new ArrayList<>();

    /**
     * Method to add a cage to the collection
     * @param c Cage to add
     */
    public static void addCage(Cage c){
        cagesCollection.add(c);
    }

    /**
     * Method to check if the collection is empty
     * @return True or False
     */
    public static boolean isEmpty(){
        return cagesCollection.isEmpty();
    }

    /**
     * This method will save the Cages ArrayList in a file
     * <p>
     * Link to resource found while searching for how-to
     * <p>
     * <a href="https://stackoverflow.com/questions/16111496/java-how-can-i-write-my-arraylist-to-a-file-and-read-load-that-file-to-the">Java - How Can I Write My ArrayList to a file</a>
     * @see FileOutputStream
     * @see ObjectOutputStream
     *
     */
    public static void saveCagesCollection(){
        // try-catch to get any IO errors
        try{
            // initialise an output stream for the file
            FileOutputStream fos=new FileOutputStream(fileName);
            ObjectOutputStream oos=new ObjectOutputStream(fos);
            oos.writeObject(cagesCollection);
            oos.close();
        }
        catch (IOException e){
            System.out.println("CageCollections:"+e.getMessage());
        }
    }

    /**
     * Method to load a saved cagesCollection from a file
     * @see FileInputStream
     * @see ObjectInputStream
     */
    public static void loadCagesCollection(){

        try{

            FileInputStream fis=new FileInputStream(fileName);
            ObjectInputStream ois=new ObjectInputStream(fis);
            cagesCollection.clear();
            try{
                // replacing the existing arraylist by the saved one
                cagesCollection=(ArrayList<Cage>) ois.readObject();
                // adding the number of cages to the CAGE_ID_BASE so new cages ID start after the last created one
                Cage.CAGE_ID_BASE=Cage.CAGE_ID_BASE+cagesCollection.size();
            }
            catch (ClassNotFoundException e){
                System.out.println("CageCollections:"+e.getMessage());
            }
        }
        catch (IOException e){
            System.out.println("CageCollections:"+e.getMessage());
        }

    }
    /**
     * The method will display the details of all the cages in the collection.
     */
    public static void displayAllCages(){
        // if empty, display status.
        if (cagesCollection.isEmpty())
            System.out.println("There is no cages stored");
        else{
            // using an iterator to loop over the cage collection.
            System.out.println();
            Iterator<Cage> iter=cagesCollection.iterator();
            while (iter.hasNext()){
                // displaying the index and the cage details.
                Cage cage= iter.next();
                System.out.println("Cage ID: "+cage.getCageID());
                System.out.println(cage.getCageDetails());
            }
        }
    }

    /**
     * The method will display the details of the unassigned cages in the collection.
     */
    public static void displayUnassignedCages(){

        if (cagesCollection.isEmpty())
            System.out.println("There is no cages stored");
        else{
            // using an iterator to loop over the cage collection.
            Iterator<Cage> iter=cagesCollection.iterator();
            while (iter.hasNext()){
                // if not already in the assignment collections, the cage will be displayed
                Cage cage= iter.next();
                if (!AssignmentsCollection.isAssigned(cage)){
                    System.out.println("Cage ID: "+cage.getCageID());
                    System.out.println(cage.getCageDetails());
                }
            }
        }
    }

    /**
     * Returns the number of unassigned cages
     * @return Unassigned cages
     */
    public static int countUnassignedCages(){
        if (cagesCollection.isEmpty())
            return 0;
        else{
            // using an iterator to loop over the cage collection.
            Iterator<Cage> iter=cagesCollection.iterator();
            int count=0;
            while (iter.hasNext()){
                Cage cage= iter.next();
                if (!AssignmentsCollection.isAssigned(cage)){
                    count++;
                }
            }
            return count;
        }
    }

    /**
     * Method to display a list of cages that aren't full
     */
    public static void displayNonFullCages(){
        Iterator<Cage> iter=cagesCollection.iterator();
        while (iter.hasNext()){
            Cage cfg=iter.next();
            if (!cfg.isFull())
                System.out.println(cfg.getCageDetails());
        }
    }

    /**
     * Method to get the index of a cage in the collection
     * <p>
     * will return -1 if not found
     * @param cageID Cage
     * @return -1 or the index in the ArrayList
     */
    public static int getCageIndex(int cageID){
        int index=0;
        if (cagesCollection.isEmpty())
            return -1;
        else{
            Iterator<Cage> iter=cagesCollection.iterator();
            while (iter.hasNext()){
                Cage cg= iter.next();
                if (cg.getCageID()==cageID)
                    return index;
                else
                    index++;
            }
            return -1;
        }
    }
    /**
     * Method to return an cage by its ID
     * @param cageID ID of the cage
     * @return The searched cage
     */
    public static Cage getCage(int cageID){

        if (cagesCollection.isEmpty())
            return null;
        else{
            Iterator<Cage>iter=cagesCollection.iterator();
            while (iter.hasNext()){
                Cage cg=iter.next();
                if (cg.getCageID()==cageID)
                    return cg;
            }
            return null;
        }

    }
    /**
     * Method to check if an animal is present in a cage
     * @param animal Animal to look for
     * @return True or False
     */
    public static boolean isAssigned(Animal animal){
        if (cagesCollection.isEmpty())
            return false;
        else {
            Iterator<Cage> iter=cagesCollection.iterator();
            while (iter.hasNext()){
                Cage cage=iter.next();
                if (cage.isPresent(animal))
                    return true;
            }
            return false;
        }

    }

    /**
     * Method to add an animal to an existing cage
     * @param cageID The Cage ID
     * @param animal The animal to add
     */
    public static void addAnimalToCage(int cageID,Animal animal){

        cagesCollection.get(cageID).assignAnimal(animal);
    }

// End of class
}
