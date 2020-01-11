package pl.java.project.auction.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "OPIS")
public class Description {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "zawartość")
    private String content;

    protected Description() {
    }

    public Description(String content) {
        this.content = content;
    }

    public Long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Description)) return false;
        Description that = (Description) o;
        return id.equals(that.id) &&
                content.equals(that.content);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, content);
    }

    @Override
    public String toString() {
        return "Description{" +
                "id=" + id +
                ", Content='" + content + '\'' +
                '}';
    }
}

