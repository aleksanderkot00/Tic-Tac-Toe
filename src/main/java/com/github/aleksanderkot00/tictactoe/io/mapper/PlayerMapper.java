package com.github.aleksanderkot00.tictactoe.io.mapper;

import com.github.aleksanderkot00.tictactoe.io.dto.PlayerDto;
import com.github.aleksanderkot00.tictactoe.state.Player;

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
