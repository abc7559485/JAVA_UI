import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollBar;
import javax.swing.JLabel;
import javax.swing.ListSelectionModel;
import javax.swing.AbstractListModel;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LeagueWindow {

    private JFrame frame;
    private JTextField SearchBar;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
	EventQueue.invokeLater(new Runnable() {
	    public void run() {
		try {
		    LeagueWindow window = new LeagueWindow();
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
    public LeagueWindow() {
	initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
	frame = new JFrame();
	frame.setBounds(100, 100, 678, 550);
	frame.getContentPane().setLayout(null);
	frame.setVisible(true);
	frame.setResizable(false);
	
	SearchBar = new JTextField();
	SearchBar.addFocusListener(new FocusAdapter() {
		@Override
		public void focusGained(FocusEvent e) {
		    SearchBar.setText("");
		}
		public void focusLost(FocusEvent e) {
		    SearchBar.setText("搜尋成員......");
		}
	});
	SearchBar.setFont(new Font("新細明體", Font.PLAIN, 16));
	SearchBar.setText("搜尋成員......");
	SearchBar.setBounds(10, 10, 642, 28);
	frame.getContentPane().add(SearchBar);
	SearchBar.setColumns(10);
	
	JList MemberList = new JList();
	MemberList.setFont(new Font("新細明體", Font.PLAIN, 16));
	MemberList.setModel(new AbstractListModel() {
		String[] values = new String[] {"abc7559485", "User", "Administor"};
		public int getSize() {
			return values.length;
		}
		public Object getElementAt(int index) {
			return values[index];
		}
	});
	MemberList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	MemberList.setBounds(25, 79, 427, 391);
	frame.getContentPane().add(MemberList);
	
	JLabel MemberLabel = new JLabel("成員清單：");
	MemberLabel.setFont(new Font("新細明體", Font.PLAIN, 16));
	MemberLabel.setBounds(25, 51, 196, 28);
	frame.getContentPane().add(MemberLabel);
	
	JButton DetailInfo = new JButton("成員詳細資料");
	DetailInfo.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		    JOptionPane.showMessageDialog(null, "此功能尚未實作");
		}
	});
	DetailInfo.setFont(new Font("新細明體", Font.PLAIN, 16));
	DetailInfo.setBounds(462, 78, 190, 52);
	frame.getContentPane().add(DetailInfo);
	
	JButton LeagueColumn = new JButton("聯盟公佈欄");
	LeagueColumn.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		    new LeagueColumn();
		}
	});
	LeagueColumn.setFont(new Font("新細明體", Font.PLAIN, 16));
	LeagueColumn.setBounds(462, 156, 190, 52);
	frame.getContentPane().add(LeagueColumn);
	
	JButton LeagueManage = new JButton("聯盟管理");
	LeagueManage.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		    new LeagueManage();
		}
	});
	LeagueManage.setFont(new Font("新細明體", Font.PLAIN, 16));
	LeagueManage.setBounds(462, 317, 190, 52);
	frame.getContentPane().add(LeagueManage);
	
	JLabel lblNewLabel = new JLabel("<html>聯盟人數：3/32 <br/> 聯盟勝場：15場 <br/> 聯盟勝率：72% </html>");
	lblNewLabel.setFont(new Font("新細明體", Font.PLAIN, 16));
	lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
	lblNewLabel.setBounds(462, 397, 190, 73);
	frame.getContentPane().add(lblNewLabel);
	
	JButton LeagueContestHistory = new JButton("聯盟競賽紀錄");
	LeagueContestHistory.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		    new LeagueContestHistory();
		}
	});
	LeagueContestHistory.setFont(new Font("新細明體", Font.PLAIN, 16));
	LeagueContestHistory.setBounds(462, 235, 190, 52);
	frame.getContentPane().add(LeagueContestHistory);
    }
}
