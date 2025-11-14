package EntityList;
import Entity.Fixed;
import java.util.ArrayList;
public class FixedList {
	private ArrayList<Fixed> Fixeds = new ArrayList<Fixed>();
	public void insert(Fixed c){
		Fixeds.add(c);
	}
	public boolean removeByAccount(int accountNo){
		for(int i=0;i<Fixeds.size();i++){
			if(Fixeds.get(i). getAccountNo() == accountNo){
				Fixeds.remove(i);
				return true;
			}
		}
		return false;
	}
	public Fixed getByAccount(int accountNo){
		for(int i=0;i<Fixeds.size();i++){
			if(Fixeds.get(i). getAccountNo() == accountNo){
				return Fixeds.get(i);
			}
		}
		return null;
	}
	
	public void showAll(){
		for(int i=0;i<Fixeds.size();i++){
			System.out.println("JOB TYPE: FIXED");
			Fixeds.get(i).showFixedInfo();
		}
	}
	public ArrayList<Fixed> getAll(){
		return Fixeds;
	}
}