import java.io.*; 
import java.util.*; 
 
class fileWriter4 { 
	 public static void safeClose(FileWriter fw){ 
		 try{ 
			fw.close(); 
		 } 
		 catch(IOException e){ 
			System.out.println("Error in closing file writer..."); 
		 } 
	 } 
	 
	 public static void main(String[ ] args) throws IOException{ 
	 
		 FileWriter fw = null; 
		 PrintWriter pw = null; 
		 try{ 
			 Scanner inputScanner = new Scanner(System.in); 
			 String fileName = inputScanner.next(); 
			 fw = new FileWriter(fileName); 
			 pw = new PrintWriter(fw); 
			 Scanner lineReader = new Scanner(System.in); 
			 for (int lineNum = 1; lineNum <=5; lineNum++){ 
				 System.out.print("Enter line # "+lineNum+" : "); 
				 String line = lineReader.nextLine( ); 
				 pw.println(line); 
			 } 
			 
			 pw.close( ); 
			 fw.close( ); 
		 
		 } 
		 catch(IOException ie){ 
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