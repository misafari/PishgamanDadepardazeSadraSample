package ir.safari.show.controller;

import ir.safari.show.config.annotation.CustomRestController;
import lombok.RequiredArgsConstructor;

@CustomRestController(value = PerformanceController.ROOT_PATH)
@RequiredArgsConstructor
public class PerformanceController {
    public static final String ROOT_PATH = "performance";
}
