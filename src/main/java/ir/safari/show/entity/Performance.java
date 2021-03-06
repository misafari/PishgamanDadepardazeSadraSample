package ir.safari.show.entity;

import ir.safari.show.entity.dto.PerformanceRequest;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Setter
@Getter
@NoArgsConstructor
public class Performance extends AbstractJpaPersistable {
    private String songName;
    private Double averageScore;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Candidate candidate;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "PERFORMANCE_ID")
    private List<Score> scores;

    public Performance(PerformanceRequest performanceRequest) {
        this.songName = performanceRequest.getSongName();
    }
}
