import java.awt.EventQueue;

import javax.swing.JFrame;

public class SponsorRegist {

    private JFrame frame;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
	EventQueue.invokeLater(new Runnable() {
	    public void run() {
		try {
		    SponsorRegist window = new SponsorRegist();
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
    public SponsorRegist() {
	initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
	frame = new JFrame();
	frame.setBounds(100, 100, 450, 380);
	frame.setVisible(true);
	frame.setResizable(false);
	frame.getContentPane().setLayout(null);
    }

}
