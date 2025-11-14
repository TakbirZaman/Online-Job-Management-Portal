package Entity;

public  abstract class Job{
	private int accountNo;
	private String jobName;
	private String jobStatus;// available/not
	private String jobLocation;
	private double salary;
	private String preferredGender;
	private int  ageLimit;
	
	public Job(){}
	public Job(int accountNo,String jobName,String jobStatus,String jobLocation,double salary,String preferredGender,int  ageLimit){
		this.accountNo=accountNo;
		this.jobName=jobName;
		this.jobStatus=jobStatus;
		this.jobLocation=jobLocation;
		this.salary=salary;
		this.preferredGender=preferredGender;
	    this.ageLimit=ageLimit;
	}
	
	public void setAccountNo(int accountNo)
	{
		this.accountNo=accountNo;
	}
	public void setJobName(String jobName)
	{
		this.jobName=jobName;
	}
	public void setJobStatus(String jobStatus)
	{
		this.jobStatus=jobStatus;
	}
	public void setJobLocation( String jobLocation)
	{
		this.jobLocation=jobLocation;
	}
	public void setSalary(double salary)
	{
	this.salary=salary;
	}
	
		public void setPreferredGender(String preferredGender)
	{
		this.preferredGender=preferredGender;
	}
	
		public void setageLimit(int ageLimit)
	{
		this.ageLimit=ageLimit;
	}
	
	public int getAccountNo()
	{
		return this.accountNo;
	}
	
	public String getJobName()
	{
		return this.jobName;
	}
	public String getJobStatus()
	{
		return this.jobStatus;
	}
	public String getJobLocation()
	{
		return this.jobLocation;
	}
	public double getSalary()
	{
		return this.salary;
	}
	public String getPreferredGender()
	{
		return this.preferredGender;
	}
	public int getageLimit()
	{
		return this.ageLimit;
		
	}

	public void showJobInfo(){
	System.out.println("-------------------------------------------------------");
	System.out.println("job account no: "+this.accountNo);
    System.out.println("job Name : "+this.jobName);
    System.out.println("job status : "+this.jobStatus);
    System.out.println("job location : "+this.jobLocation);
    System.out.println("salary: "+this.salary);
	System.out.println("Preferred Gender: "+this.preferredGender);
	System.out.println("AgeLimit: "+this.ageLimit);
    
	}
	//public abstract void extraInput(String extra);
	
}