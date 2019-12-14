package pl.java.project.auction;

import javax.persistence.Embeddable;
import java.util.Objects;

@Embeddable
public class Person {

    public Person(String name, String fullName) {
        this.name = name;
        this.fullName = fullName;
    }

    private String name;
    private String fullName;
//    private List<Address> address;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;
        Person person = (Person) o;
        return Objects.equals(name, person.name) &&
                Objects.equals(fullName, person.fullName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, fullName);
    }
}
