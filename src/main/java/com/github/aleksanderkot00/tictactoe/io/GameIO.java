package com.github.aleksanderkot00.tictactoe.io;

import com.github.aleksanderkot00.tictactoe.state.GameState;

public interface GameIO {
    GameState load(String string);
    String save(GameState gameState);
}
