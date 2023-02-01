package animals;

public class AnimalValidation extends Exception{

    public AnimalValidation(String message){
        super("\n"+message);
    }
}
