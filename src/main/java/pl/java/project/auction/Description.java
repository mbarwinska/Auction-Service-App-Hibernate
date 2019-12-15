package pl.java.project.auction;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Description {
    @Id
    private Long id;
    private String Content;

    protected Description() {
    }

    public Description(String content) {
        Content = content;
    }

    public Long getId() {
        return id;
    }

    public String getContent() {
        return Content;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Description)) return false;
        Description that = (Description) o;
        return id.equals(that.id) &&
                Content.equals(that.Content);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, Content);
    }

    @Override
    public String toString() {
        return "Description{" +
                "id=" + id +
                ", Content='" + Content + '\'' +
                '}';
    }
}
