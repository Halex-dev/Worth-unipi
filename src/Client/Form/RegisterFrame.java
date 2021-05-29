package Client.Form;

import Client.GUIClientMain;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class RegisterFrame extends JFrame implements ActionListener, MouseListener {
	
	private static final long serialVersionUID = -1415350520861177149L;
	private static final String WORTH_IMG = "img/worth-logo.png";
	private static final String WORTH_ICON = "img/worth_icon.png";
	
	private Container container = getContentPane();
	private JLabel userLabel = new JLabel("USERNAME");
	private JLabel passwordLabel = new JLabel("PASSWORD");
	private JTextField userTextField = new JTextField();
    private JPasswordField passwordField = new JPasswordField();
    private JButton registerButton = new JButton("Sign Up");
    private JCheckBox showPassword = new JCheckBox("Show Password");
    
    private JLabel NotAccount = new JLabel("Hai gia' un account?");
    private JLabel LabelRegister = new JLabel("Fai il login");
    
    private JLabel LogoLabel = ImageConfig();

    public JLabel ImageConfig() {
        try {
        	
        	ImageIcon imgIcon = new ImageIcon(WORTH_ICON);
        	this.setIconImage(imgIcon.getImage());
        	
            BufferedImage img = ImageIO.read(new File(WORTH_IMG));
            ImageIcon icon = new ImageIcon(img);
            JLabel label = new JLabel(icon);
            return label;
         } catch (IOException e) {
            e.printStackTrace();
         }
		return null;
    }

   
    public RegisterFrame() {
        setLayoutManager();
        setLocationAndSize();
        addComponentsToContainer();
        addActionEvent();
        addMouseEvent();
        ColorLabel();
    }
 
    public void ColorLabel() {
    	LabelRegister.setForeground(Color.BLUE);
    }
    
    public void setLayoutManager() {
        container.setLayout(null);
    }
 
    public void setLocationAndSize() {
    	LogoLabel.setBounds(140, 20, 100, 100);
    	
        userLabel.setBounds(50, 150, 100, 30);
        userTextField.setBounds(130, 150, 150, 30);
        
        passwordLabel.setBounds(50, 190, 100, 30);
        passwordField.setBounds(130, 190, 150, 30);
        
        showPassword.setBounds(150, 220, 150, 30);
        
        registerButton.setBounds(100, 255, 200, 30);
        
        NotAccount.setBounds(80, 285, 200, 30);
        LabelRegister.setBounds(200, 285, 200, 30);
 
    }
 
    public void addComponentsToContainer() {
    	container.add(LogoLabel);
        container.add(userLabel);
        container.add(passwordLabel);
        container.add(userTextField);
        container.add(passwordField);
        container.add(showPassword);
        container.add(registerButton);
        container.add(NotAccount);
        container.add(LabelRegister);
    }
 
    public void addActionEvent() {
        registerButton.addActionListener(this);
        showPassword.addActionListener(this);
    }
 
    public void addMouseEvent() {
    	LabelRegister.addMouseListener(this);
    }
    
    @SuppressWarnings("deprecation")
	@Override
    public void actionPerformed(ActionEvent e) {
        //Coding Part of REGISTER button
        if (e.getSource() == registerButton) {
            String userText;
            String pwdText;
            userText = userTextField.getText();
            pwdText = passwordField.getText();
            if (GUIClientMain.Register(userText, pwdText)) {
                JOptionPane.showMessageDialog(this, "Registration successful");
                GUIClientMain.LoginForm();
            } else {
                JOptionPane.showMessageDialog(this, "Error:\n 1. User already exist\n2. Nickname and password lenght must be greater than 3\n3.Server is offline");
            }
 
        }
       //Coding Part of showPassword JCheckBox
        if (e.getSource() == showPassword) {
            if (showPassword.isSelected()) {
                passwordField.setEchoChar((char) 0);
            } else {
                passwordField.setEchoChar('*');
            }

        }
    }


	@Override
	public void mouseClicked(MouseEvent e) {
    	if(e.getSource() == LabelRegister) {
    		GUIClientMain.LoginForm();
    	}
	}


	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
 
}
