import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import java.awt.Font;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LeagueContestHistory {

    private JFrame frame;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
	EventQueue.invokeLater(new Runnable() {
	    public void run() {
		try {
		    LeagueContestHistory window = new LeagueContestHistory();
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
    public LeagueContestHistory() {
	initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
	frame = new JFrame();
	frame.setBounds(100, 100, 484, 442);
	frame.setVisible(true);
	frame.getContentPane().setLayout(null);
	frame.setResizable(false);
	
	JComboBox<String> SelectGameMode = new JComboBox<String>();
	SelectGameMode.setModel(new DefaultComboBoxModel<String>(Game.getGameList()));
	SelectGameMode.setFont(new Font("新細明體", Font.PLAIN, 16));
	SelectGameMode.setBounds(331, 10, 127, 29);
	frame.getContentPane().add(SelectGameMode);
	
	JList<String> list = new JList<String>();
	list.setModel(new AbstractListModel() {
		String[] values = new String[] {"2024/01/02 20：40 德州撲克 勝", "2024/01/01 21：37 德州撲克 勝", "2023/12/02 10：25 德州撲克 勝", "2023/11/27 05：40 德州撲克 勝", "2023/11/24 06：08 德州撲克 勝", "2023/11/21 18：20 德州撲克 勝", "2023/11/10 06：00 德州撲克 勝", "2023/11/07 09：32 德州撲克 勝"};
		public int getSize() {
			return values.length;
		}
		public Object getElementAt(int index) {
			return values[index];
		}
	});
	list.setBounds(10, 10, 311, 383);
	frame.getContentPane().add(list);
	
	JButton DetailInfo = new JButton("詳細資訊");
	DetailInfo.setFont(new Font("新細明體", Font.PLAIN, 16));
	DetailInfo.setBounds(331, 62, 127, 44);
	frame.getContentPane().add(DetailInfo);
	
	JButton ViewContest = new JButton("觀看競賽");
	ViewContest.setFont(new Font("新細明體", Font.PLAIN, 16));
	ViewContest.setBounds(331, 135, 127, 44);
	frame.getContentPane().add(ViewContest);
	
	JButton Return = new JButton("返回");
	Return.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		    frame.setVisible(false);
		}
	});
	Return.setFont(new Font("新細明體", Font.PLAIN, 16));
	Return.setBounds(331, 209, 127, 44);
	frame.getContentPane().add(Return);
	
	
    }

}
