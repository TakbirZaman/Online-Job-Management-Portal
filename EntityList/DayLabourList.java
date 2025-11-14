package EntityList;
import Entity.DayLabour;
import java.util.ArrayList;
public class DayLabourList{
	private ArrayList<DayLabour> DayLabours = new ArrayList<DayLabour>();
	public void insert(DayLabour c){
		DayLabours.add(c);
	}
	public boolean removeByAccount(int accountNo){
		for(int i=0;i<DayLabours.size();i++){
			if(DayLabours.get(i). getAccountNo() == accountNo){
				DayLabours.remove(i);
				return true;
			}
		}
		return false;
	}
	public DayLabour getByAccount(int accountNo){
		for(int i=0;i<DayLabours.size();i++){
			if(DayLabours.get(i). getAccountNo() == accountNo){
				return DayLabours.get(i);
			}
		}
		return null;
	}
	
	public void showAll(){
		for(int i=0;i<DayLabours.size();i++){
			 System.out.println("JOB TYPE: DAY LABOUR");
			DayLabours.get(i).showDayLabourInfo();
		}
	}
	public ArrayList<DayLabour> getAll(){
		return DayLabours;
	}
}