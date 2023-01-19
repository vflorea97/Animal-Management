package ro.mycode.animalmanagement.view;

import org.springframework.stereotype.Component;
import ro.mycode.animalmanagement.exceptii.ExceptieAnimalExistent;
import ro.mycode.animalmanagement.model.Animal;
import ro.mycode.animalmanagement.repository.AnimalRepository;
import ro.mycode.animalmanagement.service.AnimalService;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

@Component
public class View {

    private AnimalService animalService;
    private Scanner scanner;
    private final AnimalRepository animalRepository;


    public View(AnimalRepository animalRepository, AnimalService animalService) {
        this.animalRepository = animalRepository;
        scanner = new Scanner(System.in);
        this.animalService = animalService;
    }

    public void meniu(){
        System.out.println("Apasa 1 pentru a afisa toate animalele");
        System.out.println("Apasa 2 pentru a afisa animalele ordonate dupa specie");
        System.out.println("Apasa 3 pentru a afisa cel mai rapid animal");
        System.out.println("Apasa 4 pentru a afisa doar animalele orange");
        System.out.println("Apasa 5 pentru a adauga un animal");
    }

    public void play(){
        boolean run = true;
        meniu();
        while (run){
            int buton = Integer.parseInt(scanner.nextLine());
            switch (buton){
                case 1:
                    animalService.afisare();
                    break;
                case 2:
                    getAnimaleOrdonateSpecie();
                    break;
                case 3:
                    getCelMaiRapidAnimal();
                    break;
                case 4:
                    getCuloareAnimale();
                    break;
                case 5:
                    addAnimal();
                    break;
                default:
                    run = false;
                    break;
            }
        }
    }
    public void getAnimaleOrdonateSpecie(){
        Optional<List<Animal>> animals = animalRepository.getAnimaleOrdonateSpecie();
        for (int i = 0; i < animals.get().size(); i++){
            System.out.println(animals.get().get(i));
        }
    }
    public void getCelMaiRapidAnimal(){
        Optional<List<Animal>> animals = animalRepository.getCelMaiRapidAnimal();
        for (int i = 0; i < animals.get().size(); i++){
            System.out.println(animals.get().get(i));
        }
    }
    public void getCuloareAnimale(){
        Optional<List<Animal>> animals = animalRepository.getCuloareAnimale("Orange");
        for (int i = 0; i < animals.get().size(); i++){
            System.out.println(animals.get().get(i));
        }
    }
    public void addAnimal(){
        System.out.println("Introdu nume:");
        String nume = scanner.nextLine();
        System.out.println("Introdu specia:");
        String specia = scanner.nextLine();
        System.out.println("Introdu viteza: ");
        int viteza = Integer.parseInt(scanner.nextLine());
        System.out.println("Introdu culoarea:");
        String culoare = scanner.nextLine();
        try{
            Animal animal = Animal.builder().nume(nume).specie(specia).viteza(viteza).culoare(culoare).build();
            animalService.add(animal);
            System.out.println("Ai adaugat un animal!!");
        }catch (ExceptieAnimalExistent a){
            System.err.println(a.getMessage());
        }
    }
}
