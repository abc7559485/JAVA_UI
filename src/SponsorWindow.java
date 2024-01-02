import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SponsorWindow {

    private JFrame frame;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
	EventQueue.invokeLater(new Runnable() {
	    public void run() {
		try {
		    SponsorWindow window = new SponsorWindow();
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
    public SponsorWindow() {
	initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
	frame = new JFrame();
	frame.setTitle("贊助商方案");
	frame.setBounds(100, 100, 826, 491);
	frame.setVisible(true);
	frame.setResizable(false);
	frame.getContentPane().setLayout(null);
	
	JLabel SponsorLabel = new JLabel("贊助方案：");
	SponsorLabel.setFont(new Font("Dialog", Font.PLAIN, 16));
	SponsorLabel.setBounds(10, 10, 185, 38);
	frame.getContentPane().add(SponsorLabel);
	
	JButton MonthButton = new JButton("<html> 月費方案 <br/>\r\n350元 / 月 </html>");
	MonthButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		    if(!Sponsor.State()) {
			JOptionPane.showMessageDialog(null, "請先登入贊助商", "登入錯誤", JOptionPane.WARNING_MESSAGE);
		    }
		    else if(!Start.sponsor.hasPlan()) {
			    int result = JOptionPane.showConfirmDialog(null, "確定選擇此方案？", "月費方案", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
			    if(result == JOptionPane.YES_OPTION) {
				Start.sponsor.setPlan(1);
				
			    }
		    }
		    else {
			Start.currentSponsor.changePlan(3);
		    }

		}
	});
	MonthButton.setFont(new Font("新細明體", Font.PLAIN, 24));
	MonthButton.setBounds(10, 68, 252, 352);
	frame.getContentPane().add(MonthButton);
	
	JButton YearButton = new JButton("<html> 年費方案 <br/>\r\n3600元 / 年 </html>");
	YearButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		    if(!Sponsor.State()) {
			JOptionPane.showMessageDialog(null, "請先登入贊助商", "登入錯誤", JOptionPane.WARNING_MESSAGE);
		    }
		    else if(!Start.sponsor.hasPlan()) {
			int result = JOptionPane.showConfirmDialog(null, "確定選擇此方案？", "年費方案", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
			if(result == JOptionPane.YES_OPTION) {
			    Start.sponsor.setPlan(2);
			}
		    }
		    else {
			Start.currentSponsor.changePlan(3);
		    }
		    
		}
	});
	YearButton.setFont(new Font("新細明體", Font.PLAIN, 24));
	YearButton.setBounds(272, 68, 252, 352);
	frame.getContentPane().add(YearButton);
	
	JButton LifeButton = new JButton("<html> 終生方案 <br/>\r\n8000元 </html>");
	LifeButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		    if(!Sponsor.State()) {
			JOptionPane.showMessageDialog(null, "請先登入贊助商", "登入錯誤", JOptionPane.WARNING_MESSAGE);
		    }
		    else if(!Start.sponsor.hasPlan()) {
			int result = JOptionPane.showConfirmDialog(null, "確定選擇此方案？", "終生方案", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
			if(result == JOptionPane.YES_OPTION) {
			    Start.sponsor.setPlan(3);
			}
		    }
		    else {
			Start.currentSponsor.changePlan(3);
		    }
		}
	});
	LifeButton.setFont(new Font("新細明體", Font.PLAIN, 24));
	LifeButton.setBounds(534, 68, 252, 352);
	frame.getContentPane().add(LifeButton);
	
	JButton SponsorLoginButton = new JButton("登記贊助商");
	SponsorLoginButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		    if(!Sponsor.State()) {
			new SponsorLogin();
		    }
		    else
			JOptionPane.showMessageDialog(null, "已經登入", "登入錯誤", JOptionPane.WARNING_MESSAGE);
		}
	});
	SponsorLoginButton.setFont(new Font("新細明體", Font.PLAIN, 16));
	SponsorLoginButton.setBounds(618, 14, 168, 38);
	frame.getContentPane().add(SponsorLoginButton);
	
	JButton ReturnButton = new JButton("返回");
	ReturnButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		    frame.setVisible(false);
		}
	});
	ReturnButton.setFont(new Font("新細明體", Font.PLAIN, 16));
	ReturnButton.setBounds(262, 14, 168, 38);
	frame.getContentPane().add(ReturnButton);
	
	JButton Logout = new JButton("登出");
	Logout.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		    if(Sponsor.State()) {
			int result = JOptionPane.showConfirmDialog(null, "確定要登出嗎？", "登出", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
			if(result == JOptionPane.YES_OPTION) {
			    Start.currentSponsor.Logout();
			}
		    }
		    else

			JOptionPane.showMessageDialog(null, "請先登入", "登出", JOptionPane.WARNING_MESSAGE);
		}
	});
	Logout.setFont(new Font("新細明體", Font.PLAIN, 16));
	Logout.setBounds(440, 14, 168, 38);
	frame.getContentPane().add(Logout);
	
    }
}
