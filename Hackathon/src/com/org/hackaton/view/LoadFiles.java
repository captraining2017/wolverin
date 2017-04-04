package com.org.hackaton.view;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import com.org.hackaton.model.Customer;
import com.org.hackaton.model.Tranaction;

public class LoadFiles {

	public static ArrayList<Customer> customer=new ArrayList<Customer>();
	ArrayList<Integer> custId=new ArrayList<Integer>();
	
	public void lodingCustomerCSV(String path, String fileName) throws IOException{
		
		String split=",";
		
		
		//ArrayList<Tranaction> tranaction=new ArrayList<Tranaction>();
		File file = new File(path+"/"+fileName);
		Scanner sc = new Scanner(new FileReader(file));
		BufferedReader br = new BufferedReader(new FileReader(file));
		int r=0;
	     while(br.readLine() != null)
	     {	
	    	 
	         r++;
	     }
	    String line;
		
		int i=0;
		while(sc.hasNext()){
			String lineSplit[];
			if(i==0){
			line=sc.nextLine();
			lineSplit=line.split(split);
			}else{
				line=sc.nextLine();
				lineSplit=line.split(split);
				Customer customer2=new Customer();
				/*System.out.println(Integer.parseInt(lineSplit[0]));
				System.out.println(lineSplit[1]);
				System.out.println(Float.parseFloat(lineSplit[2]));*/
				customer2.setCustomerId(Integer.parseInt(lineSplit[0]));
				customer2.setCustomerName(lineSplit[1]);
				customer2.setSalary(Float.parseFloat(lineSplit[2]));
				customer.add(customer2);
			
			}
			
			i++;
		}
			
		System.out.println("Master dataset loaded.....");
		
		// Getting values from Customer.... 
		/*for(Customer customer1: customer){
			
			System.out.println("ID: "+customer1.getCustomerId());
			System.out.println("Name: "+customer1.getCustomerName());
			System.out.println("Salary: "+customer1.getSalary());
			
					
			
		}*/
	}
	
public void lodingTransactionCSV(String path, String fileName) throws IOException{
		
		String split=",";
		//ArrayList<Customer> customer=new ArrayList<Customer>();
		ArrayList<Tranaction> tranaction=new ArrayList<Tranaction>();
		
		File file = new File(path+"/"+fileName);
		Scanner sc = new Scanner(new FileReader(file));
		BufferedReader br = new BufferedReader(new FileReader(file));
		int r=0;
	     while(br.readLine() != null)
	     {	
	    	 
	         r++;
	     }
	    String line;
		
		int i=0;
		while(sc.hasNext()){
			String lineSplit[];
			if(i==0){
			line=sc.nextLine();
			lineSplit=line.split(split);
			}else{
				line=sc.nextLine();
				lineSplit=line.split(split);
				Tranaction tranaction1=new Tranaction();
				/*System.out.println(lineSplit[0]);
				System.out.println(lineSplit[1]);
				System.out.println(Float.parseFloat(lineSplit[2]));
				System.out.println(lineSplit[3]);*/
				
				tranaction1.setCustomerId(Integer.parseInt(lineSplit[0]));
				tranaction1.setTranactionDate(lineSplit[1]);
				tranaction1.setTransAmount(Float.parseFloat(lineSplit[2]));
				tranaction1.setTransType(lineSplit[3]);
				tranaction.add(tranaction1);			
			}
			
			i++;
		}
		
		System.out.println(fileName+" file loaded...");
		Set<Integer> Id=new HashSet<Integer>();
		
		for(Tranaction tranaction2: tranaction){
			
			//System.out.println("to loding separete array for: "+tranaction2.getCustomerId());
			
			Id.add(tranaction2.getCustomerId());
			
			//CustomerTransactionCheck.transactionCheck(tranaction2.getCustomerId(),tranaction2.getTranactionDate(),tranaction2.getTransAmount(),tranaction2.getTransType());
			
			/*System.out.println("CustID: "+ tranaction2.getCustomerId());
			System.out.println("Date: "+ tranaction2.getTranactionDate());
			System.out.println("Transamnt: "+ tranaction2.getTransAmount());
			System.out.println("TransType: "+ tranaction2.getTransType());*/
			
		}
		for(Integer id: Id){
			//System.out.println(id);
			custId.add(id);
			
		}
		
		SingleCustomerTransactions.singleCustomerTransDetail(tranaction,custId);
		
		//ArrayList<Tranaction> singleCustTranaction=new ArrayList<Tranaction>();
		/*for(int j=0; j<custId.size();j++){
			
			for(Tranaction tranaction2: tranaction){
				
				
					
				if(tranaction2.getCustomerId() ==custId.get(j)){
					
				System.out.println("CustId:"+ custId.get(j)+ "  "+tranaction2.getCustomerId());
					Tranaction tranaction3=new Tranaction();
					tranaction3.setCustomerId(tranaction2.getCustomerId());
					tranaction3.setTranactionDate(tranaction2.getTranactionDate());
					tranaction3.setTransAmount(tranaction2.getTransAmount());
					tranaction3.setTransType(tranaction2.getTransType());
					singleCustTranaction.add(tranaction2);
					
					
				}
			}
			
			
		}*/
		
		/*for(Tranaction tranaction2:singleCustTranaction){
			
			System.out.println("Single custid: ");
			System.out.println("**************************************");
			System.out.println("CustID: "+ tranaction2.getCustomerId());
			System.out.println("Date: "+ tranaction2.getTranactionDate());
			System.out.println("Transamnt: "+ tranaction2.getTransAmount());
			System.out.println("TransType: "+ tranaction2.getTransType());
			System.out.println("**************************************");
			
		}*/
		
		SingleCustomerTransactions.singleCustomerCheck();
		
}
			
	
	
	
}
