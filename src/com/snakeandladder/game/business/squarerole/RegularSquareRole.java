package com.snakeandladder.game.business.squarerole;

import com.snakeandladder.game.model.Square;

public class RegularSquareRole extends SquareRole {

	public RegularSquareRole(Square square) {
		super(square);
	}

	@Override
	public boolean isFirstSquare() {
		return false;
	}

	@Override
	public boolean isLastSquare() {
		return false;
	}
}
