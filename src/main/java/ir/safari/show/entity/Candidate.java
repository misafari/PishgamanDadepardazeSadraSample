package ir.safari.show.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Setter
@Getter
public class Candidate extends AbstractJpaPersistable {
    private String name;
    private String surname;
    @Column(unique = true)
    private String nationalCode;

    @ManyToOne
    private Team team;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "candidate")
    @JsonBackReference
    private List<Performance> performances;
}
