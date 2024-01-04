import java.util.HashMap;

import javax.swing.JOptionPane;

public class Sponsor {
    private String name;
    private String password;
    private int plan = 0;
    static HashMap<String, Sponsor> SponsorList = new HashMap<String, Sponsor>();
    private static boolean state = false;
    
    public static void Login(String name) {
	Start.currentSponsor = SponsorList.get(name);
	state = true;
    }
    
    public void Logout() {
	Start.currentSponsor = null;
	state = false;
    }
    
    Sponsor(String name, String password){
	this.name = name;
	this.password = password;
	SponsorList.put(name, this);
    }
    
    public String getPlan() {
	if(plan == 1) {
	    return "月費方案";
	}
	else if(plan == 2) {
	    return "年費方案";
	}
	else if(plan == 3) {
	    return "終生方案";
	}
	else {
	    return "此贊助商尚未選擇任何方案";
	}
    }
    
    public boolean hasPlan() {
	if(plan > 0 && plan < 4) {
	    return true;
	}
	else {
	    //JOptionPane.showMessageDialog(null, "此贊助商尚未選擇方案", "選擇方案", JOptionPane.WARNING_MESSAGE);
	    return false;
	}
    }
    
    public void changePlan(int plan) {
	if(this.hasPlan()) {
	    int result = JOptionPane.showConfirmDialog(null, "是否要換成此方案", "改變方案", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
	    if(result == JOptionPane.YES_OPTION) {
		this.plan = plan;
		JOptionPane.showMessageDialog(null, "改變成功", "改變方案", JOptionPane.PLAIN_MESSAGE);
	    }
	}
	else {
	    JOptionPane.showMessageDialog(null, "此贊助商尚未選擇方案", "改變方案", JOptionPane.WARNING_MESSAGE);
	}
    }
    
    public void setPlan(int plan) {
	if(!this.hasPlan()) {
	    this.plan = plan;
	    JOptionPane.showMessageDialog(null, "贊助成功", "選擇方案", JOptionPane.PLAIN_MESSAGE);
	}
	else
	    JOptionPane.showMessageDialog(null, "此贊助商已有贊助方案","選擇方案", JOptionPane.WARNING_MESSAGE);
    }
    
    public String getPassword() {
	return password;
    }
    
    public static boolean State() {
	return state;
    }
    
}
