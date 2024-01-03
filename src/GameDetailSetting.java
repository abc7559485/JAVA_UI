import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GameDetailSetting {

    private JFrame frame;
    private JTextField GameNameField;
    private Game game;
    private JLabel OldGamePeopleLabel_1;
    private JTextField GameAmountsField;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
	EventQueue.invokeLater(new Runnable() {
	    public void run() {
		try {
		    GameDetailSetting window = new GameDetailSetting(Game.getGame("德州撲克"));
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
    public GameDetailSetting(Game game) {
	this.game = game;
	initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
	
	frame = new JFrame();
	frame.setBounds(100, 100, 342, 276);
	frame.setVisible(true);
	frame.setResizable(false);
	frame.getContentPane().setLayout(null);
	
	JLabel OldGameNameLabel = new JLabel("當前遊戲名稱：" + game.getGameName());
	OldGameNameLabel.setFont(new Font("新細明體", Font.PLAIN, 16));
	OldGameNameLabel.setBounds(10, 10, 306, 27);
	frame.getContentPane().add(OldGameNameLabel);
	
	GameNameField = new JTextField();
	GameNameField.addFocusListener(new FocusAdapter() {
		@Override
		public void focusGained(FocusEvent e) {
		    GameNameField.setText("");
		}
		public void focusLost(FocusEvent e) {
		    GameNameField.setText("輸入文字以更改遊戲名稱");
		}
	});
	GameNameField.setText("輸入文字以更改遊戲名稱\r\n");
	GameNameField.setFont(new Font("新細明體", Font.PLAIN, 16));
	GameNameField.setBounds(10, 36, 306, 36);
	frame.getContentPane().add(GameNameField);
	GameNameField.setColumns(10);
	
	OldGamePeopleLabel_1 = new JLabel("當前遊戲人數：" + game.getPeopleAmount());
	OldGamePeopleLabel_1.setFont(new Font("新細明體", Font.PLAIN, 16));
	OldGamePeopleLabel_1.setBounds(10, 95, 306, 27);
	frame.getContentPane().add(OldGamePeopleLabel_1);
	
	GameAmountsField = new JTextField();
	GameAmountsField.addFocusListener(new FocusAdapter() {
		@Override
		public void focusGained(FocusEvent e) {
		    GameAmountsField.setText("");
		}
		public void focusLost(FocusEvent e) {
		    GameAmountsField.setText("輸入數字以更改遊戲人數");
		}
	});
	GameAmountsField.setText("輸入數字以更改遊戲人數\r\n");
	GameAmountsField.setFont(new Font("新細明體", Font.PLAIN, 16));
	GameAmountsField.setColumns(10);
	GameAmountsField.setBounds(10, 132, 306, 36);
	frame.getContentPane().add(GameAmountsField);
	
	JButton ReturnButton = new JButton("返回");
	ReturnButton.setFont(new Font("新細明體", Font.PLAIN, 16));
	ReturnButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		    frame.setVisible(false);
		}
	});
	ReturnButton.setBounds(10, 187, 135, 40);
	frame.getContentPane().add(ReturnButton);
	
	JButton ChangeButton = new JButton("更改");
	ChangeButton.setFont(new Font("新細明體", Font.PLAIN, 16));
	ChangeButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		    String gameName = GameNameField.getText();
		    String getAmounts = GameAmountsField.getText();
		    boolean check = true;
		    for(int i = 0; i < getAmounts.length(); i++) {
			if(getAmounts.charAt(i) - '0' < 0 || getAmounts.charAt(i) - '0' > 10) {
			    check = false;
			    break;
			}
		    }
		    if(check) {
			int amounts = Integer.parseInt(getAmounts);
			game.gameSetting(gameName, amounts);
			JOptionPane.showMessageDialog(null, "更改成功", "遊戲設定", JOptionPane.PLAIN_MESSAGE);
		    }
		    else {
			JOptionPane.showMessageDialog(null, "更改失敗，錯誤的人數格式", "遊戲設定", JOptionPane.WARNING_MESSAGE);
		    }
		    
		}
	});
	ChangeButton.setBounds(181, 187, 135, 40);
	frame.getContentPane().add(ChangeButton);
    }
}
