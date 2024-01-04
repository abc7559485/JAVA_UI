import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LeagueColumn {

    private JFrame frame;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
	EventQueue.invokeLater(new Runnable() {
	    public void run() {
		try {
		    LeagueColumn window = new LeagueColumn();
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
    public LeagueColumn() {
	initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
	frame = new JFrame();
	frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	frame.setBounds(100, 100, 450, 300);
	frame.getContentPane().setLayout(null);
	frame.setVisible(true);
	frame.setResizable(false);
	
	JLabel Column = new JLabel(Start.currentAccount.league.getColumn());
	Column.setVerticalAlignment(SwingConstants.TOP);
	Column.setHorizontalAlignment(SwingConstants.CENTER);
	Column.setFont(new Font("新細明體", Font.PLAIN, 16));
	Column.setBounds(59, 33, 311, 172);
	frame.getContentPane().add(Column);
	
	JButton ReturnButton = new JButton("返回");
	ReturnButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		    frame.dispose();
		}
	});
	ReturnButton.setBounds(164, 214, 100, 37);
	frame.getContentPane().add(ReturnButton);
    }
}
