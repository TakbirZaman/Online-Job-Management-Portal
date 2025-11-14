package Entity;

public class Employee extends Person{
	private String jobPreference; 
	private String jobStatus; //Isn't employee or not
	
	public Employee(){}
    public Employee(String personName,int personId,int personAge,String gender,String bloodGroup,String address,String phoneNumber,String jobPreference,String jobStatus){
	super(personName,personId,personAge,gender,bloodGroup,address,phoneNumber);
	this.jobPreference=jobPreference;
	this.jobStatus=jobStatus;
	}
	
	public void setJobPreference(String jobPreference){this.jobPreference=jobPreference;} 
	public void setJobStatus(String jobStatus){this.jobStatus=jobStatus;}
	
	public String getJobPreference(){return this.jobPreference;} 
	public String getJobStatus(){return this.jobStatus;}
    
    public void showEmployeeInfo(){
	super.showPersonInfo();
	System.out.println("Job Preference : "+this.jobPreference);
	System.out.println("Job Status : "+this.jobStatus);
	System.out.println("-------------------------------------------------------");
	}
}