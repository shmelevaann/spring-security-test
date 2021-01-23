package ru.chiffa.securitytest.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.chiffa.securitytest.model.Score;
import ru.chiffa.securitytest.model.User;
import ru.chiffa.securitytest.repository.ScoreRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ScoreService {
    private final ScoreRepository scoreRepository;
    private final UserService userService;

    public void increase(String username) {
        Score score = findOrCreateByUsername(username);
        score.setValue(score.getValue() + 1);
        scoreRepository.save(score);
    }

    public Score findOrCreateByUsername(String username) {
        Optional<Score> score = scoreRepository.findScoreByUserUsername(username);
        if(score.isEmpty()) {
            Optional<User> user = userService.findByUsername(username);
            if(user.isEmpty()) {
                throw new RuntimeException("User not found");
            } else {
                return scoreRepository.save(new Score(null, user.get(), 0));
            }
        }
        return score.get();
    }

    public void decrease(String username) {
        Score score = findOrCreateByUsername(username);
        score.setValue(score.getValue() - 1);
        scoreRepository.save(score);
    }

    public int findByUsername(String username) {
        Score score = findOrCreateByUsername(username);
        return score.getValue();
    }

    public int findByUserId(Long id) {
        Score score = scoreRepository.findScoreByUserId(id).orElseThrow(() -> new RuntimeException("User not found"));
        return score.getValue();
    }
}
