package ir.safari.show.controller;

import ir.safari.show.config.annotation.CustomRestController;
import ir.safari.show.config.exception.EntityNotFoundException;
import ir.safari.show.entity.dto.TeamRequest;
import ir.safari.show.service.TeamService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

@RequiredArgsConstructor
@CustomRestController(value = TeamController.ROOT_PATH)
public class TeamController {
    public final static String ROOT_PATH = "team";
    private final TeamService service;

    @PostMapping
    public void save(@Valid @RequestBody TeamRequest teamRequest) throws EntityNotFoundException {
        service.save(teamRequest);
    }
}
