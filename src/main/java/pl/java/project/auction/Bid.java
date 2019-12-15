package pl.java.project.auction;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;

@Entity
public class Bid {

    public Bid() {
    }

//    public Bid(Person person, BigDecimal value) {
//        this.person = person;
//        this.value = value;
//    }


    public Bid(BigDecimal value) {
        this.value = value;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    //    private Person person;
    private BigDecimal value;


//    public Person getPerson() {
//        return person;
//    }

//    public void setPerson(Person person) {
//        this.person = person;
//    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }


}
