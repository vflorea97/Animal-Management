package ro.mycode.animalmanagement.exceptii;

public class ExceptieAnimalNeexistent extends Exception{

    public ExceptieAnimalNeexistent() {
        super("Animalul nu exista in baza de date");
    }
}
