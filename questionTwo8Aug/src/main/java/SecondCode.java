import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SecondCode {

	public static void main(String[] args) throws Exception{
		
		 Class.forName("com.mysql.cj.jdbc.Driver");
		 Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/kr", "root", "root");
		 
		 Scanner sc = new Scanner(System.in);
		 
		 while(true) {
		
			 System.out.println("Press 1 to insert row...");
			 System.out.println("Press any other key to exit..");
			 int ch = sc.nextInt();
			 
			 switch(ch) {
		
				case 1:
					
				 int Rollno = 0;
				 String Roll;
				 boolean checkRoll;
				 
					 do {
						 System.out.print("Enter the Roll No. : ");
						 Rollno = sc.nextInt();
					 
						 Roll = String.valueOf(Rollno);
					     checkRoll = false;
					     
						  if(Roll.length()==4) {
							  Rollno = Integer.parseInt(Roll);
							  checkRoll = true;
						  }
						  else {
							  System.out.println("Not a 4 digit RollNo.");
							  checkRoll = false;
						  	}
					 }while(!checkRoll);
		  
				 String Studentname="";
				 boolean nameFlag;
				 sc.nextLine();		//buffer because string is taken user input after integer.
				 
				  	do {
						  
						  System.out.print("Enter the Name : ");
						  Studentname = sc.nextLine();
						  
						  nameFlag = false;
						  String name = Studentname.toUpperCase();
						  if(Studentname.equals(name) && Studentname.length()<=20) {
							  nameFlag = true;
						  }
						  else {
							  System.out.println("Please enter the name in upper case or length of name should be less than 20!!");
							  System.out.println();
							  nameFlag = false;
						  }
				  	}while(!nameFlag);

					  String Standard = "";
					  List<String> list = new ArrayList<String>();
					  
					  list.add("I");
					  list.add("II");
					  list.add("III");
					  list.add("IV");
					  list.add("V");
					  list.add("VI");
					  list.add("VII");
					  list.add("VIII");
					  list.add("IX");
					  list.add("X");
		  
					  boolean standard;
					  
					  do {
							System.out.print("Enter Standard of the Student : ");
							Standard = sc.nextLine();
							
							standard = false;
							if(list.contains(Standard)) {
								standard = true;
							}
							else {
								System.out.println("Standard Not exists in the List...Try Again!!");
								System.out.println();
								standard = false;
							}
						} while (!standard);
		   
					  System.out.print("Enter Date of Birth : ");
					  String Data_of_Birth = sc.nextLine();
		  
					  System.out.print("Enter fees of the student : ");
					  double fees = sc.nextDouble();
						
					String query = "insert into stdnt values(?, ?, ?, ?, ?)";
					PreparedStatement ps=con.prepareStatement(query);
			
						ps.setInt(1, Rollno);
						ps.setString(2, Studentname);
						ps.setString(3, Standard);
						ps.setDouble(4, fees);
						ps.setString(5, Data_of_Birth);

						
					ps.executeUpdate();
					System.out.println("Student registered successfully...");
					System.out.println();
					break;
			
				default:
				 System.out.println("Exited Successfully");
				 System.exit(0);
			 }	
		 }
	}
	
}