package GUI;
import Entity.*;
import EntityList.*;
import Files.*;
import java.util.ArrayList;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class ManageJob extends JFrame implements ActionListener
{	JPanel panel;
	JButton btnManageDayLabour,btnManagePartTime,btnManageFullTime,btnManageFixed,backBtn;

	Font font = new Font("cambria", Font.PLAIN, 20);
	Homepage hp;
	
     DayLabourList DayLabours = new DayLabourList();	 //For DayLabourList
	 PartTimeList PartTimes = new PartTimeList();
	 FullTimeList FullTimes = new FullTimeList();
	 FixedList Fixeds = new FixedList();
	 
	
	public ManageJob(Homepage hp){
		super("ManageJob");
		this.hp = hp;
		//this.login=login;
	
		//daylabour
	 	btnManageDayLabour = new JButton("Manage Daylabour");
        btnManageDayLabour.setBounds(520, 60, 200, 35);
        btnManageDayLabour.setFont(font);
        btnManageDayLabour.addActionListener(this);
        this.add(btnManageDayLabour); 
		
		//For partTime
		btnManagePartTime = new JButton("Manage PartTime");
        btnManagePartTime.setBounds(520, 140, 200, 35);
        btnManagePartTime.setFont(font);
        btnManagePartTime.addActionListener(this);
        this.add(btnManagePartTime); 
		 
		btnManageFullTime = new JButton("Manage FullTime");
        btnManageFullTime.setBounds(520, 220, 200, 35);
        btnManageFullTime.setFont(font);
        btnManageFullTime.addActionListener(this);
        this.add(btnManageFullTime); 
		
		btnManageFixed = new JButton("Manage Fixed");
        btnManageFixed.setBounds(520, 300, 200, 35);
        btnManageFixed.setFont(font);
        btnManageFixed.addActionListener(this);
        this.add(btnManageFixed); 
		
		backBtn = new JButton("<-Back");
		backBtn.setBounds(550, 390, 120, 30);
		backBtn.setFont(font);
		backBtn.setBackground(new Color(70,132,133));
		backBtn.addActionListener(this);
		this.add(backBtn);
		
		this.setSize(800, 500);
        this.setLocation(250, 50);
        this.setLayout(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setIconImage(new ImageIcon("./Resource/logo.png").getImage());
		JLabel background = new JLabel(new ImageIcon("./Resource/job.jpg"));
		background.setBounds(0,0,800,500);
	 	panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(0,0,800,500); 
		//panel.setBackground(new Color(219,255,255));
		panel.setOpaque(false);
		this.add(panel);
		this.add(background);
		
	/* 	loaddayLabours();
		loadpartTimes();
	    loadfullTimes();
		loadfixeds(); */
		
		this.setVisible(true);
	}
/* 	public void loaddayLabours(){
		DayLabours.insert(new DayLabour(1,"jj","kk","jj",89,"m",8, "jj" ));
		DayLabours.insert(new DayLabour(1,"jj","kk","jj",89,"m",8,"jj"));
		DayLabours.insert(new DayLabour(1,"jj","kk","jj",89,"m",8,"jj"));
	}
	public void loadpartTimes(){
		PartTimes.insert(new PartTime(1,"jj","kk","jj",89,"m",8,"jj"));
		PartTimes.insert(new PartTime(1,"jj","kk","jj",89,"m",8,"jj"));
		PartTimes.insert(new PartTime(1,"jj","kk","jj",89,"m",8,"jj"));
		PartTimes.insert(new PartTime(1,"jj","kk","jj",89,"m",8,"jj"));
	}
	public void loadfullTimes(){
		FullTimes.insert(new FullTime(1,"jj","kk","jj",89,"m",8,"jj"));
		FullTimes.insert(new FullTime(1,"jj","kk","jj",89,"m",8,"jj"));
	    FullTimes.insert(new FullTime(1,"jj","kk","jj",89,"m",8,"jj"));
	    FullTimes.insert(new FullTime(1,"jj","kk","jj",89,"m",8,"jj"));
	}
	public void loadfixeds(){
		Fixeds.insert(new Fixed(1,"jj","kk","jj",89,"m",8,"jj"));
	 Fixeds.insert(new Fixed(1,"jj","kk","jj",89,"m",8,"jj"));
	} */
	
	public void actionPerformed(ActionEvent e) {
        if(btnManageDayLabour == e.getSource()){
			DayLabours=new DayLabourList();
		FileIO.loadDayLaboursFromFile(DayLabours,"./Files/DayLabours.txt");
		ManageDayLabour dl = new ManageDayLabour(this,DayLabours);
			this.setVisible(false);
		}
		else if(btnManagePartTime==e.getSource()){
			PartTimes=new PartTimeList();
		FileIO.loadPartTimesFromFile(PartTimes,"./Files/PartTimes.txt");
			ManagePartTime pt = new ManagePartTime(this,PartTimes);
			this.setVisible(false);	
		}
		else if(btnManageFullTime==e.getSource()){
			FullTimes=new FullTimeList();
		    FileIO.loadFullTimesFromFile(FullTimes,"./Files/FullTimes.txt");
			ManageFullTime ft = new ManageFullTime(this,FullTimes);
			this.setVisible(false);		
		}
		else if(btnManageFixed==e.getSource()){
			Fixeds=new FixedList();
		    FileIO.loadFixedsFromFile(Fixeds,"./Files/Fixeds.txt");
			ManageFixed f = new ManageFixed(this,Fixeds);
			this.setVisible(false);			
		}
		
			else if(backBtn == e.getSource()){
			hp.setVisible(true);
			this.dispose();
		}
    }
	
   }
