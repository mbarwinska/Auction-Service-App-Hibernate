package pl.java.project.auction;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
public class Bid {

    public Bid() {
    }

    public Bid(Person person, BigDecimal value) {
        this.person = person;
        this.value = value;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Person person;
    private BigDecimal value;


    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Bid)) return false;
        Bid bid = (Bid) o;
        return Objects.equals(id, bid.id) &&
                Objects.equals(person, bid.person) &&
                Objects.equals(value, bid.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, person, value);
    }

    @Override
    public String toString() {
        return "Bid{" +
                "id=" + id +
                ", person=" + person +
                ", value=" + value +
                '}';
    }
}
