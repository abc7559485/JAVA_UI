
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Regist extends JFrame implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JPanel panel;
	JLabel usernameLabel;
	JLabel passwordLabel;
	JLabel usermailLabel;
	JLabel passwordLabel2;
	JTextField usernameField;
	JTextField passwordField;
	JTextField usermailField;
	JTextField passwordField2;
	JButton regist;

	Regist(){
		setTitle("註冊");
		setSize(400, 300);

		panel = new JPanel();
		panel.setLayout(null);
		setResizable(false);

		usernameLabel = new JLabel("帳號：");
        usernameLabel.setBounds(40, 10, 100, 30);
        usernameField = new JTextField();
        usernameField.setBounds(130, 10, 200, 30);

        passwordLabel = new JLabel("密碼：");
        passwordLabel.setBounds(40, 50, 100, 30);
        passwordField = new JPasswordField();
        passwordField.setBounds(130, 50, 200, 30);

        passwordLabel2 = new JLabel("重複密碼：");
        passwordLabel2.setBounds(40, 90, 100, 30);
        passwordField2 = new JPasswordField();
        passwordField2.setBounds(130, 90, 200, 30);

        usermailLabel = new JLabel("電子信箱：");
        usermailLabel.setBounds(40, 130, 100, 30);
        usermailField = new JTextField();
        usermailField.setBounds(130, 130, 200, 30);

        regist = new JButton("註冊");
        regist.setBounds(130, 170, 100, 30);


        panel.add(usernameLabel);
        panel.add(usernameField);
        panel.add(passwordLabel);
        panel.add(passwordField);
        panel.add(passwordLabel2);
        panel.add(passwordField2);
        panel.add(usermailLabel);
        panel.add(usermailField);
        panel.add(regist);

        regist.addActionListener(this);

		add(panel);
		setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == regist) {
			String username = usernameField.getText();
			String password = passwordField.getText();
			String password2 = passwordField2.getText();
			String mail = usermailField.getText();
			if(username.equals("")) {
				JOptionPane.showMessageDialog(this, "使用者名稱不能為空白", "錯誤", JOptionPane.ERROR_MESSAGE);
			}
			else if(password.length() < 8 || password.length() > 16) {
				JOptionPane.showMessageDialog(this, "密碼長度需介於8至16位元之間", "錯誤", JOptionPane.ERROR_MESSAGE);
			}
			else if(!mail.contains("@")) {
				JOptionPane.showMessageDialog(this, "錯誤的電子信箱格式", "錯誤", JOptionPane.ERROR_MESSAGE);
			}
			else if((Account.map.containsKey(usernameField.getText()))) {
				JOptionPane.showMessageDialog(this, "該使用者名稱已被註冊", "錯誤", JOptionPane.ERROR_MESSAGE);
			}										
			else if(!password.equals(password2)){
				JOptionPane.showMessageDialog(this, "密碼錯誤", "錯誤", JOptionPane.ERROR_MESSAGE);
			}										
			else {
				new Account(username, password, mail);
				JOptionPane.showMessageDialog(this, "註冊成功");
				setVisible(false);
			}										
		}
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> new Regist());
	}
}