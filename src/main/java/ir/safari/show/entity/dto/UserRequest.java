package ir.safari.show.entity.dto;

import ir.safari.show.utils.UserRole;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.List;

@Setter
@Getter
public class UserRequest {
    @NotBlank
    private String username;
    @NotBlank
    private String password;
    @NotBlank
    private String name;
    @NotBlank
    private String surname;
    @NotBlank
    @Pattern(regexp = "(09)[0-9]{9}$")
    private String mobile;
    @NotBlank
    private String nationalCode;
    @NotNull
    private List<UserRole> roleList;
}
