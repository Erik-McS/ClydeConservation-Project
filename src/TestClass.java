import animals.Bird;
import animals.Menagerie;
import employees.*;
public class TestClass {
    public static void main(String[] args) {


            // HeadKeeper erik= new HeadKeeper.HdKBuilder().setName("Erik").setLastName("Mcsev").HBuilder();
              //System.out.println(erik.getDetails());
            //HeadKeeper stan=new HeadKeeper.HdKBuilder().setName("Stan").setLastName("Nagui").setAddress("123 College av")
                    //.setContactNumber("1234567890").HBuilder();
            //System.out.println(stan.getDetails());
           // Administrator mike=new Administrator("Mike","Smith","22222222","avenue");



            //String s=erik.getClass().getName();
            //System.out.println(s);
        Bird robin=new Bird();
        //Bird blue=new Bird();

        Menagerie.addAnimal(robin);
        //Menagerie.addAnimal(blue);

        Menagerie.displayAnimals();



    }
}
