public class ClydeConservationDriver {

    public static void main(String[] args) {

        boolean exit=false;

         Employee loggedAs=Menus.logAsMenu();

        do {
            switch (Menus.mainMenu()){

                case 1:
                    try {
                        Menus.headKeeperMenu((HeadKeeper)loggedAs);
                    }
                    catch (ClassCastException cce){
                        System.out.println("""
                You do not have the correct accreditation to access the selected application.
                Please select the Application related to your role.
                """);
                    }
                    break;
                case 2:
                    try {
                        Menus.administratorMenu((Administrator)loggedAs);
                    }
                    catch (ClassCastException cce){
                        System.out.println("""
                You do not have the correct accreditation to access the selected application.
                Please select the Application related to your role.
                """);
                    }
                    break;
                default:
                    exit=false;
                    break;

            }

        }
        while(!exit);

    }
}
