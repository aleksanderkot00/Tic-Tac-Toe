package com.github.aleksanderkot00.tictactoe.io.mapper;

import com.github.aleksanderkot00.tictactoe.io.dto.PlayerDto;
import com.github.aleksanderkot00.tictactoe.state.Figure;
import com.github.aleksanderkot00.tictactoe.state.Player;
import com.github.aleksanderkot00.tictactoe.state.RoundState;
import com.github.aleksanderkot00.tictactoe.io.dto.GameStateDto;
import com.github.aleksanderkot00.tictactoe.state.GameState;

public class GameStateMapper {

    private PlayerMapper playerMapper = new PlayerMapper();

    public GameState mapToGameState(GameStateDto gameStateDto) {

        Player playerOne = playerMapper.mapToPlayer(gameStateDto.getPlayerOne());
        Player playerTwo = playerMapper.mapToPlayer(gameStateDto.getPlayerTwo());

        RoundState roundState = new RoundState(gameStateDto.getRoundState());

        return new GameState(
                playerOne, playerTwo, gameStateDto.getNumberOfDraws(),
                gameStateDto.getRoundsToWin(), roundState);
    }

    public GameStateDto mapToGameStateDto(GameState gameState) {

        PlayerDto playerOne = playerMapper.mapToPlayerDto(gameState.getPlayerOne());
        PlayerDto playerTwo = playerMapper.mapToPlayerDto(gameState.getPlayerTwo());

        Figure[] roundState = new Figure[9];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                roundState[i * 3 + j] = gameState.getRoundState().getBoardFields()[j][i];
            }
        }

        return new GameStateDto(
                playerOne, playerTwo, gameState.getNumberOfDraws(),
                gameState.getRoundsToWin(), roundState);
    }
}
