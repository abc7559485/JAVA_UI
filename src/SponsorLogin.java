import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;

public class SponsorLogin {

    private JFrame frame;
    private JTextField textField;
    private JPasswordField passwordField;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
	EventQueue.invokeLater(new Runnable() {
	    public void run() {
		try {
		    SponsorLogin window = new SponsorLogin();
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
    public SponsorLogin() {
	initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
	frame = new JFrame();
	frame.setBounds(100, 100, 395, 235);
	frame.getContentPane().setLayout(null);
	frame.setVisible(true);
	frame.setResizable(false);
	
	JButton LoginButton = new JButton("登入");
	LoginButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		    String account = textField.getText();
		    String password = String.valueOf(passwordField.getPassword());
		    if(Sponsor.SponsorList.containsKey(account)) {
			if(password.equals(Sponsor.SponsorList.get(account).getPassword())) {
			    Sponsor.Login(account);
			    JOptionPane.showMessageDialog(null, "登入成功", "贊助商登入", JOptionPane.PLAIN_MESSAGE);
			    frame.setVisible(false);
			}
			else {
			    JOptionPane.showMessageDialog(null, "登入失敗，贊助商名稱或密碼錯誤", "贊助商登入", JOptionPane.WARNING_MESSAGE);
			}
		    }
		    else {
			JOptionPane.showMessageDialog(null, "登入失敗，贊助商名稱或密碼錯誤", "贊助商登入", JOptionPane.WARNING_MESSAGE);
		    }
		    
		}
	});
	LoginButton.setFont(new Font("Dialog", Font.PLAIN, 16));
	LoginButton.setBounds(251, 137, 118, 45);
	frame.getContentPane().add(LoginButton);
	
	JButton ReturnButton = new JButton("返回");
	ReturnButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		    frame.setVisible(false);
		}
	});
	ReturnButton.setFont(new Font("Dialog", Font.PLAIN, 16));
	ReturnButton.setBounds(10, 137, 118, 45);
	frame.getContentPane().add(ReturnButton);
	
	JButton RegistButton = new JButton("註冊");
	RegistButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		    new SponsorRegist();
		}
	});
	RegistButton.setFont(new Font("Dialog", Font.PLAIN, 16));
	RegistButton.setBounds(130, 137, 118, 45);
	frame.getContentPane().add(RegistButton);
	
	JLabel Name = new JLabel("贊助商名稱：");
	Name.setFont(new Font("新細明體", Font.PLAIN, 16));
	Name.setBounds(10, 10, 105, 31);
	frame.getContentPane().add(Name);
	
	textField = new JTextField();
	textField.setFont(new Font("新細明體", Font.PLAIN, 16));
	textField.setBounds(109, 10, 260, 26);
	frame.getContentPane().add(textField);
	textField.setColumns(10);
	
	JLabel Password = new JLabel("贊助商密碼：");
	Password.setFont(new Font("新細明體", Font.PLAIN, 16));
	Password.setBounds(10, 61, 105, 31);
	frame.getContentPane().add(Password);
	
	passwordField = new JPasswordField();
	passwordField.setBounds(109, 64, 260, 26);
	frame.getContentPane().add(passwordField);
    }
}
