package Entity;
import Entity.Job;

public class DayLabour extends Job {
	private String physicalstrength;
	public DayLabour (){}
	public DayLabour (int accountNo,String jobName,String jobStatus,String jobLocation,double salary,String preferredGender,int ageLimit,String physicalstrength){
		super(accountNo, jobName,jobStatus, jobLocation,salary, preferredGender,ageLimit);
		this.physicalstrength=physicalstrength;
	}
	public void setPhysicalStrength(String physicalstrength)
	{
		this.physicalstrength=physicalstrength;
	}
	public String getPhysicalStrength()
	{return this.physicalstrength;}
	public void showDayLabourInfo(){
		super. showJobInfo();
		System.out.println("physical Strength: "+this.physicalstrength);
		System.out.println("-------------------------------------------------------");
		
	}
// public  void extraInput(String extra){
	                                                   //System.out.print("physical Strength for day labour job:");
	
	                                                   // String physicalstrength= 
	// setPhysicalStrength(extra);

	
// }

}