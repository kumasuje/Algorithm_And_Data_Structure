
public class mergreSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] inputArray = new int[]{7,4,2,8,4,9,};
		int low  = 0;
		int high = inputArray.length;
		merge_sort(inputArray,low,high);
		
	}

public static void  merge_sort(int[] a,int l,int h){
	
	if(l<h){
		int mid = (int)Math.ceil((l+h)/2);
	System.out.println(" merge sort :: length of array is "+a.length+" l = "+
	l+" m= "+mid+" h ="+h);
		merge_sort(a,l,mid);
		merge_sort(a,mid+1,h);
			
	merge(a,l,mid,h);
	}
}

public static void merge(int[] a,int l,int m,int h){
	int[] leftSortedArray = new int [m-l+2];
	int[] rightSortedArray = new int [h-m+1];
	int j = 0;
	int k = 0;
	int z = 0;
	int x = 0;
	int[] sortedArray = new int [h+1];
	for(int i=l;i<=m;i++){ leftSortedArray[x++]= a[i];}
	for(int i=m+1;i<=h;i++){ rightSortedArray[z++]= a[i];}
	
	for(int b=0;b<=x;b++){ System.out.println(" --leftSortedArray "+leftSortedArray[b]);}
	for(int b=0;b<=z;b++){ System.out.println(" --rightSortedArray "+rightSortedArray[b]);}
	
	
	
	
	System.out.println(" value of i ="+" j ="+j+" k="+k+" l="+l+" m="+m+
	" h="+h);

	for(int i=l;i<=h;i++){ 
		if( j<=m && k <=h){
			System.out.println(" 1 > ( j<=m && k <=h) value of i ="+i+" j ="+j+" k="+k+" l="+l+" m="+m+
		" h="+h);

			System.out.println("leftSortedArray[j] "+leftSortedArray[j]);
			System.out.println("rightSortedArray[k] "+rightSortedArray[k]);
			if(leftSortedArray[j] < rightSortedArray[k]){
				sortedArray[i] = leftSortedArray[j++];
				}
			else {sortedArray[i] = rightSortedArray[k++];}
		}
		else if (j>m && k<=h) { 
			System.out.println(" 2> (j>m && k<=h) value of i ="+i+" j ="+j+" k="+k+" l="+l+" m="+m+
					" h="+h);
			sortedArray[i] = rightSortedArray[k++];}
		else {
			System.out.println(" 3> value of i ="+i+" j ="+j+" k="+k+" l="+l+" m="+m+
					" h="+h);
			sortedArray[i] = leftSortedArray[j++];
		}
	}
	for(int i=l;i<=h;i++){
		System.out.println("Sorted Array "+sortedArray[i]);
	}
	
}

}

