package applicationEntry;

import animals.Menagerie;
import animals.Bird;
import clydeconservationsystem.AllocationsCollection;
import clydeconservationsystem.CagesCollection;
import employees.AssistantKeeper;
import employees.EmployeeRoster;
import employees.HeadKeeper;

/**
 * Test class, used in some unit testing
 */
public class TestClass {
    public static void main(String[] args) {


            //HeadKeeper erik= new HeadKeeper.HdKBuilder().setName("Erik").setLastName("Mcsev").HBuilder();
              //System.out.println(erik.getDetails());
            //HeadKeeper stan=new HeadKeeper.HdKBuilder().setName("Stan").setLastName("Nagui").setAddress("123 College av")
                    //.setContactNumber("1234567890").HBuilder();
            //System.out.println(stan.getDetails());
           // Administrator mike=new Administrator("Mike","Smith","22222222","avenue");
        //AssistantKeeper assistantKeeper=new AssistantKeeper("John","Smith","07745362711","3 Glasgow av");
        //EmployeeRoster.addEmployee(assistantKeeper);

            //String s=erik.getClass().getName();
            //System.out.println(s);
    SystemInitialisation.initialiseData();

        // Menagerie.displayAllAnimals();
        // EmployeeRoster.displayEmployees();
         //EmployeeRoster.displayKeepers();
        //AllocationsCollection.displayAssignments();
        //CagesCollection.displayAllCages();
        //AllocationsCollection.addAssignment(assistantKeeper);
       // AllocationsCollection.displayAssignments();
        Menagerie.displayUnassignedAnimals();
    }
}
