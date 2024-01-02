import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class MainWindow_Login {

    private JFrame frame;
    private JTextField textField;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
	EventQueue.invokeLater(new Runnable() {
	    public void run() {
		try {
		    MainWindow_Login window = new MainWindow_Login();
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
    public MainWindow_Login() {
	initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
	frame = new JFrame();
	frame.setTitle("大巨巢電子競技平台");
	frame.setBounds(100, 100, 1280, 720);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.getContentPane().setLayout(null);
	frame.setResizable(false);
	
	textField = new JTextField();
	textField.setText("輸入文字搜尋聯盟、玩家、競賽紀錄等......");
	textField.setFont(new Font("新細明體", Font.PLAIN, 16));
	textField.setColumns(10);
	textField.setBounds(139, 10, 1010, 36);
	frame.getContentPane().add(textField);
	
	JPanel panel = new JPanel();
	panel.setBounds(772, 405, 353, 218);
	frame.getContentPane().add(panel);
	panel.setLayout(null);
	
	JLabel UserNameLabel = new JLabel("使用者名稱：" + Start.user.getAccount());
	UserNameLabel.setFont(new Font("Dialog", Font.PLAIN, 16));
	UserNameLabel.setBounds(10, 10, 317, 33);
	panel.add(UserNameLabel);
	
	JLabel UserMailLable = new JLabel("電子郵件：" + Start.user.getMail());
	UserMailLable.setFont(new Font("Dialog", Font.PLAIN, 16));
	UserMailLable.setBounds(10, 53, 317, 33);
	panel.add(UserMailLable);
	
	JButton LogoutButton = new JButton("登出");
	LogoutButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		    int result = JOptionPane.showConfirmDialog(frame, "確定要離開嗎？", "登出", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
		    
		    if(result == JOptionPane.YES_OPTION) {
			    frame.setVisible(false);
			    Start.user.logout();
			    MainWindow mainwindow = new MainWindow();
			    mainwindow.getFrame().setVisible(true);
		    } 
		}
	});
	LogoutButton.setFont(new Font("新細明體", Font.PLAIN, 16));
	LogoutButton.setBounds(10, 118, 106, 41);
	panel.add(LogoutButton);
	
	JButton PlayerButton = new JButton("玩家資訊");
	PlayerButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		    new PlayerInfo();
		}
	});
	PlayerButton.setFont(new Font("新細明體", Font.PLAIN, 16));
	PlayerButton.setBounds(126, 118, 106, 41);
	panel.add(PlayerButton);
	
	JButton LobbyButton = new JButton("進入大廳");
	LobbyButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		    new Lobby();
		}
	});
	LobbyButton.setFont(new Font("新細明體", Font.PLAIN, 16));
	LobbyButton.setBounds(237, 118, 106, 41);
	panel.add(LobbyButton);
	
	JButton JoinLeague = new JButton("加入聯盟");
	JoinLeague.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		    new JoinLeague();
		}
	});
	JoinLeague.setFont(new Font("新細明體", Font.PLAIN, 16));
	JoinLeague.setBounds(10, 169, 160, 39);
	panel.add(JoinLeague);
	
	JButton LeagueInfo = new JButton("聯盟資訊");
	LeagueInfo.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		    if(Start.currentAccount.JoinLeague) {
			new LeagueWindow();
		    }
		    else {
			JOptionPane.showConfirmDialog(null, "此帳號尚未加入任何聯盟", "聯盟資訊", JOptionPane.WARNING_MESSAGE);
		    }
		}
	});
	LeagueInfo.setFont(new Font("新細明體", Font.PLAIN, 16));
	LeagueInfo.setBounds(183, 169, 160, 39);
	panel.add(LeagueInfo);
	
	JLabel lblNewLabel_2 = new JLabel("New label");
	lblNewLabel_2.setIcon(new ImageIcon(MainWindow_Login.class.getResource("/Resource/toothless-dance.gif")));
	lblNewLabel_2.setBounds(114, 150, 480, 461);
	frame.getContentPane().add(lblNewLabel_2);
	
	JPanel panel_1_1 = new JPanel();
	panel_1_1.setLayout(null);
	panel_1_1.setBounds(720, 118, 433, 251);
	frame.getContentPane().add(panel_1_1);
	
	JLabel lblNewLabel_1_1 = new JLabel("公告：此競技平台仍在測試，敬請隨時更新");
	lblNewLabel_1_1.setBounds(10, 10, 544, 59);
	panel_1_1.add(lblNewLabel_1_1);
	
	JLabel lblNewLabel = new JLabel("New label");
	lblNewLabel.setIcon(new ImageIcon(MainWindow_Login.class.getResource("/Resource/MainWindow.jpg")));
	lblNewLabel.setBounds(0, 0, 1264, 681);
	frame.getContentPane().add(lblNewLabel);
	frame.setVisible(true);
	
	
	
    }
}
