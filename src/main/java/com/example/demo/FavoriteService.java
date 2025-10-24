package com.example.demo;

import com.example.demo.entities.Favorite;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class FavoriteService {

    private final FavoriteRepository repo;

    public FavoriteService(FavoriteRepository repo) {
        this.repo = repo;
    }

    public List<Favorite> listAll() {
        return repo.findAll();
    }

    public List<Favorite> listByUser(Long userId) {
        return repo.findByUserId(userId);
    }

    public Favorite add(Favorite fav) {
       return repo.save(fav);
    }

    public Favorite getById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Favorite not found with id: " + id));
    }

    public Favorite save(Favorite favorite) {
        return repo.save(favorite);
    }
     
    @Transactional
    public void removeById(Long id) {
        repo.deleteById(id);
    }

    @Transactional
    public void removeByUserAndTeam(Long userId, Long teamId) {
        repo.deleteByUserIdAndTeamId(userId, teamId);
    }

    public Favorite getByUserAndTeam(Long userId, Long teamId) {
    return repo.findByUserIdAndTeamId(userId, teamId)
        .orElseThrow(() -> new IllegalArgumentException(
            "Favorite not found for user " + userId + " and team " + teamId));
}
}
