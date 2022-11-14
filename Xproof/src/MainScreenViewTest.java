import static org.junit.jupiter.api.Assertions.*;

import java.io.InputStream;

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
	    String[] res = MSV.LoginView();
	    String[] aux = {"User1","PASSWD1"};
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
	    String[] res = MSV.RegisterView();
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
	void LoginOrRegister() {
		MainScreenView MSV = new MainScreenView();
		MockUserInput MUI = new MockUserInput();
	    InputStream stdin = System.in;
	    MUI.MockUserSelectData();
	    boolean res = MSV.LoginOrRegister();;
	    System.setIn(stdin);
	    assertEquals(res,true);
	    
	    
		MSV = new MainScreenView();
		MUI = new MockUserInput();
	    stdin = System.in;
	    MUI.MockUserSelectDataMinus();
	    res = MSV.LoginOrRegister();;
	    System.setIn(stdin);
	    assertEquals(res,true);
	}
}
