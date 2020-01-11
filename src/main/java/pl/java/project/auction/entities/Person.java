package pl.java.project.auction.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    protected Person() {
    }

    public Person(String name, String fullName) {
        this.name = name;
        this.fullName = fullName;
    }

    @Column(name = "imię")
    private String name;
    @Column(name = "imię_nazwisko")
    private String fullName;
    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name = "persons_addresses",
            foreignKey = @ForeignKey(name = "FK_persons_id"), joinColumns = @JoinColumn(name = "person_id"))
    private List<Address> address = new ArrayList<>();

    @OneToMany(mappedBy = "item", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Bid> bids = new ArrayList<>();


    public String getName() {
        return name;
    }


    public String getFullName() {
        return fullName;
    }

    public Long getId() {
        return id;
    }

    public List<Address> getAddress() {
        return address;
    }

    public List<Bid> getBids() {
        return bids;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;
        Person person = (Person) o;
        return id.equals(person.id) &&
                name.equals(person.name) &&
                fullName.equals(person.fullName) &&
                address.equals(person.address) &&
                bids.equals(person.bids);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, fullName, address, bids);
    }
}
