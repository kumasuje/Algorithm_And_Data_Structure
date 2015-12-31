class LinkedList 
{
	int key;
	LinkedList prev;
	LinkedList next;

	
	
	LinkedList(int x)
		{
		  key = x;
		}
	LinkedList()
	{
		
	}
}
 

public class ll {

	public LinkedList head = new LinkedList();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	LinkedList T1 = new LinkedList();
		
		ll o = new ll();
		o.head = null;
		o.insert(7);
	//	o.display();
	
	
	}
	
	public void insert(int x){
		
		LinkedList temp = this.getNode(x);
		if(head == null)
		{
			head= temp;
		}
		
	}
	
	public LinkedList getNode(int x)
	{
		LinkedList newNode = new LinkedList(x);
		return newNode;
	}
	

}

