import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;

public class passwdAuth {

	static int integer = 0;
	
	public static String main(String[] args) {
		try { 
			 String logFileName = args[0];
			 int checkFile = logFileName.lastIndexOf('.');
			 if(checkFile == -1) {
				 throw new Exception("Incorrect File Format");
			 }
			 File f = new File(logFileName); 
			 boolean access_granted = false; 
			 String password = ""; 
			 integer = 10;
		 
			 if(args.length == 2){ 
				 password = password + args[1]; // Comment for Empty Password Initialization Vulnerability 
				 System.out.println("Checking command-line password"); 
				 String password1 = "3dTAqb.7";
				 if (password.equals(password1)){
					 access_granted = true;
					 System.out.println("Password matches.");
				 }else{
					 System.out.println("Command-line password does not match");
					 return ("Command-line password does not match");
				 } 
			 }else{
				 throw new Exception("Incorrect Arguments Given");
			 }
		 
			 if(access_granted){ 
				 System.out.println("Access granted!"); 
				 PrintWriter out = new PrintWriter(new 
				 FileOutputStream(f, true)); 
				 out.println(); 
				 out.print("Updated..."); 
				 out.println(); 
				 out.flush(); 
				 out.close(); 
				 return ("Password matches. Access granted! Updated...");
			 }//end if 
	 
		}catch (Exception e) { 
			System.out.println("an error has occured.");
			e.printStackTrace();
		}
		return ("Sucess!");
	}
	
	public static int getInteger() {
		return integer;
	}
}
