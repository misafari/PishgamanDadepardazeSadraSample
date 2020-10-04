package ir.safari.show.entity.dto;

import lombok.Getter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
public class PerformanceRequest {
    @NotBlank
    private String songName;
    @NotNull
    private Long candidateId;

    @NotNull
    private List<ScoreRequest> scores;
}
