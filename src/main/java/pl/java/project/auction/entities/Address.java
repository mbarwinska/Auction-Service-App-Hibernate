package pl.java.project.auction.entities;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.util.Objects;

@Embeddable
public class Address {
    @Column(name = "street")
    private String street;
    @Column(name = "city")
    private String city;
    @Column(name = "zip_code")
    private String zipCode;
    @Enumerated(EnumType.STRING)
    @Column(name = "adress_type")
    private AdressType type;

    protected Address() {
    }

    public Address(String street, String city, String zipCode, AdressType type) {
        this.street = street;
        this.city = city;
        this.zipCode = zipCode;
        this.type = type;
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

    public AdressType getType() {
        return type;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Address)) return false;
        Address address = (Address) o;
        return street.equals(address.street) &&
                city.equals(address.city) &&
                zipCode.equals(address.zipCode) &&
                type == address.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(street, city, zipCode, type);
    }
}
