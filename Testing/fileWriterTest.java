import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/*
 * Unit Testing for FileWriter.java
 * 
 */

class fileWriterTest {
	// equivalence partitioning
	/*
	 * if file is created(bug)
	 */
	@Test
	public void testResourceStreamVulnerability() {
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
	public void testInvalidFileChar() {
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
	public void testInvalidFileFormat() {
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
	public void testInvalidFileEmpty() {
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
	public void testInvalidFileNull() {
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
	public void testOneLineEempty() {
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
	public void testAllLinesEmpty() {
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
	public void testOneLineNull() {
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
	public void testAllLineslNull() {
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
	public void testFile2Args() {
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
	public void testFileNoArgs() {
		//standard case to see if file is created
		fileWriter fw = new fileWriter();
		String[] args = {};
		String[] lines = {"1","2","3","4","5"};
		String res = fw.main(args, lines);
		
		assertEquals("file not created", res);
	}
	/*
	 *  lines - no args
	 */
	@Test
	public void testLinesNoArgs() {
		//standard case to see if file is created
		fileWriter fw = new fileWriter();
		String[] args = {"file1.txt"};
		String[] lines = {};
		String res = fw.main(args, lines);
		
		assertEquals("file not created", res);
	}
	/*
	 *  lines - 1 args
	 */
	@Test
	public void testLines1Args() {
		//standard case to see if file is created
		fileWriter fw = new fileWriter();
		String[] args = {"file1.txt"};
		String[] lines = {"1"};
		String res = fw.main(args, lines);
		
		assertEquals("file not created", res);
	}
	/*
	 * lines - 4 args
	 */
	@Test
	public void testLines4Args() {
		//standard case to see if file is created
		fileWriter fw = new fileWriter();
		String[] args = {"file1.txt"};
		String[] lines = {"1","2","3","4"};
		String res = fw.main(args, lines);
		
		assertEquals("file not created", res);
	}
	/*
	 *  lines - 6 args
	 */
	@Test
	public void testLines6Args() {
		//standard case to see if file is created
		fileWriter fw = new fileWriter();
		String[] args = {"file1.txt"};
		String[] lines = {"1","2","3","4","5","6"};
		String res = fw.main(args, lines);
		
		assertEquals("file was created", res);
	}

}
