package roundOne.predictor;

import java.util.ArrayList;

public class TimeManager {
	
	// Nov. 1st 2011 is Tuesday
	
	ArrayList<ArrayList<Integer>> days;

	public TimeManager() {
		days = new ArrayList<ArrayList<Integer>>();
		for (int i = 0; i <= 6; i++) {
			ArrayList<Integer> ai = new ArrayList<Integer>();
			days.add(ai);
		}
		int s = 2;
		for (int i = 1; i <= 30; i++) {
			days.get(s).add(i);
			s += 1;
			s = s % 7;
		}
	}
	
	public ArrayList<Integer> getSameDayofWeek(int date){
		return days.get((date+1)%7);
	}
	
	public ArrayList<Integer> getWeekDays(){
		ArrayList<Integer> wd = new ArrayList<Integer>();
		for (int i=1; i<=5; i++){
			wd.addAll(days.get(i));
		}
		return wd;
	}
	
	public ArrayList<Integer> getWeekendDays(){
		ArrayList<Integer> we = new ArrayList<Integer>();
		we.addAll(days.get(0));
		we.addAll(days.get(6));
		return we;
	}
	
	public ArrayList<Integer> getSameTypeDayofWeek(int date){
		int wd = (date+1)%7;
		if (wd==0 || wd==6){
			return getWeekendDays();
		}
		else{
			return getWeekDays();
		}
	}
	
}
