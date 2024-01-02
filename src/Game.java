import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JOptionPane;
public class Game {
    static ArrayList<Game> gameList = new ArrayList<Game>();
    private String gameName;
    private int peopleAmount;
    static ArrayList<String> gameNameList = new ArrayList<String>();
//    private String[] defaultName = {"踩地雷", "炸彈人", "德州撲克", "五子棋"};
//    private int[] defaultAmounts = {1, 4, 8, 2};
    
 
    
    public Game(String gameName, int peopleAmount) {
	if(!hasGame(gameName)) {
		this.gameName = gameName;
		this.peopleAmount = peopleAmount;
		gameList.add(this);
		gameNameList.add(gameName);
		JOptionPane.showMessageDialog(null, "新增成功，遊戲名稱：" + this.gameName + " 遊戲人數：" + this.peopleAmount, "新增遊戲", JOptionPane.PLAIN_MESSAGE);;
	}
	else
	    JOptionPane.showMessageDialog(null, "新增失敗，已有相同遊戲名稱", "新增遊戲", JOptionPane.WARNING_MESSAGE);

    }
    
    public String getGameName() {
	return gameName;
    }
    
    public int getPeopleAmount() {
	return peopleAmount;
    }
    
    private boolean hasGame(String gameName) {
	return Game.gameNameList.contains(gameName);
    }
    
    public static String[] getGameList() {
	String[] list = new String[gameList.size()];
	for(int i = 0; i < gameList.size(); i++){
	    list[i] = gameList.get(i).getGameName();
	    
	}
	return list;
    }
    
    public static void initialize() {
	new Game("踩地雷", 1);
	new Game("炸彈人", 8);
	new Game("五子棋", 2);
	new Game("德州撲克", 4);
    }
    
    public static Game getGame(String gameName) {
	return gameList.get(gameNameList.indexOf(gameName));
    }
}
