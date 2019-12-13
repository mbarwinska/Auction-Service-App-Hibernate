package pl.java.project.bookstore;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table( name="BOOKS",
uniqueConstraints =
    @UniqueConstraint(name = "ISSBN_Constraint", columnNames = {"ISSBN"}))
public class Book {

    Book() {}

    public Book(String title, String author, LocalDate publishDate, String publishedPlace, BigDecimal price, String issbn) {
        this.title = title;
        this.author = author;
        this.publishDate = publishDate;
        this.publishedPlace = publishedPlace;
        this.price = price;
        this.issbn = issbn;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "BOOK_ID")
    private Long id;

    @Column(name = "TITLE")
    private String title;

    @Column(name = "AUTHOR")
    private String author;

    @Column(name = "PUBLISHED")
    private LocalDate publishDate;

    @Column (name = "PUBLISHED_PLACE")
    private String publishedPlace;

    @Column (name = "PRICE")
    private BigDecimal price;

    @Column (name = "ISSBN")
    private String issbn;

    @ElementCollection
    @CollectionTable(
            name = "BOOK_COMMENTS",
            joinColumns = @JoinColumn(name = "BOOK_ID"),
            foreignKey = @ForeignKey(name = "FK_BOOK_COMMENT_BOOK_ISSBN")
    )
    private Set<Comment> comments = new HashSet<>();

    @OneToMany(mappedBy = "orderedBook", fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
    private Set<Preorder> preorders = new HashSet<>();


    public void addComment(String comment){
        comments.add(new Comment(comment));
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public LocalDate getPublishDate() {
        return publishDate;
    }

    public String getPublishedPlace() {
        return publishedPlace;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public String getIssbn() {
        return issbn;
    }

    public Set<Comment> getComments() {
        return comments;
    }

    public Set<Preorder> getPreorders() {
        return preorders;
    }

    public void addPreorder(Preorder preorder){
        preorders.add(preorder);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return issbn.equals(book.issbn);
    }

    @Override
    public int hashCode() {
        return Objects.hash(issbn);
    }
}
