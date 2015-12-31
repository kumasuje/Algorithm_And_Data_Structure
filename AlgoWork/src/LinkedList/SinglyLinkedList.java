package LinkedList;

import java.util.Scanner;

public class SinglyLinkedList {

	L list;
	L.H head;
	static int n;
		
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(" Enter the size of Linked List ");
		Scanner reader = new Scanner(System.in);
		n = reader.nextInt();
		SinglyLinkedList linkedList = new SinglyLinkedList();
		
		linkedList.list = new L(n);
		linkedList.head = linkedList.list.new H();
		
			while(true){
			System.out.println("\n**************Singly Linked List Implementation Using Array*******************");
			System.out.println("\n Enter 1 ( Insert(x) ) : To Insert an Item Into The List ");
			System.out.println("\n Enter 2 ( Delete(x) ) : TO delete an Item Into The List");
			System.out.println("\n Enter 3 ( Member(x) ) : To Search an Item Into The List");
			System.out.println("\n Enter 4 ( Exit      ) : To Exit                         ");
			
			int ch = reader.nextInt();
			int item;
			switch(ch){
			
			case 1: {
						System.out.println("\n Enter the new item to be inserted into the List");
						item 	= reader.nextInt(); 
						if (linkedList.insert(item)== 0){
						System.out.println("\n Successful Insertion");
						}
						else { System.out.println("\n Unsuccessful Insertion :: List FULL ");}
					};break;
			case 2: {
						System.out.println("\n Enter the Item to be deleted from the list");
						item 	= reader.nextInt();
						int result  = linkedList.delete(item);
						if (result == 0 )
						{
							System.out.println("Succesful Detetion");
						}
						else if (result == 1)
						{
							System.out.println("\n Unsuccessfull Deletion :: List EMPTY");
						}
						else if ( result == 2){
							System.out.println("\n Element Not Found");
						}
					};break;
			case 3 : {
						System.out.println("\n Enter the item to be searched int the list ");
						item  = reader.nextInt();
						if(linkedList.member(item) == 1){
							System.out.println("\n Element found in the list");
						}
						else {System.out.println("\n Element not found in the list");}
						
					};break;
					
			case 4 : linkedList.display();break; 
				
				//System.exit(0);		
//			case 5 : linkedList.phoo();break;
			}
			
		
		
		}
	}

	public  void display()
	{
		int tempKey;
		int tempNext;
		int boo=0;
		
		tempKey = this.head.key;
		tempNext = this.head.next;
		System.out.println("seprate --");
		System.out.println("tempKey = "+tempKey);
		System.out.println("tempNext = "+tempNext);
		
		if(this.list.freeIndex == 0){
			System.out.println("List Empty");
		}
		else {
			  System.out.println("Head ::"+tempKey);
		while((tempNext != (n+1)) &&  this.list.next[tempNext] != (n+1)){
			if(boo ==8) break;
			System.out.println("Next Key "+this.list.key[tempNext]);
			tempNext = this.list.next[tempNext];
			boo ++;
		}
		if(tempNext == (n+1)){
			System.out.println("Next Key"+head.key);
		}else
		{
		if(this.list.next[tempNext] == (n+1)){
			System.out.println("panga"+this.list.key[tempNext]);
		}}
		
		}
	}
	
	public int insert(int item){
		
		if((this.list.free.length) == this.list.freeIndex)
		{
			return 1;
		}
		else{
			
									
			if(this.list.freeIndex == 0){
				this.reset();
				
			 this.list.key[Integer.parseInt(this.list.free[this.list.freeIndex])] = item;
			 this.list.next[Integer.parseInt(this.list.free[this.list.freeIndex])] = (n+1);
			 this.head.key = this.list.key[Integer.parseInt(this.list.free[this.list.freeIndex])];
			 this.head.next = this.list.next[Integer.parseInt(this.list.free[this.list.freeIndex])];
			 this.list.lastIndex = Integer.parseInt(this.list.free[this.list.freeIndex]);
			 this.list.freeIndex++;
			}
			else{
				
				
				this.list.key[Integer.parseInt(this.list.free[this.list.freeIndex])] = item;
				this.list.next[Integer.parseInt(this.list.free[this.list.freeIndex])] = 
						this.list.lastIndex;
				
				this.head.key = this.list.key[Integer.parseInt(this.list.free[this.list.freeIndex])];
				 this.head.next = this.list.next[Integer.parseInt(this.list.free[this.list.freeIndex])];
				 this.list.lastIndex = Integer.parseInt(this.list.free[this.list.freeIndex]);
				 this.list.freeIndex++;

			}
			return 0;
		}
		
	}
	
	public int delete(int item){
		int tempNext;
		int tempPrev;
		tempPrev = this.head.next;
		tempNext = this.head.next;
		
		if(this.list.freeIndex==0)
		{
			return 1;
		}
		if(this.head.key == item){ // head is item
			this.list.freeIndex--;
			this.list.free[this.list.freeIndex] = Integer.toString(this.list.lastIndex);
			this.list.key[this.list.lastIndex] = 0;
			if(this.head.next != (n+1)){
			this.head.key = this.list.key[tempNext];
			this.head.next = this.list.next[tempNext];
			this.list.lastIndex = tempNext;
					//this.list.next[tempNext];
		    }
		    return 0;
				}
		
		if(this.list.key[tempNext]==item){
			System.out.println("Deleted Item :: "+item);
			this.list.freeIndex--;
			
			this.list.free[this.list.freeIndex] = Integer.toString(tempNext);
			this.list.key[tempNext] = 0;
			if(this.list.next[tempNext] == (n+1))
			{
				this.list.next[tempPrev] = (n+1);	
			}else
			{
				this.list.next[this.list.lastIndex]= this.list.next[tempNext];
			 
			}
						
			return 0;
					
		}
		
		while( (this.list.key[tempNext]!= item) && (this.list.next[tempNext] != (n+1)) ){
			tempPrev = tempNext;
			tempNext = this.list.next[tempNext];	
						
		}
		if(this.list.key[tempNext]==item){
			System.out.println("Deleted Item :: "+item);
			this.list.freeIndex--;
				
			this.list.free[this.list.freeIndex] = Integer.toString(tempNext);
			this.list.key[tempNext] = 0;
			if(this.list.next[tempNext] == (n+1)){
				this.list.next[tempPrev] = (n+1);	
			}else
			{
			this.list.next[tempPrev] = this.list.next[tempNext];
			}
						
			return 0;
		}
		return 2;
	}
	
	public int member(int item){
		
		int tempNext;
		tempNext = this.head.next;
		if(list.freeIndex == 0)return 0;
		
		if(this.head.key == item ) 
		{return 1;}
		while(tempNext != (n+1) && this.list.next[tempNext]!=(n+1)){
			System.out.println(this.list.key[tempNext]);
System.out.println(this.list.next[tempNext]);
			if(this.list.key[tempNext] == item){
				return 1;
			}
			tempNext = this.list.next[tempNext];
		}
		


		if(tempNext !=(n+1) &&this.list.key[tempNext]==item){
			return 1;
		}
		else {
			return 0;
		}
		
	}

public void reset(){
	
	for(int i=0;i<n;i++)
	{
		this.list.free[i] = Integer.toString(i);
	}
}

}
