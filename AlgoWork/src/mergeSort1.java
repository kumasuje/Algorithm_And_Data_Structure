import java.util.Random;

public class mergeSort1 {

	public int comp =0;
	public static void main(String[] args) {
		
		//int[] inputArray = new int[]{-7,4,2,-8,1,9,3,5,-7,4,2,-8,1,9,3,5,-7,4,2,-8,1,9,3,5,-7,4,2,-8,1,9,3,5,-7,4,2,-8,1,9,3,5,-7,4,2,-8,1,9,3,5,7};
		Random random = new Random();
		int[] inputArray = new int[100];
		for(int i=0;i<100;i++){
			
			inputArray[i]=random.nextInt(10);

		}
		int low  = 0;
		int high = (inputArray.length)-1;
		mergeSort1 phoo = new mergeSort1();
		phoo.merge_sort(inputArray,low,high);
	
		for(int i=low;i<=high;i++){
			System.out.println("Sorted Array Finally "+inputArray[i]);
			
			}		
		System.out.println("count "+phoo.comp);
	}

public  void  merge_sort(int[] a,int l,int h){
	
	if(l<h){
		int mid =(l+h)/2;
		merge_sort(a,l,mid);
		merge_sort(a,mid+1,h);
			
	merge(a,l,mid,h);
	}
}

public  void merge(int[] a,int l,int m,int h){
	int[] sortedArray = new int [h+1];

	int j = l,k=m+1;
	for(int i=l;i<=h;i++){ 
		if( j<=m && k<=h){
			if((comp==comp++) && (a[j]<a[k])){
				sortedArray[i] = a[j++];
				}
			else {sortedArray[i] = a[k++];}
		}
		else if (j>m && k<=h) { 
			sortedArray[i] = a[k++];
			}
		else {			
			sortedArray[i] = a[j++];
		}
	}
	
	for(int i=l;i<=h;i++){
		a[i]=sortedArray[i];
	}

}

}

