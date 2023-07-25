package io.codelex.flightplanner.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.codelex.flightplanner.services.TestFlightPlannerService;

@RestController
@RequestMapping("/testing-api")
public class TestApiController {
    private final TestFlightPlannerService flightPlannerService;

    public TestApiController(TestFlightPlannerService flightPlannerService) {
        this.flightPlannerService = flightPlannerService;
    }

    @PostMapping("/clear")
    public void clearData() {
        this.flightPlannerService.clearFlightRepository();
    }

}
