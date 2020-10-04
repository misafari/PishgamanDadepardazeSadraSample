package ir.safari.show;

import ir.safari.show.entity.Candidate;
import ir.safari.show.entity.Person;
import ir.safari.show.entity.User;
import ir.safari.show.service.CandidateService;
import ir.safari.show.service.UserService;
import ir.safari.show.utils.UserRole;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.stream.Stream;

@Component
@RequiredArgsConstructor
public class Starter implements CommandLineRunner {
    private final UserService userService;
    private final CandidateService candidateService;
//    private final BCryptPasswordEncoder bCryptPasswordEncoder;


    @Override
    public void run(String... args) throws Exception {
        Stream.of("mentor1", "mentor2", "mentor3", "admin")
                .filter(mentor -> !userService.existByUsername(mentor))
                .forEach(mentor -> {
                    Person person = new Person();

                    person.setName(mentor);
                    person.setSurname(mentor);
                    person.setMobile("09387207022");

                    User user = new User();

                    user.setUsername(mentor);
                    user.setDisable(false);
                    user.setPassword("123");
                    user.setRoles(Collections.singletonList(mentor.equals("admin") ? UserRole.ROLE_ADMIN : UserRole.ROLE_MENTOR));
                    user.setPerson(person);

                    userService.save(user);
                });

        Stream.of("123", "456", "789")
                .filter(candidateNationalCode -> !candidateService.existByNationalCode(candidateNationalCode))
                .forEach(candidateNationalCode -> {
                    Candidate candidate = new Candidate();

                    candidate.setName("Candidate-" + candidateNationalCode);
                    candidate.setSurname("candidate");
                    candidate.setNationalCode(candidateNationalCode);

                    candidateService.save(candidate);
                });
    }
}
