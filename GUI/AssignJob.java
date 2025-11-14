package GUI;
import Entity.*;
import EntityList.*;
import Files.*;
import java.util.ArrayList;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.datatransfer.*;
import javax.swing.table.*;
public class AssignJob extends JFrame implements ActionListener{
	
	JPanel panel;
	JLabel table1Label,table2Label,table3Label,table4Label,table5Label,table6Label;
	JButton assignBtn,backBtn, updateBtn,deleteBtn;
	JTable table1,table2, table3, table4, table5, table6;
	DefaultTableModel model1,model2, model3, model4, model5, model6;
	
	Font font = new Font("arial",Font.BOLD,12);
	
	Homepage hp;
	EmployeeList employees;
	//JobList Jobs;
	DayLabourList DayLabours ;
    PartTimeList PartTimes;
    FullTimeList FullTimes ;
    FixedList Fixeds;
public AssignJob(Homepage hp,EmployeeList employees,DayLabourList DayLabours, PartTimeList PartTimes, FullTimeList FullTimes,FixedList Fixeds){	

		super("Assign Job");
		this.hp = hp;
		this.employees = employees;
		this.DayLabours=DayLabours;
		this.PartTimes=PartTimes;
		this.FullTimes=FullTimes;
		this.Fixeds=Fixeds;
		initialization();
		
		table1Label = new JLabel("Employee List");
		table1Label.setBounds(880,10,280,20);
		table1Label.setFont(font);
		panel.add(table1Label);
		
		table2Label = new JLabel("Day Labour List");
		table2Label.setBounds(140,10,280,20);
		table2Label.setFont(font);
		panel.add(table2Label);
		
		table3Label = new JLabel("Part Time List");
		table3Label.setBounds(470,10,280,20);
		table3Label.setFont(font);
		panel.add(table3Label);
		
		table4Label = new JLabel("Full Time List");
		table4Label.setBounds(140,300,280,20);
		table4Label.setFont(font);
		panel.add(table4Label);
		
		table5Label = new JLabel("Fixed List");
		table5Label.setBounds(480,300,280,20);
		table5Label.setFont(font);
		panel.add(table5Label);
		
		table6Label = new JLabel("Assign Job List");
		table6Label.setBounds(880,300,280,20);
		table6Label.setFont(font);
		panel.add(table6Label);
		
		backBtn = new JButton("<-Back");
		backBtn.setBounds(250,600,160,30);
		backBtn.setFont(font);
		backBtn.setBackground(new Color(115,251, 253));
		backBtn.addActionListener(this);
		panel.add(backBtn);
		
		assignBtn = new JButton("Assign");
		assignBtn.setBounds(450,600,160,30);
		assignBtn.setFont(font);
		assignBtn.setBackground(Color.YELLOW);
		assignBtn.addActionListener(this);
		panel.add(assignBtn);
		
		updateBtn = new JButton("Update");
		updateBtn.setBounds(650,600,160,30);
		updateBtn.setFont(font);
		updateBtn.setBackground(Color.GREEN);
		updateBtn.addActionListener(this);
		panel.add(updateBtn);
		
		deleteBtn = new JButton("Delete");
		deleteBtn.setBounds(850,600,160,30);
		deleteBtn.setFont(font);
		deleteBtn.setBackground(Color.RED);
		deleteBtn.addActionListener(this);
		panel.add(deleteBtn);
		 
		 createTable();
		
		this.setVisible(true);
	}
	
	
	public void initialization(){
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(1250,700);
		this.setSize(1250,700);
		this.setLayout(null);
		this.setLocation(100,50);
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(0,0,1250,900);
		panel.setBackground(new Color(202,216,242 ));
		this.add(panel);
	}
	
	public void createTable(){
		model1 = new DefaultTableModel();
		model1.addColumn("EMPLOYEE ID");
		model1.addColumn("JOB PREFERENCE");
		model1.addColumn("JOB STATUS");
		
		table1 = new JTable(model1);
		table1.setFont(font);
		table1.getTableHeader().setFont(font);
		table1.setBounds(0, 0, 480, 250);
		table1.setRowHeight(30);
		table1.setBackground(new Color(121,228,230));
		table1.setSelectionBackground(new Color(255, 153, 51));
		
		
		JScrollPane scrollPane1 = new JScrollPane(table1);
		scrollPane1.setBounds(690,40,480,250);
		
		ArrayList<Employee> allEmployees = employees.getAll();
		
		for(int i=0;i<allEmployees.size();i++){
			Employee employee = allEmployees.get(i);
			model1.addRow(new Object[]{employee.getPersonId(),employee.getJobStatus(), employee.getJobPreference()});
		}
		
		panel.add(scrollPane1);
		
		
		
		
		model2 = new DefaultTableModel();
		model2.addColumn("DAY LABOUR ID");
		model2.addColumn("JOB NAME");
		model2.addColumn("JOB STATUS");
		
		table2 = new JTable(model2);
		table2.setFont(font);
		table2.getTableHeader().setFont(font);
		table2.setBounds(0, 0, 330, 250);
		table2.setRowHeight(30);
		table2.setBackground(new Color(121,228,230));
		table2.setSelectionBackground(new Color(255, 153, 51));
		
		
 		JScrollPane scrollPane2 = new JScrollPane(table2);
		scrollPane2.setBounds(10,40,330,250);   
		
		ArrayList<DayLabour> allDayLabours = DayLabours.getAll();
		
		for(int i=0;i<allDayLabours.size();i++){
				DayLabour dayLabour = allDayLabours.get(i);
			model2.addRow(new Object[]{dayLabour.getAccountNo(),dayLabour.getJobName(),dayLabour.getJobStatus()});
		}
		
		panel.add(scrollPane2);
		
		model3 = new DefaultTableModel();
		model3.addColumn("PART TIME ID");
		model3.addColumn("JOB NAME");
		model3.addColumn("JOB STATUS");
		
		table3 = new JTable(model3);
		table3.setFont(font);
		table3.getTableHeader().setFont(font);
		table3.setBounds(0, 0, 330, 250);
		table3.setRowHeight(30);
		table3.setBackground(new Color(121,228,230));
		table3.setSelectionBackground(new Color(255, 153, 51));
		
		
 		JScrollPane scrollPane3 = new JScrollPane(table3);
		scrollPane3.setBounds(350,40,330,250);   
		
		ArrayList<PartTime> allPartTimes = PartTimes.getAll();
		
		for(int i=0;i<allPartTimes.size();i++){
			PartTime partTime = allPartTimes.get(i);
			model3.addRow(new Object[]{partTime.getAccountNo(),partTime.getJobName(),partTime.getJobStatus()});
		}
		
		panel.add(scrollPane3);
		
		model4 = new DefaultTableModel();
		model4.addColumn("FULL TIME ID");
		model4.addColumn("JOB NAME");
		model4.addColumn("JOB STATUS");
		
		table4 = new JTable(model4);
		table4.setFont(font);
		table4.getTableHeader().setFont(font);
		table4.setBounds(0, 0, 330, 250);
		table4.setRowHeight(30);
		table4.setBackground(new Color(121,228,230));
		table4.setSelectionBackground(new Color(255, 153, 51));
		
		
 		JScrollPane scrollPane4 = new JScrollPane(table4);
		scrollPane4.setBounds(10,330,330,250);   
		
		ArrayList<FullTime> allFullTimes = FullTimes.getAll();
		
		for(int i=0;i<allFullTimes.size();i++){
			FullTime fullTime = allFullTimes.get(i);
			model4.addRow(new Object[]{fullTime.getAccountNo(), fullTime.getJobName(),fullTime.getJobStatus()});
		}
		
		panel.add(scrollPane4);
		
		model5 = new DefaultTableModel();
		model5.addColumn("FIXED ID");
		model5.addColumn("JOB NAME");
		model5.addColumn("JOB STATUS");
		
		table5 = new JTable(model5);
		table5.setFont(font);
		table5.getTableHeader().setFont(font);
		table5.setBounds(0, 0, 330, 250);
		table5.setRowHeight(30);
		table5.setBackground(new Color(121,228,230));
		table5.setSelectionBackground(new Color(255, 153, 51));
		
		
 		JScrollPane scrollPane5 = new JScrollPane(table5);
		scrollPane5.setBounds(350,330,330,250);   
		
		ArrayList<Fixed> allFixeds = Fixeds.getAll();
		
		for(int i=0;i<allFixeds.size();i++){
			Fixed fixed = allFixeds.get(i);
			model5.addRow(new Object[]{fixed.getAccountNo(),fixed.getJobName(),fixed.getJobStatus()});
		}
		
		panel.add(scrollPane5);
		
		
		model6 = new DefaultTableModel();
        model6.addColumn("EMPLOYEE ID");
        model6.addColumn("JOB ID");
        model6.addColumn("JOB NAME");
		FileIO.loadAssignedJobs(model6);
        table6 = new JTable(model6);

		
		
		table6.setFont(font);
		table6.getTableHeader().setFont(font);
		table6.setBounds(0, 0, 500, 250);
		table6.setRowHeight(30);
		table6.setBackground(new Color(248,177,233));
		table6.setSelectionBackground(new Color(255, 153, 51));
		
 		JScrollPane scrollPane6 = new JScrollPane(table6);
        scrollPane6.setBounds(690, 330, 480, 250);
        panel.add(scrollPane6);
		
	} 
	
			public void updateFile(){
			int rows = model6.getRowCount();
		String allLines = "";
		for(int i=0;i<rows;i++){
			int personId =Integer.parseInt( table6.getModel().getValueAt(i,0).toString());
			String jobStatus=table6.getModel().getValueAt(i,1).toString();
			String jobName=table6.getModel().getValueAt(i,2).toString();
			
			String line = "";
			if(i<rows-1){
				line =personId+";"+jobStatus+";"+jobName+"\n";
			}
			else{
				line = personId+";"+jobStatus+";"+jobName;
			}
			allLines += line;
		}
			
		FileIO.writeInFile(allLines,"./Files/JobAssignment.txt",false);
	}
	
	 
	
	
	public void actionPerformed(ActionEvent e) {
	
    int selectedEmployeeRow = table1.getSelectedRow();
    int selectedDayLabourRow = table2.getSelectedRow();
    int selectedPartTimeRow = table3.getSelectedRow();
    int selectedFullTimeRow = table4.getSelectedRow();
    int selectedFixedRow = table5.getSelectedRow();
    int selectedAssignedRow= table6.getSelectedRow();
    	

	if (backBtn == e.getSource()) {
        hp.setVisible(true);
        this.dispose();
    }

  	else if(assignBtn==e.getSource()){
	
	if (selectedEmployeeRow != -1 && selectedDayLabourRow != -1) {
		int employeeId = Integer.parseInt(table1.getModel().getValueAt(selectedEmployeeRow, 0).toString());
		int jobIdD = Integer.parseInt(table2.getModel().getValueAt(selectedDayLabourRow, 0).toString());
		int statusE = FileIO.checkEmployeeId("./Files/JobAssignment.txt",employeeId);
		int statusD = FileIO.checkDayLabourId("./Files/JobAssignment.txt",jobIdD);


			
			if((statusE == 1 && statusD==1)){
				int personId = Integer.parseInt( table1.getValueAt(selectedEmployeeRow, 0).toString());
				int  accountNo = Integer.parseInt( table2.getValueAt(selectedDayLabourRow, 0).toString());
				String jobName = table2.getValueAt(selectedDayLabourRow, 1).toString();
        
				model6 = (DefaultTableModel) table6.getModel();
				model6.addRow(new Object[]{personId, accountNo, jobName});
				table1.clearSelection();
				table2.clearSelection();

			}
			
			else if(statusE == 2){
				JOptionPane.showMessageDialog(this,"This Employee has Already been assigned a Job", "Error!", JOptionPane.WARNING_MESSAGE);
				table1.clearSelection();
				table2.clearSelection();
			}
			
			else if(statusD == 2){
				JOptionPane.showMessageDialog(this,"This Job has Already been Assigned to an Employee", "Error!", JOptionPane.WARNING_MESSAGE);
				table1.clearSelection();
				table2.clearSelection();
			}
    }
	else if(selectedEmployeeRow != -1 && selectedPartTimeRow != -1){
		int employeeId = Integer.parseInt(table1.getModel().getValueAt(selectedEmployeeRow, 0).toString());
		int jobIdP = Integer.parseInt(table3.getModel().getValueAt(selectedPartTimeRow, 0).toString());
		int statusE = FileIO.checkEmployeeId("./Files/JobAssignment.txt",employeeId);
		int statusP = FileIO.checkPartTimeId("./Files/JobAssignment.txt",jobIdP);
		
			
			if((statusE == 1 && statusP==1)){
				int personId = Integer.parseInt(table1.getValueAt(selectedEmployeeRow, 0).toString());
				int  accountNo = Integer.parseInt( table3.getValueAt(selectedPartTimeRow, 0).toString());
				String jobName = table3.getValueAt(selectedPartTimeRow, 1).toString();
		
				model6 = (DefaultTableModel) table6.getModel();
				model6.addRow(new Object[]{personId, accountNo, jobName});
				table1.clearSelection();
				table3.clearSelection();
			}
			
			else if(statusE == 2){
				JOptionPane.showMessageDialog(this,"This Employee has Already been assigned a Job", "Error!", JOptionPane.WARNING_MESSAGE);
				table1.clearSelection();
				table3.clearSelection();
			}
			
			else if(statusP == 2){
				JOptionPane.showMessageDialog(this,"This Job has Already been Assigned to an Employee", "Error!", JOptionPane.WARNING_MESSAGE);
				table1.clearSelection();
				table3.clearSelection();
			}
		
	}
	
	else if(selectedEmployeeRow != -1 && selectedFullTimeRow != -1){
		int employeeId = Integer.parseInt(table1.getModel().getValueAt(selectedEmployeeRow, 0).toString());
		int jobIdFt = Integer.parseInt(table4.getModel().getValueAt(selectedFullTimeRow, 0).toString());
		int statusE = FileIO.checkEmployeeId("./Files/JobAssignment.txt",employeeId);
		int statusFt = FileIO.checkFullTimeId("./Files/JobAssignment.txt",jobIdFt);
			
			
			if((statusE == 1 && statusFt==1)){
				int personId = Integer.parseInt(  table1.getValueAt(selectedEmployeeRow, 0).toString());
				int  accountNo = Integer.parseInt( table4.getValueAt(selectedFullTimeRow, 0).toString());
				String jobName = table4.getValueAt(selectedFullTimeRow, 1).toString();
		
				model6 = (DefaultTableModel) table6.getModel();
				model6.addRow(new Object[]{personId, accountNo, jobName});
				table1.clearSelection();
				table4.clearSelection();
			}
			
			else if(statusE == 2){
				JOptionPane.showMessageDialog(this,"This Employee has Already been assigned a Job", "Error!", JOptionPane.WARNING_MESSAGE);
				table1.clearSelection();
				table4.clearSelection();
			}
			
			else if(statusFt == 2){
				JOptionPane.showMessageDialog(this,"This Job has Already been Assigned to an Employee", "Error!", JOptionPane.WARNING_MESSAGE);
				table1.clearSelection();
				table4.clearSelection();
			}
		
	}
	
	else if(selectedEmployeeRow != -1 && selectedFixedRow != -1){
		int employeeId = Integer.parseInt(table1.getModel().getValueAt(selectedEmployeeRow, 0).toString());
		int jobIdF = Integer.parseInt(table5.getModel().getValueAt(selectedFixedRow, 0).toString());
		int statusE = FileIO.checkEmployeeId("./Files/JobAssignment.txt",employeeId);
		int statusF= FileIO.checkFixedId("./Files/JobAssignment.txt",jobIdF);
			
			
			if((statusE == 1 && statusF==1)){
				int personId = Integer.parseInt(  table1.getValueAt(selectedEmployeeRow, 0).toString());
				int  accountNo = Integer.parseInt( table5.getValueAt(selectedFixedRow, 0).toString());
				String jobName = table5.getValueAt(selectedFixedRow, 1).toString();
		
				model6 = (DefaultTableModel) table6.getModel();
				model6.addRow(new Object[]{personId, accountNo, jobName});
				table1.clearSelection();
				table5.clearSelection();
			}
			
			else if(statusE == 2){
				JOptionPane.showMessageDialog(this,"This Employee has Already been assigned a Job", "Error!", JOptionPane.WARNING_MESSAGE);
				table1.clearSelection();
				table5.clearSelection();
			}
			
			else if(statusF == 2){
				JOptionPane.showMessageDialog(this,"This Job has Already been Assigned to an Employee", "Error!", JOptionPane.WARNING_MESSAGE);
				table1.clearSelection();
				table5.clearSelection();
			}
	}
	
} 	
	else if(updateBtn == e.getSource() ){
			updateFile();
		}
		   else if (backBtn == e.getSource()) {
        hp.setVisible(true);
        this.dispose();
    }
		else if(deleteBtn == e.getSource()){
			int rows[] = table6.getSelectedRows();
			if (selectedAssignedRow != -1) {
            model6.removeRow(selectedAssignedRow);
        }
				updateFile();
			}	
	
	
	} 
}  

