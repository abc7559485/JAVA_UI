public class Start {
	public static Account defaultUser = new Account();
	public static User user;
	public static Account currentAccount;
	public static League defaultLeague = new League("初始聯盟", defaultUser);
	public static Administor defaultAdmin = new Administor("admin", "password"); //預設管理員帳號密碼
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	    	Game.initialize();
		MainWindow mainwindow = new MainWindow();
		
		mainwindow.getFrame().setVisible(true);
	}

}