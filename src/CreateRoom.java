import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CreateRoom {

    private JFrame frame;
    private JTextField roomnameField;
    private JTextField passwordField;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
	EventQueue.invokeLater(new Runnable() {
	    public void run() {
		try {
		    CreateRoom window = new CreateRoom();
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
    public CreateRoom() {
	initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
	frame = new JFrame();
	frame.setTitle("創建房間");
	frame.setBounds(100, 100, 450, 300);
	frame.setVisible(true);
	frame.setResizable(false);
	
	JLabel RoomName = new JLabel("房間名稱：");
	RoomName.setBounds(10, 30, 80, 20);
	RoomName.setFont(new Font("新細明體", Font.PLAIN, 16));
	
	roomnameField = new JTextField();
	roomnameField.setBounds(100, 30, 314, 21);
	roomnameField.setColumns(10);
	
	JLabel PasswordLabel = new JLabel("密碼：");
	PasswordLabel.setBounds(42, 88, 48, 20);
	PasswordLabel.setFont(new Font("新細明體", Font.PLAIN, 16));
	
	passwordField = new JTextField();
	passwordField.setBounds(100, 88, 314, 21);
	passwordField.setColumns(10);
	
	JLabel GameMode = new JLabel("遊戲模式：");
	GameMode.setBounds(10, 152, 80, 20);
	GameMode.setFont(new Font("新細明體", Font.PLAIN, 16));
	frame.getContentPane().setLayout(null);
	frame.getContentPane().add(RoomName);
	frame.getContentPane().add(roomnameField);
	frame.getContentPane().add(PasswordLabel);
	frame.getContentPane().add(passwordField);
	frame.getContentPane().add(GameMode);
	
	JComboBox<String> GameMenu = new JComboBox<String>();
	GameMenu.setModel(new DefaultComboBoxModel<String>(Game.getGameList()));
	GameMenu.setBounds(100, 151, 314, 23);
	frame.getContentPane().add(GameMenu);
	
	JButton CreateRoomButton = new JButton("創建房間");
	CreateRoomButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		    String roomName = roomnameField.getText();
		    if(GameRoom.roomList.containsKey(roomName)) {
			JOptionPane.showMessageDialog(null, "已有相同名稱的房間", "創建房間", JOptionPane.WARNING_MESSAGE);
		    }
		    else if(roomName.equals("")) {
			JOptionPane.showMessageDialog(null, "房間名稱不能為空白", "創建房間", JOptionPane.WARNING_MESSAGE);
		    }
		    
		    else if(roomName.contains(" ")) {
			JOptionPane.showMessageDialog(null, "房間名稱不能有空白", "創建房間", JOptionPane.WARNING_MESSAGE);
		    }
		    else {
			String selectedItem = (String)GameMenu.getSelectedItem();
			GameRoom gameRoom = new GameRoom(Game.getGame(selectedItem), roomName);
			gameRoom.enterRoom(Start.currentAccount);
			new GameRoomWindow(gameRoom);
			Lobby.frame.setVisible(false);
			frame.setVisible(false);
		    }
		}
	});
	CreateRoomButton.setFont(new Font("新細明體", Font.PLAIN, 16));
	CreateRoomButton.setBounds(156, 199, 140, 29);
	frame.getContentPane().add(CreateRoomButton);
	
	JLabel tips = new JLabel("*不需要則留白");
	tips.setForeground(new Color(255, 0, 0));
	tips.setBounds(100, 107, 115, 22);
	frame.getContentPane().add(tips);
    }
}
