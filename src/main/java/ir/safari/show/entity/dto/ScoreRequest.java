package ir.safari.show.entity.dto;

import lombok.Getter;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Getter
public class ScoreRequest {
    @NotNull
    @Min(0)
    @Max(100)
    private Integer score;
    @NotNull
    private Long mentorId;
}
