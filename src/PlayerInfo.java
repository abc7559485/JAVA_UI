import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.SwingConstants;

public class PlayerInfo {

    private JFrame frame;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
	EventQueue.invokeLater(new Runnable() {
	    public void run() {
		try {
		    PlayerInfo window = new PlayerInfo();
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
    public PlayerInfo() {
	initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
	frame = new JFrame();
	frame.setTitle("玩家資訊");
	frame.setBounds(100, 100, 400, 300);
//	frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	frame.getContentPane().setLayout(null);
	frame.setVisible(true);
	frame.setResizable(false);
	
	JLabel lblNewLabel = new JLabel("勝場：0");
	lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
	lblNewLabel.setFont(new Font("新細明體", Font.PLAIN, 16));
	lblNewLabel.setBounds(44, 29, 295, 27);
	frame.getContentPane().add(lblNewLabel);
	
	JLabel lblNewLabel_1 = new JLabel("總場數：0");
	lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
	lblNewLabel_1.setFont(new Font("新細明體", Font.PLAIN, 16));
	lblNewLabel_1.setBounds(44, 66, 295, 27);
	frame.getContentPane().add(lblNewLabel_1);
	
	JLabel lblNewLabel_2 = new JLabel("勝率：0%");
	lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
	lblNewLabel_2.setFont(new Font("新細明體", Font.PLAIN, 16));
	lblNewLabel_2.setBounds(44, 103, 295, 27);
	frame.getContentPane().add(lblNewLabel_2);
	
	JLabel lblNewLabel_2_1 = new JLabel("加入日期：XXXX年XX月XX日");
	lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.CENTER);
	lblNewLabel_2_1.setFont(new Font("新細明體", Font.PLAIN, 16));
	lblNewLabel_2_1.setBounds(44, 140, 295, 27);
	frame.getContentPane().add(lblNewLabel_2_1);
    }

}
