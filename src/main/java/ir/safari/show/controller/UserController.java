package ir.safari.show.controller;

import ir.safari.show.config.annotation.CustomRestController;
import ir.safari.show.config.exception.EntityNotFoundException;
import ir.safari.show.config.exception.UniqueException;
import ir.safari.show.entity.dto.UserRequest;
import ir.safari.show.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequiredArgsConstructor
@CustomRestController(value = UserController.ROOT_PATH)
public class UserController {
    public static final String ROOT_PATH = "user";
    private final UserService service;

    @PostMapping
    public void save(@Valid @RequestBody UserRequest userRequest) throws UniqueException {
        service.save(userRequest);
    }

    @PatchMapping("changeEnableDisable/{username}")
    public void delete(@PathVariable String username) throws EntityNotFoundException {
        service.enableOrDisable(username);
    }
}