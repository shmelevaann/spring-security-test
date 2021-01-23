package ru.chiffa.securitytest.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.chiffa.securitytest.model.Score;
import ru.chiffa.securitytest.repository.ScoreRepository;

@Service
@RequiredArgsConstructor
public class ScoreService {
    private final ScoreRepository scoreRepository;

    public void increase(String username) {
        Score score = scoreRepository.findScoreByUserUsername(username).orElseThrow(() -> new RuntimeException("User not found"));
        score.setValue(score.getValue() + 1);
        scoreRepository.save(score);
    }

    public void decrease(String username) {
        Score score = scoreRepository.findScoreByUserUsername(username).orElseThrow(() -> new RuntimeException("User not found"));
        score.setValue(score.getValue() - 1);
        scoreRepository.save(score);
    }

    public int findByUsername(String username) {
        Score score = scoreRepository.findScoreByUserUsername(username).orElseThrow(() -> new RuntimeException("User not found"));
        return score.getValue();
    }

    public int findByUserId(Long id) {
        Score score = scoreRepository.findScoreByUserId(id).orElseThrow(() -> new RuntimeException("User not found"));
        return score.getValue();
    }
}
