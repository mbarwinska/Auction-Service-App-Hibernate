package pl.java.project.bookstore;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "CUSTOMERS",
uniqueConstraints = @UniqueConstraint(name = "CUSTOMER_LOGIN_UNIQE", columnNames = {"LOGIN"}))
public class Customer {

    public Customer(String login, String password, String lastName, String firstName, Address address) {
        this.login = login;
        this.password = password;
        this.lastName = lastName;
        this.firstName = firstName;
        this.address = address;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "LOGIN", nullable = false)
    private String login;

    @Column(name = "PASSWORD")
    private String password;

    @Column(name = "LAST_NAME")
    private String lastName;

    @Column(name = "FIRST_NAME")
    private String firstName;

    private Address address;

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public Address getAddress() {
        return address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return login.equals(customer.login);
    }

    @Override
    public int hashCode() {
        return Objects.hash(login);
    }
}
