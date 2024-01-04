import java.util.ArrayList;

import javax.swing.JOptionPane;

public class League {
    private String name;
    private ArrayList<Account> memberList = new ArrayList<Account>();
    static ArrayList<League> leagueList = new ArrayList<League>();
    private Account creator;
    private String LeagueColumn;
    private static final String DEFAULT_COLUMN = "<html>此聯盟為測試初始聯盟<br/>歡迎大家加入這個家庭<br/>有任何問題皆可找管理員提出</html>";
    
    public League(String name, Account creator) { //創建聯盟
	this.name = name;
	this.creator = creator;
	memberList.add(creator);
	leagueList.add(this);
    }
    
    
    public void JoinLeague(Account member) { //加入聯盟
	if(!member.JoinLeague) {
	    memberList.add(member);
	    JOptionPane.showMessageDialog(null, "加入成功", "加入成功", JOptionPane.PLAIN_MESSAGE);
	    Start.currentAccount.JoinLeague(this);
	    member.JoinLeague = true;
	    
	}
	else {
	    JOptionPane.showMessageDialog(null, "當前帳號已有加入聯盟", "加入失敗", JOptionPane.WARNING_MESSAGE);
	}
    }
    
    public String getCreatorName() {
	return creator.getAccount();
    }
    
    public int getMemberAmounts() {
	return memberList.size();
    }
    
    public String getLeagueName() {
	return name;
    }
    
    public String toString() {
	return "<html>聯盟名稱：" + name + "<br/>聯盟人數：" + this.getMemberAmounts() + "/36</html>";
    }
    
    public void setColumn(String column) {
	LeagueColumn = column;
    }
    
    public String getColumn() {
	if (LeagueColumn == null) {
	    return DEFAULT_COLUMN;
	}
	else {
	    return LeagueColumn;
	}
	
	
    }
    
    
}
