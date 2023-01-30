import java.util.Scanner;

public class Menus {
    private static Scanner sc=new Scanner(System.in);
    private static int choice;
    private static boolean exit=false;

    public static void roleSelection(){


    }
    public static void mainMenu(Employee employee){
        System.out.println("menu");
        do {
            System.out.println("\n----- Welcome to Clyde Conservation System -----"+
                    "\n\nPlease select an option"+
                    "\n1) Enter as Head Keeper"+
                    "\n2) Enter as Administrator"+
                    "\n3) Exit"+
                    "\n--> ");
            choice=sc.nextInt();
            switch (choice){

                case 1:
                    try {
                        headKeeperMenu((HeadKeeper) employee);
                    }
                    catch (ClassCastException e){
                        System.out.println("Wrong profile for this option");
                    }
                    break;
                case 2:
                    try {
                     administratorMenu((Administrator) employee);
                    }
                    catch (ClassCastException e){
                        System.out.println("Wrong profile for this option");
                    }
                    break;
                case 3:
                    exit=true;
                    break;
            }
        }while(!exit);
    }

    private static void headKeeperMenu(HeadKeeper headKeeper){
        System.out.println(headKeeper.getDetails());
    }

    private static void administratorMenu(Administrator admin){
        System.out.println(admin.getDetails());
    }
}
