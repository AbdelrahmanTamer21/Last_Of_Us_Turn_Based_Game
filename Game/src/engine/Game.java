package engine;

import java.io.*;
import java.util.ArrayList;

import model.characters.*;
import model.world.Cell;

public class Game {
	public static ArrayList<Hero> availableHeroes;
	public static ArrayList<Hero> heroes;
	public static ArrayList<Zombie> zombies;
	public static Cell [][] map;
	
	public static void loadHeroes(String filepath) throws Exception{
		BufferedReader br = new BufferedReader(new FileReader(filepath));
		availableHeroes = new ArrayList<Hero>();
		String line = "";
		while((line=br.readLine())!=null) {
			String[] herosList = line.split(",");
			String type = herosList[1];
			String name = herosList[0];
			int maxHp = Integer.parseInt(herosList[2]);
			int maxActions = Integer.parseInt(herosList[3]);
			int attackDmg = Integer.parseInt(herosList[4]);
			switch(type) {
				case "FIGH":
					availableHeroes.add(new Fighter(name, maxHp, attackDmg,maxActions));
					break;
				case "MED":
					availableHeroes.add(new Medic(name, maxHp, attackDmg,maxActions));
					break;
				case "EXP":
					availableHeroes.add(new Explorer(name, maxHp, attackDmg,maxActions));
					break;
			}
		}
		br.close();
	}
	
	public static void main(String[] args) {
		try {
			loadHeroes("Heros.csv");
			for(int i = 0;i<availableHeroes.size();i++) {
				System.out.println(availableHeroes.get(i));
			}
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
	}
}
