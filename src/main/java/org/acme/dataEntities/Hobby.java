package org.acme.dataEntities;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.PrePersist;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@Entity
public class Hobby extends PanacheEntity {
    public String title;
    public String description;
    public String color;
    public LocalDateTime created_at;

    @PrePersist
    public void onCreate() {
        created_at = LocalDateTime.now().truncatedTo(ChronoUnit.MINUTES);
    }
}