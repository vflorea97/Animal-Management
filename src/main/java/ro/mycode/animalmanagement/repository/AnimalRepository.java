package ro.mycode.animalmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ro.mycode.animalmanagement.model.Animal;

import java.util.List;
import java.util.Optional;

@Repository
public interface AnimalRepository extends JpaRepository<Animal,Long> {

    @Query("select a from Animal a order by a.specie")
    Optional<List<Animal>> getAnimaleOrdonateSpecie();

    @Query("select a from Animal a order by a.viteza desc")
    Optional<List<Animal>> getCelMaiRapidAnimal();

    @Query("select a from Animal a where a.culoare = ?1")
    Optional<List<Animal>> getCuloareAnimale(String culore);

    Optional<Animal> findBySpecie(String specie);

}
