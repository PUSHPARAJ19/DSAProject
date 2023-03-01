package com.student;
import java.io.*;
import java.util.*;

import com.admin.Admin;

public class Student
{
	 
	public static String registerStudent() throws ClassNotFoundException, IOException
	{
		//update password
				FileInputStream fi = new FileInputStream("StudentPasswords.txt");
				TreeMap<String,String>	tm=null;
				try {
				ObjectInputStream oi = new ObjectInputStream(fi);
				 tm  = (TreeMap<String, String>) oi.readObject();
				}
				catch(IOException e) {}
				//file
				if(tm==null)
					tm = new TreeMap<String,String>();
				
				TreeMap<String,LinkedHashMap<String,String>> hm = null;
				FileInputStream fis = new FileInputStream("studentDetails.txt");
				try {
					ObjectInputStream ois = new ObjectInputStream(fis);
					hm = (TreeMap<String,LinkedHashMap<String,String>>) ois.readObject();
					ois.close();
				} 
				catch (IOException e) {}
				
				if(hm==null)
					hm = new TreeMap<String,LinkedHashMap<String,String>>();
				
					System.out.println("Enter Your details");
					System.out.println("(Name,Department,Year,Dob,Address,Mobile,Email,Blood Group)");
					LinkedHashMap<String,String> stu = new LinkedHashMap<String,String>();
					Scanner sc= new Scanner(System.in);
					String name = sc.nextLine();
					String dept = sc.nextLine();
					String year = sc.nextLine();
					String dob = sc.nextLine();
					String address = sc.nextLine();
					String mob_num = sc.nextLine();
					String email = sc.nextLine();
					String bloodGrp = sc.nextLine();
					stu.put("Name", name);
					stu.put("Dept", dept);
					stu.put("Year",year);
					stu.put("Dob", dob);
					stu.put("Address",address);
					stu.put("Mobile number", mob_num);
					stu.put("Email", email);
					stu.put("Blood group",bloodGrp);
					String id = Admin.id_generate(hm);
					tm.put(id,name.toLowerCase()+"@"+id);
					hm.put(id,stu);
					
				
				
				FileOutputStream fout1 = new FileOutputStream("studentDetails.txt");
				ObjectOutputStream out1 = new ObjectOutputStream(fout1);
				out1.writeObject(hm);
				out1.close();
				fout1.close();
				//update passwords
				FileOutputStream fout = new FileOutputStream("StudentPasswords.txt");
				 ObjectOutputStream oos = new ObjectOutputStream(fout);
				 oos.writeObject(tm);
				 oos.close();
				 fout.close();
				 return id;
	}
	public static void displayDetails(String id,LinkedHashMap<String,String> lh)
	{
		System.out.println("Hello "+lh.get("Name")+"!, Your Details:");
		  //System.out.println();
		  System.out.println("+------------------------------------------------------------------+");
		  System.out.println(String.format("|%-23s | %-40s|","Id",id));
		  for(Map.Entry e:lh.entrySet())
		  {
		      System.out.println(String.format("|%-23s | %-40s|",e.getKey(),e.getValue()));
		  }
		  System.out.println("+------------------------------------------------------------------+");
		  System.out.println();
		  
	}
	public static LinkedHashMap<String,String> editStudentInfo(String id,LinkedHashMap<String,String> lm) throws IOException
	{
		Scanner sc = new Scanner(System.in);
		Student.displayDetails(id, lm);
		System.out.println("How many fields do  you want to edit ?");
		int count = Integer.parseInt(sc.nextLine());
		while(count-- >0)
		{
			System.out.println("Enter the field you want to edit:");
			String key = sc.nextLine();
			if(lm.containsKey(key)) 
			{
				System.out.println("Enter the value for "+key+":");
				String value = sc.nextLine();
		    lm.put(key, value);
			}
			else
			{
				System.out.println("Enter a Valid Field");
				count++;
			}
		}
		System.out.println("Updated Details");
		Student.displayDetails(id, lm);
		return lm;

	}
//	public static LinkedHashMap<String,String> updateStudentInfo(String id,LinkedHashMap<String,String> lh)
//	{
//		Scanner sc = new Scanner(System.in);
//		System.out.println("Update Info(Add educational qualification,personal details)");
//	  int flag = 1;
//	  while(flag==1)
//	  {
//		  System.out.println("Enter the field to add details:");
//		  String field = sc.nextLine();
//		  System.out.println("Enter the value for the field:");
//		  String value = sc.nextLine();
//		  lh.put(field,value);
//		  System.out.println("Do you want to add more details? \n 1.Yes \n 2.No");
//		   flag = Integer.parseInt(sc.nextLine());
//		   
//	  }
//		return lh;
//	}
	
	public static void updateStudentInfo(String id,LinkedHashMap<String,String> lh)
	{
		Scanner sc = new Scanner(System.in);
//		System.out.println("Update Info(Add educational qualification,personal details)");
//	  int flag = 1;
//	  while(flag==1)
//	  {
//		  System.out.println("Enter the field to add details:");
//		  String field = sc.nextLine();
//		  System.out.println("Enter the value for the field:");
//		  String value = sc.nextLine();
//		  lh.put(field,value);
//		  System.out.println("Do you want to add more details? \n 1.Yes \n 2.No");
//		   flag = Integer.parseInt(sc.nextLine());
//		   
//	  }
//	  FileOutputStream fout11 = new FileOutputStream("studentDetails.txt");
//	  ObjectOutputStream out11 = new ObjectOutputStream(fout11);
//	  out11.writeObject(hm);
//	  out11.close();
//	  fout11.close();
//		
	}
	
	
}


