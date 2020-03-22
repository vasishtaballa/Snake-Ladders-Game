package com.snakeandladder.game.business.squarerole;

import com.snakeandladder.game.exception.GameException;
import com.snakeandladder.game.model.Square;

public class SnakeRole extends SquareRole {

	int destination;

	public SnakeRole(Square square, int destination) {
		super(square);
		this.destination = destination;
	}

	@Override
	public boolean isFirstSquare() {
		return false;
	}

	@Override
	public boolean isLastSquare() {
		return false;
	}

	public Square destination() throws GameException {
		return square.getRelativeSquare(destination);
	}

}
