package sortingPackage;

class MS { 
		public int comp =0;
			public  int mergeS(int o)
		{	
			//int comp = 0;
			RandomGenerater input = new RandomGenerater(); 
			int[] inputArray = input.randomGenerator(o);
			System.out.print("Input Array for MergeSort	 ::	 ");
			for(int q=0;q<o;q++){
			System.out.print(inputArray[q]+" ");	
			}
			int low  = 0;
			int high = (inputArray.length)-1;
	       merge_sort(inputArray,low,high);
		
	       System.out.print("\nSorted array using MergeSort 	 ::	");
			for(int i=low;i<=high;i++){
				System.out.print(" "+inputArray[i]);
				}
			int temp = comp;
			comp = 0;
			return temp;
		}

	public  void  merge_sort(int[] a,int l,int h){
		
		if(l<h){
			int mid =(l+h)/2;
			merge_sort(a,l,mid);
			merge_sort(a,mid+1,h);
				
		merge(a,l,mid,h);
		}
	}

	public void merge(int[] a,int l,int m,int h){
	   
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
