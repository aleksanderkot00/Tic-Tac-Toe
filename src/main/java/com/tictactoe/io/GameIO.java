package com.tictactoe.io;

import com.tictactoe.state.GameState;

public interface GameIO {
    GameState load(String string);
    String save(GameState gameState);
}
