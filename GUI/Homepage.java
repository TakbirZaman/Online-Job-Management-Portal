package GUI;
import Files.*;
import Entity.*;
import EntityList.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Homepage extends JFrame implements ActionListener
{	
    JPanel panel;
	JButton btnEmployeeManager,btnManageJob,btnAssignJob,logout;

	Font font = new Font("cambria", Font.PLAIN, 18);
	LoginPage login;
	
	EmployeeList employees = new EmployeeList(); //For employee
	//JobList Jobs = new JobList(); //For Job
	DayLabourList DayLabours=new DayLabourList();
	PartTimeList PartTimes=new PartTimeList();
	FullTimeList FullTimes=new FullTimeList();
	FixedList Fixeds=new FixedList();
	//AssignList Assigns=new AssignList();
	

	
	public Homepage(LoginPage login){
		super("Homepage");
		this.login = login;
		
		
		
				//For Employee
	 	btnEmployeeManager = new JButton("Manage Employee");
        btnEmployeeManager.setBounds(25, 240, 180, 45);
        btnEmployeeManager.setFont(font);
        btnEmployeeManager.addActionListener(this);
        this.add(btnEmployeeManager); 
		
		//For job
		btnManageJob = new JButton("Manage Job");
        btnManageJob.setBounds(580,240, 180, 45);
        btnManageJob.setFont(font);
        btnManageJob.addActionListener(this);
        this.add(btnManageJob); 
		
		//For AssignJob
		
		btnAssignJob = new JButton("Assign Job");
        btnAssignJob.setBounds(310,80, 180, 45);
        btnAssignJob.setFont(font);
        btnAssignJob.addActionListener(this);
        this.add(btnAssignJob); 
		
		
		logout = new JButton("Logout");
        logout.setBounds(620, 400, 120, 30);
        logout.setFont(font);
		logout.setBackground(new Color(255,0,0));
		logout.setForeground(new Color(255,255,255));
        logout.addActionListener(this);
        this.add(logout);
		
		//loadEmployees();
		
		//loadJobs();
		
		// this.setVisible(true);
		
	
	
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(800, 500);
		this.setLayout(null);
        this.setLocation(300, 200);
		 this.setIconImage(new ImageIcon("./Resource/logo.png").getImage());
		JLabel background = new JLabel(new ImageIcon("./Resource/home.jpg"));
		background.setBounds(0,0,800,500);
	 	panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(0,0,800,500); 
		//panel.setBackground(new Color(219,255,255));
		panel.setOpaque(false);
		this.add(panel);
		this.add(background);  
		
		this.setVisible(true);
		
	}
	

	
	public void actionPerformed(ActionEvent e) {
        if(btnEmployeeManager == e.getSource()){
			employees=new EmployeeList();
			FileIO.loadEmployeesFromFile(employees,"./Files/employees.txt");
			EmployeeManager em = new EmployeeManager(this,employees);
			this.setVisible(false);
		}
		else if(btnManageJob==e.getSource()){
				ManageJob mj = new ManageJob(this);
				this.setVisible(false);
		}
	 	else if(btnAssignJob==e.getSource()){
				employees=new EmployeeList();
			FileIO.loadEmployeesFromFile(employees,"./Files/employees.txt");
			// Jobs=new JobList();
			// FileIO.loadJobsFromFile(Jobs,"./Files/Jobs.txt");
			DayLabours=new DayLabourList();
		FileIO.loadDayLaboursFromFile(DayLabours,"./Files/DayLabours.txt");
				PartTimes=new PartTimeList();
		FileIO.loadPartTimesFromFile(PartTimes,"./Files/PartTimes.txt");
			FullTimes=new FullTimeList();
		    FileIO.loadFullTimesFromFile(FullTimes,"./Files/FullTimes.txt");
				Fixeds=new FixedList();
		    FileIO.loadFixedsFromFile(Fixeds,"./Files/Fixeds.txt");
			
		/* 		Assigns=new AssignList();
		    FileIO.loadAssignFromFile(Assigns,"./Files/JobAssignment.txt"); */
			
				AssignJob aj = new AssignJob(this,employees,DayLabours,PartTimes,FullTimes,Fixeds);
				
				
				this.setVisible(false); 
		} 
		 
		else if (logout == e.getSource()){
			int option = JOptionPane.showConfirmDialog(this,"You will be Logged Out?");
			if(option == JOptionPane.YES_OPTION){
				this.dispose();
				login.setVisible(true);
			}
		}
    }


}
