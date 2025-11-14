package Entity;
import Entity.Job;

public class Fixed extends Job {
	private String contactDuration;
	public Fixed (){}
	public Fixed (int accountNo,String jobName,String jobStatus,String jobLocation,double salary,String preferredGender,int ageLimit,String contactDuration){
		super(accountNo, jobName,jobStatus, jobLocation,salary, preferredGender,ageLimit);
		this.contactDuration=contactDuration;
	}
	public void setcontactDuration(String contactDuration)
	{
		this.contactDuration=contactDuration;
	}
	public String getcontactDuration()
	{return this.contactDuration;}
	
	public void showFixedInfo(){
		super. showJobInfo();
		System.out.println("contactDuration: "+this.contactDuration);
		System.out.println("-------------------------------------------------------");
    
}


// public  void extraInput(String extra){
	                            // System.out.print("contact Duration  for fixed job:");
	                            //String contactDuration=
	// setcontactDuration(extra);

// }
}