package ir.safari.show.config.security.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Setter
@Getter
public class AuthenticationRequest {
    @NotBlank
    private String username;
    @NotBlank
    private String password;
}
