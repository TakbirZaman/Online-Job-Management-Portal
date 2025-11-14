package EntityList;
import Entity.Employee;
import java.util.ArrayList;

public class EmployeeList{
	private ArrayList<Employee> employees = new ArrayList<Employee>();
	
	public void insert(Employee e){
		employees.add(e);
	}
	
	public boolean removeByID(int id){
		for(int i=0;i<employees.size();i++){
			if(employees.get(i).getPersonId() == id){
				employees.remove(i);
				return true;
			}
		}
		return false;
	}
	
	public Employee getByID(int id){
		for(int i=0;i<employees.size();i++){
			if(employees.get(i).getPersonId() == id){
				return employees.get(i);
			}
		}
		return null;
	}
	
	public void showAllEmployeeInfo(){
		for(int i=0;i<employees.size();i++){
			employees.get(i).showEmployeeInfo();
		}
	}
	public ArrayList<Employee> getAll(){   //Give the size of arraylist
		return employees;
	}
}