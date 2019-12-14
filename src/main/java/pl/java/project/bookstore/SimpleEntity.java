package pl.java.project.bookstore;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class SimpleEntity {


    protected SimpleEntity() {
    }


    public SimpleEntity(Long id, String value) {
        this.id = id;
        this.value = value;
    }

    @Id
    private Long id;

    private String value;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SimpleEntity)) return false;
        SimpleEntity that = (SimpleEntity) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
