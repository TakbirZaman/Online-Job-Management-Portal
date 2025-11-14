package EntityList;
import Entity.FullTime;
import java.util.ArrayList;
public class FullTimeList  {
	private ArrayList<FullTime> FullTimes = new ArrayList<FullTime>();
	public void insert(FullTime c){
		FullTimes.add(c);
	}
	public boolean removeByAccount(int accountNo){
		for(int i=0;i<FullTimes.size();i++){
			if(FullTimes.get(i). getAccountNo() == accountNo){
				FullTimes.remove(i);
				return true;
			}
		}
		return false;
	}
	public FullTime getByAccount(int accountNo){
		for(int i=0;i<FullTimes.size();i++){
			if(FullTimes.get(i). getAccountNo() == accountNo){
				return FullTimes.get(i);
			}
		}
		return null;
	}
	
	public void showAll(){
		for(int i=0;i<FullTimes.size();i++){
			System.out.println("JOB TYPE: FULL TIME ");
			FullTimes.get(i).showFullTimeInfo();
		}
	}
	public ArrayList<FullTime> getAll(){
		return FullTimes;
	}
}