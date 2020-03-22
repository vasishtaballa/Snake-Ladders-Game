package com.snakeandladder.game.main;

import com.snakeandladder.game.exception.GameException;

public class Main {
	int diceCount;
	int boardSize;

	public static void main(String[] args) {
		Main main = new Main();
		main.initializeRules();
		String[] playerNames = { "Player 1", "Player 2" };
		int[][] snakes = getSnakesPositions();
		int[][] ladders = getLaddersPositions();
		try {
			Game game = new Game(playerNames, main.boardSize, snakes, ladders, main.diceCount);
			game.play();
		} catch (GameException ex) {
			System.out.println("Exception occurred while playing game: " + ex.getMessage());
		}
	}

	private static int[][] getLaddersPositions() {
		int[][] ladders = { { 2, 6 }, { 7, 9 } };
		return ladders;
	}

	private static int[][] getSnakesPositions() {
		int[][] snakes = { { 11, 5 } };
		return snakes;
	}

	public void initializeRules() {
		boardSize = 100;
		diceCount = 1;
	}

}
