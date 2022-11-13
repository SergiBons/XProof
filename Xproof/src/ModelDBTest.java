import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import org.junit.jupiter.api.Test;

class ModelDBTest {

	
	@Test
	void testConstructor() {
		ModelDB DB = new ModelDB("User1","PASSWD1");
		assertEquals("User1",DB.UName);
		assertEquals("PASSWD1",DB.UPasswd);
	}
	
	//Check list from a database
	//return true if the name is there, false if isn't
	@Test
	void testCheckListName() {
		ModelDB DB = new ModelDB("User1","PASSWD1");
		assertEquals(DB.CheckListName("Lista1"),true);
		
		
		ModelDB DB1 = new ModelDB("User1","PASSWD10");
		assertEquals(DB1.CheckListName("Patata Incorrecta"),false);
	}
	//Delete code from user in database
	//if codes deleted, return true, else return false.
	@Test
	void testDeleteCodes() {
		ModelDB DB = new ModelDB("User1","PASSWD1");
		String[] aux ={"05001","05002"};
		boolean CE = DB.DeleteCodes(aux);
		assertEquals(DB.CheckListName("Lista1"),true);
		assertEquals(CE,true);
		File f = new File("C:\\Users\\Usuario\\eclipse-workspace\\Xproof\\Materials\\BD\\Users\\"+DB.UName+".txt");
		try {
			Scanner S = new Scanner(f);
			String data = S.nextLine();
			while(S.hasNextLine()) {
				data = S.nextLine();
				if (Integer.parseInt(data) == Integer.parseInt(aux[0]))
					break;
			}
			S.close();
			S = new Scanner(f);
			data = S.nextLine();
			while(S.hasNextLine()) {
				data = S.nextLine();
				if (Integer.parseInt(data) == Integer.parseInt(aux[1]))
					break;
			}
			S.close();
			assertNotEquals(Integer.parseInt(data),Integer.parseInt(aux[0]));
			assertNotEquals(Integer.parseInt(data),Integer.parseInt(aux[1]));
		}
		catch(FileNotFoundException e) {
			System.out.println("Error amb el fitxer");
		}
		CE = DB.DeleteCodes(aux);
		assertEquals(DB.CheckListName("Lista1"),true);
		assertEquals(CE,false);
		CE = DB.AddCodes(aux);
		
		
	}
	//addCode to user in database
	//return true if codes were added or already there
	//return false if list was not found
	//TODO: check if codes in List BD
	@Test
	void testAddCodes() {
		ModelDB DB = new ModelDB("User1","PASSWD1");
		String[] aux ={"05004","05005"};
		boolean CE = DB.AddCodes(aux);
		assertEquals(DB.CheckListName("Lista1"),true);
		assertEquals(CE,true);
		File f = new File("C:\\Users\\Usuario\\eclipse-workspace\\Xproof\\Materials\\BD\\Users\\"+DB.UName+".txt");
		try {
			Scanner S = new Scanner(f);
			String data = S.nextLine();
			while(S.hasNextLine()) {
				data = S.nextLine();
				if (Integer.parseInt(data) == Integer.parseInt(aux[0]))
					break;
			}
			S.close();
			S = new Scanner(f);
			String data1 = S.nextLine();
			while(S.hasNextLine()) {
				data1 = S.nextLine();
				if (Integer.parseInt(data1) == Integer.parseInt(aux[1]))
					break;
			}
			S.close();
			assertEquals(Integer.parseInt(data),Integer.parseInt(aux[0]));
			assertEquals(Integer.parseInt(data1),Integer.parseInt(aux[1]));
		}
		catch(FileNotFoundException e) {
			System.out.println("Error amb el fitxer");
		}
		CE = DB.AddCodes(aux);
		assertEquals(DB.CheckListName("Lista1"),true);
		assertEquals(CE,false);
		CE = DB.DeleteCodes(aux);
	}
	
	@Test
	void testCheckUsername() {
		ModelDB DB = new ModelDB("User1","PASSWD1");
		assertEquals(DB.CheckUserName(),true);
		
		DB = new ModelDB("Usernt", "PASSWDNT");
		assertEquals(DB.CheckUserName(),false);
	}
	
	@Test
	void testCheckUserPassword() {
		ModelDB DB = new ModelDB("User1","PASSWD1");
		assertEquals(DB.CheckUserPassword(),true);
		
		DB = new ModelDB("User1", "PASSWDNT");
		assertEquals(DB.CheckUserPassword(),false);
	}
}
