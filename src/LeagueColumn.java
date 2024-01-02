import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.SwingConstants;

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
	frame.setBounds(100, 100, 450, 300);
	frame.getContentPane().setLayout(null);
	frame.setVisible(true);
	frame.setResizable(false);
	
	JLabel Column = new JLabel(Start.user.league.getColumn());
	Column.setVerticalAlignment(SwingConstants.TOP);
	Column.setHorizontalAlignment(SwingConstants.CENTER);
	Column.setFont(new Font("新細明體", Font.PLAIN, 16));
	Column.setBounds(52, 32, 311, 172);
	frame.getContentPane().add(Column);
    }

}
