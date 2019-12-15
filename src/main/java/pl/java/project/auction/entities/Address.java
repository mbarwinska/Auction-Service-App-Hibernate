package pl.java.project.auction.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Address {
    @Id
    private Long Id;
    private String street;
    private String city;
    private String zipCode;
    private String type;

    protected Address() {
    }

    public Address(String street, String city, String zipCode, String type) {
        this.street = street;
        this.city = city;
        this.zipCode = zipCode;
        this.type = type;
    }

    public Long getId() {
        return Id;
    }

    public String getStreet() {
        return street;
    }

    public String getCity() {
        return city;
    }

    public String getZipCode() {
        return zipCode;
    }

    public String getType() {
        return type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Address)) return false;
        Address address = (Address) o;
        return zipCode == address.zipCode &&
                Id.equals(address.Id) &&
                street.equals(address.street) &&
                city.equals(address.city) &&
                type.equals(address.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Id, street, city, zipCode, type);
    }

    @Override
    public String toString() {
        return "Address{" +
                "Id=" + Id +
                ", street='" + street + '\'' +
                ", city='" + city + '\'' +
                ", zipCode=" + zipCode +
                ", type='" + type + '\'' +
                '}';
    }

}
