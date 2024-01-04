import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LeagueManage {

    private JFrame frame;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
	EventQueue.invokeLater(new Runnable() {
	    public void run() {
		try {
		    LeagueManage window = new LeagueManage();
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
    public LeagueManage() {
	initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
	frame = new JFrame();
	frame.setTitle("聯盟管理");
	frame.setBounds(100, 100, 554, 440);
	frame.setVisible(true);
	frame.getContentPane().setLayout(null);
	frame.setResizable(false);
	
	JButton MemberSetting = new JButton("成員設定");
	MemberSetting.setFont(new Font("新細明體", Font.PLAIN, 16));
	MemberSetting.setBounds(92, 218, 141, 54);
	frame.getContentPane().add(MemberSetting);
	
	JButton LeagueColumn = new JButton("聯盟公告");
	LeagueColumn.setFont(new Font("新細明體", Font.PLAIN, 16));
	LeagueColumn.setBounds(92, 127, 141, 54);
	frame.getContentPane().add(LeagueColumn);
	
	JButton JoinContest = new JButton("參加競賽");
	JoinContest.setFont(new Font("新細明體", Font.PLAIN, 16));
	JoinContest.setBounds(92, 45, 141, 54);
	frame.getContentPane().add(JoinContest);
	
	JButton LeagueLevel = new JButton("聯盟階級");
	LeagueLevel.setFont(new Font("新細明體", Font.PLAIN, 16));
	LeagueLevel.setBounds(308, 127, 141, 54);
	frame.getContentPane().add(LeagueLevel);
	
	JButton CreateContest = new JButton("創立競賽");
	CreateContest.setFont(new Font("新細明體", Font.PLAIN, 16));
	CreateContest.setBounds(308, 45, 141, 54);
	frame.getContentPane().add(CreateContest);
	
	JButton LeagueSetting = new JButton("聯盟設定");
	LeagueSetting.setFont(new Font("新細明體", Font.PLAIN, 16));
	LeagueSetting.setBounds(308, 218, 141, 54);
	frame.getContentPane().add(LeagueSetting);
	
	JButton Return = new JButton("返回");
	Return.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		    frame.setVisible(false);
		}
	});
	Return.setFont(new Font("新細明體", Font.PLAIN, 16));
	Return.setBounds(197, 306, 141, 54);
	frame.getContentPane().add(Return);
    }
}
