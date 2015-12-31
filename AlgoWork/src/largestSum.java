import java.*;
import java.time.Duration;
import java.time.Instant;
public class largestSum {

	public static void main(String[] args) {
			
		Instant start = Instant.now();
		int[] input = new int[] {40,-10,11,-10,12,-4};
		int totalSum,sumBefore,sumCon,sumSub;
	    totalSum = sumBefore = sumCon =sumSub = 0;
		System.out.println("Array length"+input.length);
	    for(int i=0;i<input.length;i++){
	    	totalSum += input[i];
	    	
	    	if(input[i] < 0 || i == (input.length-1)){
	    		
	    	//	System.out.println("s Value of i inside neagtive loop" +input[i]);
	    		if(i == (input.length-1) && (input[i] < 0)){} 
	    		else if(i == (input.length-1)) {
	    			sumSub += input[i];
	    			sumCon += input[i];
	    			}
	    //	 if 	
	    		
	    		
	    	//		    	 System.out.println("su-------------------------------");
	    		sumBefore = comp(sumCon,sumSub,sumBefore);
	    	
	    		sumCon += input[i];
	    		sumSub    = 0;
	    	}
	    	else {
	    		sumCon   += input[i];
		    	sumSub   += input[i];
	    	}
	    	
	    	
	    }
	//    if(totalSum > sumBefore) sumBefore = totalSum;
	    System.out.println("largestSum"+sumBefore);
	    Instant end = Instant.now();
	    System.out.println("Duration of program "+Duration.between(start,end));
	    
	
	}
	
		
		public static int comp(int sumCon,int sumSub,int sumBefore){
			
			int returnValue = Math.max(sumCon,Math.max(sumSub,sumBefore));
			if (returnValue != sumCon){
				sumCon = sumSub;
			}
			return returnValue;
		}
	    
}
