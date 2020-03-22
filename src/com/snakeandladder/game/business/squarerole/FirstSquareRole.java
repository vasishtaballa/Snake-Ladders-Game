package com.snakeandladder.game.business.squarerole;

import java.util.ArrayList;

import com.snakeandladder.game.model.Player;
import com.snakeandladder.game.model.Square;

public class FirstSquareRole extends SquareRole {

	private ArrayList<Player> players = new ArrayList<>();

	public FirstSquareRole(Square square) {
		super(square);
	}

	@Override
	public boolean isFirstSquare() {
		return true;
	}

	@Override
	public boolean isLastSquare() {
		return false;
	}

	@Override
	public boolean isOccupied() {
		return !this.players.isEmpty();
	}

}
