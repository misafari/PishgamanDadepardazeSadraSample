package ir.safari.show.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Setter
@Getter
public class Performance extends AbstractJpaPersistable<Long> {
    private String songName;
    private LocalDate performanceDate;
    private Integer averageScore;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Candidate candidate;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "performance")
    private List<Score> scores;
}
