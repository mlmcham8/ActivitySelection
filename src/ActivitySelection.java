import java.util.Scanner;

/**
 * @author Madison McHam, CS360 Project 4 Greedy Activity Selection Problem
 */

public class ActivitySelection {
	public int endTime; //variable assigned to end time integer
	public int activityNum; //variable assigned to the number of activities 
	public Activity[] activities; //Activity array the stores all the activity objects

	public void readActivities(){
		Scanner s = new Scanner(System.in); //reading in from standard input
		String line = s.nextLine(); //reads the first line
		String [] values = line.split(","); //splits the first line by a ,
		endTime = Integer.parseInt(values[0]); //endTime is given as the first integer 
		activityNum = Integer.parseInt(values[1]); //activityNum is the exact number of activities that there will be
    	activities = new Activity[activityNum]; //set the Activity array's size to the read in activityNum
    	
    	//for loop that runs the exact amount of activities and gathers the needed activities name, startTime and finishTime
		for(int i = 0; i < activityNum; i++){
			String newLine = s.nextLine(); //read nextLine
			String[] value = newLine.split(","); //split nextLine by ,
			String name = value[0]; //assign index 0 of value to activities names
            int startTime=Integer.parseInt(value[1]);	//assign index 1 of value to activities start time
            int finishTime=Integer.parseInt(value[2]); //assign index 2 of value to activities finish time

            //every time a new line is split and assigned to the variables a new Activity is created and adding into
            //the activities Activity[]  array
        	activities[i] = new Activity(name,startTime,finishTime);
			
		}	
		//QuickSort function that sorts the activity objects in ascending order by finishing time
		activityQuickSort(activities,0,activities.length-1);
		
		//This is the the call to function that prints out all the activities in the given way in the project outline
		printActivities(activities,activityNum );
		}

	//activity recursive quicksort
	public void activityQuickSort( Activity[] activities, int start, int end ){
		if (start < end){ 	//continue as long as start is less than end 
			int p = partition(activities, start, end); 
			activityQuickSort(activities, start, p - 1); //quickSort the left partition
			activityQuickSort(activities, p + 1, end);	//quickSort the right
		}	//end if statement
	} 	//end method quickSort

	// Partition function for quickSort method
	public int partition(Activity[] activities, int start, int end ){
		Activity pivot = activities[end];
		int index = start - 1;
		for ( int j = start; j < end; j++ ){
			if (activities[j].compareTo(pivot) < 0 ){ 
				index += 1; //increase index
				Activity temp = activities[index]; //exchange activities
				activities[index] = activities[j];
				activities[j] = temp;
			}
		}
		Activity temp = activities[index + 1];
		activities[index + 1] = activities[end];
		activities[end] = temp;
		return index + 1;
	} // End function partition

	//prints all the compatible activities in order of finishing time 
	public void printActivities(Activity[] activities, int n){
		int i, j;
	   	System.out.println("Schedule "); 
	    i = 0; // The first activity always gets selected
	    System.out.println(activities[i].getName()+ " from " + activities[i].getStartTime()+ " to "+ activities[i].getFinishTime());
	    
	    // Consider rest of the activities
	    for (j = 1; j < n; j++){
	    	// If this activity has start time greater than or equal to the finish
	    	// time of previously selected activity, then select it
	    	if (activities[j].getStartTime() >= activities[i].getFinishTime()){
	    		
	    		System.out.println(activities[j].getName() + " from " + activities[j].getStartTime()+ " to "+ activities[j].getFinishTime());
	    		i = j;
	      }
	    }
	}
}
