package ir.safari.show.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Team extends AbstractJpaPersistable<Long> {
    private String name;
    private LocalDate createDate;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name="TEAM_ID")
    private List<Candidate> candidates;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private User mentor;

    public Team(String name, List<Candidate> candidates, User mentor) {
        this.name = name;
        this.candidates = candidates;
        this.mentor = mentor;
    }

    @PrePersist
    public void prePersist() {
        setCreateDate(LocalDate.now());
    }
}
