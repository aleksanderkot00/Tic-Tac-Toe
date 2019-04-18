package com.tictactoe.io;

import com.tictactoe.state.Figure;
import com.tictactoe.state.GameState;
import com.tictactoe.state.Player;
import com.tictactoe.state.RoundState;

public class GameStateMapper {

    public GameState mapToGameState(GameStateDto gameStateDto) {
        Player playerOne = new Player(
                gameStateDto.getPlayerOneName(),
                gameStateDto.getPlayerOneRoundsWon(),
                gameStateDto.getPlayerOneFigure()
        );
        Player playerTwo = new Player(
                gameStateDto.getPlayerTwoName(),
                gameStateDto.getPlayerTwoRoundsWon(),
                gameStateDto.getPlayerTwoFigure()
        );
        RoundState roundState = new RoundState(gameStateDto.getRoundState());

        return new GameState(playerOne, playerTwo, gameStateDto.getNumberOfDraws(),
                gameStateDto.getRoundsToWin(), roundState, gameStateDto.isPlayerTwoComputer());
    }

    public GameStateDto mapToGameStateDto(GameState gameState) {
        Figure[] roundState = new Figure[9];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                roundState[i * 3 + j] = gameState.getRoundState().getBoardFields()[i][j];
            }
        }

        return new GameStateDto(
                gameState.getPlayerOne().getName(), gameState.getPlayerOne().getRoundsWon(), gameState.getPlayerOne().getFigure(),
                gameState.getPlayerTwo().getName(), gameState.getPlayerTwo().getRoundsWon(), gameState.getPlayerTwo().getFigure(),
                gameState.getNumberOfDraws(), gameState.getRoundsToWin(), gameState.isPlayerTwoComputer(),
                roundState);
    }
}
