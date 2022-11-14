import static org.junit.jupiter.api.Assertions.*;

import java.io.InputStream;

import org.junit.jupiter.api.Test;

class MainScreenViewTest {
	@Test
	void testLoginView() {
		MainScreenView MSV = new MainScreenView();
		MockUserInput MUI = new MockUserInput();
	    InputStream stdin = System.in;
	    MUI.MockUserLRData();
	    String[] res = MSV.LoginView();
	    String[] aux = {"User1","PASSWD1"};
	    System.setIn(stdin);
	    assertEquals(res.equals(aux),true);
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
	    assertEquals(res.equals(aux),true);
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
	}
}
