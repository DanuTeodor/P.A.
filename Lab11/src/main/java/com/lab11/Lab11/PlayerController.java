package com.lab11.Lab11;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@RestController
public class PlayerController {
    private final List<Player> players = new ArrayList<>();

    @GetMapping("/players")
    public List<Player> getPlayers() {
        return players;
    }

    @PostMapping("/player")
    public int addPlayer(@RequestParam String name) {
        Player player = new Player(name);
        players.add(player);
        return players.size();
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updatePlayer(@PathVariable int id, @RequestParam String name) {
        Player player = null;

        if(id >= 0 && id < players.size())
            player = players.get(id);

        if (player == null) {
            return new ResponseEntity<>("Player not found", HttpStatus.NOT_FOUND);
        }

        player.setName(name);
        return new ResponseEntity<>("Player updated successfully", HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable int id) {
        Player player = null;

        if(id >= 0 && id < players.size())
            player = players.get(id);

        if (player == null) {
            return new ResponseEntity<>("Player not found", HttpStatus.GONE);
        }

        players.remove(player);
        return new ResponseEntity<>("Player removed", HttpStatus.OK);
    }
}
