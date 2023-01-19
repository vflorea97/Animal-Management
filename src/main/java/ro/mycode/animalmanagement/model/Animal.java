package ro.mycode.animalmanagement.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

@Data
@AllArgsConstructor
@SuperBuilder
@NoArgsConstructor
@Entity(name="Animal")
@Table(name="animal")
public class Animal implements Comparable<Animal>{

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;
    private String nume;
    private String specie;
    private int viteza;
    private String culoare;


    @Override
    public int compareTo(Animal o) {
        if (this.specie.compareTo(o.specie) > 0){
            return 1;
        }
        else if(this.specie.compareTo(o.specie) < 0){
            return -1;
        }else {
            return 0;
        }
    }

    @Override
    public boolean equals(Object o){
        Animal a = (Animal) o;
        return this.specie.equals(a.specie);
    }
}