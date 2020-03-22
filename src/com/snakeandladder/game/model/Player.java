package com.snakeandladder.game.model;

import com.snakeandladder.game.exception.GameException;

public class Player {
	private int id;
	private Square square;
	private String name;

	public Player(String name, int id, Square square) {
		super();
		this.name = name;
		this.id = id;
		this.square = square;
	}

	public Square getSquare() {
		return square;
	}

	public void setSquare(Square square) {
		this.square = square;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPosition() {
		return square.getPosition();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public boolean wins() {
		return square.isLastSquare();
	}

	public void moveForward(int moves) throws GameException {
		square.leave(this);
		System.out.println("Player " + getName() + "'s turn.");
		square = square.move(moves);
		square.enter(this);
	}

	@Override
	public String toString() {
		return name;
	}

}
