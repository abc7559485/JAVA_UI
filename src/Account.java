import java.util.HashMap;
public class Account {
	private String account;
	private String password;
	private String mail;
	static HashMap<String, Account> map = new HashMap<String, Account>();
	private boolean state;

	Account(){
		map.put("user", new Account("user", "password", "name@.mail.com"));
	}

	Account(String account, String password){ //µn¤J±b¸¹
		this.account = account;
		this.password = Account.map.get(account).password;
		this.mail = Account.map.get(account).mail;
		state = true;
	}


	Account(String account, String password, String mail){ //µù¥U±b¸¹
		this.account = account;
		this.password = password;
		this.mail = mail;
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
}
