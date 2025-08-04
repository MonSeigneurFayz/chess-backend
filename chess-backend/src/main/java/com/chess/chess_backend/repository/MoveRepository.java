package com.chess.chess_backend.repository;

import com.chess.chess_backend.Move;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MoveRepository extends JpaRepository<Move, Long> {
    List<Move> findByGameId(String gameId);
    Move findTopByGameIdAndPlayerNotOrderByIdDesc(String gameId, String player);
}
