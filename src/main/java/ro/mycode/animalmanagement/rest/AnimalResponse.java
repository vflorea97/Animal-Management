package ro.mycode.animalmanagement.rest;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ro.mycode.animalmanagement.model.Animal;
import ro.mycode.animalmanagement.service.AnimalService;

import java.util.List;

@RestController
@Slf4j
public class AnimalResponse {

    private AnimalService animalService;

    public AnimalResponse(AnimalService animalService){
        this.animalService = animalService;
    }

    @GetMapping("api/v1/anima/getAllAnimale")
    public ResponseEntity<List<Animal>> getAllAnimale(){
        log.info("REST request to get all Animale");
        List<Animal> animale = animalService.getAllAnimale();
        return new ResponseEntity<>(animale, HttpStatus.OK);
    }
    @GetMapping("api/v1/anima/getAnimaleOrdonateSpecie")
    public ResponseEntity<List<Animal>> getAnimaleOrdonateSpecie(){
        log.info("REST request to get all Animale order by specie");
        List<Animal> animale = animalService.getAnimaleOrdonateSpecie();
        return new ResponseEntity<>(animale, HttpStatus.OK);
    }
    @GetMapping("api/v1/anima/getCelMaiRapidAnimal")
    public ResponseEntity<List<Animal>> getCelMaiRapidAnimal(){
        log.info("REST request to get cel mai rapid animal");
        List<Animal> animale = animalService.getCelMaiRapidAnimal();
        return new ResponseEntity<>(animale, HttpStatus.OK);
    }
    @GetMapping("api/v1/anima/getCuloareAnimale")
    public ResponseEntity<List<Animal>> getCuloareAnimale(){
        log.info("REST request to get all Animale by culoare");
        List<Animal> animale = animalService.getCuloareAnimale("Orange");
        return new ResponseEntity<>(animale, HttpStatus.OK);
    }
    
}
