package io.codelex.flightplanner.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/testing-api")
public class TestApiController {

    @PostMapping("/clear")
    public void clearData() {
        // Insert data clearing functionality
    }

}
