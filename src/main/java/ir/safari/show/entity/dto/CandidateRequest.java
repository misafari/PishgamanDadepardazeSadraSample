package ir.safari.show.entity.dto;

import ir.safari.show.entity.Candidate;
import lombok.Getter;
import javax.validation.constraints.NotBlank;

@Getter
public class CandidateRequest {
    @NotBlank
    private String name;
    @NotBlank
    private String surname;
    @NotBlank
    private String nationalCode;

    public Candidate map() {
        Candidate candidate = new Candidate();

        candidate.setName(this.name);
        candidate.setSurname(this.surname);
        candidate.setNationalCode(this.nationalCode);

        return candidate;
    }
}
