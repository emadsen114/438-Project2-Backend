package com.example.demo;

import com.example.demo.entities.Favorite;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface FavoriteRepository extends JpaRepository<Favorite, Long> {
    List<Favorite> findByUserId(Long user_id);
    Optional<Favorite> findByUserIdAndTeamId(Long user_id, Long team_id);
    void deleteByUserIdAndTeamId(Long user_id, Long team_id);
}