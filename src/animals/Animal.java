package animals;

import clydeconservationsystem.Menus;

public abstract class Animal {
    // class for the animals
    private String name;
    private String category;
    private String dateOfBirth;
    private String dateOfAcquisition;
    private String sex;
    public static int ANIMAL_ID_BASE =200;

    public abstract String getDetails();
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setName(){
        this.name=Menus.setAnimalName();
    }
    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setDateOfBirth(){
        this.dateOfBirth=Menus.setAnimalDoB();
    }
    public String getDateOfAcquisition() {
        return dateOfAcquisition;
    }

    public void setDateOfAcquisition(String dateOfAcquisition) {
        this.dateOfAcquisition = dateOfAcquisition;
    }
    public void setDateOfAcquisition(){
        this.dateOfAcquisition=Menus.setAnimalDoA();
    }

    public String getSex() {
        return sex;
    }

    public void setSex() {
        do {
            this.sex=Menus.setAnimalSex();
        }
        while(this.sex==null);
    }
    public void setSex(String sex) throws AnimalValidation{
        if (sex.equals("Male")||sex.equals("Female"))
            this.sex=sex;
        else throw new AnimalValidation("Invalid value for sex");
    }
    public String getCategory() {
        return category;
    }
    public void setCategory(){
        do {
            this.category= Menus.setAnimalCategory();
        }
        while (this.category==null);
    }
    public void setCategory(String category) throws AnimalValidation{
        if (category.equals("Predator")||category.equals("Prey"))
            this.category=category;
        else throw new AnimalValidation("Invalid Category Value");
    }


}
