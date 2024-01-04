import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SponsorRegist {

    private JFrame frame;
    private JTextField SponsorField;
    private JPasswordField passwordField;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
	EventQueue.invokeLater(new Runnable() {
	    public void run() {
		try {
		    SponsorRegist window = new SponsorRegist();
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
    public SponsorRegist() {
	initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
	frame = new JFrame();
	frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	frame.setBounds(100, 100, 378, 228);
	frame.setVisible(true);
	frame.setResizable(false);
	frame.getContentPane().setLayout(null);
	
	JLabel SponsorLabel = new JLabel("贊助商名稱：");
	SponsorLabel.setFont(new Font("新細明體", Font.PLAIN, 16));
	SponsorLabel.setBounds(10, 26, 104, 32);
	frame.getContentPane().add(SponsorLabel);
	
	SponsorField = new JTextField();
	SponsorField.setFont(new Font("新細明體", Font.PLAIN, 16));
	SponsorField.setBounds(109, 26, 243, 30);
	frame.getContentPane().add(SponsorField);
	SponsorField.setColumns(10);
	
	JLabel PasswordLabel = new JLabel("贊助商密碼：");
	PasswordLabel.setFont(new Font("新細明體", Font.PLAIN, 16));
	PasswordLabel.setBounds(10, 89, 104, 32);
	frame.getContentPane().add(PasswordLabel);
	
	passwordField = new JPasswordField();
	passwordField.setFont(new Font("新細明體", Font.PLAIN, 16));
	passwordField.setBounds(109, 91, 243, 30);
	frame.getContentPane().add(passwordField);
	
	JButton Return = new JButton("返回");
	Return.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		    frame.dispose();
		}
	});
	Return.setFont(new Font("新細明體", Font.PLAIN, 16));
	Return.setBounds(10, 138, 161, 41);
	frame.getContentPane().add(Return);
	
	JButton Regist = new JButton("註冊贊助商");
	Regist.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		    String name = SponsorField.getText();
		    if(name.equals("")) {
			JOptionPane.showMessageDialog(null, "贊助商名稱不能留白","贊助商註冊", JOptionPane.WARNING_MESSAGE);
		    }
		    else {
			String password = String.valueOf(passwordField.getPassword());
			if(password.length() >= 8 && password.length() <= 12) {
			    new Sponsor(name, password);
			    JOptionPane.showMessageDialog(null, "註冊成功", "贊助商註冊", JOptionPane.PLAIN_MESSAGE);
			    frame.dispose();
			}
			else {
			    JOptionPane.showMessageDialog(null, "請輸入8位元至12位元的密碼", "贊助商註冊", JOptionPane.WARNING_MESSAGE);
			}
		    }
		}
	});
	Regist.setFont(new Font("新細明體", Font.PLAIN, 16));
	Regist.setBounds(191, 138, 161, 41);
	frame.getContentPane().add(Regist);
    }
}
