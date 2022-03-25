import java.io.*; 
import java.util.*; 
/* Removing the Unreleased resource stream vulnerability on the resources 
FileWriter and PrintWriter objects by closing them in the finally block */ 
/* Need to handle the IOException generated by the close() methods */ 
 
class fileWriter2 { 
	 public static void safeClose(FileWriter fw){ 
		 try{ 
			fw.close(); 
		 } 
		 catch(IOException e){ 
		
			System.out.println("Error in closing file writer..."); 
		 } 
	 } 
	 public static void main(String[ ] args){ 
	 
		 FileWriter fw = null; 
		 PrintWriter pw = null; 
		 try{ 
			 fw = new FileWriter(args[0]); 
			 pw = new PrintWriter(fw); 
			 BufferedReader br = new BufferedReader(new 
			InputStreamReader(System.in)); 
			 for (int lineNum = 1; lineNum <=5; lineNum++){ 
				 System.out.print("Enter line # "+lineNum+" : "); 
				 String line = br.readLine( ); 
				 pw.println(line); 
			 } 
			 
			 pw.close( ); 
			 fw.close( ); 
		 
		 } 
		 catch(Exception ie){ 
		 //ie.printStackTrace( ); 
			System.out.println("Error occurred.."); 
		 } 
		 finally{ 
			 if (fw != null) 
				safeClose(fw); 
			 if (pw != null) 
				pw.close(); 
		 } 
	 } 
 
}