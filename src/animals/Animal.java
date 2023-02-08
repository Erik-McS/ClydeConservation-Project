package animals;

import clydeconservationsystem.Menus;
import clydeconservationsystem.ValidationException;

import java.io.Serializable;

/**
 * This the parent class of the animals handled by Clyde Conservation.
 * <p>
 * It will handle the getters and the setters for the child classes.
 * <p>
 * This generic class will also be used as a type to store the different types of animals
 * in care of Clyde Conservation.
 * <p>
 * This class implement the Serializable Interface so the objects can be saved in a file using an IOStream
 * @author Erik
 */
public abstract class Animal implements Serializable {
    // class for the animals
    private String name;
    private String category;
    private String dateOfBirth;
    private String dateOfAcquisition;
    private String sex;
    private boolean isCaged;
    /**
     * This variable is used to generate unique animal IDs
     */
    public static int ANIMAL_ID_BASE =200;
    protected int animalID;

    /**
     * Method to return the animal ID
     * @return The animal ID
     */
    public int getAnimalID(){return animalID;}
    /**
     * this method is a custom equivalent of the toString() method.
     * <p>
     * it will need to be implemented by the children classes.
     * @return Returns the full description of the animal.
     */
    public abstract String getDetails();

    /**
     * Method to get the animal's name
     * @return Animal's Name
     */
    public String getName() {
        return name;
    }

    /**
     * Method to set the animal's name by passing its value.
     * <p>
     * This method should be used when creating an object from a file.
     * <p>
     * It will not validate the data by itself
     * @param name Name of the animal
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * This set method will get a user choice by calling the corresponding menu from the Menus class.
     * <p>
     * @see Menus#setAnimalName()
     */
    public void setName(){
        do {
            this.name=Menus.setAnimalName();
        }
        while (this.name==null);
    }

    /**
     * Method to get the animal's Date of Birth.
     * @return Animal's Date of Birth
     */
    public String getDateOfBirth() {
        return dateOfBirth;
    }
    /**
     * Method to set the animal's Date of Birth by passing its value.
     * <p>
     * This method should be used when creating an object from a file.
     * <p>
     * It will not validate the data by itself
     * @param dateOfBirth DoB of the animal
     */
    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    /**
     * This set method will get a user choice by calling the corresponding menu from the Menus class.
     * <p>
     * @see Menus#setAnimalDoB()
     */
    public void setDateOfBirth(){
        do {
            this.dateOfBirth=Menus.setAnimalDoB();
        }while (this.dateOfBirth==null);
    }

    /**
     * Method to get the animal's Date of Acquisition
     * @return Animal's Date of Acquisition
     */
    public String getDateOfAcquisition() {
        return dateOfAcquisition;
    }

    /**
     * Method to set the animal's Date of Acquisition by passing its value.
     * <p>
     * This method should be used when creating an object from a file.
     * <p>
     * It will not validate the data by itself
     * @param dateOfAcquisition DoA of the animal
     */
    public void setDateOfAcquisition(String dateOfAcquisition) {
        this.dateOfAcquisition = dateOfAcquisition;
    }

    /**
     * This set method will get a user choice by calling the corresponding menu from the Menus class.
     * <p>
     * @see Menus#setAnimalDoA()
     */
    public void setDateOfAcquisition(){
        do {
            this.dateOfAcquisition=Menus.setAnimalDoA();
        }while (this.dateOfAcquisition==null);
    }

    /**
     * Method to get the animal's sex.
     * @return Animal's sex: 'Male' or 'Female'
     */
    public String getSex() {
        return sex;
    }

    /**
     * This set method will get a user choice by calling the corresponding menu from the Menus class.
     * <p>
     * @see Menus#setAnimalSex()
     */
    public void setSex() {
        do {
            this.sex=Menus.setAnimalSex();
        }
        while(this.sex==null);
    }

    /**
     * Method to set the animal's sex by passing its value.
     * <p>
     * This method should be used when creating an object from a file.
     * <p>
     * It will validate the data passed to it
     * @param sex Sex of the animal
     */
    public void setSex(String sex) throws ValidationException{
        if (sex.equals("Male")||sex.equals("Female"))
            this.sex=sex;
        else throw new ValidationException("Invalid value for sex");
    }

    /**
     * Method to get the animal's category.
     * @return Animal's category: 'Predator' or 'Prey'
     */
    public String getCategory() {
        return category;
    }

    /**
     * This set method will get a user choice by calling the corresponding menu from the Menus class.
     * <p>
     * @see Menus#setAnimalCategory()
     */
    public void setCategory(){
        do {
            this.category= Menus.setAnimalCategory();
        }
        while (this.category==null);
    }

    /**
     * Method to set the animal's category by passing its value.
     * <p>
     * This method should be used when creating an object from a file.
     * <p>
     * It will validate the data passed to it
     * @param category Sex of the animal
     */
    public void setCategory(String category) throws ValidationException{
        if (category.equals("Predator")||category.equals("Prey"))
            this.category=category;
        else throw new ValidationException("Invalid Category Value");
    }

    /**
     * Method to indicate if the animal is assigned to a cage or not.
     * @return True or False
     */
    public boolean isCaged() {
        return isCaged;
    }

    /**
     * Set the attribute indicating if an animal is assigned to a cage or not
     * @param caged True or False
     */
    public void setCaged(boolean caged) {
        isCaged = caged;
    }

    // End of Class
}
