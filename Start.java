import Entity.*;
import EntityList.*;
import java.util.Scanner;

public class Start{
	public static void main(String []args){
		Scanner scNum = new Scanner(System.in);
		Scanner scStr = new Scanner(System.in);
		EmployeeList employees=new EmployeeList();
		JobList Jobs = new JobList();
		DayLabourList DayLabours =new DayLabourList();
        PartTimeList PartTimes=new PartTimeList();		
        FullTimeList FullTimes =new FullTimeList();
        FixedList Fixeds=new FixedList();
		
		
		while(true){
			System.out.println("\n");
			System.out.println("+++++++++++++++++++++++++++++++++MENU+++++++++++++++++++++++++++++++++");
			System.out.println("1. To See The Employee Information");
			System.out.println("2. To See The Job Information");
			System.out.println("0. Exit");
			System.out.println("+++++++++++++++++++++++++++++End of MENU++++++++++++++++++++++++++++++");
			System.out.println("");
			System.out.print("ENTER YOUR CHOICE: ");
			int choice = scNum.nextInt();
	    
		switch(choice){
			case 1:
			        System.out.println("");
					System.out.println("+++++++++++++++++MANAGE Employee++++++++++++++++++++++++");
					System.out.println("1. Add an Employee: ");
					System.out.println("2. Remove A  Employee");
					System.out.println("3. Show a  Employee");
					System.out.println("4. Show All Employee");
					System.out.print("ENTER YOUR Option: ");
					int option1 = scNum.nextInt();
				switch(option1){
				
					case 1:
					System.out.println("");
					System.out.println("TO ADD AN EMPLOYEE PLEASE PROVIDE EMPLOYEE'S INFORMATION");
					System.out.print("Name: ");
					String personName=scStr.nextLine();
					System.out.print("Insert Id: ");
					int personId=scNum.nextInt();
					System.out.print("Age: ");
					int personAge=scNum.nextInt();
					System.out.print("Gender: ");
					String gender=scStr.nextLine();
					System.out.print("Blood Group: ");
					String bloodGroup=scStr.nextLine();
					System.out.print("Address: ");
					String address=scStr.nextLine();
					System.out.print("Contact No: ");
					String phoneNumber=scStr.nextLine();
					System.out.print("Preferred Job: ");
					String jobPreference=scStr.nextLine();
					System.out.print("Job Status: ");
					String jobStatus=scStr.nextLine();
					employees.insert(new Employee(personName,personId,personAge,gender,bloodGroup,address,phoneNumber,jobPreference,jobStatus));
					break;
					
					case 2:
						System.out.print("To Remove A Employee Enter ID : ");
						int didM = scNum.nextInt();
						employees.removeByID(didM);
						break;
				
					case 3:
						System.out.print("To View A Employee Info please Enter ID : ");
						int sidM = scNum.nextInt();
						employees.getByID(sidM).showEmployeeInfo();
						break;
					
					case 4:
						System.out.println("ALL EMPLOYEE INFO");
	                    employees.showAllEmployeeInfo();
						break;
						
					case 0:
						return;
				}
				
				break;
			
			
			case 2:
			System.out.println("");	
			System.out.println("+++++++++++++++++MANAGE JOB++++++++++++++++++++++++");
			System.out.println("1. Insert a Job");
			System.out.println("2. Remove a Job");
			System.out.println("3. Show All Job");
			System.out.println("0. Exit ");
			System.out.println("");
			
			System.out.print("Enter Your Option: ");
			int option2 = scNum.nextInt();
			
			
			switch(option2){
				case 1:
				        System.out.println("");
						System.out.println("To insert a Job provide Job's Information");
						System.out.print("Enter Account no: ");
						int accountNo = scNum.nextInt();
						System.out.print("Enter job Name: ");
						String jobName = scStr.nextLine();
						System.out.print("Enter job Status: ");
						String jobStatus = scStr.nextLine();
						System.out.print("Enter job location: ");
						String jobLocation = scStr.nextLine();
						System.out.print("Enter salary: ");
						double salary = scNum.nextDouble();
						System.out.print("Enter preferred Gender: ");
						String preferredGender = scStr.nextLine();
						System.out.print("Enter max age: ");
						int ageLimit = scNum.nextInt();
						//Job jobType;
						System.out.println("");
						System.out.println("job type: ");
						System.out.println("1.DAY LABOUR JOB");
						System.out.println("2.PART TIME JOB");
						System.out.println("3.FULL TIME JOB");
						System.out.println("4.FIXED JOB");
						System.out.print("Select job type: ");
						int jt=scNum.nextInt();
						switch(jt){
						
						 case 1:
						       // jobType =new DayLabour(accountNo, jobName,jobStatus, jobLocation,salary, preferredGender,ageLimit,physicalstrength);
								//System.out.print("physical Strength for day labour job:");
								//String physicalstrength  = scStr.nextLine();
							    //jobType.extraInput(physicalstrength );
								//DayLabours.insert((DayLabour)jobType);
								System.out.print("Enter physical strength: ");
						        String physicalstrength = scStr.nextLine();
								DayLabours.insert(new DayLabour(accountNo, jobName,jobStatus, jobLocation,salary, preferredGender,ageLimit,physicalstrength));
								break;
						  case 2:
						        //jobType =new PartTime (accountNo, jobName,jobStatus, jobLocation,salary, preferredGender,ageLimit,shift);
								System.out.print("shift timing for part time job:");
								String shift  = scStr.nextLine();
								// jobType.extraInput(shift);
								//PartTimes.insert((PartTime)jobType);
								
								PartTimes.insert(new PartTime (accountNo, jobName,jobStatus, jobLocation,salary, preferredGender,ageLimit,shift));
								break;
						  case 3:
						        //jobType =new FullTime(accountNo, jobName,jobStatus, jobLocation,salary, preferredGender,ageLimit,overTimepayRate);
								System.out.print("overtime payrate  for fulltime job:");
								String overTimepayRate = scStr.nextLine();
								// jobType.extraInput(overTimepayRate);
								//FullTimes.insert((FullTime)jobType)								
																
							   FullTimes.insert(new FullTime(accountNo, jobName,jobStatus, jobLocation,salary, preferredGender,ageLimit,overTimepayRate));
								break;
						  case 4:
						        //jobType =new Fixed(accountNo, jobName,jobStatus, jobLocation,salary, preferredGender,ageLimit,contactDuration);
								 System.out.print("contact Duration  for fixed job:");
								 String contactDuration = scStr.nextLine();
								// jobType.extraInput(contactDuration);
								//Fixeds.insert((Fixed)jobType);
							    Fixeds.insert(new Fixed(accountNo, jobName,jobStatus, jobLocation,salary, preferredGender,ageLimit,contactDuration));
								break;
						  default:
						        System.out.println("invalid job type ");
								break;
							
						}
						// Jobs.insert(DayLabour);
						// Jobs.insert(PartTime);
						// Jobs.insert(FullTime);
					    // Jobs.insert(Fixed);
						break;
		
			
				case 2:
					System.out.print("To Delete A Job Enter account no. : ");
					int acc = scNum.nextInt();
					DayLabours.removeByAccount(acc);
					PartTimes.removeByAccount(acc);
					FullTimes.removeByAccount(acc);
					Fixeds.removeByAccount(acc);
					break;
	
				case 3 :
				System.out.println("(LIST OF JOB TYPES)--->");
				        System.out.println("1.SHOW DAY LABOUR JOB");
						System.out.println("2.SHOW PART TIME JOB");
						System.out.println("3.SHOW FULL TIME JOB");
						System.out.println("4.SHOW FIXED JOB");
					    System.out.println("5.SHOW ALL JOB");
						System.out.print("SELECTED: ");
						System.out.println("");
				int num=scNum.nextInt();
				if(num==1)
				          {DayLabours.showAll();}
			    else if(num==2)
				          {	PartTimes.showAll();}
			    else if(num==3)
				          {FullTimes.showAll();}
			    else if(num==4)
				          {	Fixeds.showAll();}
				else if(num==5)
				      {DayLabours.showAll();
					   PartTimes.showAll();
					   FullTimes.showAll();
					   Fixeds.showAll();
					   }
			    
			     else
				 {
			    System.out.println("DATA ERROR");
				 }
				
			
			    break;

				case 0:
				    
					return;
			}
			break;
			
			
			case 0:
			   return;
		}
		
	}
						
	}
}
		