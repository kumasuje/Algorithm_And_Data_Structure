package reverseLinkedList;

import java.util.Scanner;

public class reverseLinkedList {
	
	public linkedList head =  new linkedList();
	public int count =0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int sizeOfList;
		System.out.println("Enter The Size of Linked List :: ");
		Scanner reader = new Scanner(System.in);
		sizeOfList = reader.nextInt();
		reverseLinkedList list = new reverseLinkedList(); 
		
		while(true){
			System.out.println(" Enter 1 TO Insert");
			System.out.println(" Enter 2 TO Display");
			System.out.println(" Enter 3 TO Reverse the List");
			System.out.println(" Enter 4 TO EXIT");
			int ch = reader.nextInt();
			int item;
			switch(ch){
			
			case 1 : { if(list.count == sizeOfList){
						System.out.println("Linked has reached Maximum Size, Cannot Insert new element");
						}
			else
			{
				System.out.println(" Enter the Item :: ");
				
				item = reader.nextInt();
				list.insert(item);
				list.count++;
			}		}; break;
			case 2 : {
				list.display();
					};break;
			case 3 : {
				list.reverse();
			};break;
			case 4 : {reader.close();System.exit(0);};break;		
			default : System.out.println("Unexpected Input !! ");
				;break;
	}

}
}
	
	void insert(int item){
	
		if(head.nextNode ==null && head.value ==-1)
		{
			head.value = item;
			
		}
		else
		{ 
			linkedList temp;
		 linkedList newnode = newNode(item);
		 temp = newnode;
		 temp.nextNode = head;
	     head = temp; 	
		}
	}
	
	void display()
	{
		linkedList temp = head;
		while(temp.nextNode !=null)
		{
			System.out.println("Valaue - "+temp.value);
			temp=temp.nextNode;
		}
		System.out.println("Valaue - "+temp.value);
		
		
		
	}
	
	linkedList newNode(int item)
	{
		linkedList temp = new linkedList(item);
		return temp;
	}

	void reverse()
	{
		if(count <= 3){
			
			if(count ==1) {}
			else if(count == 2){
				linkedList T1 = head.nextNode;
				head.nextNode = null;
				T1.nextNode = head;
				head = T1;
			}
			else{
			linkedList T1 = head.nextNode;
			linkedList T2 = T1.nextNode;
			
			head.nextNode = null;
			T1.nextNode = head;
			T2.nextNode = T1;
			head = T2;
		}
		}
		
		else{
		linkedList T1 = head.nextNode;
		linkedList T2 = T1.nextNode;
		boolean firstTraverse = true;
		
		while(T2.nextNode !=null)
		{
			if (firstTraverse == true)
			{
				head.nextNode =null;
				T1.nextNode = head;
				head = T1;
				T1 = T2;
				T2 = T2.nextNode;
				firstTraverse =false;
			}
			else
			{
				
				T1.nextNode = head;
				head = T1;
				T1 = T2;
				T2 = T2.nextNode;
			}
		}
		if(T2.nextNode==null)
		{
			T1.nextNode = head;
			T2.nextNode = T1;
			head = T2;
		}
	}
	}
}