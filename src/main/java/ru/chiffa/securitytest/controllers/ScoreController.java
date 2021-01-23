package ru.chiffa.securitytest.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.chiffa.securitytest.services.ScoreService;

import java.security.Principal;

@Controller
@RequestMapping("/app/score")
@RequiredArgsConstructor
public class ScoreController {
    private final ScoreService scoreService;

    @GetMapping("/inc")
    public void increaseScore(Principal principal){
        scoreService.increase(principal.getName());
    }

    @GetMapping("/dec")
    public void decreaseScore(Principal principal) {
        scoreService.decrease(principal.getName());
    }

    @GetMapping("/get/current")
    public int findScoreCurrentUser(Principal principal) {
        return scoreService.findByUsername(principal.getName());
    }

    @GetMapping("/get/{id}")
    public int findScoreByUserId(@PathVariable Long id){
        return scoreService.findByUserId(id);
    }
}
