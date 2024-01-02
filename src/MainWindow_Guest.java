import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.SwingConstants;

public class MainWindow_Guest {

    private JFrame frame;
    private JTextField textField;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
	EventQueue.invokeLater(new Runnable() {
	    public void run() {
		try {
		    MainWindow_Guest window = new MainWindow_Guest();
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
    public MainWindow_Guest() {
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
	textField.addFocusListener(new FocusAdapter() {
		@Override
		public void focusGained(FocusEvent e) {
		    textField.setText("");
		}
		@Override
		public void focusLost(FocusEvent e) {
		    textField.setText("輸入文字搜尋聯盟、玩家、競賽紀錄等......");
		}
	});
	
	JPanel panel_1 = new JPanel();
	panel_1.setLayout(null);
	panel_1.setBounds(731, 133, 433, 251);
	frame.getContentPane().add(panel_1);
	
	JLabel lblNewLabel_1_1 = new JLabel("公告：此競技平台仍在測試，敬請隨時更新");
	lblNewLabel_1_1.setBounds(10, 10, 544, 59);
	panel_1.add(lblNewLabel_1_1);
	textField.setText("輸入文字搜尋聯盟、玩家、競賽紀錄等......");
	textField.setFont(new Font("新細明體", Font.PLAIN, 16));
	textField.setColumns(10);
	textField.setBounds(141, 10, 1010, 36);
	frame.getContentPane().add(textField);
	
	JPanel panel = new JPanel();
	panel.setBounds(732, 401, 435, 270);
	frame.getContentPane().add(panel);
	panel.setLayout(null);
	
	JButton LogoutButton = new JButton("登出");
	LogoutButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		    int result = JOptionPane.showConfirmDialog(frame, "確定要離開嗎？", "登出", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
		    if(result == JOptionPane.YES_OPTION) {
			frame.setVisible(false);
			MainWindow mainwindow = new MainWindow();
			mainwindow.getFrame().setVisible(true);
		    }
		}
	});
	LogoutButton.setFont(new Font("新細明體", Font.PLAIN, 16));
	LogoutButton.setBounds(10, 216, 114, 44);
	panel.add(LogoutButton);
	
	JButton ViewContest = new JButton("觀戰競賽");
	ViewContest.setFont(new Font("新細明體", Font.PLAIN, 16));
	ViewContest.setBounds(164, 216, 114, 44);
	panel.add(ViewContest);
	
	JLabel lblNewLabel_1 = new JLabel("登入以使用更多功能");
	lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
	lblNewLabel_1.setFont(new Font("新細明體", Font.PLAIN, 16));
	lblNewLabel_1.setBounds(10, 10, 415, 189);
	panel.add(lblNewLabel_1);
	
	JButton ViewContest_1 = new JButton("聯盟列表");
	ViewContest_1.setFont(new Font("新細明體", Font.PLAIN, 16));
	ViewContest_1.setBounds(311, 216, 114, 44);
	panel.add(ViewContest_1);
	
	JLabel lblNewLabel_2 = new JLabel("New label");
	lblNewLabel_2.setBounds(99, 153, 480, 461);
	frame.getContentPane().add(lblNewLabel_2);
	lblNewLabel_2.setIcon(new ImageIcon(MainWindow_Guest.class.getResource("/Resource/toothless-dance.gif")));
	
	JLabel lblNewLabel = new JLabel("New label");
	lblNewLabel.setIcon(new ImageIcon(MainWindow_Login.class.getResource("/Resource/MainWindow.jpg")));
	lblNewLabel.setBounds(0, 0, 1264, 681);
	frame.getContentPane().add(lblNewLabel);
	frame.setVisible(true);
	
	
	
    }
}
