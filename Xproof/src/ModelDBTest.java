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
		
		DB = new ModelDB();
		assertEquals("unlogged",DB.UName);
		assertEquals("unlogged",DB.UPasswd);
	}
	
	//Check list from a database
	//return true if the name is there, false if isn't
	@Test
	void testCheckListName() {
		//Equivalent Partitions
		//Correct
		ModelDB DB = new ModelDB("User1","PASSWD1");
		assertEquals(DB.CheckListName("L1"),true);
		
		//Incorrect
		ModelDB DB1 = new ModelDB("User1","PASSWD10");
		assertEquals(DB1.CheckListName("Patata Incorrecta"),false);
		
		//LimitCase
		DB = new ModelDB("User1","PASSWD10");
		assertEquals(DB.CheckListName(""),false);
		
		DB = new ModelDB("User1","PASSWD10");
		assertEquals(DB.CheckListName("\n"),false);
	}
	//Delete code from user in database
	//if codes deleted, return true, else return false.
	//Not low level class
	@Test
	void testDeleteCodes() {
		ModelDB DB = new ModelDB("User1","PASSWD1");
		String[] aux ={"L501","L502"};
		boolean CE = DB.DeleteCodes(aux);
		assertEquals(DB.CheckListName("L1"),true);
		assertEquals(CE,true);
		File f = new File("C:\\Users\\Usuario\\eclipse-workspace\\Xproof\\Materials\\BD\\Users\\"+DB.UName+".txt");
		try {
			Scanner S = new Scanner(f);
			String data = S.nextLine();
			while(S.hasNextLine()) {
				data = S.nextLine();
				if (data.equals(aux[0]))
					break;
			}
			S.close();
			S = new Scanner(f);
			data = S.nextLine();
			while(S.hasNextLine()) {
				data = S.nextLine();
				if (data.equals(aux[1]))
					break;
			}
			S.close();
			assertEquals(data.equals(aux[0]),false);
			assertEquals(data.equals(aux[1]),false);
		}
		catch(FileNotFoundException e) {
			System.out.println("Error amb el fitxer");
		}
		CE = DB.DeleteCodes(aux);
		assertEquals(DB.CheckListName("L1"),true);
		assertEquals(CE,false);
		CE = DB.AddCodes(aux);
		
		
	}
	//addCode to user in database
	//return true if codes were added or already there
	//return false if list was not found
	//Not low level class
	@Test
	void testAddCodes() {
		ModelDB DB = new ModelDB("User1","PASSWD1");
		String[] aux ={"L504","L505"};
		boolean CE = DB.AddCodes(aux);
		assertEquals(DB.CheckListName("L1"),true);
		assertEquals(CE,true);
		File f = new File("C:\\Users\\Usuario\\eclipse-workspace\\Xproof\\Materials\\BD\\Users\\"+DB.UName+".txt");
		try {
			Scanner S = new Scanner(f);
			String data = S.nextLine();
			while(S.hasNextLine()) {
				data = S.nextLine();
				if (data.equals(aux[0]))
					break;
			}
			S.close();
			S = new Scanner(f);
			String data1 = S.nextLine();
			while(S.hasNextLine()) {
				data1 = S.nextLine();
				if (data.equals(aux[1]))
					break;
			}
			S.close();
			assertEquals(data.equals(aux[0]),true);
			assertEquals(data1.equals(aux[1]),true);
		}
		catch(FileNotFoundException e) {
			System.out.println("Error amb el fitxer");
		}
		CE = DB.AddCodes(aux);
		assertEquals(DB.CheckListName("L1"),true);
		assertEquals(CE,false);
		CE = DB.DeleteCodes(aux);
	}
	
	@Test
	void testCheckUsername() {
		//Equivalent partitions
		//correct
		ModelDB DB = new ModelDB("User1","PASSWD1");
		assertEquals(DB.CheckUserName(),true);
		
		//incorrect
		DB = new ModelDB("Usernt", "PASSWDNT");
		assertEquals(DB.CheckUserName(),false);
		
		//Limit case
		DB = new ModelDB("", "");
		assertEquals(DB.CheckUserName(),false);
	}
	
	@Test
	void testCheckUserPassword() {
		//Equivalent partitions
		//pairwise testing:
		//correct correct
		ModelDB DB = new ModelDB("User1","PASSWD1");
		assertEquals(DB.CheckUserPassword(),true);
		//incorrect correct
		DB = new ModelDB("User1", "PASSWDNT");
		assertEquals(DB.CheckUserPassword(),false);
		//correct incorrect
		DB = new ModelDB("Usernt", "PASSWD1");
		assertEquals(DB.CheckUserPassword(),false);
		//incorrect incorrect
		DB = new ModelDB("Usernt", "PASSWDNT");
		assertEquals(DB.CheckUserPassword(),false);
		
		//Limit case
		DB = new ModelDB("", "PASSWD1");
		assertEquals(DB.CheckUserPassword(),false);
		
		DB = new ModelDB("User1", "");
		assertEquals(DB.CheckUserPassword(),false);
		
		DB = new ModelDB("", "");
		assertEquals(DB.CheckUserPassword(),false);
		
	}
}
