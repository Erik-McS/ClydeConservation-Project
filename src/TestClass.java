public class TestClass {
    public static void main(String[] args) {

        try {

            HeadKeeper erik= new HeadKeeper.HdKBuilder().setName("Erik").setLastName("Mcsev").HBuilder();
            //System.out.println(erik.getDetails());
            HeadKeeper stan=new HeadKeeper.HdKBuilder().setName("Stan").setLastName("Nagui").setAddress("123 College av")
                    .setContactNumber("1234567890").HBuilder();
            //System.out.println(stan.getDetails());
            Administrator mike=new Administrator("Mike","Smith","22222222","avenue");



            Menus.mainMenu();



        }catch (ValidationException e){
            System.out.println(e.getMessage());
        }

    }
}
