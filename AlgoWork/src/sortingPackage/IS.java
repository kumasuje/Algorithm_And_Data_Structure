package sortingPackage;
import java.util.*;
class IS {
		public int insertion(int o){
			RandomGenerater inputR = new RandomGenerater(); 
			int[] input = inputR.randomGenerator(o);
			System.out.print("\nInput Array for InsertionSort 	 :: 	");
			for(int q=0;q<o;q++){
			System.out.print(input[q]+" ");	
			}
			int comp = 0;
	        int key;
	        int k =input.length;
	        for (int j=1;j<=k-1;j++ )
	        {   key = input[j];
	        int i =j-1;
	        while((i>=0) && (comp==comp++) && (input[i]> key))
	        {	
	        	input[i+1] = input[i];
	        i=i-1;
	        }
	        input[i+1] = key;
	        }    

	        System.out.print("\nSorted array Using InsertionSort ::	 ");
	        for (int j=0;j<=k-1;j++)
	        {
	        	System.out.print(input[j]+" ");

	        }

	        return comp;
	     }
		
	}
