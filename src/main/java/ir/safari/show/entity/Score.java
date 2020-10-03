package ir.safari.show.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import java.time.LocalDate;

@Entity
@Setter
@Getter
public class Score extends AbstractJpaPersistable<Long> {
    private Integer score;
    private LocalDate saveTime;


    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Performance performance;
}
