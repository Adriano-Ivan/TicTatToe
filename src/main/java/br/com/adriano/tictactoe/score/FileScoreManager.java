package br.com.adriano.tictactoe.score;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
//import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import br.com.adriano.tictactoe.core.Player;

public class FileScoreManager implements ScoreManager{

	private static final Path SCORE_FILE = Path.of("score.txt");
	private Map<String, Integer> scoreMap = new HashMap<>();
	
	public FileScoreManager() throws IOException{
		setUp();
	}
	
	private void setUp() throws IOException{
		if(!Files.exists(SCORE_FILE)) {
			Files.createFile(SCORE_FILE);
//			Path pathToFile = Paths.get("score.txt");
//		    System.out.println(pathToFile.toAbsolutePath());
		}
		
		try(BufferedReader reader = Files.newBufferedReader(SCORE_FILE)) {
			String line;
			
			while((line = reader.readLine()) != null) {
				String[] tokens = line.split("\\|");
				
				scoreMap.put(tokens[0], Integer.parseInt(tokens[1]));
			}
		}
		//reader.close();
	}
	@Override
	public Integer getScore(Player player) {
		return scoreMap.get(player.getName().toUpperCase());
	}
	
	@Override
	public void saveScore(Player player) throws IOException {
		Integer score = getScore(player);
		
		if(score == null) {
			score = 0;
		}
		
		int newScore = score + 1;
		scoreMap.put(player.getName().toUpperCase(), newScore);
		
		try(BufferedWriter writer = Files.newBufferedWriter(SCORE_FILE)) {
			Set<Map.Entry<String, Integer>> entries = scoreMap.entrySet();
			
			for(Map.Entry<String, Integer> entry : entries) {
				String name = entry.getKey().toUpperCase();
				Integer s = entry.getValue();
				writer.write(name + "|" + s);
				writer.newLine();
			}
		}
	}
}
