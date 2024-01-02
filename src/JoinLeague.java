import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class JoinLeague {

    private JFrame frame;
    private JTextField SearchLeague;
    private JButton JoinLeague;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
	EventQueue.invokeLater(new Runnable() {
	    public void run() {
		try {
		    JoinLeague window = new JoinLeague();
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
    public JoinLeague() {
	initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
	frame = new JFrame();
	frame.setTitle("加入聯盟");
	frame.setBounds(100, 100, 450, 300);
	frame.getContentPane().setLayout(null);
	frame.setVisible(true);
	frame.setResizable(false);
	
	SearchLeague = new JTextField();
	SearchLeague.addFocusListener(new FocusAdapter() {
		@Override
		public void focusGained(FocusEvent e) {
		    SearchLeague.setText("");
		}
		@Override
		public void focusLost(FocusEvent e) {
		    SearchLeague.setText("搜尋聯盟......");
		}
	});
	SearchLeague.setFont(new Font("新細明體", Font.PLAIN, 16));
	SearchLeague.setText("搜尋聯盟......");
	SearchLeague.setBounds(10, 10, 414, 32);
	frame.getContentPane().add(SearchLeague);
	SearchLeague.setColumns(10);
	
	JLabel lblNewLabel = new JLabel("聯盟資訊：");
	lblNewLabel.setFont(new Font("新細明體", Font.PLAIN, 16));
	lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
	lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
	lblNewLabel.setBounds(10, 64, 414, 20);
	frame.getContentPane().add(lblNewLabel);
	
	JLabel lblNewLabel_1 = new JLabel("聯盟人數：" + Start.defaultLeague.getMemberAmounts() + "/36 \n聯盟總勝場：20 \n聯盟勝率：72%");
	lblNewLabel_1.setVerticalAlignment(SwingConstants.TOP);
	lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
	lblNewLabel_1.setBackground(new Color(240, 240, 240));
	lblNewLabel_1.setFont(new Font("新細明體", Font.PLAIN, 16));
	lblNewLabel_1.setBounds(10, 94, 414, 108);
	frame.getContentPane().add(lblNewLabel_1);
	
	JoinLeague = new JButton("加入聯盟");
	JoinLeague.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
		    Start.defaultLeague.JoinLeague(Start.currentAccount);
		}
	});
	JoinLeague.setFont(new Font("新細明體", Font.PLAIN, 16));
	JoinLeague.setBounds(168, 212, 113, 39);
	frame.getContentPane().add(JoinLeague);
    }
}
