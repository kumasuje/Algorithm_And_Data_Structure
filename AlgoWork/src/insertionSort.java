

public class insertionSort{

     public static void main(String args[]){
        
        int[] input = new int[]{31,41,59,26,41,58};
        int key;
        int k =input.length;
        for (int j=1;j<=k-1;j++ )
        {   key = input[j];
            int i =j-1;
            while(i>=0 && input[i]< key)
            {
                input[i+1] = input[i];
                i=i-1;
            }
            input[i+1] = key;
                   }    
        
        System.out.print("Sorted array ");
        for (int j=0;j<=k-1;j++)
        {
            System.out.print(input[j]+" ");
         
        }
        
     }
}
