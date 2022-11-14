import static org.junit.jupiter.api.Assertions.*;

import java.io.InputStream;
import java.util.Scanner;

import org.junit.jupiter.api.Test;

class MainScreenViewTest {
	@Test
	void testUpdateListView() {
		String[] aux = {"L101","L102"};
		PortableController PC = new PortableController("L1",aux);
		MainScreenView MSV = new MainScreenView();
		MSV.UpdateListView(PC.ListMap);
		
		
		String[] listNames = {"L1","Lista2"};
		String[] aux1 = {"L201","L202"};
		String[][] ListCL = {aux, aux1};
		PC = new PortableController(listNames,ListCL);
		MSV = new MainScreenView();
		MSV.UpdateListView(PC.ListMap);
	}
	
	
	@Test
	void testLoginView() {
		MainScreenView MSV = new MainScreenView();
		MockUserInput MUI = new MockUserInput();
	    InputStream stdin = System.in; //* Comment for manual testing
	    MUI.MockUserLRData(); //*
	    Scanner scanner = new Scanner(System.in);
	    String[] res = MSV.LoginView(scanner);
	    String[] aux = {"User1","PASSWD1"};
	    scanner.close();
	    System.setIn(stdin); //*
	    boolean result = true;;
	    for(int i=0; i<res.length; i++){
	        if(!res[i].equals(aux[i])){
	             result = false;
	             break;
	        }
	    }
	    assertEquals(result,true);
	}
	@Test
	void testRegisterView() {
		MainScreenView MSV = new MainScreenView();
		MockUserInput MUI = new MockUserInput();
	    InputStream stdin = System.in;
	    MUI.MockUserLRData();
	    Scanner scanner = new Scanner(System.in);
	    String[] res = MSV.RegisterView(scanner);
	    scanner.close();
	    String[] aux = {"User1","PASSWD1"};
	    System.setIn(stdin);
	    boolean result = true;;
	    for(int i=0; i<res.length; i++){
	        if(!res[i].equals(aux[i])){
	             result = false;
	             break;
	        }
	    }
	    assertEquals(result,true);
	}
	@Test
	void testLoginOrRegister() {
		MainScreenView MSV = new MainScreenView();
		MockUserInput MUI = new MockUserInput();
	    InputStream stdin = System.in;
	    MUI.MockUserSelectData();
	    Scanner scanner = new Scanner(System.in);
	    boolean res = MSV.LoginOrRegister(scanner);
	    scanner.close();
	    System.setIn(stdin);
	    assertEquals(res,true);
	    
	    
		MSV = new MainScreenView();
		MUI = new MockUserInput();
	    stdin = System.in;
	    MUI.MockUserSelectDataMinus();
	    scanner = new Scanner(System.in);
	    res = MSV.LoginOrRegister(scanner);
	    scanner.close();
	    System.setIn(stdin);
	    assertEquals(res,true);
	    
		MSV = new MainScreenView();
		MUI = new MockUserInput();
	    stdin = System.in;
	    MUI.MockUserSelectDataReg();
	    scanner = new Scanner(System.in);
	    res = MSV.LoginOrRegister(scanner);;
	    scanner.close();
	    System.setIn(stdin);
	    assertEquals(res,false);
	}
	
	
	@Test
	void testShowSelectorAlert(){
		MainScreenView MSV = new MainScreenView();
		MSV.ShowSelectorAlert();
	    
	}
	
	@Test
	void testPrintAlertMessage(){
		MainScreenView MSV = new MainScreenView();
		String st = "Patata cocida";
		MSV.PrintAlertMessage(st);
	    
	}
}
