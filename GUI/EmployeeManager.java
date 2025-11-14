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

public class EmployeeManager extends JFrame implements ActionListener{
	
	JPanel panel;
	JLabel nameLabel,idLabel,ageLabel,genderLabel, bloodGroupLabel, addressLabel, phoneNumberLabel, jobPreferenceLabel,jobStatusLabel;
	JTextField nameField,idField,ageField,genderField, bloodGroupField, addressField, phoneNumberField, jobPreferenceField, jobStatusField;
	JButton addBtn,backBtn,updateBtn,deleteBtn;
	JTable table;
	DefaultTableModel model;
	JComboBox<String> genderComboBox;     //for gender dropdown
	
	Font font = new Font("arial",Font.BOLD,20);
	
	Homepage hp;
	EmployeeList employees;
	public EmployeeManager(Homepage hp, EmployeeList employees){
		super("Employee Manager");
		this.hp = hp;
		this.employees = employees;
		initialization();
		
		//=================//
			nameLabel = new JLabel("NAME");
			nameLabel.setFont(font);
			nameLabel.setBounds(40,20,210,30);
			panel.add(nameLabel);
			
			nameField = new JTextField();
			nameField.setFont(font);
			nameField.setBounds(260,20,300,30);
			panel.add(nameField);
		
		//======================//
		//=================//
			idLabel = new JLabel("ID");
			idLabel.setFont(font);
			idLabel.setBounds(40,60,210,30);
			panel.add(idLabel);
			
			idField = new JTextField();
			idField.setFont(font);
			idField.setBounds(260,60,300,30);
			panel.add(idField);
		
		//======================//
		//=================//
			ageLabel = new JLabel("Age");
			ageLabel.setFont(font);
			ageLabel.setBounds(40,100,210,30);
			panel.add(ageLabel );
			
			ageField = new JTextField();
			ageField.setFont(font);
			ageField.setBounds(260,100,300,30);
			panel.add(ageField);
		
		//======================//
		//=================//
			genderLabel = new JLabel("Gender");
			genderLabel.setFont(font);
			genderLabel.setBounds(40,140,210,30);
			panel.add(genderLabel );
			
/* 			genderField = new JTextField();
			genderField.setFont(font);
			genderField.setBounds(260,140,300,30);
			panel.add(genderField); */
			
		genderComboBox = new JComboBox<>(new String[]{"Male", "Female", "Other"});
        genderComboBox.setFont(font);
        genderComboBox.setBounds(260, 140, 300, 30);
        panel.add(genderComboBox);
			
		//======================//	
		//=================//
			bloodGroupLabel = new JLabel("Blood Group");
			bloodGroupLabel.setFont(font);
			bloodGroupLabel.setBounds(40,180,210,30);
			panel.add(bloodGroupLabel);
			
			bloodGroupField = new JTextField();
			bloodGroupField.setFont(font);
			bloodGroupField.setBounds(260,180,300,30);
			panel.add(bloodGroupField);
		
		//======================//
		//=================//
			addressLabel = new JLabel("Address");
			addressLabel.setFont(font);
			addressLabel.setBounds(40,220,210,30);
			panel.add(addressLabel);
			
			addressField = new JTextField();
			addressField.setFont(font);
			addressField.setBounds(260,220,300,30);
			panel.add(addressField);
		
		//======================//
		//=================//
			phoneNumberLabel = new JLabel("Mobile");
			phoneNumberLabel.setFont(font);
			phoneNumberLabel.setBounds(40,260,210,30);
			panel.add(phoneNumberLabel);
			
			phoneNumberField = new JTextField();
			phoneNumberField.setFont(font);
			phoneNumberField.setBounds(260,260,300,30);
			panel.add(phoneNumberField);
			
		//======================//
		//=================//
			jobPreferenceLabel = new JLabel("Job Preference");
			jobPreferenceLabel.setFont(font);
			jobPreferenceLabel.setBounds(40,300,210,30);
			panel.add(jobPreferenceLabel);
			
			jobPreferenceField = new JTextField();
			jobPreferenceField.setFont(font);
			jobPreferenceField.setBounds(260,300,300,30);
			panel.add(jobPreferenceField);
			
			
		//======================//
		//=================//
			jobStatusLabel = new JLabel("Job Status");
			jobStatusLabel.setFont(font);
			jobStatusLabel.setBounds(40,340,210,30);
			panel.add(jobStatusLabel);
			
			jobStatusField = new JTextField();
			jobStatusField.setFont(font);
			jobStatusField.setBounds(260,340,300,30);
			panel.add(jobStatusField);
			
			
		//======================//
		addBtn = new JButton("Add");
		addBtn.setBounds(300,390,120,30);
		addBtn.setFont(font);
		addBtn.setBackground(Color.YELLOW);
		addBtn.addActionListener(this);
		panel.add(addBtn);
		
		
		deleteBtn = new JButton("Delete");
		deleteBtn.setBounds(500,390,120,30);
		deleteBtn.setFont(font);
		deleteBtn.setBackground(Color.RED);
		//deleteBtn.setForeground(Color.RED);
		deleteBtn.addActionListener(this);
		panel.add(deleteBtn);
		
		updateBtn = new JButton("Update");
		updateBtn.setBounds(700,390,120,30);
		updateBtn.setFont(font);
		updateBtn.setBackground(Color.GREEN);
		//updateBtn.setForeground(Color.RED);
		updateBtn.addActionListener(this);
		panel.add(updateBtn);
		
		
		backBtn = new JButton("<-Back");
		backBtn.setBounds(900,390,120,30);
		backBtn.setFont(font);
		backBtn.setBackground(new Color(115,251,253));
		//backBtn.setBackground(Color.RED);
		backBtn.addActionListener(this);
		panel.add(backBtn);
		
		createTable();
		
		this.setVisible(true);
	}
	
	
	public void initialization(){
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(1600,900);
		this.setLayout(null);
		this.setLocation(100,50);
		this.setIconImage(new ImageIcon("./Resource/logo.png").getImage());
		JLabel background = new JLabel(new ImageIcon("./Resource/employee.jpg"));
		background.setBounds(0,0,1600,900);
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(0,0,1600,900);
		//panel.setBackground(new Color(200,200,200));
		panel.setOpaque(false);
		this.add(panel);
		this.add(background);
	}
	
	
	public void createTable(){
		model = new DefaultTableModel();
		model.addColumn("NAME");
		model.addColumn("ID");
		model.addColumn("AGE");
		model.addColumn("GENDER");
		model.addColumn("BLOOD GROUP");
		model.addColumn("ADDRESS");
		model.addColumn("PHONE NUMBER");
		model.addColumn("PREFERRED JOB");
		model.addColumn("JOB STATUS");
		
		table = new JTable(model);
		table.setFont(font);
		table.getTableHeader().setFont(font);
		table.setBounds(0, 0, 1500, 600);
		table.setRowHeight(30);
		table.setBackground(new Color(121,228,230));
		table.setSelectionBackground(new Color(255, 153, 51));
		
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(20,450,1550,600);
		
		ArrayList<Employee> allEmployees = employees.getAll();
		
		for(int i=0;i<allEmployees.size();i++){
			Employee employee = allEmployees.get(i);
			model.addRow(new Object[]{employee.getPersonName(),employee.getPersonId(),employee.getPersonAge(), employee.getGender(),employee.getBloodGroup(),
									employee.getAddress(), employee.getPhoneNumber(), employee.getJobPreference(),employee.getJobStatus()});
		}
		
		panel.add(scrollPane);
	}
	
	public void updateFile(){
		int rows = model.getRowCount();
		String allLines = "";
		for(int i=0;i<rows;i++){
			String personName = table.getModel().getValueAt(i,0).toString();
			int personId =Integer.parseInt( table.getModel().getValueAt(i,1).toString());
			int personAge = Integer.parseInt(table.getModel().getValueAt(i,2).toString());
			String gender=table.getModel().getValueAt(i,3).toString();
			String bloodGroup=table.getModel().getValueAt(i,4).toString();
		    String address=table.getModel().getValueAt(i,5).toString();
			String phoneNumber=table.getModel().getValueAt(i,6).toString();
			String jobPreference=table.getModel().getValueAt(i,7).toString();
			String jobStatus=table.getModel().getValueAt(i,8).toString();
			
			String line = "";
			if(i<rows-1){
				line =personName +";"+personId+";"+personAge+";"+gender+";"+bloodGroup+";"+address+";"+phoneNumber+";"+jobPreference+";"+jobStatus+"\n";
			}
			else{
				line = personName +";"+personId+";"+personAge+";"+gender+";"+bloodGroup+";"+address+";"+phoneNumber+";"+jobPreference+";"+jobStatus;
			}
			allLines += line;
		}
		FileIO.writeInFile(allLines,"./Files/employees.txt",false);
	}
	
	
	public void  actionPerformed(ActionEvent e){
/* 		if(addBtn == e.getSource()){
			if(!nameField.getText().isEmpty() &&
				!idField.getText().isEmpty() && 
			   !ageField.getText().isEmpty() && 
			   !genderField.getText().isEmpty() && 
			   !bloodGroupField.getText().isEmpty() && 
			   !addressField.getText().isEmpty() && 
			   !phoneNumberField.getText().isEmpty() &&
               !jobPreferenceField.getText().isEmpty()&& 
			   !jobStatusField.getText().isEmpty() ){
			
			model.addRow(new Object[]{nameField.getText(),idField.getText(),ageField.getText(),genderField.getText(), bloodGroupField.getText(),
										addressField.getText(),phoneNumberField.getText(),jobPreferenceField.getText(),jobStatusField.getText()});
			
			String personName = nameField.getText();
			int personId= Integer.parseInt( idField.getText());
			int personAge= Integer.parseInt(ageField.getText());
			String gender = genderField.getText();
			String bloodGroup = bloodGroupField.getText();
			String address = addressField.getText();
			String phoneNumber = phoneNumberField.getText();
			String jobPreference = jobPreferenceField.getText();
			String jobStatus = jobStatusField.getText();
			Employee c = new Employee(personName,personId,personAge,gender,bloodGroup,address,phoneNumber,jobPreference,jobStatus);	
			employees.insert(c);
			}
			else{
				JOptionPane.showMessageDialog(this,"Enter All Details", "Warning",JOptionPane.WARNING_MESSAGE );
			}
		} */
		
		
			if(addBtn == e.getSource()){
			if(!nameField.getText().isEmpty() &&
				!idField.getText().isEmpty() && 
			   !ageField.getText().isEmpty() &&  
			   !bloodGroupField.getText().isEmpty() && 
			   !addressField.getText().isEmpty() && 
			   !phoneNumberField.getText().isEmpty() &&
               !jobPreferenceField.getText().isEmpty()&& 
			   !jobStatusField.getText().isEmpty() ){
				   
			String gender = (String) genderComboBox.getSelectedItem(); // Get selected gender
			
			model.addRow(new Object[]{nameField.getText(),idField.getText(),ageField.getText(),gender, bloodGroupField.getText(),
										addressField.getText(),phoneNumberField.getText(),jobPreferenceField.getText(),jobStatusField.getText()});
			
			String personName = nameField.getText();
			int personId= Integer.parseInt( idField.getText());
			int personAge= Integer.parseInt(ageField.getText());
			String bloodGroup = bloodGroupField.getText();
			String address = addressField.getText();
			String phoneNumber = phoneNumberField.getText();
			String jobPreference = jobPreferenceField.getText();
			String jobStatus = jobStatusField.getText();
			Employee c = new Employee(personName,personId,personAge,gender,bloodGroup,address,phoneNumber,jobPreference,jobStatus);	
			employees.insert(c);
			}
			else{
				JOptionPane.showMessageDialog(this,"Enter All Details", "Warning",JOptionPane.WARNING_MESSAGE );
			}
			
			
			}
			else if(deleteBtn == e.getSource()){
			int rows[] = table.getSelectedRows();
			if(rows != null){
				Arrays.sort(rows);
				for(int i=rows.length-1;i>=0;i--){
					
					employees.removeByID(Integer.parseInt(table.getModel().
													getValueAt(rows[i],1).
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
			hp.setVisible(true);
			this.dispose();
		}
		 	 else if(e.getSource() == genderComboBox){
		 String selectedGender = (String) genderComboBox.getSelectedItem();
        System.out.println("Selected Gender: " + selectedGender);
			 }
		
	}
}