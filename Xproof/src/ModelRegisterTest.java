import static org.junit.jupiter.api.Assertions.*;

import java.io.File;

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
		}
	
	@Test
	void testRegisterNewUser() {
		ModelRegister Reg = new ModelRegister("User10","PASSWD10");
		Reg.RegisterNewUser();
		File f = new File("C:\\Users\\Usuario\\eclipse-workspace\\Xproof\\Materials\\BD\\Users\\"+Reg.UName+".txt");
		assertEquals(true, f.exists());
		f.delete();
		}
	
	
}
