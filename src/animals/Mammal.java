package animals;

public class Mammal extends Animal{
    // class for the Mammal type
    // unique ID for the animal
    private int animalID;
    // the default constructor will use the setters implemented in the parent class
    // those setters use the Menus class to get users input
    public Mammal(){
        setName();
        setCategory();
        setSex();
        setDateOfBirth();
        setDateOfAcquisition();
        // using the static variable from the parent class to produce a unique ID
        this.animalID= ANIMAL_ID_BASE++;

    }
    // constructor for internal use if implement files
    public Mammal(String name,String category,String sex,String doB,String doA){
        try {
            setName(name);
            setCategory(category);
            setSex(sex);
            setDateOfAcquisition(doA);
            setDateOfBirth(doB);
            this.animalID= ANIMAL_ID_BASE++;
        }
        catch (AnimalValidation ex){
            System.out.println(ex.getMessage());
        }
    }
    // getter for the ID
    public int getAnimalID() {
        return animalID;
    }
    // custom toString()
    @Override
    public String getDetails() {
        return "\nType: Bird"+
                "\nName: "+getName()+
                "\nCategory: "+getCategory()+
                "\nSex: "+getSex()+
                "\nDate of Birth: "+getDateOfBirth()+
                "\nDate of Acquisition: "+getDateOfAcquisition()+
                "\nAnimal ID: "+getAnimalID();
    }
}
