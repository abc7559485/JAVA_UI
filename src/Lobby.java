import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionListener;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JScrollBar;
import javax.swing.AbstractListModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Lobby{ //implements ListSelectionListener {

    static JFrame frame;
    private JList<String> list;
    public DefaultListModel<String> modList; 

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
	EventQueue.invokeLater(new Runnable() {
	    public void run() {
		try {
		    Lobby window = new Lobby();
		    frame.setVisible(true);
		} catch (Exception e) {
		    e.printStackTrace();
		}
	    }
	});
    }

    /**
     * Create the application.
     */
    public Lobby() {
	initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
	frame = new JFrame();
	frame.setTitle("大廳");
	frame.setBounds(100, 100, 800, 600);
	frame.setVisible(true);
	frame.setResizable(false);
	

	
	

	
	
	
	
	JButton CreateButton = new JButton("創建房間");
	CreateButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		    new CreateRoom();
		}
	});
	CreateButton.setFont(new Font("新細明體", Font.PLAIN, 16));
	
	JButton JoinButton = new JButton("加入房間");
	JoinButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		    try {
			String title = list.getSelectedValue().split(" ")[0];
			GameRoom gameRoom = GameRoom.roomList.get(title);
			gameRoom.enterRoom(Start.currentAccount);
			new GameRoomWindow(gameRoom);
			frame.dispose();
		    }
		    catch(NullPointerException exception) {
			JOptionPane.showMessageDialog(null, "請先選取房間或創建房間", "進入房間", JOptionPane.WARNING_MESSAGE);
		    }

		}
	});
	JoinButton.setFont(new Font("新細明體", Font.PLAIN, 16));
	
	JButton SearchButton = new JButton("遊戲篩選");
	SearchButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		    JOptionPane.showMessageDialog(null, "此功能尚未實作");
		}
	});
	SearchButton.setFont(new Font("新細明體", Font.PLAIN, 16));
	
	JButton ReturnButton = new JButton("返回");
	ReturnButton.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
		    frame.setVisible(false);
		}
	});
	ReturnButton.setFont(new Font("新細明體", Font.PLAIN, 16));
	
	JButton ReloadButton = new JButton("刷新頁面");
	ReloadButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		    frame.dispose();
		    new Lobby();
		}
	});


	ReloadButton.setFont(new Font("新細明體", Font.PLAIN, 16));
	
	
	JScrollPane scrollPane = new JScrollPane();

	GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
	groupLayout.setHorizontalGroup(
		groupLayout.createParallelGroup(Alignment.LEADING)
			.addGroup(groupLayout.createSequentialGroup()
				.addGap(45)
				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
					.addGroup(groupLayout.createSequentialGroup()
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 697, GroupLayout.PREFERRED_SIZE)
						.addContainerGap())
					.addGroup(groupLayout.createSequentialGroup()
						.addComponent(ReturnButton, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(SearchButton, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
						.addGap(14)
						.addComponent(ReloadButton, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
						.addGap(18)
						.addComponent(CreateButton, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
						.addComponent(JoinButton, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(38, Short.MAX_VALUE))))
	);
	groupLayout.setVerticalGroup(
		groupLayout.createParallelGroup(Alignment.LEADING)
			.addGroup(groupLayout.createSequentialGroup()
				.addGap(33)
				.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 447, GroupLayout.PREFERRED_SIZE)
				.addGap(18)
				.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
					.addComponent(ReturnButton, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
					.addComponent(ReloadButton, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
					.addComponent(JoinButton, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
					.addComponent(SearchButton, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
					.addComponent(CreateButton, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE))
				.addContainerGap(20, Short.MAX_VALUE))
	);
	
	list = new JList<String>(GameRoom.getGameroomList());
	list.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
	scrollPane.setViewportView(list);
	frame.getContentPane().setLayout(groupLayout);
    }
}
