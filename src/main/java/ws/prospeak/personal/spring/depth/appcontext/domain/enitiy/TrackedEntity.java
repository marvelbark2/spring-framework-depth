package ws.prospeak.personal.spring.depth.appcontext.domain.enitiy;

import java.io.Serializable;
import java.time.LocalDateTime;

public class TrackedEntity<T extends Serializable> extends BaseEntity<T> {
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;


    @Override
    public T getId() {
        return id;
    }

    @Override
    public void setId(T id) {
        this.id = id;
    }

    public void beforePersist() {
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    public void beforeUpdate() {
        this.updatedAt = LocalDateTime.now();
    }

    public void deleteIt() {
        this.deletedAt = LocalDateTime.now();
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public LocalDateTime getDeletedAt() {
        return deletedAt;
    }
    public boolean isDeleted() {
        return this.getDeletedAt() != null;
    }
}
