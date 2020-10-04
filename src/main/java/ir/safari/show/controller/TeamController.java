package ir.safari.show.controller;

import ir.safari.show.config.annotation.CustomRestController;
import ir.safari.show.config.exception.EntityNotFoundException;
import ir.safari.show.entity.Team;
import ir.safari.show.entity.dto.TeamRequest;
import ir.safari.show.entity.dto.TeamResponse;
import ir.safari.show.service.TeamService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.util.List;

@RequiredArgsConstructor
@CustomRestController(value = TeamController.ROOT_PATH)
public class TeamController {
    public final static String ROOT_PATH = "team";
    private final TeamService service;

    @PostMapping
    public void save(@Valid @RequestBody TeamRequest teamRequest) throws EntityNotFoundException {
        service.save(teamRequest);
    }

    @GetMapping("getForAdmin")
    public List<TeamResponse> getForAdmin() {
        return service.findAllForAdmin();
    }

    @GetMapping("getForMentor")
    public List<TeamResponse> getForMentor() {
        return service.findAllForMentor();
    }

    @GetMapping("getTeamScoreAverage/{teamId}")
    public Double getTeamScore(@PathVariable Long teamId) {
        return service.getTeamScoreAverage(teamId);
    }
}
