import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PortableControllerTest {
	
	
	//SumaCodis
	void testSumaCodis() {
		//Suma codis a una llista
		PortableController PC = new PortableController();
		int[] testArr = {0010001,0010002};
		boolean res_SC1 = PC.SumaCodis("ObraPublica", testArr);
		assertEquals(true, res_SC1);
		assertEquals(2,PC.ListMap.get("ObraPublica").length);
	}
	
	
	
	//RestaCodis
	void testRestaCodis() {
		//Resta codis d'una llista, pero no la buida
		
		//Inicialitzar llista amb 3 elements
		PortableController PC = new PortableController();
		int[] testArr = {0010001,0010002};
		boolean res_RC1 = PC.RestaCodis("ObraPublica", testArr);
		assertEquals(true, res_RC1);
		assertEquals(1,PC.ListMap.get("ObraPublica").length);
	}
	
	
	//AddList
	@Test
	void testAddList_notfound() {
		//Afegeix una llista nova
		PortableController PC = new PortableController();
		boolean res_XP1 = PC.AddList("ObraPublica");
		assertEquals(true, res_XP1);
		assertEquals(true, PC.ListMap.containsKey("ObraPublica"));
	}
	
	@Test
	void testAddList_found() {
		//Intenta afegir una llista que ja existeix
		PortableController PC = new PortableController();
		boolean res_XP1 = PC.AddList("ObraPublica");
		assertEquals(false, res_XP1);
		assertEquals(true, PC.ListMap.containsKey("ObraPublica"));
	}
	
	
	
	
	
	
	//RemoveList
	@Test
	void testRemoveList_found() {
		//Esborra una llista existent
		PortableController PC = new PortableController();
		
		assertEquals(true, PC.ListMap.containsKey("ObraPublica"));
		boolean res_XP1 = PC.RemoveList("ObraPublica");
		assertEquals(true, res_XP1);
		assertEquals(false, PC.ListMap.containsKey("ObraPublica"));
	}
	
	@Test
	void testRemoveList_notfound() {
		//Esborra una llista inexistent
		PortableController PC = new PortableController();
		
		assertEquals(true, PC.ListMap.containsKey("ObraPublica"));
		boolean res_XP1 = PC.RemoveList("ObraPublica");
		assertEquals(false, res_XP1);
		assertEquals(false, PC.ListMap.containsKey("ObraPublica"));
	}
	
	
	//CheckListNameFromDatabase
		@Test
		void testCheckListNameFromDatabase() {
			PortableController PC = new PortableController();
			//Inicialitzar llista "ObraPublica"
			assertEquals(true, PC.CheckListNameFromDatabase("ObraPublica"));;
		}
	
}