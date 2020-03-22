package com.snakeandladder.game.main;

import java.util.LinkedList;
import java.util.Queue;

import com.snakeandladder.game.business.Board;
import com.snakeandladder.game.exception.GameException;
import com.snakeandladder.game.model.Player;
import com.snakeandladder.game.service.DieService;

public class Game {
	private Queue<Player> players = new LinkedList<>();
	private Board board = null;
	private Player winner = null;
	private int diceCount;

	public Game(String[] playerNames, int boardSize, int[][] snakes, int[][] ladders, int diceCount)
			throws GameException {
		this.diceCount = diceCount;
		prepareBoard(boardSize, snakes, ladders);
		preparePlayers(playerNames);
	}

	private void preparePlayers(String[] playerNames) {
		System.out.println("Players are : ");
		int i = 1;
		for (String name : playerNames) {
			Player player = new Player(name, i, board.firstSquare());
			players.add(player);
			System.out.println(i + ". " + name);
			i++;
		}
	}

	public void play() throws GameException {
		if (players.isEmpty())
			System.out.println("No players");
		if (board == null)
			System.out.println("No board to play");
		DieService dieService = new DieService(diceCount);
		startGame();
		while (gameNotOver()) {
			int roll = dieService.rollDice();
			movePlayer(roll);
		}
		System.out.println("Game completed and the winner is: " + winner.getName());
	}

	private void movePlayer(int roll) throws GameException {
		Player currentPlayer = players.remove();
		currentPlayer.moveForward(roll);
		players.add(currentPlayer);
		if (currentPlayer.wins())
			winner = currentPlayer;
	}

	private boolean gameNotOver() {
		return winner == null;
	}

	private void startGame() {
		addPlayersAtStart();
		winner = null;
	}

	private void addPlayersAtStart() {
		// TODO Auto-generated method stub
		for (Player player : players) {
			board.firstSquare().addPlayer(player);
		}
	}

	private void prepareBoard(int boardSize, int[][] snakes, int[][] ladders) throws GameException {
		board = new Board(boardSize, snakes, ladders);
	}

}
