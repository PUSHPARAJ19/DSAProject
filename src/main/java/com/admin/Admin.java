package com.admin;
import java.io.*;
import java.util.*;

import com.faculty.FacultyInfo;
import com.student.StudentInfo;


public class Admin implements Serializable {
	
	
	public static StudentInfo getStudent(LinkedHashMap<String,String> li)
	{
		
		String details[] = new String[9];
		String roll="";
		int i=0;
           //roll = ((String)e.getKey());
				for(Map.Entry e1: li.entrySet())
				{
					details[i++] = (String)e1.getValue();
					//System.out.println(details[i]);
				}

		StudentInfo  student = new StudentInfo(details[0],details[1],details[2],details[3],details[4],details[5],details[6],details[7],details[8]);
	student.setRollNo(roll);
	//System.out.println(Arrays.toString(details));
		return student;
	}
   public static FacultyInfo getFaculty(LinkedHashMap<String,String> li)
   {
	   String details[] = new String[10];
		String roll="";
		int i=0;

				for(Map.Entry e1: li.entrySet())
				{
					details[i++] = (String)e1.getValue();
					//System.out.println(details[i]);
				}
				
              FacultyInfo faculty = new FacultyInfo(details[0],details[1],details[2],details[3],details[4],details[5],details[6],details[7],details[8]);
              return faculty;
   }
	@SuppressWarnings("unchecked")
	public static TreeMap<String,LinkedHashMap<String,String>> getRec() throws ClassNotFoundException, IOException
	{
		File f2 = new File("D:/III Year Project/DSAProject/studentDetails.txt");
		TreeMap<String, LinkedHashMap<String, String>> li11=null;
		FileInputStream fis2 = new FileInputStream(f2);
		try {
		ObjectInputStream ois2 = new ObjectInputStream(fis2);
		li11 = (TreeMap<String, LinkedHashMap<String, String>>) ois2
				.readObject();
		}
		catch(IOException e) {}
		
	
		FileOutputStream fout1 = new FileOutputStream("D:/III Year Project/DSAProject/studentDetails.txt");
		ObjectOutputStream out1 = new ObjectOutputStream(fout1);
		out1.writeObject(li11);
		out1.close();
		fout1.close();
		return li11;
		
	}
	public static TreeMap<String,LinkedHashMap<String,String>> getFacultyRec() throws ClassNotFoundException, IOException
	{
		File f2 = new File("D:/III Year Project/DSAProject/FacultyDetails.txt");
		TreeMap<String, LinkedHashMap<String, String>> li11=null;
		FileInputStream fis2 = new FileInputStream(f2);
		try {
		ObjectInputStream ois2 = new ObjectInputStream(fis2);
		li11 = (TreeMap<String, LinkedHashMap<String, String>>) ois2
				.readObject();
		}
		catch(IOException e) {}
		
	
		FileOutputStream fout1 = new FileOutputStream("D:/III Year Project/DSAProject/FacultyDetails.txt");
		ObjectOutputStream out1 = new ObjectOutputStream(fout1);
		out1.writeObject(li11);
		out1.close();
		fout1.close();
		return li11;
		
	}
	public static boolean addAdmin(LinkedHashMap<String,String> admin) throws IOException, ClassNotFoundException
	{
		//demo text
				//file
				TreeMap<String,LinkedHashMap<String,String>> hm = null;
				FileInputStream fis = new FileInputStream("D:/III Year Project/DSAProject/AdminDetails.txt");
				try {
					ObjectInputStream ois = new ObjectInputStream(fis);
					hm = (TreeMap<String,LinkedHashMap<String,String>>) ois.readObject();
					ois.close();
				} 
				catch (IOException e) {}
				
				if(hm==null)
					hm = new TreeMap<String,LinkedHashMap<String,String>>();
				
					//System.out.println("Enter Admimn details");
					//System.out.println("(Name,Dob,Email,Address,YearOfJoining)");
//					LinkedHashMap<String,String> stu = new LinkedHashMap<String,String>();
//					stu.put("Name", name);
//					stu.put("Dob", dob);
//					stu.put("Email",email);
//					stu.put("Address",address);
//					stu.put("YearOfJoin",year);
					hm.put("admin"+hm.entrySet().size()+1,admin);
					//System.out.println("Are you want to add Admin ? \n 1.Yes\n 2.No");
					//c=sc.nextInt();
					
				//}
				FileOutputStream fout12 = new FileOutputStream("D:/III Year Project/DSAProject/AdminDetails.txt");
				ObjectOutputStream out12 = new ObjectOutputStream(fout12);
				out12.writeObject(hm);
				out12.close();
				fout12.close();
				return true;
	}
	public static LinkedHashMap<String,String> getAdminRec(String userID) throws FileNotFoundException, ClassNotFoundException
	{
		TreeMap<String,LinkedHashMap<String,String>> hm = null;
		FileInputStream fis = new FileInputStream("D:/III Year Project/DSAProject/AdminDetails.txt");
		try {
			ObjectInputStream ois = new ObjectInputStream(fis);
			hm = (TreeMap<String,LinkedHashMap<String,String>>) ois.readObject();
			ois.close();
		} 
		catch (IOException e) {}
		
		if(hm==null)
			hm = new TreeMap<String,LinkedHashMap<String,String>>();
		LinkedHashMap<String,String> admin = null;
		admin = hm.get(userID);
		return admin;
		}
	public static boolean validateAdmin(String id,String pass) throws IOException, ClassNotFoundException
	{
		//file
		TreeMap<String,LinkedHashMap<String,String>> hm = null;
		//FileInputStream fis = new FileInputStream("AdminDetails.txt");
		FileInputStream fis = new FileInputStream("D:/III Year Project/DSAProject/AdminDetails.txt");
		ObjectInputStream ois = new ObjectInputStream(fis);
			hm = (TreeMap<String,LinkedHashMap<String,String>>) ois.readObject();
	     if(hm.containsKey(id))
	     {
	    	 String password = hm.get(id).get("Name").toLowerCase()+"@"+hm.get(id).get("Dob").substring(8);
	        //System.out.println(hm.get(id).get("Dob").substring(8));
	    	 if(!pass.equals(password))
	         {
	        	 //System.out.println("*****Enter a Valid Password*****");
	        	 return false;
	         }
	     }
	     else
	     {
	    	// System.out.println("*****Enter a valid UserName*****");
	    	 return false;
	     }
	     ois.close();
	     fis.close();

		return true;
	}
	
	//validating user login details
		public static boolean validateStudent(String id,String pass) throws IOException, ClassNotFoundException
		{
			TreeMap<String,String> tm=null;
			FileInputStream fin = new FileInputStream("D:/III Year Project/DSAProject/StudentPasswords.txt");
			try {
			ObjectInputStream ois = new ObjectInputStream(fin);
			 tm= (TreeMap<String, String>)ois.readObject();
			 ois.close();
			}
			catch(Exception e) {}
			if(tm==null)
			{
				return false;
			}if(tm.containsKey(id))
			{
				 if(!tm.get(id).equals(pass))
				 {
					 //System.out.println("***** Enter a valid password *****");
					 return false;
				 }
				 
			}
			else
			{
				//System.out.println("***** Enter a Valid UserName *****");
				return false;
			}
			
			fin.close();
			return true;
		}
//		
		public static boolean validateFaculty(String name,String pass) throws IOException, ClassNotFoundException
		{
			TreeMap<String,String> tm=null;
			FileInputStream fin = new FileInputStream("D:/III Year Project/DSAProject/FacultyPasswords.txt");
			try {
			ObjectInputStream ois = new ObjectInputStream(fin);
			 tm= (TreeMap<String, String>)ois.readObject();
			 ois.close();
			}
			catch(Exception e) {}
			if(tm==null)
			{
				//System.out.println("Insufficient Details!");
				return false;
			}
			//System.out.println(name+" "+pass);
			if(tm.containsKey(name))
			{
				 if(!tm.get(name).equals(pass))
				 {
					 //System.out.println("***** Enter a valid Password*****");
					 return false;
				 }
			}
			else
			{
				//System.out.println("***** Enter a Valid UserName *****");
				return false;
			}
			
			fin.close();
			return true;
		}
		
	public static String id_generate(TreeMap<String,LinkedHashMap<String,String>> tm)
	{
		Set<String> st = tm.keySet();
		if(tm.containsKey(st.size()+1+""))
			return st.size()+2+"";
		else
		return st.size()+1+"";
	}
	//servlet add student admin
	public static String addStudent(LinkedHashMap<String,String> student) throws ClassNotFoundException, IOException
	{
		FileInputStream fi = new FileInputStream("D:/III Year Project/DSAProject/StudentPasswords.txt");
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
		FileInputStream fis = new FileInputStream("D:/III Year Project/DSAProject/studentDetails.txt");
		try {
			ObjectInputStream ois = new ObjectInputStream(fis);
			hm = (TreeMap<String,LinkedHashMap<String,String>>) ois.readObject();
			ois.close();
		} 
		catch (IOException e) {}
		
		if(hm==null)
			hm = new TreeMap<String,LinkedHashMap<String,String>>();
		LinkedHashMap<String,String> stu = new LinkedHashMap<String,String>();
		stu.put("stu_name", student.get("stu_name"));
		stu.put("stu_email", student.get("stu_email"));
		stu.put("year",student.get("year"));
		stu.put("degree",student.get("degree"));
		stu.put("department", student.get("department"));
		stu.put("dob", student.get("dob"));
		stu.put("address",student.get("address"));
		stu.put("mobileNum", student.get("mobileNum"));
		stu.put("bloodgroup",student.get("bloodgroup"));
		String id = Admin.id_generate(hm);
		String stu_id = student.get("stu_name").toLowerCase()+"@"+id;
		tm.put(id,stu_id);
		hm.put(id,stu);
		FileOutputStream fout1 = new FileOutputStream("D:/III Year Project/DSAProject/studentDetails.txt");
		ObjectOutputStream out1 = new ObjectOutputStream(fout1);
		out1.writeObject(hm);
		out1.close();
		fout1.close();
		//update passwords
		FileOutputStream fout = new FileOutputStream("D:/III Year Project/DSAProject/StudentPasswords.txt");
		 ObjectOutputStream oos = new ObjectOutputStream(fout);
		 oos.writeObject(tm);
		 oos.close();
		 fout.close();
		 return stu_id;
	}
	public static boolean addStudent(StudentInfo student) throws ClassNotFoundException, IOException
	{
		//update password
		FileInputStream fi = new FileInputStream("D:/III Year Project/DSAProject/StudentPasswords.txt");
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
		FileInputStream fis = new FileInputStream("D:/III Year Project/DSAProject/studentDetails.txt");
		try {
			ObjectInputStream ois = new ObjectInputStream(fis);
			hm = (TreeMap<String,LinkedHashMap<String,String>>) ois.readObject();
			ois.close();
		} 
		catch (IOException e) {}
		
		if(hm==null)
			hm = new TreeMap<String,LinkedHashMap<String,String>>();
		LinkedHashMap<String,String> stu = new LinkedHashMap<String,String>();
		stu.put("stu_name", student.getStu_name());
		stu.put("stu_email", student.getStu_email());
		stu.put("year",student.getYear());
		stu.put("degree",student.getDegree());
		stu.put("department", student.getDepartment());
		stu.put("dob", student.getDob());
		stu.put("address",student.getAddress());
		stu.put("mobileNum", student.getMobileNum());
		stu.put("bloodgroup",student.getBloodgroup());
		String id = Admin.id_generate(hm);
		tm.put(id,student.getStu_name().toLowerCase()+"@"+id);
		hm.put(id,stu);
		FileOutputStream fout1 = new FileOutputStream("D:/III Year Project/DSAProject/studentDetails.txt");
		ObjectOutputStream out1 = new ObjectOutputStream(fout1);
		out1.writeObject(hm);
		out1.close();
		fout1.close();
		//update passwords
		FileOutputStream fout = new FileOutputStream("D:/III Year Project/DSAProject/StudentPasswords.txt");
		 ObjectOutputStream oos = new ObjectOutputStream(fout);
		 oos.writeObject(tm);
		 oos.close();
		 fout.close();
		 return true;
	}
	public static boolean  removeStudent(String id) throws IOException, ClassNotFoundException
	{
		File f = new File("D:/III Year Project/DSAProject/studentDetails.txt");
		FileInputStream fis = new FileInputStream(f);
		ObjectInputStream ois = new ObjectInputStream(fis);
		TreeMap<String,LinkedHashMap<String,String>> tm = (TreeMap<String, LinkedHashMap<String, String>>) ois.readObject();
	    tm.remove(id);
	    ois.close();
		   fis.close();
		   FileOutputStream fout1 = new FileOutputStream("D:/III Year Project/DSAProject/studentDetails.txt");
			ObjectOutputStream out1 = new ObjectOutputStream(fout1);
			out1.writeObject(tm);
			out1.close();
			fout1.close();
			return true;
	}

	public static boolean  removeFaculty(String id) throws IOException, ClassNotFoundException
	{
		File f = new File("D:/III Year Project/DSAProject/FacultyDetails.txt");
		FileInputStream fis = new FileInputStream(f);
		ObjectInputStream ois = new ObjectInputStream(fis);
		TreeMap<String,LinkedHashMap<String,String>> tm = (TreeMap<String, LinkedHashMap<String, String>>) ois.readObject();
	    tm.remove(id);
	    ois.close();
		   fis.close();
		   FileOutputStream fout1 = new FileOutputStream("D:/III Year Project/DSAProject/FacultyDetails.txt");
			ObjectOutputStream out1 = new ObjectOutputStream(fout1);
			out1.writeObject(tm);
			out1.close();
			fout1.close();
			return true;
	}

	
	public static boolean search(TreeMap<String,LinkedHashMap<String,String>> li) throws IOException, ClassNotFoundException
	{
	   if(li==null) {
		   //System.out.println("Details are not sufficient!");
		   return false;
	   }
	   else  
		{
			System.out.println("Enter the Student Id:");
		   Scanner sc = new Scanner(System.in);
		   String id = sc.next();
		   if(li.containsKey(id))
		   {
			  System.out.println("Details of "+id+" :");
			  for(Map.Entry e: li.get(id).entrySet())
			  {
				  System.out.println(e.getKey()+": "+e.getValue());
			  }
			  return true;
		   }
		   else
		   {
			   return false;
		   }
	}
		   
	}

	public static String id_create(TreeMap<String,LinkedHashMap<String,String>> tm)
	{
		if(tm==null)
			return "c01";
		Set<String> st = tm.keySet();
		return "c"+st.size()+1+"";
	}
	public static String addFaculty(LinkedHashMap<String,String> faculty) throws ClassNotFoundException, IOException
	{
		FileInputStream fi = new FileInputStream("D:/III Year Project/DSAProject/FacultyPasswords.txt");
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
		FileInputStream fis = new FileInputStream("D:/III Year Project/DSAProject/FacultyDetails.txt");
		try {
			ObjectInputStream ois = new ObjectInputStream(fis);
			hm = (TreeMap<String,LinkedHashMap<String,String>>) ois.readObject();
			ois.close();
		} 
		catch (IOException e) {}
		if(hm==null)
			hm = new TreeMap<String,LinkedHashMap<String,String>>();
		String id = Admin.id_create(hm);
		String user_id = faculty.get("f_name").toLowerCase()+"@"+id;
		tm.put(id,user_id);
		hm.put(id,faculty);
		
	
	
	FileOutputStream fout1 = new FileOutputStream("D:/III Year Project/DSAProject/FacultyDetails.txt");
	ObjectOutputStream out1 = new ObjectOutputStream(fout1);
	out1.writeObject(hm);
	out1.close();
	fout1.close();
	//update passwords
	FileOutputStream fout = new FileOutputStream("D:/III Year Project/DSAProject/FacultyPasswords.txt");
	 ObjectOutputStream oos = new ObjectOutputStream(fout);
	 oos.writeObject(tm);
	 oos.close();
	 fout.close();
	 return user_id;
		
	}
	public static boolean addFaculty(FacultyInfo faculty) throws ClassNotFoundException, IOException
	{
		//update password
		FileInputStream fi = new FileInputStream("D:/III Year Project/DSAProject/FacultyPasswords.txt");
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
		FileInputStream fis = new FileInputStream("D:/III Year Project/DSAProject/FacultyDetails.txt");
		try {
			ObjectInputStream ois = new ObjectInputStream(fis);
			hm = (TreeMap<String,LinkedHashMap<String,String>>) ois.readObject();
			ois.close();
		} 
		catch (IOException e) {}
		
		if(hm==null)
			hm = new TreeMap<String,LinkedHashMap<String,String>>();
		 //System.out.println("(Name,Email,Dob,Address,Bloodgroup,CourseHandling,YearOfJoining,Degree)");
			LinkedHashMap<String,String> fac = new LinkedHashMap<String,String>();
			fac.put("f_name",faculty.getF_name());
			fac.put("f_email", faculty.getF_email());
			fac.put("dob", faculty.getDob());
			fac.put("address",faculty.getAddress());
			fac.put("bloodgroup", faculty.getBloodgroup());
			fac.put("designation", faculty.getDesignation());
			fac.put("course",faculty.getCourse());
			fac.put("yearJoin",faculty.getYearJoin());
			fac.put("mobileNum", faculty.getMobileNum());
			String id = Admin.id_create(hm);
			tm.put(id,faculty.getF_name().toLowerCase()+"@"+id);
			hm.put(id,fac);
			
		
		
		FileOutputStream fout1 = new FileOutputStream("D:/III Year Project/DSAProject/FacultyDetails.txt");
		ObjectOutputStream out1 = new ObjectOutputStream(fout1);
		out1.writeObject(hm);
		out1.close();
		fout1.close();
		//update passwords
		FileOutputStream fout = new FileOutputStream("D:/III Year Project/DSAProject/FacultyPasswords.txt");
		 ObjectOutputStream oos = new ObjectOutputStream(fout);
		 oos.writeObject(tm);
		 oos.close();
		 fout.close();
		 return true;
	}
	public static boolean editFaculty(String faculty_id,LinkedHashMap<String,String> faculty) throws ClassNotFoundException, IOException
	{
		TreeMap<String,LinkedHashMap<String,String>> hm = null;
		FileInputStream fis = new FileInputStream("D:/III Year Project/DSAProject/FacultyDetails.txt");
		try {
			ObjectInputStream ois = new ObjectInputStream(fis);
			hm = (TreeMap<String,LinkedHashMap<String,String>>) ois.readObject();
			ois.close();
		} 
		catch (IOException e) {}
		if(hm==null)
			hm = new TreeMap<String,LinkedHashMap<String,String>>();
		
		hm.put(faculty_id, faculty);
		FileOutputStream fout1 = new FileOutputStream("D:/III Year Project/DSAProject/FacultyDetails.txt");
		ObjectOutputStream out1 = new ObjectOutputStream(fout1);
		out1.writeObject(hm);
		out1.close();
		fout1.close();
		
		return true;
	}
	{
		
	}
	
//	public static void displayPassword() throws IOException, ClassNotFoundException
//	{
//		FileInputStream fin = new FileInputStream("Passwords.txt");
//		ObjectInputStream ois = new ObjectInputStream(fin);
//		TreeMap<String,String> tm = (TreeMap<String, String>) ois.readObject();
//		for(Map.Entry e:tm.entrySet())
//		{
//			System.out.println("Username: "+e.getKey()+"  password : "+e.getValue());
//		}
//	}
	
	//update the password of admin
//	public static void updatePass() throws IOException
//	{
//		TreeMap<String,String> tm =null;
//		FileInputStream fin = new FileInputStream("Passwords.txt");
//		ObjectInputStream ois = new ObjectInputStream(fin);
//		 try {
//			tm = (TreeMap<String, String>) ois.readObject();
//		} catch ( IOException | ClassNotFoundException e) {
//		}
//		 if(tm==null)
//		   tm = new TreeMap<String,String>();
//		 tm.put("admin","admin@101");
//		 FileOutputStream fout = new FileOutputStream("Passwords.txt");
//		 ObjectOutputStream oos = new ObjectOutputStream(fout);
//		 oos.writeObject(tm);
//		 oos.close();
//		 fout.close();
//		 
//	}
//	
//	
//	public static void main(String[] args) throws IOException, ClassNotFoundException {
//        //Admin.updatePass();
//		//Admin.addAdmin();
//		TreeMap<String,LinkedHashMap<String,String>> hm = null;
//		FileInputStream fis = new FileInputStream("AdminDetails.txt");
//		try {
//			ObjectInputStream ois = new ObjectInputStream(fis);
//			hm = (TreeMap<String,LinkedHashMap<String,String>>) ois.readObject();
//			ois.close();
//		} 
//		catch (IOException e) {}
//		
//		if(hm==null)
//			hm = new TreeMap<String,LinkedHashMap<String,String>>();
//		System.out.println(hm);
// }	
//}
}
