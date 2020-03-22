package com.snakeandladder.game.service;

import java.util.Random;

public class DieService {
	int dieCount;

	public DieService(int dieCount) {
		this.dieCount = dieCount;
	}

	public int rollDice() {
		Random random = new Random();
		int max = dieCount * 6;
		return random.nextInt((max - 1) + 1) + 1;
	}

}
