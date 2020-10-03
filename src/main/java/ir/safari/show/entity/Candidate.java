package ir.safari.show.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Setter
@Getter
@Table(indexes = {@Index(name="Candidate-NationalCode-Index", columnList = "nationalCode", unique = true)})
public class Candidate extends AbstractJpaPersistable<Long> {
    private String name;
    private String surname;
    private String nationalCode;

    @ManyToOne
    private Team team;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "candidate")
    private List<Performance> performances;
}
