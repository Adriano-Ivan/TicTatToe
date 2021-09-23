package br.com.adriano.tictactoe.ui;

import java.util.Scanner;

public class UI {
	
	public static void printText(String text) {
		System.out.println(text);
	}
	
	public static void printTextWithNoNewLine(String text) {
		System.out.print(text);
	}
	
	public static void printNewLine() {
		System.out.println();
	}
	
	public static void printGameTitle() {
		printText("=====================");
		printText("|   JOGO DA VELHA   |");
		printText("=====================");
	}
	
	public static String readInput(String text) {
		printTextWithNoNewLine(text + " ");
		
		Scanner sc = new Scanner(System.in);
		
		return sc.next();
	}
}
