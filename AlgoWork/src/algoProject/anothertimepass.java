package algoProject;

import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.TreeSet;
import java.util.concurrent.CopyOnWriteArrayList;

public class anothertimepass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		File writeFile 		= new File("C:\\Users\\sujee\\Downloads\\E-Books\\Alog\\B503_Graphs\\write.txt");
//
//		
//		
//		
//
//		try{
//			
//			
//			FileWriter wr	= new FileWriter(writeFile);
//			BufferedWriter  bw = new BufferedWriter(wr);
//			if(writeFile.exists()==false)
//			{
//				writeFile.createNewFile();
//			}
//		
//			int size = 36;
//			String[] prefix 	= new String[size];
//			prefix[0]			= "0";
//			for(int i =1; i < size; i++)
//			{
//				prefix[i]       ="0"+prefix[i-1];
//			}
//			
//			int pow 			= (int)Math.pow(2, size);
//			
//			for(int i =1; i < pow; i++)
//			{
//				String binaryRepre = Integer.toBinaryString(i);
//				int len1 		   = binaryRepre.length();
//				if(len1 != size)
//				{
//					int sub 	   = size - len1;
//					binaryRepre   = prefix[sub-1]+binaryRepre;
//				}
//				
//				bw.write(binaryRepre);
//			    bw.newLine();
//			    System.out.println(i);
//			}
//
//			
//		
//			wr.close();
//			
//			 
//			
//		}catch(Exception e)
//		{}

		ArrayList<String> nn = new ArrayList<String>();
		ArrayList<String> n1 = new  ArrayList<String>();
		HashSet<String> tempHash    = new HashSet<String>();
		LinkedHashSet<String> test = new LinkedHashSet<String>();
		TreeSet<String> gig	= new TreeSet<String>();
		
		nn.add("GO:001 GO:007");
		n1.add("GO:001 GO:007");
		n1.add("GO:008 GO:098");
		n1.add("GO:055 GO:598");
		String kk = n1.toString()
		kk=kk.substring(1, kk.length()-1).replaceAll(",", "");
		
		System.out.println(" kk "+kk);
		
		System.out.println("adding 1 "+gig.addAll(nn));
		System.out.println("adding 2 "+gig.addAll(n1));
		test.add("GO:008");
		test.add("GO:007");
		
		tempHash.add("GO:003");
		tempHash.add("GO:002");
		tempHash.add("GO:001");
		tempHash.add("GO:001");
		
//		System.out.println(" 0 =" +nn.get(0)+" 1= " +nn.get(1)+" 2= " +nn.get(2));
//		nn.remove("2");
//		nn.add("2");
	//System.out.println(" 0 =" +nn.get(0)+" 1= " +nn.get(1)+" 2= " +nn.get(2));
//		
//		HashSet<String> no = new HashSet<String>();
//		no.contains(nn);
//		no.addAll(nn);
//		System.out.println(n1.contains()));
		
		System.out.println("list size "+tempHash.size()+tempHash);
		
		
		
	}

}
