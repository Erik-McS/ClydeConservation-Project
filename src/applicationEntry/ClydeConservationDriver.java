package applicationEntry;

import employees.*;
import clydeconservationsystem.*;
public class ClydeConservationDriver {

    public static void main(String[] args) {

        // using the logAsMenu to simulate an Employee login and store the profile in a variable
        Employee loggedAs=Menus.logAsMenu();

        // this loop has no exit condition by itself as the exit option will be handled
        // by the Menus class itself
        do {
            // the switch statement takes the value returned by Menus.mainMenu() as parameter
            switch (Menus.mainMenu()){
                case 1:
                    try {
                        // we cast the profile stored in the loggedAS variable as a HeadKeeper
                        // if the types match, the Headkeeper menu will display
                        // else it means the user is an administrator and can't access the menu
                        Menus.headKeeperMenu((HeadKeeper)loggedAs);
                    }
                    catch (ClassCastException cce){
                        // unauthorised access message
                        System.out.println("""
                                            You do not have the correct accreditation to access the selected application.
                                            Please select the Application related to your role.
                                            """);
                    }
                    break;
                case 2:
                    try {
                        // we cast the profile stored in the loggedAS variable as an Administrator
                        // if the types match, the Administrator menu will display
                        // else it means the user is a Keeper and can't access the menu
                        Menus.administratorMenu((Administrator)loggedAs);
                    }
                    catch (ClassCastException cce){
                        // unauthorised access message
                        System.out.println("""
                                            You do not have the correct accreditation to access the selected application.
                                            Please select the Application related to your role.
                                            """);
                    }
                    break;
                default:
                    // looping until choice 1-2 is selected. the choice 3 in the Menus.mainMenu will use System.exit(0)
                    // to exit the application
                    break;
            }
        }
        while(true);
    }
}
