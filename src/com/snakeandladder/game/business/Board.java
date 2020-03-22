package com.snakeandladder.game.business;

import java.util.ArrayList;

import com.snakeandladder.game.business.squarerole.FirstSquareRole;
import com.snakeandladder.game.business.squarerole.LadderRole;
import com.snakeandladder.game.business.squarerole.LastSquareRole;
import com.snakeandladder.game.business.squarerole.RegularSquareRole;
import com.snakeandladder.game.business.squarerole.SnakeRole;
import com.snakeandladder.game.exception.GameException;
import com.snakeandladder.game.model.Square;

public class Board {
	private ArrayList<Square> squares = new ArrayList<>();
	private static int MIN_NUM_SQUARES = 50;

	public Board(int boardSize, int[][] snakes, int[][] ladders) throws GameException {
		if (boardSize < MIN_NUM_SQUARES)
			throw new GameException("Minimum squares in board should be " + MIN_NUM_SQUARES);
		else {
			prepareSquares(boardSize);
			prepareSnakes(snakes);
			prepareLadders(ladders);
		}
	}

	private void prepareLadders(int[][] ladders) throws GameException {
		System.out.println("There are " + ladders.length + " number of ladders. Preparing them..");
		for (int i = 0; i < ladders.length; i++) {
			if (ladders[i].length != 2)
				throw new GameException("Insufficient arguments for Ladders at index: " + i);
			int from = ladders[i][0] - 1;
			int to = ladders[i][1] - 1;
			int destination = to - from;
			System.out.println("Ladder from " + from + 1 + " to " + to + 1);
			Square ladderSquare = squares.get(from);
			ladderSquare.setSquareRole(new LadderRole(ladderSquare, destination));
		}
	}

	private void prepareSnakes(int[][] snakes) throws GameException {
		System.out.println("There are " + snakes.length + " number of snakes. Preparing them..");
		for (int i = 0; i < snakes.length; i++) {
			if (snakes[i].length != 2)
				throw new GameException("Insufficient arguments for Snakes at index: " + i);
			int from = snakes[i][0] - 1;
			int to = snakes[i][1] - 1;
			int destination = to - from;
			System.out.println("Snake from " + from + 1 + " to " + to + 1);
			Square snakeSquare = squares.get(from);
			snakeSquare.setSquareRole(new SnakeRole(snakeSquare, destination));
		}
	}

	private void prepareSquares(int boardSize) throws GameException {
		System.out.println("There are " + boardSize + " number of squares. Preparing them..");
		for (int i = 0; i < boardSize; i++) {
			Square square = new Square(i, this);
			squares.add(square);
			square.setSquareRole(new RegularSquareRole(square));
		}
		firstSquare().setSquareRole(new FirstSquareRole(firstSquare()));
		lastSquare().setSquareRole(new LastSquareRole(lastSquare()));
	}

	public Square findSquare(int position) throws GameException {
		if (position < 0 || position > numberOfSquares())
			throw new GameException("Square doesn't exist.");
		return squares.get(position);
	}

	private int numberOfSquares() {
		return squares.size();
	}

	public Square firstSquare() {
		return squares.get(0);
	}

	public Square lastSquare() {
		return squares.get(squares.size() - 1);
	}
}
