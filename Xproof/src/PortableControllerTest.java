import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PortableControllerTest {
	
	
	
	//AddList
	@Test
	void testAddList_notfound() {
		PortableController PC = new PortableController();
		boolean res_XP1 = PC.AddList("ObraPublica");
		assertEquals(true, res_XP1);
		assertEquals(true, PC.ListMap.containsKey("ObraPublica"));
	}
	
	@Test
	void testAddList_found() {
		PortableController PC = new PortableController();
		boolean res_XP1 = PC.AddList("ObraPublica");
		assertEquals(false, res_XP1);
		assertEquals(true, PC.ListMap.containsKey("ObraPublica"));
	}
	
	
	
	
	
	
	//RemoveList
	@Test
	void testRemoveList_found() {
		PortableController PC = new PortableController();
		
		assertEquals(true, PC.ListMap.containsKey("ObraPublica"));
		boolean res_XP1 = PC.RemoveList("ObraPublica");
		assertEquals(true, res_XP1);
		assertEquals(false, PC.ListMap.containsKey("ObraPublica"));
	}
	
	@Test
	void testRemoveList_notfound() {
		PortableController PC = new PortableController();
		
		assertEquals(true, PC.ListMap.containsKey("ObraPublica"));
		boolean res_XP1 = PC.RemoveList("ObraPublica");
		assertEquals(false, res_XP1);
		assertEquals(false, PC.ListMap.containsKey("ObraPublica"));
	}
	
	
	
	
	
	
	//CheckListNameFromDatabase
	
	//AddToList
	
	//RemoveFromList
	
}