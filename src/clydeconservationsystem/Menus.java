package clydeconservationsystem;

import java.util.InputMismatchException;
import java.util.Scanner;

import animals.Bird;
import animals.Mammal;
import animals.Menagerie;
import animals.Reptile;
import employees.*;

/**
 * The Menus class will be used to propose the different menus of the app.
 * <p>
 * All variables and methods will be static ( except any private methods).
 * Most methods will return an object or a primitive type.
 * <p>
 * This class will have a private constructor to forbid the instantiation of an object.
 * @author Erik
 */
public class Menus {
    // Scanner object to get the user's menu choice.
    private static final Scanner sc=new Scanner(System.in);
    // variable to store the user's choice
    private static int choice;
    // exit condition used in the do-while
    private static boolean exit=false;

    // this private constructor will forbid the creation of Menus object as they are not needed.
    // this will also forbid inheritance for this class.
    private Menus(){}

    /**
     * This method will vaguely simulate a login.
     * <p>
     * It will create two profiles : Admin and Head Keeper and return the selected profile to the caller.
     * <p>
     * The profile is sent back as Employee variable, which can contain any of its child class.
     * @return The selected profile.
     */
    public static Employee logAsMenu(){
        // the Employee interface is used to contain the selected profile.
        Employee loggedAs;
        // this first try-catch is used in case of a validation issue while creating the Administrator or HeadKeeper object.
        try {

            // creating two different profile to use
            Administrator mark=new Administrator("Mark","Smith","07722334455","1 Glasgow av");
            HeadKeeper erik= new HeadKeeper.HdKBuilder().setName("Erik").setLastName("Mcseveney").setContactNumber("077667788").HBuilder();

            // do-while loop for the menu
            do {
                // this second try-catch is used in case of an incorrect choice entered
                try{
                    // printing the menu
                    System.out.println("""

                        ----- Welcome to Clyde Conservation System -----

                        Please select an option
                        1) Log as Head Keeper
                        2) Log as Administrator
                        3) Exit
                        -->\s""");
                    // getting user's input
                    choice=sc.nextInt();
                    // using the 'enhanced switch' which allows to get a parameter in return. for info:
                    // https://www.geeksforgeeks.org/enhancements-for-switch-statement-in-java-13/
                    // the Employee variable loggedAs will receive either an Administrator or headKeeper object as a result.
                    // the yield keyword is the equivalent of return used with functions returning parameters
                    loggedAs=switch (choice){
                        case 1-> {
                            exit=true;
                            // returning the headKeeper profile
                            yield erik;}
                        case 2-> {
                            exit=true;
                            // returning the Administrator profile
                            yield mark;}
                        case 3-> {
                            // existing the program
                            System.out.println("Exiting Clyde Conservation Application");
                            System.exit(0);
                            // each case statement of an enhanced switch must have a yield
                            // the following will never happens but must be present
                            yield null;
                        }
                        default -> throw new ValidationException("Incorrect choice value: " + choice);
                    };
                }
                catch (ValidationException e){
                    exit=false;
                    loggedAs=null;
                    System.out.println(e.getMessage());
                }
            }
            while (!exit);
            // returning the selected profile
            return loggedAs;
        }
        catch (EmployeeValidation e){
            System.out.println(e.getMessage());
        }
        // this return will never happen, but needs to be here
        return null;
    }

    /**
     * This function will return the choice selected in the main menu.
     * <p>
     * the function do not use a Do-While loop itself, this will be done where the function is called.
     * @return The selected choice.
     */
    public static int mainMenu(){
        // printing the menu
            System.out.println("""

                    ----- Welcome to Clyde Conservation System -----

                    Please select an option
                    1) Head Keeper Application
                    2) Administrator Application
                    3) Exit
                    -->\s""");
            try{
                choice=sc.nextInt();
                // returning the selected choice from the user
                return switch (choice){
                    case 1, 2 ->{yield choice;}
                    case 3->{
                        exit=true;
                        System.exit(0);
                        yield 0;
                    }
                    default -> { yield 5;}
                };
            }
            catch (InputMismatchException e){
                System.out.println("Incorrect choice entered");
                return 0;
            }
            finally {
                sc.nextLine();
            }
    }

    /**
     * This function will handle the options accessible to a Head Keeper.
     * @param headKeeper the profile of the logged Head Keeper.
     */
    public static void headKeeperMenu(HeadKeeper headKeeper){

        System.out.println(headKeeper.getDetails());
    }

    /**
     * This function will handle the options accessible to an Administrator.
     * @param admin the profile of the logged Administrator.
     */
    public static void administratorMenu(Administrator admin){
        // exit condition for the Admin Menu
        int exit=0;
        // we loop the menu until the suer select exist
        do {
            // switch to process choices from the admin menu
            switch (adminMenu()){
                case 1:
                    // do-while and switch to handle the submenu for Add an Animal
                    // sub-exit condition
                    int exit1=0;
                    // looping the options
                    do {
                        switch (adminAddAnimalMenu()){
                            case 1:
                                // adding a bird
                                // the default constructor will call the menus to create the object.
                                Bird bird=new Bird();
                                // we add the animal to the collection
                                Menagerie.addAnimal(bird);
                                System.out.println("The following bird is now added in the system:");
                                System.out.println(bird.getDetails());
                                break;
                            case 2:
                                // adding a Mammal
                                // the default constructor will call the menus to create the object.
                                Mammal mammal=new Mammal();
                                // we add the animal to the collection
                                Menagerie.addAnimal(mammal);
                                System.out.println("The following mammal is now added in the system:");
                                System.out.println(mammal.getDetails());
                                break;
                            case 3:
                                // adding a Reptile
                                // the default constructor will call the menus to create the object.
                                Reptile reptile=new Reptile();
                                // we add the animal to the collection
                                Menagerie.addAnimal(reptile);
                                System.out.println("The following bird is now added in the system:");
                                System.out.println(reptile.getDetails());
                                break;
                            case 4:
                                exit1=4;
                                break;
                        }
                    }while (exit1!=4);
                    break;
                case 2:
                    System.out.println("Add Cage");
                    break;
                case 3:
                    //System.out.println("Add Keeper");
                    int exit3=0;
                    do {
                        switch (adminAddKeeperMenu()){
                            case 1:
                                // add an Assistant Keeper
                                String[] keeperDetails=getKeeperDetails();
                                AssistantKeeper assist=new AssistantKeeper(keeperDetails[0],keeperDetails[1],
                                        keeperDetails[2],keeperDetails[3]);
                                EmployeeRoster.addEmployee(assist);
                                System.out.println("The following employee is now added to the roster:");
                                System.out.println(assist.getDetails());
                                break;
                            case 2:
                                // add a HeadKeeper
                                String[] hKeeperDetails=getKeeperDetails();
                                try{
                                    HeadKeeper hKeeper=new HeadKeeper.HdKBuilder().setName(hKeeperDetails[0]).setLastName(hKeeperDetails[1])
                                            .setContactNumber(hKeeperDetails[2]).setAddress(hKeeperDetails[3]).HBuilder();
                                }
                                catch (EmployeeValidation e){
                                    System.out.println(e.getMessage());
                                }
                            case 3:
                                // exiting the menu
                                exit3=3;
                                break;
                        }
                    }
                    while (exit3!=3);
                    break;
                case 4:
                    exit=4;
            }
        }
        while (exit!=4);

        // System.out.println(admin.getDetails());
    }

    // methods called to create an Animal object.
    // the setters from the animal class will call those methods to get the user input.

    /**
     * Menu Method to select the animal's category.
     * <p>
     * The looping of the menu in case of invalid input is done in the calling setter.
     * @return The selected animal's category
     */
    public static String setAnimalCategory(){
        // printing the menu choices
        System.out.println("""
                    
                    Please select a category:
                    1) Predator
                    2) Prey
                    -->\s""");
        // try-catch in case the user enters characters
        try{
            // getting the user choice
            choice=sc.nextInt();
            // enhanced switch to return a valid category
            return switch (choice){
                case 1->{yield "Predator";}
                case 2->{yield "Prey";}
                // if incorrect choice, we return null
                // this will signal the calling function to loop again
                default -> {yield null;}
            };
        }
        catch (InputMismatchException e){
            System.out.println("Incorrect choice value entered");
            return null;
        }
        // to avoid unexpected issues( like unexpected looping)
        // we make sure that the Scanner object is cleared to be re-used
        finally {
            sc.nextLine();
        }
    }
    // same logic as setAnimalCategory()
    /**
     * Menu Method to select the animal's sex.
     * <p>
     * The looping of the menu in case of invalid input is done in the calling setter.
     * @return The selected animal's sex
     */
    public static String setAnimalSex(){
        System.out.println("""
                    
                    Please select a sex:
                    1) Male
                    2) Female
                    -->\s""");
        try{
            choice=sc.nextInt();
            return switch (choice){
                case 1->{yield "Male";}
                case 2->{yield "Female";}
                default -> {yield null;}
            };
        }
        catch (InputMismatchException e){
            System.out.println("Incorrect choice entered");
            return null;
        }
        finally {
            sc.nextLine();
        }
    }

    // same logic as setAnimalCategory()
    /**
     * Menu Method to select the animal's name.
     * <p>
     * The looping of the menu in case of invalid input is done in the calling setter.
     * @return The selected animal's name
     */
    public static String setAnimalName(){
        System.out.println("""
                
                Please enter the animal's name
                (Must contains at least one character)
                -->\s""");
        // this try-catch will make sure that the value entered is not just a number
        try{
            return sc.next();
        }
        catch(InputMismatchException e){
            System.out.println("Invalid name format");
            return null;
        }
        finally {
            sc.nextLine();
        }
    }
    // same logic as setAnimalCategory()
    /**
     * Menu Method to select the animal's Date of Birth.
     * <p>
     * The looping of the menu in case of invalid input is done in the calling setter
     * @return The selected animal's Date of Birth
     */
    public static String setAnimalDoB(){
        System.out.println("""
                
                Please enter the animal's Date of Birth
                ( dd/mm/yyyy)
                -->\s""");
        // this try-catch will make sure that the value entered is not just a number
        try{
            return sc.next();
        }
        catch(InputMismatchException e){
            System.out.println("Invalid DoB format");
            return null;
        }
        finally {
            sc.nextLine();
        }
    }

    /**
     * Menu Method to select the animal's Date of Acquisition.
     * <p>
     * The looping of the menu in case of invalid input is done in the calling setter
     * @return The selected animal's Date of Acquisition
     */
    public static String setAnimalDoA(){
        System.out.println("""
                
                Please enter the animal's Date of Acquisition
                ( dd/mm/yyyy)
                -->\s""");
        // this try-catch will make sure that the value entered is not just a number
        try{
            return sc.next();
        }
        catch(InputMismatchException e){
            System.out.println("Invalid DoA format");
            return null;
        }
        finally {
            sc.nextLine();
        }
    }

    // the following privates methods are used for internal menus

    private static int adminMenu(){
        // printing the menu
        System.out.println("""

                    Please select an option
                    1) Add an Animal
                    2) Add a Cage
                    3) Add a Keeper
                    4) Exit
                    -->\s""");
        try{
            choice=sc.nextInt();
            // returning the selected choice from the user
            return switch (choice){
                case 1, 2, 3, 4 ->{yield choice;}
                default -> { yield 5;}
            };
        }
        catch (InputMismatchException e){
            System.out.println("Incorrect choice entered");
            return 0;
        }
        finally {
            sc.nextLine();
        }
    }

    private static int adminAddAnimalMenu(){
        // printing the menu
        System.out.println("""
                    ----- Add an Animal -----  
                    Please select an option
                    1) Add a Bird
                    2) Add a Mammal
                    3) Add a Reptile
                    4) Exit
                    -->\s""");
        try{
            choice=sc.nextInt();
            // returning the selected choice from the user
            return switch (choice){
                case 1, 2, 3, 4 ->{yield choice;}
                default -> { yield 0;}
            };
        }
        catch (InputMismatchException e){
            System.out.println("Incorrect choice entered");
            return 0;
        }
        finally {
            sc.nextLine();
        }
    }

    private static int adminAddKeeperMenu(){
        // printing the menu
        System.out.println("""
                    ----- Add a Keeper -----  
                    Please select an option
                    1) Add an Assistant Keeper
                    2) Add a Head Keeper
                    3) Exit
                    -->\s""");
        try{
            choice=sc.nextInt();
            // returning the selected choice from the user
            return switch (choice){
                case 1, 2, 3->{yield choice;}
                default -> { yield 0;}
            };
        }
        catch (InputMismatchException e){
            System.out.println("Incorrect choice entered");
            return 0;
        }
        finally {
            sc.nextLine();
        }
    }

    private static String[] getKeeperDetails(){
        String [] keeper=new String[4];
        // getting each value and storing
        System.out.println("Please enter the keeper's first name: ");
        keeper[0]=sc.next();
        System.out.println("Please enter the keeper's last name: ");
        keeper[1]=sc.next();
        System.out.println("Please enter the keeper's last contact number: ");
        keeper[2]=sc.next();
        System.out.println("Please enter the keeper's address:");
        keeper[3]=sc.next();

        return keeper;
    }
// end of class
}
