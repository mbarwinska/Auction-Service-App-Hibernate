package pl.java.project.auction.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
public class Description {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String Content;
    private BigDecimal initPrice;

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

