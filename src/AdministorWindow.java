import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.AbstractListModel;
import javax.swing.ScrollPaneConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AdministorWindow {

    private JFrame frame;
    private JTextField textField;
    private JTextField textField_1;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
	EventQueue.invokeLater(new Runnable() {
	    public void run() {
		try {
		    AdministorWindow window = new AdministorWindow();
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
    public AdministorWindow() {
	initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
	frame = new JFrame();
	frame.setTitle("系統管理");
	frame.setBounds(100, 100, 1080, 720);
	frame.setResizable(false);
	frame.setVisible(true);
	
	JButton MemberButton = new JButton("用戶清單");
	MemberButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		    JOptionPane.showMessageDialog(null, "此功能尚未實作");
		}
	});
	MemberButton.setFont(new Font("新細明體", Font.PLAIN, 16));
	
	JButton ContestManage = new JButton("競賽管理");
	ContestManage.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		    JOptionPane.showMessageDialog(null, "此功能尚未實作");
		}
	});
	ContestManage.setFont(new Font("新細明體", Font.PLAIN, 16));
	
	JButton VersionInfo = new JButton("版本資訊");
	VersionInfo.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		    JOptionPane.showMessageDialog(null, "此功能尚未實作");
		}
	});
	VersionInfo.setFont(new Font("新細明體", Font.PLAIN, 16));
	
	JButton GameManage = new JButton("遊戲管理");
	GameManage.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		    new GameSetting();
		}
	});
	GameManage.setFont(new Font("新細明體", Font.PLAIN, 16));
	
	JButton LeagueManage = new JButton("聯盟管理");
	LeagueManage.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		    JOptionPane.showMessageDialog(null, "此功能尚未實作");
		}
	});
	LeagueManage.setFont(new Font("新細明體", Font.PLAIN, 16));
	
	JButton SponsorManage = new JButton("贊助管理");
	SponsorManage.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		    JOptionPane.showMessageDialog(null, "此功能尚未實作");
		}
	});
	SponsorManage.setFont(new Font("新細明體", Font.PLAIN, 16));
	
	textField = new JTextField();
	textField.setFont(new Font("新細明體", Font.PLAIN, 16));
	textField.setText("輸入文字搜尋......");
	textField.setColumns(10);
	
	JLabel lblNewLabel_1 = new JLabel("伺服器歷程記錄：\r\n");
	lblNewLabel_1.setFont(new Font("新細明體", Font.PLAIN, 16));
	
	JScrollPane scrollPane = new JScrollPane();
	scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
	
	textField_1 = new JTextField();
	textField_1.setColumns(10);
	
	JButton Return = new JButton("返回");
	Return.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		    frame.setVisible(false);
		    new MainWindow();
		}
	});
	Return.setFont(new Font("新細明體", Font.PLAIN, 16));
	
	

	
	GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
	groupLayout.setHorizontalGroup(
		groupLayout.createParallelGroup(Alignment.LEADING)
			.addGroup(groupLayout.createSequentialGroup()
				.addContainerGap()
				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
					.addComponent(MemberButton, GroupLayout.PREFERRED_SIZE, 194, GroupLayout.PREFERRED_SIZE)
					.addComponent(ContestManage, GroupLayout.PREFERRED_SIZE, 194, GroupLayout.PREFERRED_SIZE)
					.addComponent(VersionInfo, GroupLayout.PREFERRED_SIZE, 194, GroupLayout.PREFERRED_SIZE)
					.addComponent(GameManage, GroupLayout.PREFERRED_SIZE, 194, GroupLayout.PREFERRED_SIZE)
					.addComponent(LeagueManage, GroupLayout.PREFERRED_SIZE, 194, GroupLayout.PREFERRED_SIZE)
					.addComponent(SponsorManage, GroupLayout.PREFERRED_SIZE, 194, GroupLayout.PREFERRED_SIZE)
					.addComponent(Return, GroupLayout.PREFERRED_SIZE, 194, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(ComponentPlacement.RELATED)
				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
					.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 812, GroupLayout.PREFERRED_SIZE)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 811, GroupLayout.PREFERRED_SIZE)
					.addComponent(textField, GroupLayout.PREFERRED_SIZE, 826, GroupLayout.PREFERRED_SIZE)
					.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 221, GroupLayout.PREFERRED_SIZE))
				.addContainerGap(28, Short.MAX_VALUE))
	);
	groupLayout.setVerticalGroup(
		groupLayout.createParallelGroup(Alignment.LEADING)
			.addGroup(groupLayout.createSequentialGroup()
				.addContainerGap()
				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
					.addComponent(MemberButton, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
					.addGroup(groupLayout.createSequentialGroup()
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
						.addGap(30)
						.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)))
				.addPreferredGap(ComponentPlacement.RELATED)
				.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
					.addGroup(groupLayout.createSequentialGroup()
						.addComponent(ContestManage, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
						.addGap(18)
						.addComponent(VersionInfo, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
						.addGap(18)
						.addComponent(GameManage, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
						.addGap(18)
						.addComponent(LeagueManage, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
						.addGap(18)
						.addComponent(SponsorManage, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE))
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 341, GroupLayout.PREFERRED_SIZE))
				.addGap(18)
				.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
					.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 189, GroupLayout.PREFERRED_SIZE)
					.addComponent(Return, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE))
				.addContainerGap(20, Short.MAX_VALUE))
	);
	
	JList list = new JList();
	list.setModel(new AbstractListModel() {
		String[] values = new String[] {"2024/1/2 11:18 server test", "2024/1/2 11:18 server test", "2024/1/2 11:18 server test", "2024/1/2 11:18 server test", "2024/1/2 11:18 server test", "2024/1/2 11:18 server test", "2024/1/2 11:18 server test", "2024/1/2 11:18 server test", "2024/1/2 11:18 server test", "2024/1/2 11:18 server test", "2024/1/2 11:18 server test", "2024/1/2 11:18 server test", "2024/1/2 11:18 server test", "2024/1/2 11:18 server test", "2024/1/2 11:18 server test", "2024/1/2 11:18 server test", "2024/1/2 11:18 server test", "2024/1/2 11:18 server test", "2024/1/2 11:18 server test", "2024/1/2 11:18 server test", "2024/1/2 11:18 server test", "2024/1/2 11:18 server test", "2024/1/2 11:18 server test", "2024/1/2 11:18 server test", "2024/1/2 11:18 server test", "2024/1/2 11:18 server test", "2024/1/2 11:18 server test", "2024/1/2 11:18 server test", "2024/1/2 11:18 server test"};
		public int getSize() {
			return values.length;
		}
		public Object getElementAt(int index) {
			return values[index];
		}
	});
	scrollPane.setViewportView(list);
	frame.getContentPane().setLayout(groupLayout);
	frame.setVisible(true);
    }
}
