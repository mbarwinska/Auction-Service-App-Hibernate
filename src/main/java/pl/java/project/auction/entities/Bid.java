package pl.java.project.auction.entities;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "OFERTY")
public class Bid {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private BigDecimal value;
    @ManyToOne
    @JoinColumn(name = "przedmiot", foreignKey = @ForeignKey(name = "FK_bid_item"))
    private Item item;
    @ManyToOne
    @JoinColumn(name = "osoba", foreignKey = @ForeignKey(name = "FK_bid_person"))
    private Person person;
    @CreationTimestamp
    @Column(name = "czas_utworzenia")
    private LocalDateTime creationTime;

    protected Bid() {
    }

    public Bid(BigDecimal value, Item item, Person person) {
        this.value = value;
        this.item = item;
        this.person = person;
    }

    public Bid(BigDecimal value) {
        this.value = value;
    }


    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public Long getId() {
        return id;
    }

    public Item getItem() {
        return item;
    }

    public Person getPerson() {
        return person;
    }

    public LocalDateTime getCreationTime() {
        return creationTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Bid)) return false;
        Bid bid = (Bid) o;
        return id.equals(bid.id) &&
                value.equals(bid.value) &&
                item.equals(bid.item) &&
                person.equals(bid.person) &&
                creationTime.equals(bid.creationTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, value, item, person, creationTime);
    }
}
