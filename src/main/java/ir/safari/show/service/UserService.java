package ir.safari.show.service;


import ir.safari.show.config.annotation.TransactionalService;
import ir.safari.show.config.exception.EntityNotFoundException;
import ir.safari.show.config.exception.UniqueException;
import ir.safari.show.entity.Person;
import ir.safari.show.entity.User;
import ir.safari.show.entity.dto.UserRequest;
import ir.safari.show.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.transaction.annotation.Transactional;

@TransactionalService
@RequiredArgsConstructor
public class UserService implements UserDetailsService {
    private final UserRepository repository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public User findByUsername(String username) throws EntityNotFoundException {
        return repository.findFirstByUsername(username)
                .orElseThrow(() -> new EntityNotFoundException("User Not Found"));
    }

    @Transactional
    public void save(UserRequest userRequest) throws UniqueException {
        if (repository.existsByUsername(userRequest.getUsername()))
            throw new UniqueException("User is Exists");

        Person person = Person.createInstance(userRequest);


        repository.save(User.builder()
                .username(userRequest.getUsername())
                .password(bCryptPasswordEncoder.encode(userRequest.getPassword()))
                .disable(false)
                .person(person)
                .build());
    }

    @Transactional
    public void enableOrDisable(String username) throws EntityNotFoundException {
        User user = findByUsername(username);
        user.setDisable(!user.isDisable());
    }



    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = repository.findFirstByUsername(username).orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + username));
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), user.getAuthorities());
    }

}