package com.tictactoe.io;

import com.google.gson.*;
import com.tictactoe.state.GameState;

public class GameLoader implements GameIO {

    private Gson gson = new Gson();
    private GameStateMapper mapper = new GameStateMapper();

    @Override
    public GameState load(String json) {
        return mapper.mapToGameState(gson.fromJson(json,GameStateDto.class));
    }

    @Override
    public String save(GameState gameState) {
        return gson.toJson(mapper.mapToGameStateDto(gameState));
    }
}
