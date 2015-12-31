package sortingPackage;
import java.util.*;
class RandomGenerater {

	public int[] randomGenerator(int n){
		Random random = new Random();
		int[] randomInput = new int[n];
		for(int i=0;i<n;i++){
			
			randomInput[i]=random.nextInt(n*100);

		}
		return randomInput;

	}
	
	
}
