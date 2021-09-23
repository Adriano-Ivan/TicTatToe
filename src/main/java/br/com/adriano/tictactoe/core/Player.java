package br.com.adriano.tictactoe.core;

import br.com.adriano.tictactoe.ui.UI;

public class Player {

	private String name;
	private Board board;
	private char symbol;
	
	public Player(String name, Board board, char symbol) {
		//super();
		this.name = name;
		this.board = board;
		this.symbol = symbol;
	}
	
	private Move inputMove() throws InvalidMoveException{
		String moveStr = UI.readInput("Jogador " + name + " => ");
		Move m = new Move(moveStr);
		return m;
	}
	
	public boolean play() throws InvalidMoveException {
		Move move = inputMove();
		return board.play(this, move);
	}
	
	public Board getBoard() {
		return this.board;
	}
	
	public String getName()  {
		return this.name;
	}
	public char getSymbol() {
		return this.symbol;
	}
}
