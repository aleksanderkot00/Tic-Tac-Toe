package com.tictactoe.io.mapper;

import com.tictactoe.io.dto.GameStateDto;
import com.tictactoe.io.dto.PlayerDto;
import com.tictactoe.state.Figure;
import com.tictactoe.state.GameState;
import com.tictactoe.state.Player;
import com.tictactoe.state.RoundState;

public class GameStateMapper {

    private PlayerMapper playerMapper = new PlayerMapper();

    public GameState mapToGameState(GameStateDto gameStateDto) {

        Player playerOne = playerMapper.mapToPlayer(gameStateDto.getPlayerOne());
        Player playerTwo = playerMapper.mapToPlayer(gameStateDto.getPlayerTwo());

        RoundState roundState = new RoundState(gameStateDto.getRoundState());

        return new GameState(
                playerOne, playerTwo, gameStateDto.getNumberOfDraws(),
                gameStateDto.getRoundsToWin(), roundState, gameStateDto.isPlayerTwoComputer());
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
                gameState.getRoundsToWin(), gameState.isPlayerTwoComputer(), roundState);
    }
}
