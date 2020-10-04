package ir.safari.show.entity;


import ir.safari.show.entity.dto.UserRequest;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Setter
@Getter
public class Person extends AbstractJpaPersistable {
    private String name;
    private String surname;
    private String nationalCode;
    private String mobile;

    public static Person createInstance(UserRequest userRequest) {
        Person person = new Person();

        person.setName(userRequest.getName());
        person.setSurname(userRequest.getSurname());
        person.setNationalCode(userRequest.getNationalCode());
        person.setMobile(userRequest.getMobile());

        return person;
    }

    @Transient
    public String getFullName() {
        return name + " " + surname;
    }
}