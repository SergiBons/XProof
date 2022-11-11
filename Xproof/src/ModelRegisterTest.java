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
	//Checks if name is correct
	//(Max Size(19) and Min size(2))
	@Test
	void testCheckNameRestrictions() {
		ModelRegister Reg = new ModelRegister("User1","PASSWD1");
		assertEquals(Reg.CheckNameRestrictions(),"CORRECT");
		
		
		ModelRegister Reg1 = new ModelRegister("U","PASSWD1");
		assertEquals(Reg1.CheckNameRestrictions(),"NAME TOO SHORT");
		
		ModelRegister Reg2 = new ModelRegister("ThisNameIsClearlyTooLongForAUsernameAndWeCanAllAgreeOnThat","PASSWD1");
		assertEquals(Reg2.CheckNameRestrictions(),"NAME TOO LONG");
		
		}
	//Checks if password is correct
	//and Min size(5)
	@Test
	void testCheckPasswdRestrictions() {
		ModelRegister Reg = new ModelRegister("User1","PASSWD1");
		assertEquals(Reg.CheckPasswdRestrictions(),"CORRECT");
		
		
		ModelRegister Reg1 = new ModelRegister("User1","1");
		assertEquals(Reg1.CheckPasswdRestrictions(),"PASSWD TOO SHORT");
		
		}
	//Creates new file associated with user info in DB
	//returns error value, if error found, else returns "CORRECT"
	@Test
	void testRegisterNewUser() {
		ModelRegister Reg = new ModelRegister("User10","PASSWD10");
		Reg.DeleteRegisteredUser();
		String CE = Reg.RegisterNewUser();
		File f = new File("C:\\Users\\Usuario\\eclipse-workspace\\Xproof\\Materials\\BD\\Users\\"+Reg.UName+".txt");
		
		assertEquals(true, f.exists());
		assertEquals("CORRECT", CE);
		try {
			Scanner S = new Scanner(f);
			String data = S.nextLine();
			S.close();
			assertEquals(data,"PASSWD10");
			}
		catch(FileNotFoundException e) {
			System.out.println("Error amb el fitxer");
		}
		
		Reg.DeleteRegisteredUser();
	
		}
	//Deletes file associated with user info in DB
	//returns error value, if error found, else returns "CORRECT"
	@Test
	void testDeleteRegisteredUser() {
		ModelRegister Reg = new ModelRegister("User10","PASSWD10");
		Reg.RegisterNewUser();
		boolean CE = Reg.DeleteRegisteredUser();
		File f = new File("C:\\Users\\Usuario\\eclipse-workspace\\Xproof\\Materials\\BD\\Users\\"+Reg.UName+".txt");
		assertEquals(false, f.exists());
		assertEquals(true, CE);
		
		ModelRegister Reg1 = new ModelRegister("User15","PASSWD15");
		boolean CE1 = Reg1.DeleteRegisteredUser();
		File f1 = new File("C:\\Users\\Usuario\\eclipse-workspace\\Xproof\\Materials\\BD\\Users\\"+Reg1.UName+".txt");
		assertEquals(false, f1.exists());
		assertEquals(false, CE1);
	}
	
	
}
