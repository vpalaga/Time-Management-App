package org.acme.dataEntities;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;
import java.time.LocalDateTime;

import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import java.time.temporal.ChronoUnit;

@Entity
public class Period extends PanacheEntity{
    @ManyToOne
    public Hobby hobby;

    public LocalDateTime start_time;
    public LocalDateTime end_time;

    public boolean running = true;

    public Long durationMinutes;

    // when end and start times are set, calculate the duration
    @PrePersist
    public void onCreate() {
        if (running) {
            start_time = LocalDateTime.now().truncatedTo(ChronoUnit.MINUTES);
        }
    }

    @PreUpdate
    public void onUpdate() {
        // first insert
        if (!running && end_time == null) {
            end_time = LocalDateTime.now().truncatedTo(ChronoUnit.MINUTES);
        }
        // time values have changed, need to update the duration
        if (start_time != null && end_time != null) {
            durationMinutes = ChronoUnit.MINUTES.between(start_time, end_time);
        }
    }
}
