package algoProject;

import java.io.BufferedReader;

import java.io.BufferedWriter;
import java.io.*;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class SubDags2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int fileCount = 0;
		String tempWork = null;
		File file 		= new File("C:\\Users\\sujee\\Downloads\\E-Books\\Alog\\B503_Graphs"
									+ "\\tree_25.txt");
		File writeFile 		= new File("C:\\Users\\sujee\\Downloads\\E-Books\\Alog\\B503_Graphs"
				+ "\\testing.txt");
		//ArrayList<String> graphSoFar					= new ArrayList<String>();
		
		
		
		LinkedHashSet<String> tempHash 					= new LinkedHashSet<String>();
		HashMap<String,ArrayList<String>> parentMatrix	= new HashMap<String,ArrayList<String>>();
		HashMap<String,ArrayList<String>> childMatrix 	= new HashMap<String,ArrayList<String>>();
		
		
		System.out.println(file.exists());
		System.out.println(file.exists());
		
		try 
		{
		    
			FileReader fr	= new FileReader(file);
			FileReader frr	= new FileReader(file);
			FileWriter wr	= new FileWriter(writeFile);
			BufferedReader  br = new BufferedReader(fr);
			BufferedWriter  bw = new BufferedWriter(wr);
			
			if(writeFile.exists()==false)
			{
				writeFile.createNewFile();
			}
						
			/***************************************************************************
			 *	Populating Temp LinkedHashSet										   *								
			 ***************************************************************************/
			
			String temp = br.readLine();
			tempHash.add(temp);
				
			while(( tempWork = br.readLine()) != null)
				{
					fileCount++;
					String tempSplit[] = tempWork.split("\\t");
					for(int i =0; i < tempSplit.length;i++)
					{
						tempHash.add(tempSplit[i]);
					}
				}
			
			/***************************************************************************
			 *	Populating InContent which contains input data 										   *								
			 ***************************************************************************/
			
				String [][] InContent = new String[fileCount][2];
				BufferedReader  brr = new BufferedReader(frr);
				temp = brr.readLine();
				int z = 0;
				while((tempWork = brr.readLine()) != null)
				{
					String tempSplit[] = tempWork.split("\\t");
					for(int i =0; i< tempSplit.length;i++)
					{
						if(i==0)
						{
							InContent[z][0] = tempSplit[i]; 
						}
						else
						{
							InContent[z][1] = tempSplit[i]; 
						}
					}
							z++;				
				}
				
//				for(int i =0; i < fileCount; i++)
//				{
//					for( int j =0; j< 2; j++)
//					{
//						System.out.print(" "+InContent[i][j]);
//					}
//					System.out.println();
//				}

				/***************************************************************************
				 *	Copying tempHash to workingArray									   *								
				 ***************************************************************************/
				
				int noOfNodes        = tempHash.size(); 
				String[] workingArray = new String[noOfNodes];
				workingArray          = tempHash.toArray(workingArray);
				
				//tempHash.forEach(a -> System.out.println(a));
				
				br.close();
				brr.close();

				/***************************************************************************
				 *	Generating ParentMatrix for all node in wokringArray 				   *								
				 ***************************************************************************/
				
				for(int i =0; i< noOfNodes;i++)
				{
					String tempItem    			= workingArray[i];
					ArrayList<String>  tempList = new ArrayList<String>();
				    for(int j =0; j< fileCount; j++)
				    {
				    	
				    	if(InContent[j][0].equals(tempItem) )
				    	{
				    		tempList.add(InContent[j][1]);
				    	
				    	}
				    }
				  
				  	parentMatrix.put(tempItem, tempList);
					  
				}

				
				/***************************************************************************
				 *	Generating Child Matrix with eliminating duplicates childs  			*
				 *  and keeping it to very last entry in the tree		 				    *								
				 ***************************************************************************/
				
				
				HashMap<String,Boolean> colorCheckI = new HashMap<String,Boolean>(); 
				for(int i =0; i< workingArray.length;i++)
				{
					colorCheckI.put(workingArray[i],false);
				}
				
				for(int i =0; i< noOfNodes;i++)
				{
					String tempItem    			= workingArray[i];
					ArrayList<String>  tempList = new ArrayList<String>();
				    for(int j =0; j< fileCount; j++)
				    {
				    	if(InContent[j][1].equals(tempItem) )
				    	{
				    		if(colorCheckI.get(InContent[j][0]) == false)
				    		{
				    		tempList.add(InContent[j][0]);
				    		colorCheckI.put(InContent[j][0],true);
				    		}
				    		
				    	}
				    }
				  	childMatrix.put(tempItem, tempList);
				}
				
				
				
				
				System.out.println("childs");
				
				for(Map.Entry<String,ArrayList<String>> entry : childMatrix.entrySet())	
				{
					System.out.println(entry.getKey()+" = "+entry.getValue());
					
				}
				
				
				/***************************************************************************
				 *	Generating Consistent Parent Matrix with 			 				    *								
				 ***************************************************************************/
				
				
				HashMap<String,CopyOnWriteArrayList<String>> consisParentMatrix = new HashMap<String,CopyOnWriteArrayList<String>>();
//			    ArrayList<String> usedOnce = new ArrayList<String>();
//				consisParentMatrix.put(inOrdered.get(0),usedOnce);
				
//				CopyOnWriteArrayList<String> nodesAllParent 			= new CopyOnWriteArrayList<String>();
//				nodesAllParent.add(" new");
//				Iterator<String> iterator       						= nodesAllParent.iterator();
//				String aa = "jjj";
//				ArrayList<String> ss = new ArrayList<String>(); 
//				while(iterator.hasNext())
//				{
//					nodesAllParent.addAll(ss);
//				}
//			    
				for (int i = 0; i < noOfNodes; i++)
				{
					String node = workingArray[i];
					CopyOnWriteArrayList<String> nodesAllParent 			= new CopyOnWriteArrayList<String>();
					nodesAllParent.add(node);
					Iterator<String> iterator       						= nodesAllParent.iterator();
					HashSet<String>  removingDuplicateParentsInList			= new HashSet<String>();
					int count = 0;
					int size  = 0;
					while(iterator.hasNext())
					{
						ArrayList<String> parentsToBeAdded = parentMatrix.get(nodesAllParent.get(count));
						if(parentsToBeAdded.size() != 0)
						{
							count += parentsToBeAdded.size();
							
							nodesAllParent.addAll(parentsToBeAdded);
							
						}
						size++;
						if(size > count){
							break;
						}
						
					}
					removingDuplicateParentsInList.addAll(nodesAllParent);
					nodesAllParent.clear();
					nodesAllParent.addAll(removingDuplicateParentsInList);
					TreeSet<String> justCheck = new TreeSet<String>();
					justCheck.addAll(nodesAllParent);
					nodesAllParent.clear();
					nodesAllParent.addAll(justCheck);
					consisParentMatrix.put(node, nodesAllParent);
				}
				
				
//				for(Map.Entry<String,CopyOnWriteArrayList<String>> entry : consisParentMatrix.entrySet())	
//				{
//					System.out.println(entry.getKey()+" = "+entry.getValue());
//					
//				}
				
				
				/***************************************************************************
				 *	Generating nodes for 1st level distribution 						   *								*
				 ***************************************************************************/
				
				ArrayList<String>  firstLevelNodes = new ArrayList<String>();
//				for(int i =0; i< noOfNodes;i++)
//				{
					String tempItem    			= workingArray[0];
					for(int j =0; j< fileCount; j++)
				    {
				    	if(InContent[j][1].equals(tempItem) )
				    	{
				    		firstLevelNodes.add(InContent[j][0]);
				    	}
				     }
				//}
				
				/***************************************************************************
				 *	Generating All children of any given  node  		   				   *								
				 ***************************************************************************/
				
				HashMap<String,ArrayList<String>> allChildren = new HashMap<String,ArrayList<String>>();
				
				for(int i =0; i < noOfNodes; i++)
				{
					ArrayList<String> listOfChildren = new ArrayList<String>();
					
					SendMeListOfChildren(workingArray[i],listOfChildren,childMatrix);
					
					allChildren.put(workingArray[i], listOfChildren);
					
				}
				
				
//				System.out.println(" childreen for all nodes");
//				for(Map.Entry<String,ArrayList<String>> entry : allChildren.entrySet())	
//				{
//					System.out.println(entry.getKey()+" = "+entry.getValue());
//					
//				}
//				
				
				
				
//				for(int i =0; i < firstLevelNodes.size();i++)
//				{
//					ArrayList<String>  testFistLevelNodes = parentMatrix.get(firstLevelNodes.get(i));					
//					if(testFistLevelNodes.size() > 1)
//					{
//						firstLevelNodes.remove(i);
//					}
//				}
				

				/***************************************************************************
				 *	Building Double Hash Function		   				                   *					
				 ***************************************************************************/

				
				HashMap<String,HashMap<String, CopyOnWriteArrayList<String>>> fisrtHashing = 
						new HashMap<String,HashMap<String, CopyOnWriteArrayList<String>>>();
				
				for (int i = 0; i < firstLevelNodes.size(); i++)
				{
					String currentNode = firstLevelNodes.get(i);
					
//					CopyOnWriteArrayList<String> childsOfCurrentNode = new CopyOnWriteArrayList<String>();
//					childsOfCurrentNode.add(currentNode);
					HashMap<String, CopyOnWriteArrayList<String>> secondHashing = new HashMap<String, CopyOnWriteArrayList<String>>();
				    ArrayList<String> childsOfFirstHashing 			= allChildren.get(currentNode);
				    secondHashing.put(currentNode, consisParentMatrix.get(currentNode));
				    for(int j =0; j < childsOfFirstHashing.size(); j++)
				    {
				    	secondHashing.put(childsOfFirstHashing.get(j), consisParentMatrix.get(childsOfFirstHashing.get(j)));
				    
				    }
				    populateMore(currentNode,secondHashing);
				    
				    
				  //  wr.newLine();
				    System.out.println("currentNode = "+currentNode+" secondHashing = "+secondHashing.size());
				 fisrtHashing.put(firstLevelNodes.get(i), secondHashing);   
					
				}  
				
			
//				System.out.println("  nawa ------------------------------------------------");
//				for(Map.Entry<String,HashMap<String,CopyOnWriteArrayList<String>>> entry : fisrtHashing.entrySet())	
//				{
//					//System.out.println(entry.getKey()+" = "+entry.getValue());
//					
//					HashMap<String,CopyOnWriteArrayList<String>> justToPrint = entry.getValue();
//					
//					for(Map.Entry<String,CopyOnWriteArrayList<String>> entry1 : justToPrint.entrySet())	
//					{
//						bw.write(entry.getKey()+" => "+entry1.getKey()+" = "+entry.getValue());
//					    bw.newLine();
//						
//					}
//					
//					
//				}
				
				
				
				/* Generating ConsistentPartentMatrix for all nodes*/
				
//				ConcurrentHashMap<String, Arraylist>
//				ConcurrentMap<String,ArrayList<String>>  = new HashMap<String,ArrayList<String>>();
//			    ArrayList<String> usedOnce = new ArrayList<String>();
//				.put(workingArray[0],usedOnce);
//			    
				System.out.println(" END 1");
				
				
				System.out.println(" END 2");	
				wr.close();
		}catch(IOException e)
		{}
				
	}
	
	public static void SendMeListOfChildren(String node , ArrayList<String> listTobeAdded , 
			HashMap<String, ArrayList<String>> matrix )
	{
			ArrayList<String> list = matrix.get(node);
			
			if (list.size()== 0) return;
			else 
			{
				for(int i = 0; i < list.size(); i++)
				{
					listTobeAdded.add(list.get(i));
					SendMeListOfChildren(list.get(i),listTobeAdded,matrix);
					
				}
			}
			
			
		
	}
	
	public static void populateMore(String cNode,HashMap<String, CopyOnWriteArrayList<String>> secondHashing)
	{
		
		int size 			= secondHashing.size();
		String[] prefix 	= new String[size];
		prefix[0]			= "0";
		String[] retrivalKeys = new String[size];

		TreeSet<String> addCheckSet = new TreeSet<String>();		
		ArrayList<ArrayList<String>> arrList = new ArrayList<ArrayList<String>>(size);
		
		int temp 			= 0;
		for(Map.Entry<String,CopyOnWriteArrayList<String>> entry : secondHashing.entrySet())	
		{
			
			CopyOnWriteArrayList<String> l1 = entry.getValue();
			ArrayList<String> l2 	= new ArrayList<String>();
			
	l2.addAll(l1);
			
			TreeSet<String> setOrder = new TreeSet<String>();
			for(int p = 0; p < l1.size();p++ )
			{
				setOrder.add(l1.get(p));
			}
			String kk = setOrder.toString();
			kk=kk.substring(1, kk.length()-1).replaceAll(",", "");
			retrivalKeys[temp++] = entry.getKey();
			arrList.add(l2);
			addCheckSet.add(kk);
		
			
//			l2.addAll(l1);
//			String kk = l2.toString();
//			kk=kk.substring(1, kk.length()-1).replaceAll(",", "");
//			retrivalKeys[temp++] = entry.getKey();
//			arrList.add(l2);
//			addCheckSet.add(kk);
			
		}

		
		
		for(int i =1; i < size; i++)
		{
			prefix[i]       ="0"+prefix[i-1];
		}
		
		int pow 			= (int)Math.pow(2, size);
		
		for(int i =1; i < pow; i++)
		{
			String binaryRepre = Integer.toBinaryString(i);
			int len1 		   = binaryRepre.length();
			if(len1 != size)
			{
				int sub 	   = size - len1;
				binaryRepre   = prefix[sub-1]+binaryRepre;
			}
			String[] binaryRepreArray = binaryRepre.split("");
			int[] index = new int[binaryRepreArray.length];
			int indexCount = 0;
			Arrays.fill(index, -99);
			for(int j =0; j < index.length; j++)
			{
				if (binaryRepreArray[j].equals("1"))
				{
					index[indexCount++] = j;
				}
			}
			
		
			int loppingCount =0;
		//	String newKeyToBeAdded ="NO";
			TreeSet<String> tempHash    = new TreeSet<String>();
			while(loppingCount < size && index[loppingCount] != -99)
			{
				int posIndex = index[loppingCount++];
			//	newKeyToBeAdded = newKeyToBeAdded.concat(" ").concat(retrivalKeys[posIndex]);
				tempHash.addAll(secondHashing.get(retrivalKeys[posIndex]));
			}
			
			if(loppingCount > 1)
			{
				boolean flag = false;
				
				
				CopyOnWriteArrayList<String> tempp = new CopyOnWriteArrayList<String>();
				tempp.addAll(tempHash);
				
				String kk = tempp.toString();
				kk=kk.substring(1, kk.length()-1).replaceAll(",", "");
				
				for(int z = 0; z < size; z++)
				{	
					if(arrList.get(z).containsAll(tempp) == true)
					{
						flag = true;
					}
				}
//				
				if(addCheckSet.add(kk)==true)
				{
					secondHashing.put(cNode+" "+i,tempp);
				}
				
			}
			
		}
		
	}
	
}
