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
		
		//Equivalent partition
		//Correct
		ModelRegister Reg = new ModelRegister("User1","PASSWD1");
		assertEquals(Reg.CheckNameRestrictions(),"CORRECT");
		//Incorrect
		Reg = new ModelRegister("ThisNameIsClearlyTooLongForAUsernameAndWeCanAllAgreeOnThat","PASSWD1");
		assertEquals(Reg.CheckNameRestrictions(),"NAME TOO LONG");
		
		
		//Frontier and Limit Testing
		ModelRegister Reg1 = new ModelRegister("U","PASSWD1");
		assertEquals(Reg1.CheckNameRestrictions(),"NAME TOO SHORT");
		
		Reg1 = new ModelRegister("","PASSWD1");
		assertEquals(Reg1.CheckNameRestrictions(),"NAME TOO SHORT");
		
		Reg1 = new ModelRegister("Use","PASSWD1");
		assertEquals(Reg1.CheckNameRestrictions(),"CORRECT");
		
		Reg1 = new ModelRegister("UserNameJustLongEno","PASSWD1");
		assertEquals(Reg1.CheckNameRestrictions(),"CORRECT");
		
		Reg1 = new ModelRegister("UserNameJustLongEn","PASSWD1");
		assertEquals(Reg1.CheckNameRestrictions(),"CORRECT");
		
		Reg1 = new ModelRegister("UserNamesJustTooLong","PASSWD1");
		assertEquals(Reg1.CheckNameRestrictions(),"NAME TOO LONG");
		
		}
	//Checks if password is correct
	//and Min size(5)
	@Test
	void testCheckPasswdRestrictions() {
		//Equivalent partitions
		//correct
		ModelRegister Reg = new ModelRegister("User1","PASSWD1");
		assertEquals(Reg.CheckPasswdRestrictions(),"CORRECT");
		
		//incorrect
		ModelRegister Reg1 = new ModelRegister("User1","12");
		assertEquals(Reg1.CheckPasswdRestrictions(),"PASSWD TOO SHORT");
		
		//frontier and limit testing
		Reg = new ModelRegister("User1","12345");
		assertEquals(Reg.CheckPasswdRestrictions(),"CORRECT");
		
		Reg = new ModelRegister("User1","123456");
		assertEquals(Reg.CheckPasswdRestrictions(),"CORRECT");
		
		Reg = new ModelRegister("User1","1234");
		assertEquals(Reg.CheckPasswdRestrictions(),"PASSWD TOO SHORT");
		
		Reg = new ModelRegister("User1","");
		assertEquals(Reg.CheckPasswdRestrictions(),"PASSWD TOO SHORT");
		
		Reg = new ModelRegister("User1","THIS PASSWD.IS,REAAAAAAAAAAAAAAAAAAAAAAALLY¨LONG,ANDContainsMultîpleKindOfCharacters");
		assertEquals(Reg.CheckPasswdRestrictions(),"CORRECT");
		
		
		}
	//Creates new file associated with user info in DB
	//returns error value, if error found, else returns "CORRECT"
	//Not LoLlevel class by definition
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
	//returns error value, if error found, else returns true
	//NotLowLevel
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
