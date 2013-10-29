package roundOne.predictor;

import java.util.*;

public class Probability {

	public static void main(String[] args) {
		String entry_1 = "183497,4,1,20121101162700,116.3256454,39.9061546,84,270,1";
		String entry_2 = "426448,4,1,20121101162519,116.3255463,39.9060860,62,90,1";
		ArrayList<String> info = new ArrayList<String>();
		info.add(entry_1);
		info.add(entry_2);

		double probability = new Probability().calculateProb(info);
		System.out.println(probability);

	}

	public double calculateProb(ArrayList<String> info) {
		double emptyTaxi = 0.0;
		double fullTaxi = 0.0;
		double otherTaxi = 0;

		for (int i = 0; i < info.size(); i++) {
			String text = info.get(i).toString();
			String[] feature = text.split(",");
			if (Integer.parseInt(feature[2]) == 0) {
				emptyTaxi++;
			} else if (Integer.parseInt(feature[2]) == 0) {
				fullTaxi++;
			} else {
				otherTaxi++;
			}
		}
		
		double probability = emptyTaxi / (emptyTaxi + fullTaxi + otherTaxi);
		return probability;
	}

}
