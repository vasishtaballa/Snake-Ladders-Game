package com.snakeandladder.game.model;

import java.util.ArrayList;

import com.snakeandladder.game.business.Board;
import com.snakeandladder.game.business.squarerole.SquareRole;
import com.snakeandladder.game.exception.GameException;

public class Square {
	private Board board;
	private ArrayList<Player> players = new ArrayList<>();
	private int position;
	private SquareRole squareRole;

	public Square(int position, Board board) throws GameException {
		if (position < 0)
			throw new GameException("Square number must be positive");
		this.position = position;
		this.board = board;
	}

	public ArrayList<Player> getPlayers() {
		return players;
	}

	public void addPlayer(Player player) {
		this.players.add(player);
	}

	public void removePlayer(Player player) {
		Player playerToRemove = null;
		for (Player item : this.players) {
			if (player.getId() == item.getId()) {
				playerToRemove = item;
				break;
			}
		}
		this.players.remove(playerToRemove);
	}

	public int getPosition() {
		return position;
	}

	public void setSquareRole(SquareRole squareRole) {
		this.squareRole = squareRole;
	}

	public boolean isOccupied() {
		return squareRole.isOccupied();
	}

	public boolean isLastSquare() {
		return squareRole.isLastSquare();
	}

	public Square move(int moves) throws GameException {
		return squareRole.move(moves);
	}

	public void enter(Player player) {
		squareRole.enter(player);
	}

	public void leave(Player player) {
		squareRole.leave(player);
	}

	public Square getRelativeSquare(int jump) throws GameException {
		return board.findSquare(position + jump);
	}

	public Square findFirstSquare() {
		return board.firstSquare();
	}

	public Square findLastSquare() {
		return board.lastSquare();
	}

}
