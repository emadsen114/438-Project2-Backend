package com.example.demo;

import com.example.demo.entities.Favorite;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/favorites")
public class FavoriteController {

    private final FavoriteService service;

    public FavoriteController(FavoriteService service) {
        this.service = service;
    }

    @GetMapping
    public List<Favorite> all() {
        return service.listAll();
    }
    
    @GetMapping("/user/{userId:\\d+}")
    public List<Favorite> byUser(@PathVariable Long userId) {
        return service.listByUser(userId);
    }

    @PostMapping
    public Favorite add(@RequestBody Favorite fav) {
        return service.add(fav);
    }

    @PostMapping("/game/{gameId:\\d+}")
    public Favorite addByGame(@PathVariable Long gameId, @RequestBody Favorite fav) {
        fav.setGameId(gameId);
        return service.add(fav);
    }


    @PutMapping("/{id:\\d+}")
    public ResponseEntity<Favorite> updateFavorite(
            @PathVariable Long id,
            @RequestBody Favorite updated) {
        Favorite existing = service.getById(id);
        existing.setUserId(updated.getUserId());
        existing.setTeamId(updated.getTeamId());
        existing.setGameId(updated.getGameId());
        return ResponseEntity.ok(service.save(existing));
    }

    @PutMapping("/user/{userId:\\d+}/team/{teamId:\\d+}")
    public ResponseEntity<Favorite> updateByUserAndTeam(
            @PathVariable Long userId,
            @PathVariable Long teamId,
            @RequestBody Favorite updated) {

        Favorite existing = service.getByUserAndTeam(userId, teamId);
        existing.setGameId(updated.getGameId());
        return ResponseEntity.ok(service.save(existing));
    }


    @DeleteMapping("/{id:\\d+}")
    public void deleteById(@PathVariable Long id) {
        service.removeById(id);
    }
    
    @DeleteMapping("/user/{userId:\\d+}/team/{teamId:\\d+}")
    public void deleteByUserAndTeam(@PathVariable Long userId, @PathVariable Long teamId) {
        service.removeByUserAndTeam(userId, teamId);
    }
}
