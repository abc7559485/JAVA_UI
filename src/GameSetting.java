import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GameSetting {

    private JFrame frame;
    private JButton Option;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
	EventQueue.invokeLater(new Runnable() {
	    public void run() {
		try {
		    GameSetting window = new GameSetting();
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
    public GameSetting() {
	initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
	frame = new JFrame();
	frame.setBounds(100, 100, 450, 423);
	frame.getContentPane().setLayout(null);
	frame.setVisible(true);
	frame.setResizable(false);
	
	JScrollPane scrollPane = new JScrollPane();
	scrollPane.setBounds(10, 10, 282, 364);
	frame.getContentPane().add(scrollPane);
	
	JList<String> gameList = new JList<String>(Game.getGameList());
	gameList.setFont(new Font("新細明體", Font.PLAIN, 16));
	gameList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	scrollPane.setViewportView(gameList);
	
	JButton AddGame = new JButton("新增遊戲");
	AddGame.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		    new AddGame();
		}
	});
	AddGame.setFont(new Font("新細明體", Font.PLAIN, 16));
	AddGame.setBounds(302, 20, 108, 45);
	frame.getContentPane().add(AddGame);
	
	Option = new JButton("遊戲設定");
	Option.setFont(new Font("新細明體", Font.PLAIN, 16));
	Option.setBounds(302, 99, 108, 45);
	frame.getContentPane().add(Option);
	
	JButton removeGame = new JButton("移除遊戲");
	removeGame.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		    String gameName = gameList.getSelectedValue();
		    int result = JOptionPane.showConfirmDialog(null, "確定要移除遊戲？", "移除遊戲", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
		    if(result == JOptionPane.YES_OPTION) {
			Game.gameList.remove(Game.getGame(gameName));
			Game.gameNameList.remove(gameName);
		    }
		}
	});
	removeGame.setFont(new Font("新細明體", Font.PLAIN, 16));
	removeGame.setBounds(302, 179, 108, 45);
	frame.getContentPane().add(removeGame);
	
	JButton Return = new JButton("返回");
	Return.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		    frame.setVisible(false);
		}
	});
	Return.setFont(new Font("新細明體", Font.PLAIN, 16));
	Return.setBounds(302, 329, 108, 45);
	frame.getContentPane().add(Return);
    }
}
