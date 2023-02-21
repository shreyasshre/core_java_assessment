package company_lockers;

import java.util.*;
import java.io.*;

public class file_tracer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s=new Scanner(System.in);
		int main_option;
		char sub_option;
		String folder_path;
		ArrayList<String> b=new ArrayList<String>();
		boolean outerloop=true,innerloop=true;
		
		System.out.println("A COMPANY LOCKERS PORTAL BY SHREYAS");
		
		while(outerloop==true)
		{
			System.out.println("\n******************************************************************");
			System.out.println("Please select below options for the corresponding operations \n");
			System.out.println("Option 1 : Retrieve all the files from a directory");
			System.out.println("Option 2 : Display additional file operations");
			System.out.println("Option 3 : Close the application \n");
			System.out.println("******************************************************************\n");
			main_option=s.nextInt();
			
			switch (main_option) {
			case 1: {
			System.out.println("Enter the folder path u wish to retrieve all the files");
			folder_path=s.next();
			File obj=new File(folder_path);
			File a[]=obj.listFiles();
			for(int j=0;j<a.length;j++) {
			b.add(a[j].getName());
			}
			Collections.sort(b);
			System.out.println("\n------------------------------------------------------------------------------\n");
			System.out.println("\n BELOW ARE THE FILES IN THE REQUESTED DIRECTORY AND SORTED IN ASCENDING ORDER \n");
			for(int i=0;i<a.length;i++)	
				System.out.println(b.get(i));
			System.out.println("\n------------------------------------------------------------------------------\n");
			
			}break;
			case 2:{
				while(innerloop==true) {
				System.out.println("\n*************************************************************************\n");
				System.out.println("Below are the additional file operations, please select the option to proceed");
				System.out.println("Option A : Add a file in the current directory");
				System.out.println("Option B : Delete a specified file (case sensitive)");
				System.out.println("Option C : Search a specified file from current directory");
				System.out.println("Option D : Switch to main menu");
				System.out.println("\n*************************************************************************\n");
				
				sub_option = s.next().charAt(0);
				
				switch (sub_option) {
				case 'A': {
				System.out.println("adding a file to directory");
				try {
					System.out.println("Please input the file name u wish to add");
					String file_name=s.next();
					File myobj=new File(file_name);
					if(myobj.createNewFile()) {
						//System.out.println("file "+file_name+" created successfully");	
						System.out.println("Type in a single word content u wish to write to the file");
						String file_content=s.next();
						BufferedWriter out = new BufferedWriter(new FileWriter(file_name+".txt"));
						out.write(file_content);
						out.close();
						
//						
					}
					else {
						System.out.println("file already exists\n\n");
					}	
				} catch (IOException e) 
				{
					System.out.println("the file name u tried already exits please try with a different file name");
				}
				}break;
				
				case 'B': {
					System.out.println("deleting a file");
					System.out.println("Enter the file name with the path u want to delete");
					String delete_file_path=s.next();
					File f=new File(delete_file_path);
					if(f.delete()) {
						System.out.println("File "+delete_file_path+" successfully deleted");
					}
					else {
						System.out.println("please recheck if the file exists to delete");
					}
				}break;
				case 'C': {
					System.out.println("searching for a file");
					System.out.println("Please input the file name u wish to search with path");
					String file_name=s.next();
					File myobj=new File(file_name);
					if(myobj.exists()) {
						System.out.println("The file exists in the current directory");
					}
					else {
						System.out.println("The file does not exist");
					}
					
				}break;
				case 'D': {
					System.out.println("navigating to main menu");
					innerloop=false;
				}break;
				
				default:
					throw new IllegalArgumentException("PLEASE SELECT AN APPROPRIATE OPTION");
				}
			
			}}break;
			
			
			case 3:{
				System.out.println("Your application is closed");
				outerloop=false;
				
			}break;
			
			
			default:
				throw new IllegalArgumentException("please enter a valid option");
			}
			
			
		}
		s.close();
	}

}
