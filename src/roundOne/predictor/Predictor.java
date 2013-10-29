package roundOne.predictor;

import java.util.ArrayList;

public class Predictor {
	String coordinate;
	ArrayList<String> data;
	TimeManager tm = new TimeManager();

	public String getCoordinate() {
		return coordinate;
	}

	public void setCoordinate(String coordinate) {
		this.coordinate = coordinate;
	}

	public void getData() {
		// TODO
		data = new ArrayList<String>();
	}

	public ArrayList<String> getData(String cord) {
		// TODO
		return null;
	}

	public double calculateProb() {
		double emptyTaxi = 0.0;
		double fullTaxi = 0.0;
		double otherTaxi = 0.0;

		for (int i = 0; i < data.size(); i++) {
			String text = data.get(i).toString();
			String[] feature = text.split(",");
			if (Integer.parseInt(feature[2]) == 0) {
				emptyTaxi++;
			} else if (Integer.parseInt(feature[2]) == 1) {
				fullTaxi++;
			} else {
				otherTaxi++;
			}
		}
		double probability = emptyTaxi / (emptyTaxi + fullTaxi + otherTaxi);
		return probability;
	}

	public double getExpectedNumberofEmptyTaxis_Uniform() {
		int date = Integer.parseInt(coordinate.substring(
				coordinate.length() - 6, coordinate.length() - 4));
		ArrayList<String> data = new ArrayList<String>();
		ArrayList<Integer> days = tm.getSameDayofWeek(date);
		double total = days.size();
		for (Integer day : days) {
			String cord = coordinate.substring(0, coordinate.length() - 6)
					+ day.toString()
					+ coordinate.substring(coordinate.length() - 4);
			data.addAll(getData(cord));
		}
		double count = 0.0;
		for (String str : data) {
			String[] feature = str.split(",");
			if (Integer.parseInt(feature[2]) == 0) {
				count++;
			}
		}
		if (count > 0) {
			return count / total;
		} else{
			return -1;
		}
	}

	public double getExpectedNumberofEmptyTaxis_Dynamic() {
		// TODO
		return -1;
	}

	public double predictWaitingTime() {
		double expect = getExpectedNumberofEmptyTaxis_Uniform();
		if (expect<0){
			return 3600;
		}
		else{
			return 3600.0/expect;
		}
	}
}
