package stack;

import java.util.Scanner;

public class stackWithHead {
	
	stack S;
	public static int sizeOfStack;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("Enter The Size of Stack :: ");
		Scanner reader = new Scanner(System.in);
		sizeOfStack = reader.nextInt();
		stackWithHead stackH = new stackWithHead();
		stackH.S = new stack(sizeOfStack);
		
		
		while(true){
			System.out.println(" Enter 1 to Push");
			System.out.println(" Enter 2 to Pop");
			System.out.println(" Display the stack");
			
			int ch = reader.nextInt();
			int item;
			switch(ch){
			
			case 1 : { 
					System.out.println("Enter the Element to Be Inserted");
					item = reader.nextInt();
					stackH.push(item);
						
				
			};break;
			case 2 : {
				stackH.pop();
			};break;
			case 3: stackH.display();break;
			case 4: System.exit(0);
			case 5: System.out.println("Unexpected Input , Please Enter The Input again");
		}
		
	}

}
	public void push(int item){
		
		if(  S.top== sizeOfStack -1){
			System.out.println("Stack OverFlow, Element can not be Inserted");
			
		}
		else
		{	
			S.a[++S.top] = item;
			S.head = S.a[S.top];
		}
		
	}
	
	public void pop(){
		
		if(S.top < 0)
		{
			System.out.println("Stack UnderFlow, Cannot delete Element");
		}
		else
		{//	System.out.println(" S.a[S.top] = "+S.a[S.top]+" S.top = "+S.top);

			S.top--;
			S.head = S.a[S.top];

//			System.out.println(" S.a[S.top] = "+S.a[S.top]+" S.top = "+S.top);
//			System.out.println(" S.a[S.top] = "+S.a[S.top]+" S.top");
		}
	}
	public void display()
	{
		System.out.println("S.top = "+S.top);
		if(S.top < 0)
		{
			System.out.println("Stack UnderFlow, Cannot delete Element");
		}
		else
		{
			for(int i=S.top;i>=0;i--)
			{	//System.out.println(" S.a[S.top] = "+S.a[S.top]+" S.top = "+S.top);
				
				System.out.println(S.a[i]);
			}
		}
	}
	
}
