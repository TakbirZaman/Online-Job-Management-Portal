package EntityList;
import Entity.Job;
import java.util.ArrayList;
public class JobList{
	private ArrayList<Job> Jobs = new ArrayList<Job>();
	public void insert(Job c){
		Jobs.add(c);
	}
	public boolean removeByAccount(int accountNo){
		for(int i=0;i<Jobs.size();i++){
			if(Jobs.get(i). getAccountNo() == accountNo){
				Jobs.remove(i);
				return true;
			}
		}
		return false;
	}
	public Job getByAccount(int accountNo){
		for(int i=0;i<Jobs.size();i++){
			if(Jobs.get(i). getAccountNo() == accountNo){
				return Jobs.get(i);
			}
		}
		return null;
	}
	
	public void showAll(){
		for(int i=0;i<Jobs.size();i++){
		Jobs.get(i).showJobInfo();}
	}
	
	public ArrayList<Job> getAll(){
		return Jobs;
	}
}