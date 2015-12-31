package LinkedList;

public class L {

	int[] next; 
	int[] key;
	String[] free;
	int freeIndex;
	int lastIndex;
	
	public class H {
		int next;
		int key;
	}
	
	L(int n){
	next = new int[n];
	key   = new int[n];
	free  = new String[n];	
	freeIndex = 0;
	lastIndex = n+1;
	for(int i=0;i<n;i++)
	{
		free[i] = Integer.toString(i);
	}
	}
	
}

