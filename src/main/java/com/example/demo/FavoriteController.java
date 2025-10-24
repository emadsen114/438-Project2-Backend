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
    //working 
    @GetMapping
    public List<Favorite> all() {
        return service.listAll();
    }
    //working!
    @GetMapping("/user/{userId:\\d+}")
    public List<Favorite> byUser(@PathVariable Long userId) {
        return service.listByUser(userId);
    }

    //not working :(
    // // POST /favorites
    // @PostMapping
    // public Favorite add(@RequestBody Favorite fav) {
    //     return service.add(fav);
    // }


    // not working/in progress 
    // // PUT /favorites/{id}
    // @PutMapping("/{id:\\d+}")
    // public ResponseEntity<Favorite> updateFavorite(
    //         @PathVariable Long id,
    //         @RequestBody Favorite updated) {
    //     Favorite existing = service.getById(id);
    //     existing.setUserId(updated.getUserId());
    //     existing.setTeamId(updated.getTeamId());
    //     existing.setGameId(updated.getGameId());
    //     return ResponseEntity.ok(service.save(existing));
    // }

    //working! 
    // DELETE /favorites/{id}
    @DeleteMapping("/{id:\\d+}")
    public void deleteById(@PathVariable Long id) {
        service.removeById(id);
    }
    //working 
    @DeleteMapping("/user/{userId:\\d+}/team/{teamId:\\d+}")
    public void deleteByUserAndTeam(@PathVariable Long userId, @PathVariable Long teamId) {
        service.removeByUserAndTeam(userId, teamId);
    }
}
