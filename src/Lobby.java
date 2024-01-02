import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JList;
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

    private JFrame frame;
    public DefaultListModel<String> modList; 

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
	EventQueue.invokeLater(new Runnable() {
	    public void run() {
		try {
		    Lobby window = new Lobby();
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
	JoinButton.setFont(new Font("新細明體", Font.PLAIN, 16));
	
	JButton SearchButton = new JButton("遊戲篩選");
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
	ReloadButton.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
		    frame.repaint();
		    frame.revalidate();
		}
	});

	ReloadButton.setFont(new Font("新細明體", Font.PLAIN, 16));
	
	modList = new DefaultListModel<String>();
	for(GameRoom gameRoom: GameRoom.roomList) {
	    modList.addElement(gameRoom.toString());
	}
	JList<String> GameList = new JList<String>(modList);

	GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
	groupLayout.setHorizontalGroup(
		groupLayout.createParallelGroup(Alignment.LEADING)
			.addGroup(groupLayout.createSequentialGroup()
				.addGap(45)
				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
					.addGroup(groupLayout.createSequentialGroup()
						.addComponent(GameList, GroupLayout.PREFERRED_SIZE, 697, GroupLayout.PREFERRED_SIZE)
						.addContainerGap())
					.addGroup(groupLayout.createSequentialGroup()
						.addComponent(ReturnButton, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(SearchButton, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
						.addGap(14)
						.addComponent(ReloadButton, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
						.addGap(18)
						.addComponent(CreateButton, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(JoinButton, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(35, Short.MAX_VALUE))))
	);
	groupLayout.setVerticalGroup(
		groupLayout.createParallelGroup(Alignment.LEADING)
			.addGroup(groupLayout.createSequentialGroup()
				.addGap(33)
				.addComponent(GameList, GroupLayout.PREFERRED_SIZE, 438, GroupLayout.PREFERRED_SIZE)
				.addGap(27)
				.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
					.addComponent(ReturnButton, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
					.addComponent(ReloadButton, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
					.addComponent(JoinButton, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
					.addComponent(SearchButton, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
					.addComponent(CreateButton, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE))
				.addContainerGap(20, Short.MAX_VALUE))
	);
	frame.getContentPane().setLayout(groupLayout);
    }
}
