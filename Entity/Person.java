package Entity;

public abstract class Person{
	private String personName;
	private int personId;
	private int personAge;
	private String gender;
	private String bloodGroup;
	private String address;
	private String phoneNumber;
	
	public Person(){}
	public Person(String personName,int personId,int personAge,String gender,String bloodGroup,String address,String phoneNumber){
		this.personName=personName;
		this.personId=personId;
		this.personAge=personAge;
		this.gender=gender;
		this.bloodGroup=bloodGroup;
		this.address=address;
		this.phoneNumber=phoneNumber;
	}
	
	public void setPersonName(String personName){this.personName=personName;}
	public void setPersonId(int personId){this.personId=personId;}
	public void setPersonAge(int personAge){this.personAge=personAge;}
	public void setGender(String gender){this.gender=gender;}
	public void setBloodGroup(String bloodGroup){this.bloodGroup=bloodGroup;}
    public void setAddress(String address){this.address=address;}
	public void setPhoneNumber(String phoneNumber){this.phoneNumber=phoneNumber;}
    
	public String getPersonName(){return this.personName;}
    public int getPersonId(){return this.personId;}
    public int getPersonAge(){return this.personAge;}
    public String getGender(){return this.gender;}
	public String getBloodGroup(){return this.bloodGroup;}
    public String getAddress(){return this.address;}
	public String getPhoneNumber(){return this.phoneNumber;}

    public void showPersonInfo(){
	System.out.println("-------------------------------------------------------");	
    System.out.println("Person Name : "+this.personName);
    System.out.println("Person Id : "+this.personId);
    System.out.println("Person Age : "+this.personAge);
    System.out.println("Gender : "+this.gender);
	System.out.println("Blood Group : "+this.bloodGroup);
	System.out.println("Adress : "+this.address);
    System.out.println("Phone Number : "+this.phoneNumber);
	}
}
   	