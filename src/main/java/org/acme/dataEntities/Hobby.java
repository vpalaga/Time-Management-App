package org.acme.dataEntities;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;
import java.time.LocalDateTime;


@Entity
public class Hobby extends PanacheEntity {
    public String title;
    public String description;

    public String color;

    public LocalDateTime created_at;
}
