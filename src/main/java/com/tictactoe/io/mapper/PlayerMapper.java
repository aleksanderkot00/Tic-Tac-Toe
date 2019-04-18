package com.tictactoe.io.mapper;

import com.tictactoe.io.dto.PlayerDto;
import com.tictactoe.state.Player;

public class PlayerMapper {
    public Player mapToPlayer(PlayerDto playerDto) {
        return new Player(
                playerDto.getName(),
                playerDto.getRoundsWon(),
                playerDto.getFigure()
        );
    }

    public PlayerDto mapToPlayerDto(Player player) {
        return new PlayerDto(
                player.getName(),
                player.getRoundsWon(),
                player.getFigure()
        );
    }
}
