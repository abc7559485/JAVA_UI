import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddGame {

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
		    AddGame window = new AddGame();
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
    public AddGame() {
	initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
	frame = new JFrame();
	frame.setTitle("新增遊戲");
	frame.setBounds(100, 100, 450, 248);
	frame.getContentPane().setLayout(null);
	frame.setVisible(true);
	frame.setResizable(false);
	
	JLabel GameName = new JLabel("遊戲名稱：");
	GameName.setFont(new Font("新細明體", Font.PLAIN, 16));
	GameName.setBounds(10, 25, 105, 37);
	frame.getContentPane().add(GameName);
	
	textField = new JTextField();
	textField.setFont(new Font("新細明體", Font.PLAIN, 16));
	textField.setBounds(96, 25, 301, 34);
	frame.getContentPane().add(textField);
	textField.setColumns(10);
	
	JLabel People = new JLabel("遊戲人數：");
	People.setFont(new Font("新細明體", Font.PLAIN, 16));
	People.setBounds(10, 99, 105, 37);
	frame.getContentPane().add(People);
	
	textField_1 = new JTextField();
	textField_1.setFont(new Font("新細明體", Font.PLAIN, 16));
	textField_1.setColumns(10);
	textField_1.setBounds(96, 102, 301, 34);
	frame.getContentPane().add(textField_1);
	
	JButton Return = new JButton("返回");
	Return.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		    frame.setVisible(false);
		}
	});
	Return.setFont(new Font("新細明體", Font.PLAIN, 16));
	Return.setBounds(10, 162, 188, 37);
	frame.getContentPane().add(Return);
	
	JButton Add = new JButton("新增遊戲");
	Add.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		    String name = textField.getText();
		    int amounts = Integer.parseInt(textField_1.getText());
		    new Game(name, amounts);
		}
	});
	Add.setFont(new Font("新細明體", Font.PLAIN, 16));
	Add.setBounds(236, 162, 188, 37);
	frame.getContentPane().add(Add);
    }
}
