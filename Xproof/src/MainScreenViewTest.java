import static org.junit.jupiter.api.Assertions.*;

import java.io.InputStream;
import java.util.Scanner;

import org.junit.jupiter.api.Test;

class MainScreenViewTest {
	@Test
	void testUpdateListView() {
		//n_max=9
		//loop Testing
		//1
		String[] aux = {"L101","L102"};
		PortableController PC = new PortableController("L1",aux);
		MainScreenView MSV = new MainScreenView();
		MSV.UpdateListView(PC.ListMap);
		
		//2
		String[] listNames = {"L1","Lista2"};
		String[] aux1 = {"L201","L202"};
		String[][] ListCL = {aux, aux1};
		PC = new PortableController(listNames,ListCL);
		MSV = new MainScreenView();
		MSV.UpdateListView(PC.ListMap);
		
		//0
		String[] listNamesnt = {};
		PC = new PortableController(listNamesnt,ListCL);
		MSV = new MainScreenView();
		MSV.UpdateListView(PC.ListMap);
		
		//5
		String[] listNamesM = {"l1","l2","l3","l4","l5"};
		String[][] ListCLM = {aux, aux, aux, aux, aux};
		PC = new PortableController(listNamesM,ListCLM);
		MSV = new MainScreenView();
		MSV.UpdateListView(PC.ListMap);
		
		//8
		String[] listNamesMb = {"l1","l2","l3","l4","l5","l6","l7","l8"};
		String[][] ListCLMb = {aux, aux, aux, aux, aux, aux, aux, aux};
		PC = new PortableController(listNamesMb,ListCLMb);
		MSV = new MainScreenView();
		MSV.UpdateListView(PC.ListMap);
		
		//9
		String[] listNamesMa = {"l1","l2","l3","l4","l5","l6","l7","l8","l9"};
		String[][] ListCLMa = {aux, aux, aux, aux, aux, aux, aux, aux, aux};
		PC = new PortableController(listNamesMa,ListCLMa);
		MSV = new MainScreenView();
		MSV.UpdateListView(PC.ListMap);
		
		//10
		String[] listNamesMax = {"l1","l2","l3","l4","l5","l6","l7","l8","l9","l10"};
		String[][] ListCLMax = {aux, aux, aux, aux, aux, aux, aux, aux, aux, aux};
		PC = new PortableController(listNamesMax,ListCLMax);
		MSV = new MainScreenView();
		MSV.UpdateListView(PC.ListMap);
		
	}
	
	
	@Test
	void testLoginView() {
		//Equivalent partitions
		//correct
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
	    
	    //incorrect (returns true, not checked here if correct or not)
	    MSV = new MainScreenView();
		MUI = new MockUserInput();
		String[] aux1 = {"Usernt","PASSWDnt"};
	    stdin = System.in; //* Comment for manual testing
	    MUI.MockUserLWData(); //*
	    scanner = new Scanner(System.in);
	    res = MSV.LoginView(scanner);
	    scanner.close();
	    System.setIn(stdin); //*
	    result = true;
	    for(int i=0; i<res.length; i++){
	        if(!res[i].equals(aux1[i])){
	             result = false;
	             break;
	        }
	    }
	    assertEquals(result,true);
	    
	    //Limit case
	    //empty list
	    MSV = new MainScreenView();
		MUI = new MockUserInput();
		String[] aux2 = {"",""};
	    stdin = System.in; //* Comment for manual testing
	    MUI.MockUserLEData(); //*
	    scanner = new Scanner(System.in);
	    res = MSV.LoginView(scanner);
	    scanner.close();
	    System.setIn(stdin); //*
	    result = true;
	    for(int i=0; i<res.length; i++){
	        if(!res[i].equals(aux2[i])){
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
	    
	    
	    //incorrect (returns true, not checked here if correct or not)
	    MSV = new MainScreenView();
		MUI = new MockUserInput();
		String[] aux1 = {"Usernt","PASSWDnt"};
	    stdin = System.in; //* Comment for manual testing
	    MUI.MockUserLWData(); //*
	    scanner = new Scanner(System.in);
	    res = MSV.RegisterView(scanner);
	    scanner.close();
	    System.setIn(stdin); //*
	    result = true;
	    for(int i=0; i<res.length; i++){
	        if(!res[i].equals(aux1[i])){
	             result = false;
	             break;
	        }
	    }
	    assertEquals(result,true);
	    
	    //Limit case
	    //empty list
	    MSV = new MainScreenView();
		MUI = new MockUserInput();
		String[] aux2 = {"",""};
	    stdin = System.in; //* Comment for manual testing
	    MUI.MockUserLEData(); //*
	    scanner = new Scanner(System.in);
	    res = MSV.RegisterView(scanner);
	    scanner.close();
	    System.setIn(stdin); //*
	    result = true;
	    for(int i=0; i<res.length; i++){
	        if(!res[i].equals(aux2[i])){
	             result = false;
	             break;
	        }
	    }
	    assertEquals(result,true);
	}
	@Test
	void testLoginOrRegister() {
		//frontier case
		//login
		MainScreenView MSV = new MainScreenView();
		MockUserInput MUI = new MockUserInput();
	    InputStream stdin = System.in;
	    MUI.MockUserSelectData();
	    Scanner scanner = new Scanner(System.in);
	    boolean res = MSV.LoginOrRegister(scanner);
	    scanner.close();
	    System.setIn(stdin);
	    assertEquals(res,true);
	    
	    //login minuscula
		MSV = new MainScreenView();
		MUI = new MockUserInput();
	    stdin = System.in;
	    MUI.MockUserSelectDataMinus();
	    scanner = new Scanner(System.in);
	    res = MSV.LoginOrRegister(scanner);
	    scanner.close();
	    System.setIn(stdin);
	    assertEquals(res,true);
	    
	    //register r
		MSV = new MainScreenView();
		MUI = new MockUserInput();
	    stdin = System.in;
	    MUI.MockUserSelectDataReg();
	    scanner = new Scanner(System.in);
	    res = MSV.LoginOrRegister(scanner);;
	    scanner.close();
	    System.setIn(stdin);
	    assertEquals(res,false);
	    
	    //Limit Cases
	    MSV = new MainScreenView();
		MUI = new MockUserInput();
	    stdin = System.in;
	    MUI.MockUserSelect(" ");
	    scanner = new Scanner(System.in);
	    res = MSV.LoginOrRegister(scanner);;
	    scanner.close();
	    System.setIn(stdin);
	    assertEquals(res,false);
	    
	    MSV = new MainScreenView();
		MUI = new MockUserInput();
	    stdin = System.in;
	    MUI.MockUserSelect("");
	    scanner = new Scanner(System.in);
	    res = MSV.LoginOrRegister(scanner);;
	    scanner.close();
	    System.setIn(stdin);
	    assertEquals(res,false);
	}
	
	//notLowLevel by definition
	@Test
	void testShowSelectorAlert(){
		MainScreenView MSV = new MainScreenView();
		MSV.ShowSelectorAlert();
	    
	}
	//notLowLevel by definition
	@Test
	void testPrintAlertMessage(){
		MainScreenView MSV = new MainScreenView();
		String st = "Patata cocida";
		MSV.PrintAlertMessage(st);
	    
	}
}
