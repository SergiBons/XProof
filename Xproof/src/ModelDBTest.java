import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ModelDBTest {

	
	@Test
	void testConstructor() {
		ModelDB DB = new ModelDB("User1","PASSWD1");
		assertEquals("User1",DB.UName);
		assertEquals("User1",DB.UPasswd);
	}
	
	
	@Test
	void testCheckListName() {
		
	}

	@Test
	void testDeleteCodes() {
		
	}
	
	@Test
	void testAddCodes() {
		
	}
	
	
	
}
