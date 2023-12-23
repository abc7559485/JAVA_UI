
import javax.swing.*;
//import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserLogin extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;

	
	JTextField usernameField;
    JPasswordField passwordField;
    JTextField checkcodeField;
    JButton loginButton;
    JButton registButton;
    JButton checkButton;
    
    JPanel panel;
    JLabel checkText;

    public UserLogin() {
        setTitle("�ϥΪ̵n�J");

        setSize(400, 300);

        panel = new JPanel();
        panel.setLayout(null);

        JLabel usernameLabel = new JLabel("�ϥΪ̦W�١G");
        usernameLabel.setBounds(50, 10, 100, 30);
        usernameField = new JTextField();
        usernameField.setBounds(130, 10, 200, 30);

        JLabel passwordLabel = new JLabel("�K�X�G");
        passwordLabel.setBounds(50, 50, 100, 30);
        passwordField = new JPasswordField();
        passwordField.setBounds(130, 50, 200, 30);

        JLabel checkCode = new JLabel("���ҽX");
        checkCode.setBounds(50, 90, 100, 30);
        checkcodeField = new JTextField();
        checkcodeField.setBounds(130, 90, 200, 30);

        checkButton = new JButton("���o���ҽX");
        checkButton.setBounds(130, 130, 100, 30);

        loginButton = new JButton("�n�J");
        loginButton.setBounds(240, 130, 90, 30);

        registButton = new JButton("���U");
        registButton.setBounds(50, 130, 70, 30);

        checkText = new JLabel("���ҽX�G " + checkcode());
        checkText.setBounds(130, 170, 200, 30);

        panel.add(usernameLabel);
        panel.add(usernameField);
        panel.add(passwordLabel);
        panel.add(passwordField);
        panel.add(checkCode);
        panel.add(checkcodeField);
        panel.add(registButton);
        panel.add(loginButton);
        panel.add(checkButton);
        panel.add(checkText);



        loginButton.addActionListener(this);
        checkButton.addActionListener(this);
        registButton.addActionListener(this);

        add(panel);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == loginButton) {
			String username = AccountField.getText();
            String password = new String(passwordField.getPassword());
            String checkCode = new String(checkcodeField.getText());
            String checkCode_in = this.checkCode;

            if(!checkCode.equals(this.checkCode)) {
            	JOptionPane.showMessageDialog(this, "�n�J���ѡA���ҽX���~");
            	checkcode_display.setText("���ҽX�G " + checkcode());
            }
            else if (Account.map.containsKey(username)) {
            	if(password.equals(Account.getPassword(username))) {
            		JOptionPane.showMessageDialog(this, "�n�J���");
                    

            	}
            	else {
            		JOptionPane.showMessageDialog(this, "�n�J���ѡA�K�X���~", "���~", JOptionPane.ERROR_MESSAGE);
            	}

            } else {
                JOptionPane.showMessageDialog(this, "�n�J���ѡA���ˬd�ϥΪ̦W�٩M�K�X", "���~", JOptionPane.ERROR_MESSAGE);
                checkcode_display.setText("���ҽX�G " + checkcode());
            }
        }

        else if(e.getSource() == checkButton) {
        	
        }

        else if(e.getSource() == registButton) {
        	new	Regist();
        }
    }

    


    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new UserLogin());
    }
}