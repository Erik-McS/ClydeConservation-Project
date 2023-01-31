import java.util.Scanner;

// the Menus class will be used to propose the different menus of the app.
// all variables and methods will be static ( except any private methods)
// most methods will return an object or a primitive type.
public class Menus {
    // Scanner object to get the user's menu choice.
    private static final Scanner sc=new Scanner(System.in);
    // variable to store the user's choice
    private static int choice;
    // exit condition used in the do-while
    private static boolean exit=false;

    public static Employee logAsMenu(){
        // this method will vaguely simulate a login
        // it will create two profiles : Admin and Head Keeper
        // and return the selected profile to the caller

        // the Employee interface is used to contain the selected profile
        Employee loggedAs;
        // this first try-catch is used in case of a validation issue while creating the Administrator or HeadKeeper object
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
        catch (ValidationException e){
            System.out.println(e.getMessage());
        }
        // this return will never happen, but needs to be here
        return null;
    }

    // this function will return the choice selected in the main menu
    public static int mainMenu(){
        // do while to select a user's choice.
        do {
            System.out.println("""

                    ----- Welcome to Clyde Conservation System -----

                    Please select an option
                    1) Head Keeper Application
                    2) Administrator Application
                    3) Exit
                    -->\s""");
            choice=sc.nextInt();
            // returning the selected choice from the user
            return switch (choice){
                case 1, 2 ->{yield choice;}
                case 3->{
                    exit=true;
                    System.exit(0);
                    yield 0;
                }
                default -> { yield 0;}
                };


        }while(!exit);
    }

    public static void headKeeperMenu(HeadKeeper headKeeper){
        System.out.println(headKeeper.getDetails());
    }

    public static void administratorMenu(Administrator admin){
        System.out.println(admin.getDetails());
    }
}
