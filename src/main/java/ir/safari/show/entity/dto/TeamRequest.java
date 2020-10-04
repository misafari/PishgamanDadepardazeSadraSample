package ir.safari.show.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class TeamRequest {
    @NotBlank
    private String name;
    @NotNull
    private List<Long> candidates;
    @NotNull
    private Long mentor;
}
