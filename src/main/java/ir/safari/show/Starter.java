package ir.safari.show;

import ir.safari.show.entity.Person;
import ir.safari.show.entity.User;
import ir.safari.show.service.UserService;
import ir.safari.show.utils.CollectionUtils;
import ir.safari.show.utils.UserRole;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Collections;

@Component
@RequiredArgsConstructor
public class Starter implements CommandLineRunner {
    private final UserService userService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;


    @Override
    public void run(String... args) throws Exception {
        if (!userService.existByUsername("admin")){
            Person person = new Person();

            person.setName("admin");
            person.setSurname("admin");
            person.setMobile("09387207022");

            User user = new User();

            user.setUsername("admin");
            user.setDisable(false);
            user.setPassword(bCryptPasswordEncoder.encode("123"));
            user.setRoles(Collections.singletonList(UserRole.ROLE_ADMIN));
            user.setPerson(person);

            userService.save(user);
        }
    }
}
