package Files;
import java.lang.*;
import java.util.*;
import javax.swing.JOptionPane;
import java.io.*;
import EntityList.*;
import Entity.*;
import javax.swing.table.*;
public class FileIO{
	
	public static int checkUserLogin(String fname,String uname, String upass){
		int statusE = 0;
		try{
			Scanner sc = new Scanner(new File(fname));
			while(sc.hasNextLine()){
				String row = sc.nextLine();
				String cols[] = row.split(";");
				
				String name = cols[0];
				String pass = cols[1];
				
				if(uname.equals(name) && upass.equals(pass)){
					statusE = 1;
					break;
				}
				else if(uname.equals(name) && !upass.equals(pass)){
					statusE = 2;
				}
			}
			sc.close();
		}

		catch(FileNotFoundException e){
			System.out.println("Cannot Read From File");
		}
		return statusE;
	}
	
	
	public static int checkEmployeeId(String filePath,int idOfEmployee){
		int status = 0;
		try{
			Scanner sc = new Scanner(new File(filePath));
			while(sc.hasNextLine()){
				String row = sc.nextLine();
				String cols[] = row.split(";");
				
				int employeeId = Integer.parseInt(cols[0].toString());
				
				if(idOfEmployee!=employeeId){
					status = 1;
				}
				
				else if(idOfEmployee==employeeId){
					status = 2;
					break;
				}
			}
			sc.close();
		}
		catch(FileNotFoundException e){
			System.out.println("Cannot Read From File");
		}
		return status;
	}
	
	public static int checkDayLabourId(String filePath,int dayLabourId){
		int statusD = 0;
		try{
			Scanner sc = new Scanner(new File(filePath));
			while(sc.hasNextLine()){
				String row = sc.nextLine();
				String cols[] = row.split(";");
				
				int jobIdD = Integer.parseInt(cols[1].toString());
				
				if(dayLabourId!=jobIdD){
					statusD = 1;
				}
				
				else if(dayLabourId==jobIdD){
					statusD = 2;
					break;
				}
			}
			sc.close();
		}
		catch(FileNotFoundException e){
			System.out.println("Cannot Read From File");
		}
		return statusD;
	}
	
	public static int checkPartTimeId(String filePath,int partTimeId){
		int statusP = 0;
		try{
			Scanner sc = new Scanner(new File(filePath));
			while(sc.hasNextLine()){
				String row = sc.nextLine();
				String cols[] = row.split(";");
				
				int jobIdP = Integer.parseInt(cols[1].toString());
				
				if(partTimeId!=jobIdP){
					statusP = 1;
				}
				
				else if(partTimeId==jobIdP){
					statusP = 2;
					break;
				}
			}
			sc.close();
		}
		catch(FileNotFoundException e){
			System.out.println("Cannot Read From File");
		}
		return statusP;
	}
	
	public static int checkFullTimeId(String filePath,int fullTimeId){
		int statusFt = 0;
		try{
			Scanner sc = new Scanner(new File(filePath));
			while(sc.hasNextLine()){
				String row = sc.nextLine();
				String cols[] = row.split(";");
				
				int jobIdFt = Integer.parseInt(cols[1].toString());
				
				if(fullTimeId!=jobIdFt){
					statusFt = 1;
				}
				
				else if(fullTimeId==jobIdFt){
					statusFt = 2;
					break;
				}
			}
			sc.close();
		}
		catch(FileNotFoundException e){
			System.out.println("Cannot Read From File");
		}
		return statusFt;
	}
	
	public static int checkFixedId(String filePath,int fixedId){
		int statusF = 0;
		try{
			Scanner sc = new Scanner(new File(filePath));
			while(sc.hasNextLine()){
				String row = sc.nextLine();
				String cols[] = row.split(";");
				
				int jobIdF = Integer.parseInt(cols[1].toString());
							
				if(fixedId!=jobIdF){
					statusF = 1;
				}
				
				else if(fixedId==jobIdF){
					statusF = 2;
					break;
				}
			}
			sc.close();
		}
		catch(FileNotFoundException e){
			System.out.println("Cannot Read From File");
		}
		return statusF;
	}
	
	
	public static boolean registerUser(String fname, String uname, String upass){
		if(checkUserLogin(fname,uname,upass) == 0){			
			try {
				FileWriter writer = new FileWriter(fname,true);
				writer.write(uname+";"+upass+"\n");
				writer.close();
			} catch (Exception e){
				System.out.println("Cannot Write in File");
			}
			return true;
		}
		
		return false;
	}
	
	
	public static void readFromFile(String fname){
		try{
			Scanner sc = new Scanner(new File(fname));
			while(sc.hasNextLine()){
				String row = sc.nextLine();
				String cols[] = row.split(";");
				
				String name = cols[0];
				String pass = cols[1];
				//int id = cols[2];
				int id = Integer.parseInt( cols[2] );
				int age = Integer.parseInt( cols[3] );
				String gender = cols[4];
				String bloodGroup = cols[5];
				String address = cols[6];
				String phoneNumber = cols[7];
				String jobPreference = cols[8];
				String jobStatus = cols[9];
		
				System.out.println("-------------------");
				System.out.println("User Name : "+name);
				System.out.println("User ID : "+id);
				System.out.println("User Age : "+age);
				System.out.println("User Gender : "+gender);
				System.out.println("User Blood Group : "+bloodGroup);
				System.out.println("User Address : "+address);
				System.out.println("User phone Number : "+phoneNumber);
				System.out.println("User Job Preference : "+jobPreference);
				System.out.println("User Job Status : "+jobStatus);
			}
			sc.close();
		}
		catch(FileNotFoundException e){
			System.out.println("Cannot Read From File");
		}
	}
	
	public static void writeInFile(String line, String fname, boolean append){
		try {
			FileWriter writer = new FileWriter(fname,append);
			writer.write(line+"\n");
			writer.close();
		} catch (Exception e){
			System.out.println("Cannot Write in File");
		}
	}
	
	           //=============For Employee=================//
		
		public static void loadEmployeesFromFile(EmployeeList employees, String fname){
		try{
			Scanner sc = new Scanner(new File(fname));
			while(sc.hasNextLine()){
				String row = sc.nextLine();
				String cols[] = row.split(";");
				
				
					
				 String personName=cols[0];
				 int personId=Integer.parseInt( cols[1] );
				 int personAge=Integer.parseInt( cols[2] );
				 String gender=cols[3];
				 String bloodGroup=cols[4];
				 String address=cols[5];
				 String phoneNumber=cols[6];
				 String jobPreference=cols[7];
				 String jobStatus=cols[8]; //Isn't employee or not
				 
				
		employees.insert(new Employee(personName,personId,personAge,gender,bloodGroup,address,phoneNumber,jobPreference,jobStatus));
	
			
				
			}
			sc.close();
		}
		catch(FileNotFoundException e){
			System.out.println("Cannot Read From File");
		}
	}
	
	          //=============For  DayLabours=================//
	
			public static void loadDayLaboursFromFile(DayLabourList  DayLabours , String fname){
		try{
			Scanner sc = new Scanner(new File(fname));
			while(sc.hasNextLine()){
				String row = sc.nextLine();
				String cols[] = row.split(";");
				
				
				 
				 int accountNo=Integer.parseInt(cols[0]);
				 String jobName= cols[1] ;
				 String jobStatus=cols[2] ;
				 String jobLocation=cols[3];
				 double salary=Double.parseDouble(cols[4]);
				 String preferredGender=cols[5];
				 int ageLimit=Integer.parseInt(cols[6]);
				 String physicalstrength=cols[7];
				
	            DayLabours.insert(new DayLabour(accountNo, jobName,jobStatus, jobLocation,salary, preferredGender,ageLimit,physicalstrength));
	
			
				
			}
			sc.close();
		}
		catch(FileNotFoundException e){
			System.out.println("Cannot Read From File");
		}
	}
	
	
	                   //=============For PartTimes =================//
	
				public static void loadPartTimesFromFile(PartTimeList PartTimes , String fname){
		try{
			Scanner sc = new Scanner(new File(fname));
			while(sc.hasNextLine()){
				String row = sc.nextLine();
				String cols[] = row.split(";");
				
				
				 
				 int accountNo=Integer.parseInt(cols[0]);
				 String jobName= cols[1] ;
				 String jobStatus=cols[2] ;
				 String jobLocation=cols[3];
				 double salary=Double.parseDouble(cols[4]);
				 String preferredGender=cols[5];
				 int ageLimit=Integer.parseInt(cols[6]);
				 String shift=cols[7];
				
	           PartTimes.insert(new PartTime (accountNo, jobName,jobStatus, jobLocation,salary, preferredGender,ageLimit,shift));
	
			
				
			}
			sc.close();
		}
		catch(FileNotFoundException e){
			System.out.println("Cannot Read From File");
		}
	}
	
	
	                   
	                   //=============For FullTimes =================//
	
	
					public static void loadFullTimesFromFile(FullTimeList FullTimes , String fname){
		try{
			Scanner sc = new Scanner(new File(fname));
			while(sc.hasNextLine()){
				String row = sc.nextLine();
				String cols[] = row.split(";");
				
				
				 
				 int accountNo=Integer.parseInt(cols[0]);
				 String jobName= cols[1] ;
				 String jobStatus=cols[2] ;
				 String jobLocation=cols[3];
				 double salary=Double.parseDouble(cols[4]);
				 String preferredGender=cols[5];
				 int ageLimit=Integer.parseInt(cols[6]);
				 String overTimepayRate=cols[7];
				
	          FullTimes.insert(new FullTime(accountNo, jobName,jobStatus, jobLocation,salary, preferredGender,ageLimit,overTimepayRate));
	
			
				
			}
			sc.close();
		}
		catch(FileNotFoundException e){
			System.out.println("Cannot Read From File");
		}
	}
	
	
		//=============For Fixed =================//
		
					public static void loadFixedsFromFile(FixedList Fixeds , String fname){
		try{
			Scanner sc = new Scanner(new File(fname));
			while(sc.hasNextLine()){
				String row = sc.nextLine();
				String cols[] = row.split(";");
				
				
				 
				 int accountNo=Integer.parseInt(cols[0]);
				 String jobName= cols[1] ;
				 String jobStatus=cols[2] ;
				 String jobLocation=cols[3];
				 double salary=Double.parseDouble(cols[4]);
				 String preferredGender=cols[5];
				 int ageLimit=Integer.parseInt(cols[6]);
				 String contactDuration=cols[7];
				
	          Fixeds.insert(new Fixed(accountNo, jobName,jobStatus, jobLocation,salary, preferredGender,ageLimit,contactDuration));
	
			
				
			}
			sc.close();
		}
		catch(FileNotFoundException e){
			System.out.println("Cannot Read From File");
		}
	}
	

	                    //For  assinjob
						
	 
	
public static void loadAssignedJobs(DefaultTableModel model) {
    String filePath = "./Files/JobAssignment.txt";

    try (Scanner scanner = new Scanner(new File(filePath))) {
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] parts = line.split(";");

            if (parts.length == 3) {
                int personId = Integer.parseInt(parts[0]);
                String jobStatus = parts[1];
                String jobName = parts[2];

                model.addRow(new Object[]{personId, jobStatus, jobName});
            }
        }
    } catch (IOException e) {
        e.printStackTrace();
        // Handle the exception appropriately
    }
}
	
}