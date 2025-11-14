package EntityList;
import Entity.PartTime;
import java.util.ArrayList;
public class PartTimeList{
	private ArrayList<PartTime> PartTimes = new ArrayList<PartTime>();
	public void insert(PartTime c){
		PartTimes.add(c);
	}
	public boolean removeByAccount(int accountNo){
		for(int i=0;i<PartTimes.size();i++){
			if(PartTimes.get(i). getAccountNo() == accountNo){
				PartTimes.remove(i);
				return true;
			}
		}
		return false;
	}
	public PartTime getByAccount(int accountNo){
		for(int i=0;i<PartTimes.size();i++){
			if(PartTimes.get(i). getAccountNo() == accountNo){
				return PartTimes.get(i);
			}
		}
		return null;
	}
	
	public void showAll(){
		for(int i=0;i<PartTimes.size();i++){
			System.out.println("JOB TYPE: PART TIME ");
			PartTimes.get(i).showPartTimeInfo();
		}
	}
	public ArrayList<PartTime> getAll(){
		return PartTimes;
	}
}