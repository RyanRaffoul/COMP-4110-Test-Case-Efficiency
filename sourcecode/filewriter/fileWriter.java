import java.io.*; 
 
class fileWriter { 
 
	 public static String main(String[ ] args, String[ ] lines) throws IOException{ 
	 
		 try{ 
			 FileWriter fw = new FileWriter(args[0]); 
			 PrintWriter pw = new PrintWriter(fw); 
			 BufferedReader br = new BufferedReader(new InputStreamReader( 
			System.in)); 
			 
			 for (int lineNum = 1; lineNum <=5; lineNum++){ 
				 System.out.print("Enter line # "+lineNum+" : "); 
				 String line = lines[lineNum]; 
				 pw.println(line); 
				 
			 } 
			 
			 pw.close( ); 
			 fw.close( ); 
			 return "file was created";
		 
		 } 
		 catch(IOException ie){ 
			ie.printStackTrace( ); 
			return "file not created";
		 } 
	 } 
	 
}
