package animals;

/**
 * Class used to describe birds
 * <p>
 * it will be used as it own type, further developments could add children types to it
 */
public class Bird extends Animal {
    // unique ID for the animal
    private int animalID;

    /**
     * The default constructor will use the setters implemented in the parent class
     * <p>
     * Those setters use the Menus class to get users input
     */
    public Bird() {
        setName();
        setCategory();
        setSex();
        setDateOfBirth();
        setDateOfAcquisition();
        // using the static variable from the parent class to produce a unique ID
        this.animalID= ANIMAL_ID_BASE++;
        // the Animal is not assigned to a cage by default
        setCaged(false);
    }

    /**
     * Constructor to use for creating Birds object from a file
     * <p>
     * may or may not be implemented at this stage
     * @param name Name of the bird
     * @param category Category of the bird
     * @param sex Sex of the bird
     * @param doB Date of Birth of the bird
     * @param doA Date of Acquisition of the bird
     */
    public Bird(String name,String category,String sex,String doB,String doA){
        try {
            setName(name);
            setCategory(category);
            setSex(sex);
            setDateOfAcquisition(doA);
            setDateOfBirth(doB);
            this.animalID= ANIMAL_ID_BASE++;
            // the Animal is not assigned to a cage by default
            setCaged(false);
        }
        catch (AnimalValidation ex){
            System.out.println(ex.getMessage());
        }
    }

    /**
     * Getter method to get the Bird's animal ID
     * @return Animal ID
     */
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
