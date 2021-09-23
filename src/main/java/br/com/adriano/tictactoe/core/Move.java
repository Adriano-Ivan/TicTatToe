package br.com.adriano.tictactoe.core;

public class Move {

	private int l;
	private int c;
	
	public Move(String moveStr) throws InvalidMoveException{
		// "0, 0"
		// [ "0", "0" ]
		try {
		String[] tokens = moveStr.split(",");
		
		this.l = Integer.parseInt(tokens[0]);
		this.c = Integer.parseInt(tokens[1]);
		} catch(Exception e) {
			throw new InvalidMoveException("A jogada é inválida.");
		}
		
		// TODO - validar se a estrutura do moveStr está correta
	}
	
	public int getL() {
		return this.l;
	}
	
	public int getC() {
		return this.c;
	}
}


