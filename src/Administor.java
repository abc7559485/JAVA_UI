import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JOptionPane;

public class Administor {

    static ArrayList<Administor> list = new ArrayList<Administor>();
    static HashMap<String, Administor> administorList = new HashMap<String , Administor>();
    private String account;
    private String password;
    
    Administor(String account, String password){
	this.account = account;
	this.password = password;
	list.add(this);
	administorList.put(account, this);
    }
    
    public static boolean Login(String account, String password) {
	if(Administor.administorList.containsKey(account)) {
	    if(password.equals(Administor.administorList.get(account).password)) {
		return true;
	    }
	    else return false;
	}
	else return false;
    }
    
    
}
