import java.util.HashMap;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
public class Account {
	private String account;
	private String password;
	private String mail;
	static HashMap<String, Account> map = new HashMap<String, Account>();
	private boolean state;
	private String joinDate;
	protected boolean JoinLeague;
	protected League league;

	Account(){
		map.put("user", new Account("user", "password", "name@.mail.com"));
	}

	Account(String account, String password){ //登入帳號
		this.account = account;
		this.password = Account.map.get(account).password;
		this.mail = Account.map.get(account).mail;
		state = true;
	}


	Account(String account, String password, String mail){ //創建帳號
		this.account = account;
		this.password = password;
		this.mail = mail;
		DateTimeFormatter dtf5 = DateTimeFormatter.ofPattern("yyyy/MM/dd hh:mm");
		joinDate = dtf5.format(LocalDateTime.now());
		map.put(account, this);
	}

	public String getPassword(){
		return password;
	}
	public String getAccount(){
		return account;
	}
	public String getMail(){
		return mail;
	}

	public static String getPassword(String account){
		return Account.map.get(account).password;
	}
	
	public boolean LoginState() {
		return state;
	}
	public String getJoinDate() {
	    return joinDate;
	}
	
	public void JoinLeague(League league) {
	    JoinLeague = true;
	    this.league = league;
	}
	
	public String getLeagueInfo(){
	    return this.toString();
	}
}
