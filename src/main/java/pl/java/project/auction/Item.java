package pl.java.project.auction;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "ITEMS")
public class Item {


    protected Item() {
    }

    public Item(String description, BigDecimal initPrice) {
        this.description = description;
        this.initPrice = initPrice;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "item_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "category_id", foreignKey = @ForeignKey(name = "FK_item_category_id"))
    private Category category;

    private String description;

    private BigDecimal initPrice;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getInitPrice() {
        return initPrice;
    }

    public void setInitPrice(BigDecimal initPrice) {
        this.initPrice = initPrice;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Category getCategory() {
        return category;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Item)) return false;
        Item item = (Item) o;
        return Objects.equals(id, item.id) &&
                Objects.equals(description, item.description) &&
                Objects.equals(initPrice, item.initPrice);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, description, initPrice);
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", initPrice=" + initPrice +
                '}';
    }
}
