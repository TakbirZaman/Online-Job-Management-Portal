package GUI;
import Files.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class LoginPage extends JFrame implements ActionListener, MouseListener{
	
	JPanel panel;
	JLabel userLabel,passLabel;
	JTextField userField;
	JPasswordField passField;
	JButton loginBtn,regBtn, showPassBtn;
	
	Font font = new Font("arial",Font.BOLD,25);
	
	public LoginPage(){
		super("Login Page");
		initialization();
		
		//=========Login========//
		//User Name
		userLabel = new JLabel("User Name :");
		userLabel.setBounds(360,90,200,40);
		userLabel.setFont(font);
		panel.add(userLabel);
		
		userField = new JTextField("ARESABIR");
		userField.setBounds(520,90,170,40);
		userField.setFont(font);
		panel.add(userField);
		
		//Password
		passLabel = new JLabel("Password  :");
		passLabel.setBounds(360,180,200,40);
		passLabel.setFont(font);
		panel.add(passLabel);
		
		passField = new JPasswordField("1234");
		passField.setBounds(520,180,170,40);
		passField.setFont(font);
		passField.setEchoChar('*');
		panel.add(passField);
		
		//Login Button
		loginBtn = new JButton("Login");
		loginBtn.setBounds(400,280,140,40);
		loginBtn.setFont(font);
		loginBtn.addActionListener(this);
		loginBtn.addMouseListener(this);
		panel.add(loginBtn);
		//======================//
		//register button
		regBtn = new JButton("Register");
		regBtn.setBounds(580,280,140,40);
		regBtn.setFont(font);
		regBtn.addActionListener(this);
		panel.add(regBtn);
		//======================//
		//show pass button
		showPassBtn = new JButton("Show");
		showPassBtn.setBounds(700,190,70,20);
		showPassBtn.setBackground(new Color(255, 255, 128));
		showPassBtn.addActionListener(this);
		panel.add(showPassBtn);
		
		this.setVisible(true);
	}
	
	public void initialization(){
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(800,500);
		this.setLayout(null);
		this.setLocation(250,50);
		this.setIconImage(new ImageIcon("./Resource/logo.png").getImage());
		JLabel background = new JLabel(new ImageIcon("./Resource/back.jpg"));
		background.setBounds(0,0,800,500);
	 	panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(0,0,800,500); 
		//panel.setBackground(new Color(219,255,255));
		panel.setOpaque(false);
		this.add(panel);
		this.add(background);  
	}
	
	public void mouseExited(MouseEvent me){
		if(loginBtn == me.getSource()){
			loginBtn.setBackground(null);
		}
	}
	public void mouseEntered(MouseEvent me){
		if(loginBtn == me.getSource()){
			loginBtn.setBackground(Color.GRAY);
		}
	}
	public void mouseClicked(MouseEvent me){}
	public void mousePressed(MouseEvent me){}
	public void mouseReleased(MouseEvent me){}
	
	public void  actionPerformed(ActionEvent e){
		String userName = userField.getText();
		String userPass = String.valueOf(passField.getPassword());
			 
		if( loginBtn == e.getSource()){	
			int status = FileIO.checkUserLogin("./Files/admin.txt",userName,userPass);
			if(status == 1){
				System.out.println(userName+" "+" is Verified");
				Homepage hp = new Homepage(this);
				this.setVisible(false);
				userField.setText("");
				passField.setText("");
			}
			else if(status == 2){
				JOptionPane.showMessageDialog(this,"Invalid Password", "Error", JOptionPane.WARNING_MESSAGE);
			}
			else{
				JOptionPane.showMessageDialog(this,"Invalid User Name or Password", "Error", JOptionPane.WARNING_MESSAGE);
			}
		}
			 if( regBtn == e.getSource()){
			if(FileIO.registerUser("./Files/admin.txt", userName,userPass)){
				JOptionPane.showMessageDialog(this,"User Registration Complete");
			}
			else{
				JOptionPane.showMessageDialog(this,"User Already Registered", "Error", JOptionPane.WARNING_MESSAGE);
			}  
		}
		
		if (showPassBtn==e.getSource()) {
			if(passField.getEchoChar()=='*'){
                passField.setEchoChar((char)0);
				showPassBtn.setText("Hide");
			}
			else if(passField.getEchoChar()==0){
                passField.setEchoChar('*');
				showPassBtn.setText("Show");
			}
            }
	}
}
