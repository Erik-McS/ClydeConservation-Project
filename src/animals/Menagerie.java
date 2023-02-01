package animals;

import java.util.ArrayList;
import java.util.Iterator;

public class Menagerie {

    private static final ArrayList<Animal> menagerie=new ArrayList<>();

    public static void displayAnimals(){
        int index=0;
        if (menagerie.isEmpty())
            System.out.println("There is no animals stored");
        else{
            Iterator<Animal> iter=menagerie.iterator();
            while (iter.hasNext()){

                Animal animal= iter.next();
                System.out.println("Index: "+index);
                System.out.println(animal.getDetails());
                index++;
            }
        }
    }

    public static void addAnimal(Animal newAnimal){
        menagerie.add(newAnimal);
    }

    public static void  removeAnimal(int index){
        menagerie.remove(index);
    }
    public static void  removeAnimal(String name){

        Iterator<Animal> iter=menagerie.iterator();
        while (iter.hasNext()){
            Animal animal= iter.next();
            if (animal.getName().equals(name))
                menagerie.remove(animal);
        }
    }
}
