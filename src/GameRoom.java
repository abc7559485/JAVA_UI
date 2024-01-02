import java.util.ArrayList;
public class GameRoom {
    
    private String gameName;
    private String roomName;
    private int peopleAmount;
    private String roomPassword;
    private boolean lockOn = false;
    static ArrayList<GameRoom> roomList = new ArrayList<GameRoom>();

    
    
    public GameRoom(Game game, String roomName) {
	this.gameName = game.getGameName();
	this.peopleAmount = game.getPeopleAmount();
	this.roomName = roomName;
	roomList.add(this);
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
    
    

}
