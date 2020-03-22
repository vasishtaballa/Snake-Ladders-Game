package com.snakeandladder.game.business.squarerole;

import com.snakeandladder.game.model.Square;

public class LastSquareRole extends SquareRole {

	public LastSquareRole(Square square) {
		super(square);
	}

	@Override
	public boolean isFirstSquare() {
		return false;
	}

	@Override
	public boolean isLastSquare() {
		return true;
	}

}
