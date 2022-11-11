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
	//if codes found, return true, else return false.
	@Test
	void testDeleteCodes() {
		ModelDB DB = new ModelDB("User1","PASSWD1");
		int[] aux ={05001,05002};
		boolean CE = DB.DeleteCodes("Lista1", aux);
		assertEquals(DB.CheckListName("Lista1"),true);
		assertEquals(CE,true);
		File f = new File("C:\\Users\\Usuario\\eclipse-workspace\\Xproof\\Materials\\BD\\Users\\"+DB.UName+".txt");
		try {
			Scanner S = new Scanner(f);
			String data = S.nextLine();
			while(S.hasNextLine() && Integer.parseInt(data) != aux[0]) {
				data = S.nextLine();
			}
			S.close();
			assertEquals(Integer.parseInt(data),aux[0]);
			assertNotEquals(Integer.parseInt(data),aux[0]);
			assertNotEquals(Integer.parseInt(data),aux[1]);
		}
		catch(FileNotFoundException e) {
			System.out.println("Error amb el fitxer");
		}
		CE = DB.DeleteCodes("Lista1", aux);
		assertEquals(DB.CheckListName("Lista1"),true);
		assertEquals(CE,false);
		
	}
	//addCode to user in database
	//return true if codes were added or already there
	//return false if list was not found
	@Test
	void testAddCodes() {
		ModelDB DB = new ModelDB("User1","PASSWD1");
		int[] aux ={05001,05002};
		boolean CE = DB.AddCodes("Lista1", aux);
		assertEquals(DB.CheckListName("Lista1"),true);
		assertEquals(CE,true);
		File f = new File("C:\\Users\\Usuario\\eclipse-workspace\\Xproof\\Materials\\BD\\Users\\"+DB.UName+".txt");
		try {
			Scanner S = new Scanner(f);
			String data = S.nextLine();
			while(S.hasNextLine() && Integer.parseInt(data) != aux[0]) {
				data = S.nextLine();
			}
			S.close();
			assertEquals(Integer.parseInt(data),aux[0]);
			while(S.hasNextLine() && Integer.parseInt(data) != aux[1]) {
				data = S.nextLine();
			}
			S.close();
			assertEquals(Integer.parseInt(data),aux[1]);
			}
		catch(FileNotFoundException e) {
			System.out.println("Error amb el fitxer");
		}
		
		ModelDB DB1 = new ModelDB("User1","PASSWD1");
		int[] aux1 ={05001,05002};
		boolean CE1 = DB1.AddCodes("Patata Incorrecta", aux1);
		assertEquals(DB1.CheckListName("Patata Incorrecta"),false);
		assertEquals(CE1,false);
	}
	
	
	
}
