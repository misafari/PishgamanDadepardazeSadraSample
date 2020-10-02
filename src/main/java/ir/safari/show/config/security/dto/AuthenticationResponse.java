package ir.safari.show.config.security.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class AuthenticationResponse {
    private final String token;
    private final String username;
    private final List<String> roles;
    private final List<String> groups;
}