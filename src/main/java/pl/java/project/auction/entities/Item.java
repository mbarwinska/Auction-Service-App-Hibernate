package pl.java.project.auction.entities;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "PRZEDMIOTY")
public class Item {


    protected Item() {
    }

    public Item(Description description, BigDecimal initPrice) {
        this.description = description;
        this.initPrice = initPrice;
    }

    public Item(Category category, Description description, BigDecimal initPrice) {
        this.category = category;
        this.description = description;
        this.initPrice = initPrice;
    }


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "item_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "category", foreignKey = @ForeignKey(name = "FK_item_category_id"))
    private Category category;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "description_id", foreignKey = @ForeignKey(name = "FK_item_description_id"))
    private Description description;
    @Column(name = "cena_początkowa")
    private BigDecimal initPrice;
    @OneToMany(mappedBy = "item", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Bid> bids = new ArrayList<>();


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Description getDescription() {
        return description;
    }


    public BigDecimal getInitPrice() {
        return initPrice;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Category getCategory() {
        return category;
    }

    public List<Bid> getBids() {
        return bids;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Item)) return false;
        Item item = (Item) o;
        return id.equals(item.id) &&
                category.equals(item.category) &&
                description.equals(item.description) &&
                initPrice.equals(item.initPrice) &&
                bids.equals(item.bids);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, category, description, initPrice, bids);
    }
}

