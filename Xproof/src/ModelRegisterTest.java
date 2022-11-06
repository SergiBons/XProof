import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import org.junit.jupiter.api.Test;

class ModelRegisterTest {

	@Test
	void testConstructorModelRegister() {
		ModelRegister Reg = new ModelRegister("User10","PASSWD10");
		assertEquals("User10",Reg.UName);
		assertEquals("PASSWD10",Reg.UPasswd);
		}
	
	@Test
	void testCheckIfNameAlreadyExists() {
		ModelRegister Reg = new ModelRegister("User1","PASSWD1");
		assertEquals(Reg.CheckIfNameAlreadyExists(),true);
		ModelRegister Reg1 = new ModelRegister("User10","PASSWD10");
		assertEquals(Reg1.CheckIfNameAlreadyExists(),false);
		}
	
	@Test
	void testCheckNameRestrictions() {
		ModelRegister Reg = new ModelRegister("User1","PASSWD1");
		assertEquals(Reg.CheckNameRestrictions(),"CORRECT");
		
		
		ModelRegister Reg1 = new ModelRegister("U","PASSWD1");
		assertEquals(Reg1.CheckNameRestrictions(),"NAME TOO SHORT");
		
		ModelRegister Reg2 = new ModelRegister("ThisNameIsClearlyTooLongForAUsernameAndWeCanAllAgreeOnThat","PASSWD1");
		assertEquals(Reg2.CheckNameRestrictions(),"NAME TOO LONG");
		
		}
	
	@Test
	void testCheckPasswdRestrictions() {
		ModelRegister Reg = new ModelRegister("User1","PASSWD1");
		assertEquals(Reg.CheckPasswdRestrictions(),"CORRECT");
		
		
		ModelRegister Reg1 = new ModelRegister("User1","1");
		assertEquals(Reg1.CheckPasswdRestrictions(),"PASSWD TOO SHORT");
		
		}
	
	@Test
	void testRegisterNewUser() {
		ModelRegister Reg = new ModelRegister("User10","PASSWD10");
		String CE = Reg.RegisterNewUser();
		File f = new File("C:\\Users\\Usuario\\eclipse-workspace\\Xproof\\Materials\\BD\\Users\\"+Reg.UName+".txt");
		
		assertEquals(true, f.exists());
		assertEquals("CORRECT", CE);
		try {
			Scanner R = new Scanner(f);
			if (R.hasNextLine()) {
				String data = R.nextLine();
				assertEquals(data,"PASSWD10");
				}
			}
		catch(FileNotFoundException e) {
			System.out.println("Error amb el fitxer");
		}
		
		f.delete();
		}
	
	
}
