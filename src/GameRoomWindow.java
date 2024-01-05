import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.ListSelectionModel;
import javax.swing.JTextPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GameRoomWindow {

    private JFrame frame;
    private ArrayList<Account> playerList = new ArrayList<Account>();
    private int playerAmounts = 0;
    private GameRoom gameRoom;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
	EventQueue.invokeLater(new Runnable() {
	    public void run() {
		try {
		    GameRoomWindow window = new GameRoomWindow();
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
    public GameRoomWindow(GameRoom gameRoom) {
	this.gameRoom = gameRoom;
	initialize();
    }
    
    public void enterRoom(Account account) {
	playerList.add(account);
	playerAmounts++;
    }
    
    


    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
	frame = new JFrame();
	frame.getContentPane().setFont(new Font("新細明體", Font.PLAIN, 16));
	frame.getContentPane().setLayout(null);
	frame.setVisible(true);
	frame.setResizable(false);
	
	JLabel lblNewLabel = new JLabel("玩家列表");
	lblNewLabel.setFont(new Font("新細明體", Font.PLAIN, 16));
	lblNewLabel.setBounds(189, 10, 110, 26);
	frame.getContentPane().add(lblNewLabel);
	
	JScrollPane scrollPane = new JScrollPane();
	scrollPane.setBounds(189, 34, 386, 237);
	frame.getContentPane().add(scrollPane);
	
	JList<String> list = new JList<String>(gameRoom.playerString());
	list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	scrollPane.setViewportView(list);
	
	JTextArea textArea = new JTextArea();
	textArea.setBounds(189, 353, 386, 22);
	frame.getContentPane().add(textArea);
	
	JLabel lblNewLabel_1 = new JLabel("聊天室");
	lblNewLabel_1.setFont(new Font("新細明體", Font.PLAIN, 16));
	lblNewLabel_1.setBounds(189, 278, 386, 65);
	frame.getContentPane().add(lblNewLabel_1);
	
	JButton ReturnButton = new JButton("退出");
	ReturnButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		    gameRoom.exitRoom(Start.currentAccount);
		    frame.dispose();
		    new Lobby();
		}
	});
	ReturnButton.setFont(new Font("新細明體", Font.PLAIN, 16));
	ReturnButton.setBounds(10, 353, 169, 25);
	frame.getContentPane().add(ReturnButton);
	
	JButton Start = new JButton("開始");
	Start.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		    JOptionPane.showMessageDialog(null, "此功能尚未實作");
		}
	});
	Start.setFont(new Font("新細明體", Font.PLAIN, 16));
	Start.setBounds(10, 278, 169, 25);
	frame.getContentPane().add(Start);
	
	JLabel GameRoomInfo = new JLabel(gameRoom.detailInfo());
	GameRoomInfo.setBounds(10, 36, 169, 229);
	frame.getContentPane().add(GameRoomInfo);
	frame.setTitle("房間");
	frame.setBounds(100, 100, 601, 424);
	frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
}
