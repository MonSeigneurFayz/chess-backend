package com.chess.chess_backend.controller;

import com.chess.chess_backend.Move;
import com.chess.chess_backend.repository.MoveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/moves")
@CrossOrigin(origins = "*") // Autorise les requêtes depuis n'importe quelle origine
public class MoveController {

    @Autowired
    private MoveRepository moveRepository;

    
    @PostMapping
    public Move addMove(@RequestBody Move move) {
        return moveRepository.save(move);
    }

    
    @GetMapping("/{gameId}")
    public List<Move> getMoves(@PathVariable String gameId) {
        return moveRepository.findByGameId(gameId);
    }

    
    @GetMapping("/{gameId}/last/{player}")
    public ResponseEntity<String> getLastOpponentMove(@PathVariable String gameId, @PathVariable String player) {
        Move move = moveRepository.findTopByGameIdAndPlayerNotOrderByIdDesc(gameId, player);
        if (move == null) return ResponseEntity.noContent().build();
        return ResponseEntity.ok(move.getMove());
    }

    
    @GetMapping("/ping")
    public String ping() {
        return "pong";
    }

}
