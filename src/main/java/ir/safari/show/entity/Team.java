package ir.safari.show.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Team extends AbstractJpaPersistable<Long> {
    private String name;
    private LocalDate createDate;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "team")
    private List<Candidate> candidates;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "team")
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
