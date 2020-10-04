package ir.safari.show.controller;

import ir.safari.show.config.annotation.CustomRestController;
import ir.safari.show.config.exception.EntityNotFoundException;
import ir.safari.show.entity.dto.PerformanceRequest;
import ir.safari.show.service.PerformanceService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

@RequiredArgsConstructor
@CustomRestController(value = PerformanceController.ROOT_PATH)
public class PerformanceController {
    public static final String ROOT_PATH = "performance";
    private final PerformanceService service;

    @PostMapping
    public void save(@Valid @RequestBody PerformanceRequest performanceRequest) throws EntityNotFoundException {
        service.save(performanceRequest);
    }

}
