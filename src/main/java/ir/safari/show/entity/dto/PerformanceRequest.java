package ir.safari.show.entity.dto;

import lombok.Getter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

@Getter
public class PerformanceRequest {
    @NotBlank
    private String songName;
    @NotNull
    private LocalDate performanceDate;

    @NotNull
    private List<ScoreRequest> scores;
}
