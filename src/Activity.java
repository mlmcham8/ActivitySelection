/**
 * @author Madison McHam, CS360 Project 4 Greedy Activity Selection Problem
 */
public class Activity {
	
	String name; //global variable for activities name
	int startTime;//global variable for start time
	int finishTime; //global variable for finish time
	
	//Empty constructor 
	public Activity(){}
	
	//Constructor that takes arguments 
	public Activity(String name,int startTime,int finishTime){
		this.name = name;
		this.finishTime=finishTime;
		this.startTime=startTime;
	}
	
	//method to get the Activity start time
	public int getStartTime() {
		return startTime;
	}
	
	//method to set the start time for this Activity to a given argument
	public void setStartTime(int startTime) {
		this.startTime = startTime;
	}
	
	//method to get the Activity finish time
	public int getFinishTime() {
		return finishTime;
	}
	
	//method to set the finish time for this Activity to a given argument
	public void setFinishTime(int finishTime) {
		this.finishTime = finishTime;
	}
	//method to get the Activity name
	public String getName(){
		return name;
	}
	
	//method to set the name for this Activity to a given argument
	public void setName(String name){
		this.name = name;
	}
	
	//CompareTo method to compare this Activity to different Activity that is given as an argument 
	public int compareTo(Activity activity){
		if (this.finishTime == activity.finishTime){
			return 0;
		}else if (this.finishTime> activity.finishTime){
			return 1;
		}else{
			return -1;
		}
	}
}
