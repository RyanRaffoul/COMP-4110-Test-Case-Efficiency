import java.io.*; 
import java.util.*; 
/* Removing the Hardcoded Password Vulnerability by reading the actual 
password from a file*/ 
/* We use the Scanner class to read the contents of a file */ 
class passwdAuth5 
{ 
	 public static int Sanitize(String logFileName){ 
	 if (!logFileName.endsWith(".txt")) return -1; 
	 // attempting to write to a non-text file 
	
	if (logFileName.indexOf('/') != -1) return -1; 
	 // attempting to write to a file that is located in another directory 
		return 1; // valid file extension; file located in same directory 
	 } 
	 public static void main(String args[]) 
		 { 
		 try 
		 { 
			 boolean access_granted = false; 
			 
			 if (args.length == 1) 
			 { 
				 System.out.println("Checking command-line password"); 
				 String inputPassword = args[0]; 
				 File f = new File("passwordFile.txt"); 
				 Scanner fileScanner = new Scanner(f); 
				 String actualPassword = fileScanner.nextLine();
				 if (inputPassword.equals(actualPassword)) 
				 { 
					access_granted = true; 
					
					System.out.println("Password matches."); 
				 } 
				 else 
					 System.out.println("Command-line password does
					not match"); 
			 }//end if 
			 
			 if (access_granted) 
			 { 
				 System.out.print("Enter a name for the log file: "); 
				 Scanner inputScanner = new Scanner(System.in); 
				 String logFileName = inputScanner.next(); 
				 if (Sanitize(logFileName) == -1){ 
					 System.out.println("invalid file extension/path"); 
					 System.exit(1); 
				 } 
				 File f = new File(logFileName); 
				 
				 System.out.println("Access granted!"); 
				 PrintWriter out = new PrintWriter(new 
				 FileOutputStream(f, true)); 
				 out.println(); 
				 out.print("Updated..."); 
				 out.println(); 
				 out.flush(); 
				 out.close(); 
			 }//end if 
			 
		 }//end try 
		 catch (Exception e) 
		 { 
			System.out.println("an error has occured."); 
		 } 
	 }//end main 
}//end class
