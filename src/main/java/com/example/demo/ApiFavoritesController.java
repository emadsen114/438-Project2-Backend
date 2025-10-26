package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.demo.entities.Favorite;
import java.util.List;

@RestController
@RequestMapping("/api/favorites")
@CrossOrigin(origins = "*")
public class ApiFavoritesController {

    @Autowired
    private FavoriteService favoriteService;

    @Autowired
    private FavoriteRepository favoriteRepository;

    @GetMapping
    public ResponseEntity<List<Favorite>> getAllFavorites() {
        List<Favorite> favorites = favoriteRepository.findAll();
        return ResponseEntity.ok(favorites);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Favorite> getFavorite(@PathVariable Long id) {
        return favoriteRepository.findById(id)
                .map(favorite -> ResponseEntity.ok().body(favorite))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Favorite> addFavorite(@RequestParam Long userId, @RequestParam Long teamId, @RequestParam Long gameId) {
        try {
            Favorite favorite = new Favorite(userId, teamId, gameId);
            Favorite savedFavorite = favoriteService.add(favorite);
            return ResponseEntity.ok(savedFavorite);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteFavorite(@PathVariable Long id) {
        return favoriteRepository.findById(id)
                .map(favorite -> {
                    favoriteRepository.delete(favorite);
                    return ResponseEntity.ok().build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}