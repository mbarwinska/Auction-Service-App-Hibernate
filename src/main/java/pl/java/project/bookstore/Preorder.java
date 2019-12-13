package pl.java.project.bookstore;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "PREORDERS")
public class Preorder {

    Preorder() {}

    public Preorder(Book orderedBook) {
        this.orderedBook = orderedBook;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "CREATED", nullable = false)
    @CreationTimestamp
    private LocalDateTime created;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "BOOK_ID", nullable = false)
    private Book orderedBook;

    public LocalDateTime getCreated() {
        return created;
    }

    public Book getOrderedBook() {
        return orderedBook;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Preorder preOrder = (Preorder) o;
        return created.equals(preOrder.created) &&
                orderedBook.equals(preOrder.orderedBook);
    }

    @Override
    public int hashCode() {
        return Objects.hash(created, orderedBook);
    }
}
