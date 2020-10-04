package ir.safari.show.controller;

import ir.safari.show.config.annotation.CustomRestController;
import ir.safari.show.entity.dto.ScoreRequest;
import ir.safari.show.service.ScoreService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

@CustomRestController(value = ScoreController.ROOT_PATH)
@RequiredArgsConstructor
public class ScoreController {
    public static final String ROOT_PATH = "score";
    private final ScoreService service;
}
