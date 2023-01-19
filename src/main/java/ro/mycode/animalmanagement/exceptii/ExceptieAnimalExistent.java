package ro.mycode.animalmanagement.exceptii;

public class ExceptieAnimalExistent extends Exception{

    public ExceptieAnimalExistent() {
        super("Animalul exista in baza de date");
    }
}
