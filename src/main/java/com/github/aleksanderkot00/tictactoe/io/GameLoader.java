package com.github.aleksanderkot00.tictactoe.io;

import com.github.aleksanderkot00.tictactoe.io.dto.GameStateDto;
import com.github.aleksanderkot00.tictactoe.io.mapper.GameStateMapper;
import com.github.aleksanderkot00.tictactoe.state.GameState;
import com.google.gson.*;

public class GameLoader implements GameIO {

    private Gson gson = new Gson();
    private GameStateMapper mapper = new GameStateMapper();

    @Override
    public GameState load(String json) {
        return mapper.mapToGameState(gson.fromJson(json, GameStateDto.class));
    }

    @Override
    public String save(GameState gameState) {
        return gson.toJson(mapper.mapToGameStateDto(gameState));
    }
}
