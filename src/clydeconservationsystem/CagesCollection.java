package clydeconservationsystem;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Class to hold the cages owned by Clyde Conservation
 */
public class CagesCollection {

    private static final String fileName="cages.dat";
    private static ArrayList<Cage> cagesCollection=new ArrayList<>();

    public static void addCage(Cage c){
        cagesCollection.add(c);
    }
    public static boolean isEmpty(){
        return cagesCollection.isEmpty();
    }
    /**
     * Function to return the filename for the Menagerie
     * @return File name
     */
    public static String getFileName(){
        return fileName;
    }

    /**
     * This method will save the Cages ArrayList in a file
     * Link to resource found while searching for how-to
     * <p>
     * <a href="https://stackoverflow.com/questions/16111496/java-how-can-i-write-my-arraylist-to-a-file-and-read-load-that-file-to-the">Java - How Can I Write My ArrayList to a file</a>
     * @param filename Name of the file
     * @see FileOutputStream
     * @see ObjectOutputStream
     *
     */
    public static void saveCagesCollection(String filename){
        // try-catch to get any IO errors
        try{
            // initialise an output stream for the file
            FileOutputStream fos=new FileOutputStream(filename);
            ObjectOutputStream oos=new ObjectOutputStream(fos);
            oos.writeObject(cagesCollection);
            oos.close();
        }
        catch (IOException e){
            System.out.println(e.getMessage());
        }
    }

    /**
     * Method to load a saved cagesCollection from a file
     * @param filename Name fo the file to load
     * @see FileInputStream
     * @see ObjectInputStream
     */
    public static void loadCagesCollection(String filename){

        try{

            FileInputStream fis=new FileInputStream(filename);
            ObjectInputStream ois=new ObjectInputStream(fis);
            cagesCollection.clear();
            try{
                cagesCollection=(ArrayList<Cage>) ois.readObject();
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
     * The method will display the details of all the animals in the collection.
     */
    public static void displayCages(){
        // local variable to display the cage position in the collection.
        int index=0;
        // if empty, display status.
        if (cagesCollection.isEmpty())
            System.out.println("There is no cages stored");
        else{
            // using an iterator to loop over the animal collection.
            Iterator<Cage> iter=cagesCollection.iterator();
            while (iter.hasNext()){
                // displaying the index and the animal details.
                Cage cage= iter.next();
                System.out.println("Index: "+index);
                System.out.println(cage.getCageDetails());
                index++;
            }
        }
    }
// End of class
}
