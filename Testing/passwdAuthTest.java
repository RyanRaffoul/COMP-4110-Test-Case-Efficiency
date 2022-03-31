import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * Unit Testing for PasswdAuth
 */

class passwdAuthTest {
	
	/**
	 * Test for checking if a System Vulnerability is present (BUG)
	 */
	@Test
	public void testSystemVulnerability() {
		// give empty parameters
		passwdAuth pa = new passwdAuth();
		String[] args = {"",""};
		String res = pa.main(args);
		
		assertEquals("Command-line password does not match",res);
	}
	
	/**
	 * Test for checking if a variable was used (BUG)
	 */
	@Test
	public void testValueRead() {
		// check variable
		passwdAuth pa = new passwdAuth();
		String[] args = {"check.txt","123abc"};
		pa.main(args);
		int res = pa.getInteger();
		
		assertNotEquals(0,res);
	}
	
	/**
	 * Test for checking empty password (BUG)
	 */
	@Test
	public void testEmptyPassword() {
		// give null password
		passwdAuth pa = new passwdAuth();
		String[] args = {"check.txt",null};
		String res = pa.main(args);
		
		assertEquals(res,"Command-line password does not match");
	}
	
	/**
	 * Test for checking incorrect filename format
	 */
	@Test
	public void testFileName() {
		// give empty filename
		passwdAuth pa = new passwdAuth();
		String[] args = {"","3dTAqb.7"};
		String res = pa.main(args);
		
		assertEquals("Incorrect File Format",res);
	}
	
	/**
	 * Test for checking if password was hard coded before execution (REJECTED BUG)
	 */
	@Test
	public void testPasswordHard() {
		// check if password was hard coded
		passwdAuth pa = new passwdAuth();
		String password = pa.getPassword();
		
		assertNotEquals("3dTAqb.7", password);
	}
	
	/**
	 * Test for checking a filename extension (still should work) (REJECTED BUG)
	 */
	@Test
	public void testFileExt() {
		// give filename without extension
		passwdAuth pa = new passwdAuth();
		String[] args = {"result","3dTAqb.7"};
		String res = pa.main(args);
		
		assertNotEquals("Incorrect File Format",res);
	}
	
	/**
	 * Test for checking invalid chars in filename (MISSED BUG)
	 */
	@Test
	public void testFileChars() {
		// give invalid filename
		passwdAuth pa = new passwdAuth();
		String[] args = {"res>>>ult.txt","3dTAqb.7"};
		String res = pa.main(args);
		
		assertEquals("res>>>ult.txt (The filename, directory name, or volume label syntax is incorrect)",res);
	}
	
	/**
	 * Test for checking invalid chars in password (MISSED BUG)
	 */
	@Test
	public void testPasswordChars() {
		// give invalid password
		passwdAuth pa = new passwdAuth();
		String[] args = {"result.txt","3:dTAqb.7"};
		String res = pa.main(args);
		
		assertEquals("Command-line password does not match", res);
	}
	
	/**
	 * Test for checking invalid number of arguments
	 * BLACK BOX - EQUIVALENCE PARITIONING
	 */
	@Test
	public void testInvalidArgs() {
		// give 6 arguments
		passwdAuth pa = new passwdAuth();
		String[] args = {"result.txt","3dTAqb.7","1","2","3","4"};
		String res = pa.main(args);
		
		assertEquals("Incorrect Arguments Given", res);
	}
	
	/**
	 * Test for checking valid number of arguments
	 * BLACK BOX - EQUIVALENCE PARTITIONING
	 */
	@Test
	public void testValidArgs() {
		// give valid arguments
		passwdAuth pa = new passwdAuth();
		String[] args = {"result.txt","3dTAqb.7"};
		String res = pa.main(args);
		
		assertEquals("Password matches. Access granted! Updated...", res);
	}
	
	/**
	 * Test for checking equal passwords
	 * BLACK BOX - EQUIVALENCE PARTITIONING
	 */
	@Test
	public void testEqualPassword() {
		// give equal password
		passwdAuth pa = new passwdAuth();
		String[] args = {"result.txt","3dTAqb.7"};
		String res = pa.main(args);
		
		assertEquals("Password matches. Access granted! Updated...", res);
	}
	
	/**
	 * Test for checking not equal passwords
	 * BLACK BOX - EQUIVALENCE PARTITIONING 
	 */
	@Test
	public void testNotEqualPassword() {
		// give unequal password
		passwdAuth pa = new passwdAuth();
		String[] args = {"result.txt","3dTAqb."};
		String res = pa.main(args);
		
		assertEquals("Command-line password does not match", res);
	}
	
	/**
	 * Test for checking valid filename
	 * BLACK BOX - EQUIVALENCE PARITIONING
	 */
	@Test
	public void testValidFile() {
		// give valid filename
		passwdAuth pa = new passwdAuth();
		String[] args = {"result.txt","3dTAqb.7"};
		String res = pa.main(args);
		
		assertEquals("Password matches. Access granted! Updated...", res);
	}
	
	/**
	 * Test for checking an invalid filename (BUG)
	 * BLACK BOX - EQUIVALENCE PARITIONING 
	 */
	@Test
	public void testInvalidFile() {
		// give null filename
		passwdAuth pa = new passwdAuth();
		String[] args = {null,"3dTAqb.7"};
		String res = pa.main(args);
		
		assertEquals("Incorrect File Format", res);
	}
	
	/**
	 * Test for invalid number of arguments
	 * BLACK BOX - BOUNDARY VALUE
	 */
	@Test
	public void testArgs3() {
		// give 3 arguments
		passwdAuth pa = new passwdAuth();
		String[] args = {"result.txt","3dTAqb.7","1"};
		String res = pa.main(args);
		
		assertEquals("Incorrect Arguments Given", res);
	}
	
	/**
	 * Test for checking invalid arguments (BUG)
	 * BLACK BOX - BOUNDARY VALUE
	 */
	@Test
	public void testArgs1() {
		// give 1 argument
		passwdAuth pa = new passwdAuth();
		String[] args = {"result.txt"};
		String res = pa.main(args);
		
		assertEquals("Incorrect Arguments Given", res);
	}
	
	/**
	 * Test for checking correct number of 2 arguments
	 * BLACK BOX - BOUNDARY VALUE
	 */
	@Test
	public void testArgs2() {
		// give valid arguments
		passwdAuth pa = new passwdAuth();
		String[] args = {"result.txt","3dTAqb.7"};
		String res = pa.main(args);
		
		assertEquals("Password matches. Access granted! Updated...", res);
	}
	
	/**
	 * Test for checking 1 invalid char in filename (BUG)
	 * BLACK BOX - BOUNDARY VALUE
	 */
	@Test
	public void testCharF() {
		// give filename wrong by 1 char
		passwdAuth pa = new passwdAuth();
		String[] args = {"res>ult.txt","3dTAqb.7"};
		String res = pa.main(args);
		
		assertEquals("Incorrect File Format",res);
	}
	
	/**
	 * Test for checking 1 invalid char in password (BUG)
	 * BLACK BOX - BOUNDARY VALUE
	 */
	@Test
	public void testCharP() {
		// give password invalid by 1 char
		passwdAuth pa = new passwdAuth();
		String[] args = {"result.txt","3:dTAqb.7"};
		String res = pa.main(args);
		
		assertNotEquals("Command-line password does not match", res);
	}
	
	/**
	 * Test for valid filename and equal password
	 */
	@Test
	public void testValidFileEqualPass() {
		// give valid arguments
		passwdAuth pa = new passwdAuth();
		String[] args = {"result.txt","3dTAqb.7"};
		String res = pa.main(args);
		
		assertEquals("Password matches. Access granted! Updated...", res);
	}
	
	/**
	 * Test for checking valid filename and not equal password
	 */
	@Test
	public void testValidFileNotEqualPass() {
		// give valid arguments
		passwdAuth pa = new passwdAuth();
		String[] args = {"result.txt","3dTAqb."};
		String res = pa.main(args);
		
		assertEquals("Command-line password does not match", res);
	}
	
	/**
	 * Test for checking invalid filename and equal password
	 */
	@Test
	public void testInvalidFileEqualPass() {
		// give valid arguments
		passwdAuth pa = new passwdAuth();
		String[] args = {"result","3dTAqb.7"};
		String res = pa.main(args);
		
		assertEquals("Incorrect File Format", res);
	}
	
	/**
	 * Test for checking invalid filename and not equal password
	 */
	@Test
	public void testInvalidFileNotEqualPass() {
		// give valid arguments
		passwdAuth pa = new passwdAuth();
		String[] args = {"result","3dT:Aqb.7"};
		String res = pa.main(args);
		
		assertEquals("Incorrect File Format", res);
	}
}
