import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import org.junit.jupiter.api.Test;

/*
 * Unit Testing for FileWriter.java
 * 
 */

class fileWriterTest {
	
	// equivalence partitioning
	/*
	 * if file is created(missed bug)
	 */
	@Test
	public void testResourceStreamVulnerability() throws IOException {
		//standard case to see if file is created
		fileWriter fw = new fileWriter();
		String[] args = {"file.txt"};
		String[] lines = {"1","2","3","4","5"};
		String res = fw.main(args, lines);
		
		assertEquals("file was created", res);
	}
	
	/*
	 * invalid character (bug)
	 */
	@Test
	public void testInvalidFileChar() throws IOException {
		//standard case to see if file is created
		fileWriter fw = new fileWriter();
		String[] args = {"fi., le.txt"};
		String[] lines = {"1","2","3","4","5"};
		String res = fw.main(args, lines);
		
		assertEquals("file not created", res);
	}
	
	/*
	 * invalid file format (bug)
	 */
	@Test
	public void testInvalidFileFormat() throws IOException {
		//standard case to see if file is created
		fileWriter fw = new fileWriter();
		String[] args = {"file.jpeg"};
		String[] lines = {"1","2","3","4","5"};
		String res = fw.main(args, lines);
		
		assertEquals("file not created", res);
	}
	
	/*
	 * empty string file name (bug)
	 */
	@Test
	public void testInvalidFileEmpty() throws IOException {
		//see if file is created
		fileWriter fw = new fileWriter();
		String[] args = {""};
		String[] lines = {"1","2","3","4","5"};
		String res = fw.main(args, lines);
		
		assertEquals("file not created", res);
	}
	
	/*
	 * null file name (bug)
	 */
	@Test
	public void testInvalidFileNull() throws IOException {
		//standard case to see if file is created
		fileWriter fw = new fileWriter();
		String[] args = {null};
		String[] lines = {"1","2","3","4","5"};
		String res = fw.main(args, lines);
		
		assertEquals("file not created", res);
	}
	
	/*
	 *  1 empty line (bug)
	 */
	@Test
	public void testOneLineEempty() throws IOException {
		//standard case to see if file is created
		fileWriter fw = new fileWriter();
		String[] args = {"file.txt"};
		String[] lines = {"","2","3","4","5"};
		String res = fw.main(args, lines);
		
		assertEquals("file was created", res);
	}
	
	/*
	 *  all empty lines (bug)
	 */
	@Test
	public void testAllLinesEmpty() throws IOException {
		//standard case to see if file is created
		fileWriter fw = new fileWriter();
		String[] args = {"file.txt"};
		String[] lines = {"","","","",""};
		String res = fw.main(args, lines);
		
		assertEquals("file was created", res);
	}
	
	/*
	 *  1 null line (bug)
	 */
	@Test
	public void testOneLineNull() throws IOException {
		//standard case to see if file is created
		fileWriter fw = new fileWriter();
		String[] args = {"file.txt"};
		String[] lines = {"1","2",null,"4","5"};
		String res = fw.main(args, lines);
		
		assertEquals("file not created", res);
	}
	
	/*
	 *  all null lines (bug)
	 */
	@Test
	public void testAllLineslNull() throws IOException {
		//standard case to see if file is created
		fileWriter fw = new fileWriter();
		String[] args = {"file.txt"};
		String[] lines = {null,null,null,null,null};
		String res = fw.main(args, lines);
		
		assertEquals("file not created", res);
	}
	
	// boundary testing
	/*
	 *  file - 2 args
	 */
	@Test
	public void testFile2Args() throws IOException {
		//standard case to see if file is created
		fileWriter fw = new fileWriter();
		String[] args = {"file1.txt","file2.txt"};
		String[] lines = {"1","2","3","4","5"};
		String res = fw.main(args, lines);
		
		assertEquals("file was created", res);
	}
	
	/*
	 * file - no args
	 */
	@Test
	public void testFileNoArgs() throws IOException {
		//standard case to see if file is created
		fileWriter fw = new fileWriter();
		String[] args = {};
		String[] lines = {"1","2","3","4","5"};
		String res = fw.main(args, lines);
		
		assertEquals("file not created", res);
	}

}
