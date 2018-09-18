import java.util.Scanner;
import java.util.Date;
import java.text.SimpleDateFormat;

public class Solution {
	public static void main(String[] args) {
		FitByte info = new FitByte();
		// SimpleDateFormat sleepDF = new SimpleDateFormat("dd/mm/yyyy,hh:mm");
		// System.out.println(sleepDF.format(new Date()));
		Scanner s = new Scanner(System.in);
		while (s.hasNext()) {
		String[] tokens = s.nextLine().split(" ");
		switch(tokens[0]) {
			case "Food":
			String[] check = tokens[1].split(",");
			info.addFoodDetails(new Foodlog(check[0], Integer.parseInt(check[1]), check[2], check[3]));
			break;
			case "Water":
			check = tokens[1].split(",");
			info.addWaterDetails(new Waterlog(Integer.parseInt(check[0]), check[1]));
			break;
			case "PhysicalActivity":
			check = tokens[1].split(",");
			info.addPA(new Physicalactivities(check[0], check[1], check[2], check[3], check[4]));
			break;
			case "Weight":
			check = tokens[1].split(",");
			info.addWeight(new Weightlog(check[0], check[1], check[2], check[3]));
			break;
			case "Sleep":
			check = tokens[1].split(",");
			info.addSleepinfo(new Sleeplog(check[0], check[1], check[2]));
			break;
			case "Foodlog":
			info.displayFood();
			break;
			case "Waterlog":
			info.displayWaterinfo();
			break;
			case "PhysicalActivitylog":
			info.displayPA();
			break;
			case "Weightlog":
			info.displayWeightlog();
			break;
			case "Sleeplog":
			info.displaySleeplog();
			break;
			case "Summary":
			info.summary();
			break;
			}

		}
	}

}
class Dashboard {

}
class Waterlog {
	private double wateramt;
	private String date;
	Waterlog(double wateramt, String date) {
		this.wateramt = wateramt;
		this.date = date;
	}
	public String toString() {
		String s = "";
		s += "Water" + "\n" + "Date : " + date + "\n" + "Quantity : " + wateramt;
		return s;
	}

}
class Physicalactivities {
	private String activityname;
	private String type;
	private String datetime;
	private String starttime;
	private String endtime;
	Physicalactivities(String activityname, String type, String datetime, String starttime, String endtime) {
		this.activityname = activityname;
		this.type = type;
		this.datetime = datetime;
		this.starttime = starttime;
		this.endtime = endtime;
	}
	public String toString() {
		String s = "";
		s += "Physicalactivity" + "\n" + "Name : " + activityname + "\n" + "Notes : " + type + "\n" + "Date : " + datetime + "\n" + "Starttime : " + starttime + "\n" + "Endtime : " + endtime;
		return s;
	}
}
class Foodlog {
	private String foodname;
	private int quantity;
	private String date;
	private String time;

	Foodlog(String foodname, int quantity, String date, String time) {
		this.foodname = foodname;
		this.quantity = quantity;
		this.date = date;
		this.time = time;
	}
	public String getFoodname() {
		return foodname;
	}
	public int getFoodquan() {
		return quantity;
	}
	public String getFooddate() {
		return date;
	}
	public String getFoodtime() {
		return time;
	}
	public String toString() {
		String s = "";
		s += "Food" + "\n" + "Date : " + date + "\n" + "Time : " + time + "\n" + "Name : " + foodname + "\n" + "Quantity : " + quantity;
		return s;
	}
}
class Sleeplog {
	private String date;
	private String bedtime;
	private String waketime;
	Sleeplog(String date, String bedtime, String waketime) {
		this.date = date;
		this.bedtime = bedtime;
		this.waketime = waketime;
	}
	public String toString() {
		String s = "";
		s += "Sleep" + "\n" + "Date : " + date + "\n" + "Starttime : " + bedtime + "\n" + "Endtime : " + waketime;
		return s; 
	}
}
class Weightlog {
	private String date;
	private String time;
	private String weight;
	private String fatper;
	Weightlog(String date, String time, String weight, String fatper) {
		this.weight = weight;
		this.time = time;
		this.weight = weight;
		this.fatper = fatper;
	}
	public String toString() {
		String s = "";
		s += "Weight" + "\n" + "Date : " + date + "\n" + "Time : " + time + "\n" + "Weight : " + weight + "\n" + "Fat : " + fatper;
		return s;
	}
}
class FitByte {
	private List<Physicalactivities> activitieslog;
	private List<Waterlog> waterlog;
	private List<Foodlog> foodlog;
	private List<Sleeplog> sleeplog;
	private List<Weightlog> weightlog;
	FitByte() {
		activitieslog = new List<Physicalactivities>();
		waterlog = new List<Waterlog>();
		foodlog = new List<Foodlog>();
		sleeplog = new List<Sleeplog>();
		weightlog = new List<Weightlog>();
	}
	public List<Physicalactivities> getphysicalactivity() {
		return activitieslog;
	}
	public List<Waterlog> getwaterlog() {
		return waterlog;
	}
	public List<Foodlog> getfoodlog() {
		return foodlog;
	}
	public List<Sleeplog> sleeplog() {
		return sleeplog;
	}
	public void addFoodDetails(Foodlog food) {
		foodlog.add(food);
	}
	public void addWaterDetails(Waterlog waterinfo) {
		waterlog.add(waterinfo);
	}
	public void addPA(Physicalactivities pa) {
		activitieslog.add(pa);
	}
	public void addWeight(Weightlog wt) {
		weightlog.add(wt);
	}
	public void addSleepinfo(Sleeplog sleep) {
		sleeplog.add(sleep);
	}
	public void displayFood() {
		for (int i = 0; i < foodlog.size(); i++) {
		System.out.println(foodlog.get(i));
		}
	}
	public void displayWaterinfo() {
		for (int i = 0; i < waterlog.size(); i++) {
		System.out.println(waterlog.get(i));
		}
	}
	public void displayPA() {
		for (int i = 0; i < activitieslog.size(); i++) {
			System.out.println(activitieslog.get(i));
		}
	}
	public void displayWeightlog() {
		for (int i = 0; i < waterlog.size(); i++) {
			System.out.println(weightlog.get(i));
		}
	}
	public void displaySleeplog() {
		for (int i = 0; i < sleeplog.size(); i++) {
			System.out.println(sleeplog.get(i));
		}
	}
	public void summary() {
		displayFood();
		displayWaterinfo();
		displayPA();
		displayWeightlog();
		displaySleeplog();
	}

}
