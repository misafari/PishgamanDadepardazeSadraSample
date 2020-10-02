package ir.safari.show.entity;


import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Entity
@Table(indexes = {@Index(name="User-Username-Index", columnList = "username", unique = true)})
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User extends AbstractJpaPersistable<Long> implements UserDetails {
    @Column(updatable = false, length = 20, nullable = false, unique = true)
    private String username;
    private String password;
    private boolean disable;
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = false)
    private Person person;
    @ElementCollection(fetch = FetchType.EAGER)
    private List<String> roles;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if (this.roles != null)
            return roles.stream().map(SimpleGrantedAuthority::new).collect(Collectors.toList());
        else
            return Collections.singletonList(new SimpleGrantedAuthority("ROLE_USER"));
    }

    public List<String> getAuthoritiesAsString() {
        return getAuthorities().stream().map(Objects::toString).collect(Collectors.toList());
    }

    @Override
    @Transient
    public boolean isAccountNonExpired() {
        return !disable;
    }

    @Override
    @Transient
    public boolean isAccountNonLocked() {
        return !disable;
    }

    @Override
    @Transient
    public boolean isCredentialsNonExpired() {
        return !disable;
    }

    @Override
    @Transient
    public boolean isEnabled() {
        return !disable;
    }
}