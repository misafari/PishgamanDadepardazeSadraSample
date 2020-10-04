package ir.safari.show.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Setter
@Getter
public class Score extends AbstractJpaPersistable<Long> {
    private Integer score;
    private LocalDate saveTime;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Performance performance;

    @OneToOne(optional = false)
    private User mentor;

    @PrePersist
    public void prePersist() {
        setSaveTime(LocalDate.now());
    }
}
