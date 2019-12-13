package pl.java.project.bookstore;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Lob;
import java.time.LocalDateTime;
import java.util.Objects;

@Embeddable
public class Comment {

    Comment() {
    }

    public Comment(String content) {
        this.content = content;
    }

    @CreationTimestamp
    @Column(name = "CREATION_TIME", nullable = false)
    private LocalDateTime creationTime;

    @Lob
    @Column(name = "CONTENT")
    private String content;

    public LocalDateTime getCreationTime() {
        return creationTime;
    }

    public String getContent() {
        return content;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Comment comment = (Comment) o;
        return creationTime.equals(comment.creationTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(creationTime);
    }
}
