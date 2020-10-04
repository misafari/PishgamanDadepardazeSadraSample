package ir.safari.show.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
public class TeamResponse {
    private String name;
    private LocalDate createDate;
}
