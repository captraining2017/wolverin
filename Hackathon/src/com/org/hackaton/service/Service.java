package com.org.hackaton.service;

import java.io.File;
import java.io.IOException;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.TreeMap;

import com.org.hackaton.config.Config;
import com.org.hackaton.constants.Constans;
import com.org.hackaton.view.LoadFiles;

import sun.reflect.generics.tree.Tree;

public class Service {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// D:/Wolverin
		
		LoadFiles load=new LoadFiles();
		Scanner scan=new Scanner(System.in);
		//Config.configProperties(args[0]);
		System.out.println("Select which Dataset to be load.....");
		
		File inbox = new File(args[0]+"/"+Constans.INBOX);
		File[] listInboxFiles = inbox.listFiles();
		
		File MasterdataSet=new File(args[0]+"/"+Constans.MASTERDATASET);
		File[] listDatasetFiles = MasterdataSet.listFiles();
		
		
		TreeMap<Integer, String> fileName=new TreeMap<Integer, String>();
		
			for(int i=0; i<listDatasetFiles.length;i++){
				
				 if (listDatasetFiles[i].isFile()) {
				        //System.out.println("File: "+i+" " + listOfFiles[i].getName());
				        System.out.println(listDatasetFiles[i].getName());
				    	
				    	load.lodingCustomerCSV(args[0]+"/"+Constans.MASTERDATASET,listDatasetFiles[i].getName());
				        
				      }
			}
		
			
			//list of files in inbox...
		    for (int i=0; i < listInboxFiles.length; i++) {
		      if (listInboxFiles[i].isFile()) {
		        //System.out.println("File: "+i+" " + listOfFiles[i].getName());
		        fileName.put(i,listInboxFiles[i].getName());
		        
		      } else {
		        System.out.println("No Files...");
		      }
		    }
		    
		    //option to load file...
		    for(Entry<Integer, String> Name: fileName.entrySet()){
		    	System.out.println(Name.getKey()+" : "+Name.getValue());
		    }
		    int option=scan.nextInt();
		    //loading input file...
		    if(option<listInboxFiles.length){
		    	System.out.println(fileName.get(option).toString());
		    
		    	load.lodingTransactionCSV(args[0]+"/"+Constans.INBOX, fileName.get(option).toString());
		    	}
		    else{
		    	System.out.println("enter correct value");
		    }
		
		
		
		

	}

}
