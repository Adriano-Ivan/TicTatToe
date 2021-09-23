package br.com.adriano.tictactoe.core;

import br.com.adriano.tictactoe.ui.UI;

public class Board {

	private char[][] matrix = new char[Constants.BOARD_SIZE][Constants.BOARD_SIZE];
	
	public Board() {
		clear();
	}
	
	public void clear() {
		for(int l = 0; l < matrix.length; l++) {
			for(int c = 0; c < matrix[l].length; c++) {
				matrix[l][c] = ' ';
			}
		}
	}
	
	public void print() {
		UI.printNewLine();
		for(int l = 0; l < matrix.length; l++) {
			UI.printTextWithNoNewLine("   ");
			for(int c = 0; c < matrix[l].length; c++) {
				
				UI.printTextWithNoNewLine(String.valueOf(matrix[l][c]));
				
				if(c < matrix[l].length - 1) {
					UI.printTextWithNoNewLine("  |  ");
				}
				
			}
			UI.printNewLine();
			UI.printTextWithNoNewLine("   ");
			
			if(l < matrix.length - 1) {
				UI.printText("-------------");
			}
		}
		UI.printNewLine();
	}
	
	public boolean isFull() {
		for(int l = 0; l < matrix.length; l++) {
			for(int c = 0; c < matrix[l].length; c++) {
				if(matrix[l][c] == ' ') {
					return false;
				}
			}
		}
		
		return true;
	}
	
	public boolean play(Player player, Move move) throws InvalidMoveException{
		int l = move.getL();
		int c = move.getC();
		
		if( l < 0 || c < 0 || l >= Constants.BOARD_SIZE || c >= Constants.BOARD_SIZE) {
			throw new InvalidMoveException("Algum parâmetro excede o limite !");
		}
		if(matrix[l][c] != ' ') {
			throw new InvalidMoveException("A posição indicada já está ocupada !");
		}
		matrix[l][c] = player.getSymbol();
		
		return checkRows(player) || checkCols(player) || checkDiagonal1(player) || checkDiagonal2(player);
	}
	
	private boolean checkRows(Player player) {
		for(int i = 0; i < Constants.BOARD_SIZE; i++) {
			if(checkRow(i, player))
				return true;
		}
		return false;
	}
	
	private boolean checkCols(Player player) {
		for(int j = 0; j < Constants.BOARD_SIZE; j++) {
			if(checkCol(j, player))
				return true;
		}
		return false;
	}
	
	private boolean checkRow(int i, Player player) {
		char symbol = player.getSymbol();
		
		for(int j = 0; j < Constants.BOARD_SIZE; j++) {
			if(matrix[i][j] != symbol) {
				return false;
			}
		}
		
		return false;
	}
	
	private boolean checkCol(int j, Player player) {
		char symbol = player.getSymbol();
		
		for(int i = 0; i < Constants.BOARD_SIZE; i++) {
			if(matrix[i][j] != symbol) {
				return false;
			}
		}
		
		return true;
	}
	
	public boolean checkDiagonal1(Player player) {
		char symbol = player.getSymbol();
		
		for(int i = 0; i < Constants.BOARD_SIZE; i++) {
			if(matrix[i][i] != symbol) 
				return false;
		}
		
		return true;
	}
	
	private boolean checkDiagonal2(Player player) {
		char symbol = player.getSymbol();
		
		for(int p = 2, s = 0; p >= 0; p--, s++ ) {
			if(matrix[p][s] != symbol)
				return false;
		}
		
		return true;
	}
}
