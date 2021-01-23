package ru.chiffa.securitytest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.chiffa.securitytest.model.Score;
import ru.chiffa.securitytest.model.User;

import java.util.Optional;

@Repository
public interface ScoreRepository extends JpaRepository<Score, User> {

    Optional<Score> findScoreByUserUsername(String username);

    Optional<Score> findScoreByUserId(Long id);
}
