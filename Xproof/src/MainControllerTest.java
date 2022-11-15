import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;

import org.junit.jupiter.api.Test;

class MainControllerTest {

	//@Test
	//void testManual() {
	//	MainController MC = new MainController();
	//	MC.main(null);
	//}
	@Test
	void testLogReg() {
		MainController MC = new MainController();
		PortableController PC = new PortableController();
		MainScreenView MSV = new MainScreenView();
		ModelRegister RDB = new ModelRegister();
		MockUserInput MUI = new MockUserInput();
		String err = "CORRECT";
		//register correct
		InputStream stdin = System.in;
		MUI = new MockUserInput();
	    stdin = System.in;
	    MUI.MockUserLogReg(1);
	    MC.SetScanner();
	    PC = MC.Log_Reg(MSV, PC, RDB, err);
	    MC.CloseScanner();
		File f = new File("C:\\Users\\Usuario\\eclipse-workspace\\Xproof\\Materials\\BD\\Users\\Usernew.txt");
		if (f.exists()) {
			System.gc();
			f.delete();
		}
	    System.setIn(stdin);
	    assertEquals(PC.DB.UName.equals("Usernew"),true);
	    assertEquals(PC.DB.UPasswd.equals("PASSWDN"),true);
	    
	    //register incorrect
	    PC = new PortableController();
		stdin = System.in;
		MUI = new MockUserInput();
	    MUI.MockUserLogReg(4);
	    MC.SetScanner();
	    PC = MC.Log_Reg(MSV, PC, RDB, err);
	    MC.CloseScanner();
	    f = new File("C:\\Users\\Usuario\\eclipse-workspace\\Xproof\\Materials\\BD\\Users\\Usernew.txt");
		if (f.exists()) {
			System.gc();
			f.delete();
		}
		System.setIn(stdin);
	    
	    
		//register incorrect then correct
	    PC = new PortableController();
		stdin = System.in;
		MUI = new MockUserInput();
	    MUI.MockUserLogReg(2);
	    MC.SetScanner();
	    PC = MC.Log_Reg(MSV, PC, RDB, err);
	    MC.CloseScanner();
	    f = new File("C:\\Users\\Usuario\\eclipse-workspace\\Xproof\\Materials\\BD\\Users\\Usernew.txt");
		if (f.exists()) {
			System.gc();
			f.delete();
		}
	    System.setIn(stdin);
	    assertEquals(PC.DB.UName.equals("Usernew"),true);
	    assertEquals(PC.DB.UPasswd.equals("PASSWDN"),true);
	    
		//login correct
	    PC = new PortableController();
		stdin = System.in;
		MUI = new MockUserInput();
	    MUI.MockUserLogReg(3);
	    MC.SetScanner();
	    PC = MC.Log_Reg(MSV, PC, RDB, err);
	    MC.CloseScanner();
	    System.setIn(stdin);
	    assertEquals(PC.DB.UName.equals("User1"),true);
	    assertEquals(PC.DB.UPasswd.equals("PASSWD1"),true);
	    
	    //register incorrect (already exists) then login to end statement
	    PC = new PortableController();
		stdin = System.in;
		MUI = new MockUserInput();
	    MUI.MockUserLogReg(5);
	    MC.SetScanner();
	    PC = MC.Log_Reg(MSV, PC, RDB, err);
	    MC.CloseScanner();
	    System.setIn(stdin);
	    
	    //register incorrect (passwordtoolong) then login to end statement
	    PC = new PortableController();
		stdin = System.in;
		MUI = new MockUserInput();
	    MUI.MockUserLogReg(6);
	    MC.SetScanner();
	    PC = MC.Log_Reg(MSV, PC, RDB, err);
	    MC.CloseScanner();
	    System.setIn(stdin);
	    
	}
	
	@Test
	void testTerminalInteract() {
		//add2codesL1
		MainController MC = new MainController();
		PortableController PC = new PortableController();
		PC.Login("User1", "PASSWD1");
	    PortableController ans = MC.TerminalInteract(PC,0);
	    assertEquals(ans.ListMap.containsKey("L1"),true);
	    assertEquals(ans.ListMap.get("L1")[0].equals("L101"),true);
	    assertEquals(ans.ListMap.get("L1")[1].equals("L102"),true);
	    
	    //del2CodesL1
		MC = new MainController();
		String[] aux1 = {"L101","L102"};
		PC = new PortableController("L1",aux1);
		assertEquals(ans.ListMap.containsKey("L1"),true);
	    assertEquals(ans.ListMap.get("L1")[0].equals("L101"),true);
	    assertEquals(ans.ListMap.get("L1")[1].equals("L102"),true);
	    PC.Login("User1", "PASSWD1");
	    ans = MC.TerminalInteract(PC,1);
	    assertEquals(ans.ListMap.containsKey("L1"),false);
	}
	@Test
	void testSelectorPick() {
		MainController MC = new MainController();
		PortableController PC = new PortableController();
		MainScreenView MSV = new MainScreenView();
		MockUserInput MUI = new MockUserInput();
		//exit case
		InputStream stdin = System.in;
		MUI = new MockUserInput();
	    stdin = System.in;
	    MUI.MockUserSelect("0");
	    MC.SetScanner();
	    int ans = MC.SelectorPick(PC, MSV);
	    MC.CloseScanner();
	    System.setIn(stdin);
	    assertEquals(ans,10);
		//Logout case
		stdin = System.in;
		MUI = new MockUserInput();
	    MUI.MockUserSelect("1");
	    MC.SetScanner();
	    ans = MC.SelectorPick(PC, MSV);
	    MC.CloseScanner();
	    System.setIn(stdin);
	    assertEquals(ans,0);
		
	    //Interact Case
		stdin = System.in;
		MUI = new MockUserInput();
	    MUI.MockUserSelect("2");
	    MC.SetScanner();
	    ans = MC.SelectorPick(PC, MSV);
	    MC.CloseScanner();
	    System.setIn(stdin);
	    assertEquals(ans,2);
	    
	    //default Case
		stdin = System.in;
		MUI = new MockUserInput();
	    MUI.MockUserSelect("5\n0");
	    MC.SetScanner();
	    ans = MC.SelectorPick(PC, MSV);
	    MC.CloseScanner();
	    System.setIn(stdin);
	    assertEquals(ans,10);
	}
	
	@Test
	void testMain() {
		MainController MC = new MainController();
		//Login,exit
		InputStream stdin = System.in;
		MockUserInput MUI = new MockUserInput();
		MUI.MockUserFull();
		MC.main(null);
		System.setIn(stdin);
		
		
		//Login,Logout,LoginDifferent,Exit
		MC = new MainController();		
		stdin = System.in;
		MUI.MockUserFull1();
		MC.main(null);
		System.setIn(stdin);

		
		//Login,DefaultInteract,Exit
		MC = new MainController();		
		stdin = System.in;
		MUI.MockUserFull2();
		MC.main(null);
		System.setIn(stdin);
	}


}
