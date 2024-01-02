
public class User extends Account {
	
	private String account;
	private String password;
	private String mail;
	private String joinDate;
	
	private static boolean state;
	
	public boolean LoginState() { //登入狀態
		return state;
	}
	
	public User(Account account) {
	    this.account = account.getAccount();
	    this.password = account.getPassword();
	    this.mail = account.getMail();
	    state = true;
	}
	
	public void logout() {
	    state = false;
	}
	
	public String getAccount() {
	    return account;
	}
	
	public String getPassword() {
	    return password;
	}
	
	public String getMail() {
	    return mail;
	}
	
	public String getJoinDate() {
	    return joinDate;
	}
	
	public void JoinLeague(League league) {
	    this.league = league;
	}
}
