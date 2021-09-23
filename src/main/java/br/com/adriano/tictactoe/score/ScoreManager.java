package br.com.adriano.tictactoe.score;

import java.io.IOException;

import br.com.adriano.tictactoe.core.Player;

public interface ScoreManager {

	public Integer getScore(Player player);
	
	public void saveScore(Player player) throws IOException;
}
