import java.util.ArrayList;
import java.util.HashMap;
public class GameRoom {
    
    private String gameName;
    private String roomName;
    private int peopleAmount;
    private String roomPassword;
    private boolean lockOn = false;
    static HashMap<String, GameRoom> roomList = new HashMap<String, GameRoom>();
    private ArrayList<Account> playerList = new ArrayList<Account>();
    private int playerAmounts = 0;

    
    
    public GameRoom(Game game, String roomName) {
	this.gameName = game.getGameName();
	this.peopleAmount = game.getPeopleAmount();
	this.roomName = roomName;
	roomList.put(roomName, this);
    }
    
    public void setPassword(String password) {
	this.roomPassword = password;
	lockOn = true;
    }
    
    public String toString() {
	if(!lockOn)
	    return roomName + "  0/" + peopleAmount + " 遊戲模式：" + gameName; 
	else
	    return roomName + "  0/" + peopleAmount + " 遊戲模式：" + gameName + " 需要密碼";
    }
    
    public boolean needPassword() {
	return lockOn;
    }
    
    public static String[] getGameroomList() {
	String[] list = new String[roomList.size()];
	int i = 0;
	for(String roomName : roomList.keySet()) {
	    list[i] = roomList.get(roomName).toString();
	    i++;
	}
	return list;
    }
    
    public String[] playerString() {
	String[] list = new String[playerList.size()];
	for(int i = 0; i < playerList.size(); i++) {
	    list[i] = playerList.get(i).getAccount();
	}
	return list;
    }
    
    public void enterRoom(Account account) {
	playerList.add(account);
	playerAmounts++;
    }
    
    public int getPlayerAmounts() {
	return playerAmounts;
    }
    
    public void exitRoom(Account account) {
	playerList.remove(account);
	playerAmounts--;
    }
    
    public String detailInfo() {
	return "<html>房間名稱：" + roomName + "<br/>房間人數：" + playerAmounts + "/" + peopleAmount + "</html>";
    }

}
