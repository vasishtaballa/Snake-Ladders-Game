package com.snakeandladder.game.business.squarerole;

import com.snakeandladder.game.exception.GameException;
import com.snakeandladder.game.model.Player;
import com.snakeandladder.game.model.Square;

public abstract class SquareRole {
	public Square square;

	public abstract boolean isFirstSquare();

	public abstract boolean isLastSquare();

	public SquareRole(Square square) {
		this.square = square;
	}

	public boolean isOccupied() {
		return !this.square.getPlayers().isEmpty();
	}

	public Square move(int moves) throws GameException {
		int endPosition = square.findLastSquare().getPosition();
		int currentPosition = square.getPosition();
		if (currentPosition + moves > endPosition) {
			System.out.println("Should go to " + currentPosition + moves + 1 + " from " + currentPosition
					+ " which is beyond the board. So, you can't move now");
			return square;
		} else {
			System.out.println("Moving from " + (currentPosition + 1) + " to "
					+ (square.getRelativeSquare(moves).getPosition() + 1));
			return square.getRelativeSquare(moves);
		}
	}

	public void enter(Player player) {
		square.addPlayer(player);
		player.setSquare(square);
	}

	public void leave(Player player) {
		square.removePlayer(player);
		player.setSquare(square);
	}

}
