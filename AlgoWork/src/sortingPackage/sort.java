package sortingPackage;
import java.util.Arrays;
public class sort {
	
	public static void main(String[] args){
		
		int[] compI = new int[100];
		int[] compM = new int[100];
		int[] avgI  = new int[20];
		int[] avgM  = new int[20];
		MS merge = new MS();
	IS insertion = new IS();
	for(int n=5;n<=100;n+=5){
		int tempM=0; 
		int tempI=0;	
	
	for(int i =0;i<100;i++){
		
	compM[i] =merge.mergeS(n); tempM +=compM[i];
	compI[i] = insertion.insertion(n); tempI +=compI[i];
	//System.out.println(" \nvalue for I -- "+i+" -- is Done");
	} 
	avgM[(n/5)-1] = tempM/100;
	avgI[(n/5)-1] = tempI/100;
	 Arrays.fill(compM,0);
	 Arrays.fill(compI,0);

	}
	for(int i =0;i<20;i++){
		System.out.println("\ncomp M = "+avgM[i]+"\t comp I = "+avgI[i] +" ");
			
		
	}
		
		}
	

}
