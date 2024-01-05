import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class AdministorLogin {

    private JFrame frame;
    private JTextField AccountField;
    private JPasswordField passwordField;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
	EventQueue.invokeLater(new Runnable() {
	    public void run() {
		try {
		    AdministorLogin window = new AdministorLogin();
		    window.frame.setVisible(true);
		} catch (Exception e) {
		    e.printStackTrace();
		}
	    }
	});
    }

    /**
     * Create the application.
     */
    public AdministorLogin() {
	initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
	frame = new JFrame();
	frame.setTitle("管理員登入");
	frame.setBounds(100, 100, 450, 228);
	frame.setVisible(true);
	frame.setResizable(false);
	frame.getContentPane().setLayout(null);
	
	JLabel AdministorAccount = new JLabel("管理員帳號：");
	AdministorAccount.setFont(new Font("新細明體", Font.PLAIN, 16));
	AdministorAccount.setBounds(10, 10, 135, 42);
	frame.getContentPane().add(AdministorAccount);
	
	AccountField = new JTextField();
	AccountField.setBounds(119, 16, 305, 32);
	frame.getContentPane().add(AccountField);
	AccountField.setColumns(10);
	
	JLabel PasswordLabel = new JLabel("管理員密碼：");
	PasswordLabel.setFont(new Font("新細明體", Font.PLAIN, 16));
	PasswordLabel.setBounds(10, 79, 135, 42);
	frame.getContentPane().add(PasswordLabel);
	
	JButton Return = new JButton("返回");
	Return.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		    frame.setVisible(false);
		    
		}
	});
	Return.setFont(new Font("新細明體", Font.PLAIN, 16));
	Return.setBounds(10, 131, 197, 48);
	frame.getContentPane().add(Return);
	
	JButton LoginButton = new JButton("登入");
	LoginButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		    String account = AccountField.getText();	
		    String password =String.valueOf(passwordField.getPassword());		    
		    
		    if(Administor.Login(account, password)) {
			JOptionPane.showMessageDialog(null, "登入成功，管理員身分", "管理員登入", JOptionPane.PLAIN_MESSAGE);
			new AdministorWindow();
			frame.setVisible(false);
		    }
		    else {
			JOptionPane.showMessageDialog(null, "登入失敗，用戶名稱或密碼錯誤", "管理員登入", JOptionPane.WARNING_MESSAGE);
		    }
		}
	});
	LoginButton.setFont(new Font("新細明體", Font.PLAIN, 16));
	LoginButton.setBounds(227, 131, 197, 48);
	frame.getContentPane().add(LoginButton);
	
	passwordField = new JPasswordField();
	passwordField.setBounds(119, 79, 305, 32);
	frame.getContentPane().add(passwordField);
    }
}
