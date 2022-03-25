import java.io.*; 
 
class fileWriter { 
 
	 public static void main(String[ ] args) throws IOException{ 
	 
		 try{ 
			 FileWriter fw = new FileWriter(args[0]); 
			 PrintWriter pw = new PrintWriter(fw); 
			 BufferedReader br = new BufferedReader(new InputStreamReader( 
			System.in)); 
			 
			 for (int lineNum = 1; lineNum <=5; lineNum++){ 
				 System.out.print("Enter line # "+lineNum+" : "); 
				 String line = br.readLine( ); 
				 pw.println(line); 
			 } 
			 
			 pw.close( ); 
			 fw.close( ); 
		 
		 } 
		 catch(IOException ie){ 
			ie.printStackTrace( ); 
		 } 
	 } 
	 
}
