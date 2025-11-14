package Entity;
import Entity.Job;

public class FullTime extends Job {
	private String overTimepayRate;
	public FullTime (){}
	public FullTime (int accountNo,String jobName,String jobStatus,String jobLocation,double salary,String preferredGender,int ageLimit,String overTimepayRate){
		super(accountNo, jobName,jobStatus, jobLocation,salary, preferredGender,ageLimit);
		this.overTimepayRate=overTimepayRate;
	}
	public void setoverTimepayRate(String overTimepayRate)
	{
		this.overTimepayRate=overTimepayRate;
	}
	public String getoverTimepayRate()
	{return this.overTimepayRate;}
	public void showFullTimeInfo(){
		super. showJobInfo();
		System.out.println("overTimepayRate: "+this.overTimepayRate);
		System.out.println("-------------------------------------------------------");
    }
		
		
		// public  void extraInput(String  extra){
											// System.out.print("overtime payrate  for fulltime job:");
	//String overTimepayRate=
		// setoverTimepayRate(extra);
		
	// }
}