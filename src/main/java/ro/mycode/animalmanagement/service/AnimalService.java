package ro.mycode.animalmanagement.service;

import org.springframework.stereotype.Service;
import ro.mycode.animalmanagement.exceptii.ExceptieAnimalExistent;
import ro.mycode.animalmanagement.model.Animal;
import ro.mycode.animalmanagement.repository.AnimalRepository;

import java.util.List;
import java.util.Optional;

@Service
public class AnimalService {

    private AnimalRepository animalRepository;

    public AnimalService(AnimalRepository animalRepository) {
        this.animalRepository = animalRepository;
    }


    public void afisare(){
        List<Animal> animals = animalRepository.findAll();
        animals.forEach(a-> System.out.println(a));
    }

    public List<Animal> getAllAnimale(){
        return animalRepository.findAll();
    }


    public List<Animal> getAnimaleOrdonateSpecie(){
        return  animalRepository.getAnimaleOrdonateSpecie().get();
    }

    public  List<Animal> getCelMaiRapidAnimal(){
        return animalRepository.getCelMaiRapidAnimal().get();
    }

    public List<Animal> getCuloareAnimale(String culore){
        return animalRepository.getCuloareAnimale(culore).get();
    }


    public void add(Animal animal) throws ExceptieAnimalExistent {
        Optional<Animal> a = animalRepository.findBySpecie(animal.getSpecie());
        if(a.equals(Optional.empty())){
            animalRepository.save(animal);
        }else{
            throw  new ExceptieAnimalExistent();
        }
    }
}