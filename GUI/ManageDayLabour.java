package GUI;
import Entity.*;
import EntityList.*;
import Files.*;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.table.*;
import javax.swing.JComboBox;

public class ManageDayLabour extends JFrame implements ActionListener{
	
	JPanel panel;
	JLabel accountNoLabel,jobNameLabel,jobStatusLabel,jobLocationLabel,salaryLabel,preferredGenderLabel,ageLimitLabel,physicalstrengthLabel;
	JTextField accountNoField,jobNameField,jobStatusField,jobLocationField,salaryField,preferredGenderField,ageLimitField,physicalstrengthField;
	JButton addBtn,backBtn,updateBtn,deleteBtn;
	JTable table;
	DefaultTableModel model;
	JComboBox<String> preferredGenderComboBox;     //for gender dropdown
	
	Font font = new Font("arial",Font.BOLD,20);
	
	ManageJob mj;
	JobList Jobs;
	DayLabourList DayLabours;
	
	
	public ManageDayLabour(ManageJob mj,DayLabourList DayLabours){
		super("MANAGE DAYLABOUR JOB");
		this.mj = mj;
		this.DayLabours = DayLabours;
		initialization();
		//int accountNo,String jobName,String jobStatus,String jobLocation,double salary,String preferredGender,int ageLimit
		//=================//
			accountNoLabel = new JLabel("JOB ID");
			accountNoLabel.setFont(font);
			accountNoLabel.setBounds(40,20,260,30);
			panel.add(accountNoLabel);
			
			accountNoField = new JTextField();
			accountNoField.setFont(font);
			accountNoField.setBounds(320,20,300,30);
			panel.add(accountNoField);
			
			
		//======================//
		//=================//
			jobNameLabel = new JLabel("JOB NAME");
			jobNameLabel.setFont(font);
			jobNameLabel.setBounds(40,60,260,30);
			panel.add(jobNameLabel );
			
			jobNameField = new JTextField();
			jobNameField.setFont(font);
			jobNameField.setBounds(320,60,300,30);
			panel.add(jobNameField);
			
		//======================//
		//=================//
			jobStatusLabel = new JLabel("JOB STATUS");
			jobStatusLabel.setFont(font);
			jobStatusLabel.setForeground(Color.BLACK);;
			jobStatusLabel.setBounds(40,100,260,30);
			panel.add(jobStatusLabel );
			
			jobStatusField = new JTextField();
			jobStatusField.setFont(font);
			jobStatusField.setBounds(320,100,300,30);
			panel.add(jobStatusField);
			
			
		//======================//
			jobLocationLabel = new JLabel("JOB LOCATION");
			jobLocationLabel.setFont(font);
			jobLocationLabel.setForeground(Color.BLACK);;
			jobLocationLabel.setBounds(40,140,260,30);
			panel.add(jobLocationLabel );
			
			jobLocationField = new JTextField();
			jobLocationField.setFont(font);
			jobLocationField.setBounds(320,140,300,30);
			panel.add(jobLocationField);
			//======================//
		
		//======================//
			salaryLabel = new JLabel("SALARY");
			salaryLabel.setFont(font);
			salaryLabel.setForeground(Color.BLACK);;
			salaryLabel.setBounds(40,180,260,30);
			panel.add(salaryLabel );
			
			salaryField = new JTextField();
			salaryField.setFont(font);
			salaryField.setBounds(320,180,300,30);
			panel.add(salaryField);
			//======================//
		
		//======================//
 			preferredGenderLabel = new JLabel("PREFERRED GENDER");
			preferredGenderLabel.setFont(font);
			preferredGenderLabel.setForeground(Color.BLACK);;
			preferredGenderLabel.setBounds(40,220,260,30);
			panel.add(preferredGenderLabel );
			
			/* preferredGenderField = new JTextField();
			preferredGenderField.setFont(font);
			preferredGenderField.setBounds(320,220,300,30);
			panel.add(preferredGenderField); */ 
			
		preferredGenderComboBox = new JComboBox<>(new String[]{"Male", "Female", "Other"});
        preferredGenderComboBox.setFont(font);
        preferredGenderComboBox.setBounds(320, 220, 300, 30);
        panel.add(preferredGenderComboBox); 
			//======================//
		
		//======================//
			ageLimitLabel = new JLabel("AGE LIMIT");
			ageLimitLabel.setFont(font);
			ageLimitLabel.setForeground(Color.BLACK);;
			ageLimitLabel.setBounds(40,260,260,30);
			panel.add(ageLimitLabel );
			
			ageLimitField = new JTextField();
			ageLimitField.setFont(font);
			ageLimitField.setBounds(320,260,300,30);
			panel.add(ageLimitField);
			//======================//
		 //======================//
			physicalstrengthLabel = new JLabel("PHYSICAL STRENGTH");
			physicalstrengthLabel.setFont(font);
			physicalstrengthLabel.setForeground(Color.BLACK);;
			physicalstrengthLabel.setBounds(40,300,260,30);
			panel.add(physicalstrengthLabel );
			
			physicalstrengthField = new JTextField();
			physicalstrengthField.setFont(font);
			physicalstrengthField.setBounds(320,300,300,30);
			panel.add(physicalstrengthField);
			//======================//
		 
		
        addBtn = new JButton("Add");
		addBtn.setBounds(300,380,100,30);
		addBtn.setFont(font);
		addBtn.setBackground(Color.YELLOW);
		addBtn.addActionListener(this);
		panel.add(addBtn);
		
		
		deleteBtn = new JButton("Delete");
		deleteBtn.setBounds(500,380,120,30);
		deleteBtn.setFont(font);
		deleteBtn.setBackground(Color.RED);
		deleteBtn.addActionListener(this);
		panel.add(deleteBtn);
		
		
		updateBtn = new JButton("Update");
		updateBtn.setBounds(700,380,120,30);
		updateBtn.setFont(font);
		updateBtn.setBackground(Color.GREEN);
		updateBtn.addActionListener(this);
		panel.add(updateBtn);
		
		
       	backBtn = new JButton("<-Back");
		backBtn.setBounds(900,380,120,30);
		backBtn.setFont(font);
		backBtn.setBackground(new Color(115,251,253));
		//backBtn.setBackground(Color.RED);
		backBtn.addActionListener(this);
		panel.add(backBtn);
		
		createTable();
		
		this.setVisible(true);
	}
	
	
	public void  initialization(){
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(1500,800);
		this.setLayout(null);
		this.setLocation(100,50);
		this.setIconImage(new ImageIcon("./Resource/logo.png").getImage());
		JLabel background = new JLabel(new ImageIcon("./Resource/day.jpg"));
		background.setBounds(0,0,1500,800);
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(0,0,1500,800);
		//panel.setBackground(new Color(200,200,200));
		panel.setOpaque(false);
		this.add(panel);
		this.add(background); 
	}
	
	public void createTable(){
		model = new DefaultTableModel();
		model.addColumn("ACCOUNT NO");
		model.addColumn("JOB NAME");
		model.addColumn("JOB STATUS");
		model.addColumn("JOB LOCATION");
		model.addColumn("SALARY");
		model.addColumn("PREFERRED GENDER");
		model.addColumn("AGELIMIT");
		model.addColumn("PHYSICAL STRENGTH");
		table = new JTable(model);
		table.setFont(font);
		table.getTableHeader().setFont(font);
		table.setBounds(0, 0, 1300, 600);
		table.setRowHeight(30);
		table.setBackground(new Color(121,228,230));
		table.setSelectionBackground(new Color(255, 153, 51));
		
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(30,430,1410,400);
		panel.add(scrollPane);
		
		
		ArrayList<DayLabour> allDayLabours = DayLabours.getAll();
		for(Job j : allDayLabours )
		{if( j instanceof DayLabour){
		//DayLabour dayLabourJob = (DayLabour) job;
		//for(int i=0;i<allDayLabours.size();i++){
			DayLabour daylabour = (DayLabour)j;
			model.addRow(new Object[]{daylabour.getAccountNo(),
			daylabour.getJobName(),
			daylabour.getJobStatus(),
			daylabour.getJobLocation(),
			daylabour.getSalary(),
			daylabour.getPreferredGender(),
			daylabour.getageLimit()
			,daylabour.getPhysicalStrength()
			});
		}
		
		}
	}
	
	
		public void updateFile(){
		int rows = model.getRowCount();
		String allLines = "";
		for(int i=0;i<rows;i++){
			int accountNo = Integer.parseInt(table.getModel().getValueAt(i,0).toString());
			String jobName = table.getModel().getValueAt(i,1).toString();
			String jobStatus = table.getModel().getValueAt(i,2).toString();
			String jobLocation=table.getModel().getValueAt(i,3).toString();
			double salary=Double.parseDouble(table.getModel().getValueAt(i,4).toString());
		    String preferredGender=table.getModel().getValueAt(i,5).toString();
			int ageLimit=Integer.parseInt(table.getModel().getValueAt(i,6).toString());
			String physicalstrength=table.getModel().getValueAt(i,7).toString();
			
			
			String line = "";
			if(i<rows-1){
				line =accountNo+";"+jobName+";"+jobStatus+";"+jobLocation+";"+ salary+";"+preferredGender+";"+ageLimit+";"+physicalstrength+"\n";
			}
			else{
				line = accountNo+";"+jobName+";"+jobStatus+";"+jobLocation+";"+ salary+";"+preferredGender+";"+ageLimit+";"+physicalstrength;
			}
			
			allLines += line;
		}
		
		FileIO.writeInFile(allLines,"./Files/DayLabours.txt",false);
	}
	
	
	
	
	
	 public void  actionPerformed(ActionEvent e){
	/* 	if(addBtn == e.getSource()){
			if(!accountNoField.getText().isEmpty() && 
			   !jobNameField.getText().isEmpty() && 
			   !jobStatusField.getText().isEmpty() &&
               !jobLocationField.getText().isEmpty() && 
			   !salaryField.getText().isEmpty() && 
			   !preferredGenderField.getText().isEmpty() && 
			   !ageLimitField.getText().isEmpty() &&
	          !physicalstrengthField.getText().isEmpty()
			   ){
			
			model.addRow(new Object[]{accountNoField.getText(),jobNameField.getText(),
			                         jobStatusField.getText(),jobLocationField.getText(),
			                          salaryField.getText(),preferredGenderField.getText(),ageLimitField.getText()
									  ,physicalstrengthField.getText()
									  });
			
			int accountNo = Integer.parseInt( accountNoField.getText());
			String jobName = jobNameField.getText();
			String jobStatus =jobStatusField.getText();
			String jobLocation = jobLocationField.getText();
			Double salary = Double.parseDouble( salaryField.getText());
			String preferredGender = preferredGenderField.getText();
			int ageLimit = Integer.parseInt(ageLimitField.getText());
			String physicalstrength = physicalstrengthField.getText();
			DayLabour d=new DayLabour(accountNo,jobName,jobStatus,jobLocation,salary,preferredGender,ageLimit,physicalstrength);
			DayLabours.insert(d);
			}
			else{
				JOptionPane.showMessageDialog(this,"Enter All Details", "Warning",JOptionPane.WARNING_MESSAGE );
			}
		} */
		
		
	    if (addBtn == e.getSource()) {
        if (!accountNoField.getText().isEmpty() &&
                !jobNameField.getText().isEmpty() &&
                !jobStatusField.getText().isEmpty() &&
                !jobLocationField.getText().isEmpty() &&
		!salaryField.getText().isEmpty() &&
                !ageLimitField.getText().isEmpty() &&
                !physicalstrengthField.getText().isEmpty()) {

            String preferredGender = (String) preferredGenderComboBox.getSelectedItem(); // Get selected gender

            model.addRow(new Object[]{accountNoField.getText(), jobNameField.getText(),
                    jobStatusField.getText(), jobLocationField.getText(),
                    salaryField.getText(), preferredGender, ageLimitField.getText(),
                    physicalstrengthField.getText()
            });

            int accountNo = Integer.parseInt(accountNoField.getText());
            String jobName = jobNameField.getText();
            String jobStatus = jobStatusField.getText();
            String jobLocation = jobLocationField.getText();
            Double salary = Double.parseDouble(salaryField.getText());
            int ageLimit = Integer.parseInt(ageLimitField.getText());
            String physicalstrength = physicalstrengthField.getText();
            DayLabour d = new DayLabour(accountNo, jobName, jobStatus, jobLocation, salary, preferredGender, ageLimit, physicalstrength);
            DayLabours.insert(d);
        } else {
            JOptionPane.showMessageDialog(this, "Enter All Details", "Warning", JOptionPane.WARNING_MESSAGE);
        }
			}
		
		 			else if(deleteBtn == e.getSource()){
			int rows[] = table.getSelectedRows();
			if(rows != null){
				Arrays.sort(rows);
				for(int i=rows.length-1;i>=0;i--){
					
					DayLabours.removeByAccount(Integer.parseInt(table.getModel().
													getValueAt(rows[i],0).
													toString() ));
					model.removeRow(rows[i]);
				}
				updateFile();
			}
		}
		else if(updateBtn == e.getSource() ){
			updateFile();
		}
		 
		else if(backBtn == e.getSource()){
			mj.setVisible(true);
			this.dispose();
		}
		 else if(e.getSource() == preferredGenderComboBox){
		 String selectedGender = (String) preferredGenderComboBox.getSelectedItem();
        System.out.println("Selected Gender: " + selectedGender);
		}
		
	}
}
	
	
