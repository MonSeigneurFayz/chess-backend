package com.chess.chess_backend;

import jakarta.persistence.*;


@Entity
public class Move {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String gameId;
    private String player;
    private String move;

    public Move() {}

    public Move(String gameId, String player, String move) {
        this.gameId = gameId;
        this.player = player;
        this.move = move;
    }

    public Long getId() {
        return id;
    }

    public String getGameId() {
        return gameId;
    }

    public void setGameId(String gameId) {
        this.gameId = gameId;
    }

    public String getPlayer() {
        return player;
    }

    public void setPlayer(String player) {
        this.player = player;
    }

    public String getMove() {
        return move;
    }

    public void setMove(String move) {
        this.move = move;
    }
}
