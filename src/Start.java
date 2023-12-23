public class Start {
	public static Account administor = new Account("user", "password", "name@mail.com");
	static Account user;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MainWindow mainwindow = new MainWindow();

		mainwindow.getFrame().setVisible(true);
	}

}