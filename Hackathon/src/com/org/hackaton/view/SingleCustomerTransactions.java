package com.org.hackaton.view;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import com.org.hackaton.constants.Constans;
import com.org.hackaton.model.Tranaction;

public class SingleCustomerTransactions {
	
	
	public static void singleCustomerTransDetail(ArrayList<Tranaction> singleCustTranaction, ArrayList<Integer> custId) throws IOException{
		
		int Custid = 0;
		String split=",";
		
		/*for(Tranaction trans:singleCustTranaction){
		
			Custid=trans.getCustomerId();
		}
		*/
		for(int j=0; j<custId.size();j++){
			
			FileWriter single = new FileWriter(Constans.ROOT+"/"+Constans.ALLCUSTDATASET+"/"+custId.get(j)+" Transactions.csv");
			PrintWriter pw = new PrintWriter(single);
			StringBuilder sb=new StringBuilder();
			//custId	TransDate	TransAmnt	TransType

			sb.append("custId");
			sb.append(split);
			sb.append("TransDate");
			sb.append(split);
			sb.append("TransAmnt");
			sb.append(split);
			sb.append("TransType");
			sb.append(split);
			sb.append("\n");
			for(Tranaction tranaction2: singleCustTranaction){
				
				
					
				if(tranaction2.getCustomerId() ==custId.get(j)){
					
				//System.out.println("CustId:"+ custId.get(j)+ "  "+tranaction2.getCustomerId());
					
					sb.append(tranaction2.getCustomerId());
					sb.append(split);
					sb.append(tranaction2.getTranactionDate());
					sb.append(split);
					sb.append(tranaction2.getTransAmount());
					sb.append(split);
					sb.append(tranaction2.getTransType());
					sb.append(split);
					sb.append("\n");
					
					//System.out.println(sb.toString());
					
				}
			}
			
			pw.write(sb.toString());
			pw.close();
			
		}
		
		
		
		
	}
	
	public static void singleCustomerCheck(){
		
		String path=Constans.ROOT+"/"+Constans.ALLCUSTDATASET+"/";
		File singleCSV=new File(path);
		File[] listCSVFiles = singleCSV.listFiles();
		
		for(int i=0; i<listCSVFiles.length;i++){
			
			 if (listCSVFiles[i].isFile()) {
			        //System.out.println("File: "+i+" " + listOfFiles[i].getName());
			        System.out.println(listCSVFiles[i].getName());
			    	
			    	//load.lodingCustomerCSV(args[0]+"/"+Constans.MASTERDATASET,listDatasetFiles[i].getName());
			        
			      }
		}
		
		
	}
	
	
	
	
	

}
