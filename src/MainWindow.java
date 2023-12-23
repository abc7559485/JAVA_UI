import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.Font;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.JDesktopPane;
import javax.swing.JPanel;
import javax.swing.JLayeredPane;
import java.awt.Color;
import javax.swing.ImageIcon;

public class MainWindow extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static String Alphabet = "ABCDEFGHIJKLMNOPQRSTUVXYZ0123456789";
	private String checkCode;
	private JFrame frame;
	private JTextField AccountField;
	private JPasswordField passwordField;
	private JTextField checkcodeField;
	private JTextField SearchBar;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow window = new MainWindow();
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
	public MainWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("\u5927\u5DE8\u5DE2\u7AF6\u6280\u5E73\u53F0");
		frame.setBounds(100, 100, 1280, 720);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);
		
		
		AccountField = new JTextField();
		AccountField.setFont(new Font("新細明體", Font.PLAIN, 16));
		AccountField.setBounds(851, 416, 281, 36);
		frame.getContentPane().add(AccountField);
		AccountField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("新細明體", Font.PLAIN, 16));
		passwordField.setBounds(851, 471, 282, 36);
		frame.getContentPane().add(passwordField);
		
		checkcodeField = new JTextField();
		checkcodeField.setFont(new Font("新細明體", Font.PLAIN, 16));
		checkcodeField.setBounds(851, 526, 281, 36);
		frame.getContentPane().add(checkcodeField);
		checkcodeField.setColumns(10);
		
		JLabel account_1 = new JLabel("\u5E33\u865F\uFF1A");
		account_1.setFont(new Font("新細明體", Font.PLAIN, 24));
		account_1.setBounds(773, 421, 72, 30);
		frame.getContentPane().add(account_1);
		
		JLabel password = new JLabel("\u5BC6\u78BC\uFF1A");
		password.setFont(new Font("新細明體", Font.PLAIN, 24));
		password.setBounds(773, 471, 119, 45);
		frame.getContentPane().add(password);
		
		JLabel checkcode = new JLabel("\u9A57\u8B49\u78BC\uFF1A");
		checkcode.setFont(new Font("新細明體", Font.PLAIN, 24));
		checkcode.setBounds(749, 526, 119, 45);
		frame.getContentPane().add(checkcode);
		
		JLabel checkcode_display = new JLabel("\u9A57\u8B49\u78BC\uFF1A" + checkcode() );
		checkcode_display.setFont(new Font("新細明體", Font.PLAIN, 18));
		checkcode_display.setBounds(851, 636, 204, 36);
		frame.getContentPane().add(checkcode_display);
		
		JButton registButton = new JButton("\u8A3B\u518A");
		registButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Regist();
			}
		});
		registButton.setBounds(948, 581, 87, 45);
		frame.getContentPane().add(registButton);
		
		JButton LoginButton = new JButton("\u767B\u5165");
		LoginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String account = AccountField.getText();
				String password = new String(passwordField.getPassword());
				String checkcode = checkcodeField.getText();
				if(!(checkcode.equals(checkCode))) {
					JOptionPane.showMessageDialog(null,  "登入失敗，驗證碼錯誤");
					checkcode_display.setText("驗證碼： " + checkcode());
				}
				else if (Account.map.containsKey(account)) {
					if(password.equals(Account.map.get(account).getPassword())) {
						JOptionPane.showMessageDialog(null, ":");
						new MainWindow_Login();
						frame.setVisible(false);
						
					}
					else {
	            		JOptionPane.showMessageDialog(null, "登入失敗，密碼錯誤", "錯誤", JOptionPane.ERROR_MESSAGE);
	            	}
				}
				
				else {
	                JOptionPane.showMessageDialog(null, "登入失敗，請檢查使用者名稱和密碼", "錯誤", JOptionPane.ERROR_MESSAGE);
	                checkcode_display.setText("驗證碼： " + checkcode());
	            }
			}
		});
		LoginButton.setBounds(1045, 581, 87, 45);
		frame.getContentPane().add(LoginButton);
		
		
		JButton checkcodeButton = new JButton("\u9A57\u8B49\u78BC");
		checkcodeButton.setBounds(851, 581, 87, 45);
		frame.getContentPane().add(checkcodeButton);	
		
		SearchBar = new JTextField();
		SearchBar.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				SearchBar.setText("");
				
			}
			@Override
			public void focusLost(FocusEvent e) {
				SearchBar.setText("輸入文字搜尋聯盟、玩家、競賽紀錄等......");
			}
		});
		SearchBar.setFont(new Font("新細明體", Font.PLAIN, 16));
		SearchBar.setText("\u8F38\u5165\u6587\u5B57\u641C\u5C0B\u806F\u76DF\u3001\u73A9\u5BB6\u3001\u7AF6\u8CFD\u7D00\u9304\u7B49......");
		SearchBar.setBounds(140, 10, 1010, 36);
		frame.getContentPane().add(SearchBar);
		SearchBar.setColumns(10);
		
		JPanel panel = new JPanel();
		panel.setBounds(734, 391, 430, 281);
		frame.getContentPane().add(panel);
		
		
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(MainWindow.class.getResource("/Resource/MainWindow.jpg")));
		lblNewLabel.setBounds(0, 0, 1330, 697);
		frame.getContentPane().add(lblNewLabel);
		checkcodeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checkcode_display.setText("驗證碼： " + checkcode());
			}
		});
	}
	
	
	public String checkcode() { //產生驗證碼
    	String x = "";
    	for(int i = 0; i < 6; i++) {
    		x += Alphabet.charAt((int) (Math.random() * Alphabet.length()));
    	}
    	checkCode = x;
    	return x;
    }
	
	public JFrame getFrame() {
		return frame;
	}
}