package Entity;
import Entity.Job;

public class PartTime extends Job {
	private String shift;
	public PartTime (){}
	public PartTime (int accountNo,String jobName,String jobStatus,String jobLocation,double salary,String preferredGender,int ageLimit,String shift){
		super(accountNo, jobName,jobStatus, jobLocation,salary, preferredGender,ageLimit);
		this.shift=shift;
	}
	public void setShift(String shift)
	{
		this.shift=shift;
	}
	public String getShift()
	{return this.shift;}
	public void showPartTimeInfo(){
		super. showJobInfo();
		System.out.println("Shift: "+this.shift);
        System.out.println("-------------------------------------------------------");

}
// public  void extraInput(String  extra){
	                                         //System.out.print("shift timing for part time job:");
	
	                                      // String shift =
	// setShift(extra);

// }
}