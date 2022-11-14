import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.junit.jupiter.api.Test;

class MainControllerTest {

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
	    PC = MC.Log_Reg(MSV, PC, RDB, err);
	    System.setIn(stdin);
	    assertEquals(PC.DB.UName.equals("Usernew"),true);
	    assertEquals(PC.DB.UPasswd.equals("PASSWDN"),true);
	    
		//register incorrect then correct
	    PC = new PortableController();
		stdin = System.in;
		MUI = new MockUserInput();
	    stdin = System.in;
	    MUI.MockUserLogReg(2);
	    PC = MC.Log_Reg(MSV, PC, RDB, err);
	    System.setIn(stdin);
	    assertEquals(PC.DB.UName.equals("Usernew"),true);
	    assertEquals(PC.DB.UPasswd.equals("PASSWDN"),true);
	    
		//login correct
	    PC = new PortableController();
		stdin = System.in;
		MUI = new MockUserInput();
	    stdin = System.in;
	    MUI.MockUserLogReg(3);
	    PC = MC.Log_Reg(MSV, PC, RDB, err);
	    System.setIn(stdin);
	    assertEquals(PC.DB.UName.equals("User1"),true);
	    assertEquals(PC.DB.UPasswd.equals("PASSWD1"),true);
	    
	    
		//login incorrect then correct
	    PC = new PortableController();
		stdin = System.in;
		MUI = new MockUserInput();
	    stdin = System.in;
	    MUI.MockUserLogReg(4);
	    PC = MC.Log_Reg(MSV, PC, RDB, err);
	    System.setIn(stdin);
	    assertEquals(PC.DB.UName.equals("User1"),true);
	    assertEquals(PC.DB.UPasswd.equals("PASSWD1"),true);
	    
	}
	
	@Test
	void testTerminalInteract() {
		//add2codesL1
		MainController MC = new MainController();
		PortableController PC = new PortableController();
	    PortableController ans = MC.TerminalInteract(PC,0);
	    assertEquals(ans.ListMap.containsKey("L1"),true);
	    assertEquals(ans.ListMap.get("L1")[0].equals("L1001"),true);
	    assertEquals(ans.ListMap.get("L1")[1].equals("L1002"),true);
	    
	    //del2CodesL1
		MC = new MainController();
		String[] aux1 = {"L101","L102"};
		PC = new PortableController("L1",aux1);
		assertEquals(ans.ListMap.containsKey("L1"),true);
	    assertEquals(ans.ListMap.get("L1")[0].equals("L1001"),true);
	    assertEquals(ans.ListMap.get("L1")[1].equals("L1002"),true);
	    ans = MC.TerminalInteract(PC,1);
	    assertEquals(ans.ListMap.containsKey("L1"),false);
	    assertEquals(ans.ListMap.get("L1")[0].equals("L1001"),false);
	    assertEquals(ans.ListMap.get("L1")[1].equals("L1002"),false);
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
	    int ans = MC.SelectorPick(PC, MSV);
	    System.setIn(stdin);
	    assertEquals(ans,10);
		//Logout case
		stdin = System.in;
		MUI = new MockUserInput();
	    MUI.MockUserSelect("1");
	    ans = MC.SelectorPick(PC, MSV);
	    System.setIn(stdin);
	    assertEquals(ans,0);
		
	    //Interact Case
		stdin = System.in;
		MUI = new MockUserInput();
	    MUI.MockUserSelect("2");
	    ans = MC.SelectorPick(PC, MSV);
	    System.setIn(stdin);
	    assertEquals(ans,2);
	}
	
	@Test
	void testMain() {
		MainController MC = new MainController();
		MockUserInput MUI = new MockUserInput();
		//Login,exit
		InputStream stdin = System.in;
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
