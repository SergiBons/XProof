import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PortableControllerTest {
	
	//Constructors
	@Test
	void testConstructors() {
		//Constr per defecte
		PortableController PC = new PortableController();
		assertNotNull(PC.ListMap);
		
		//Constr amb nom de llista
		PortableController PC1 = new PortableController("Lista1");
		assertEquals(true, PC1.ListMap.containsKey("Lista1"));
		
		//Constr amb nom de llista i codis
		int[] aux = {0,0};
		PortableController PC2 = new PortableController("Lista1", aux );
		assertEquals(true, PC2.ListMap.containsKey("Lista1"));
		assertEquals(aux, PC2.ListMap.get("Lista1"));
		
		//Constr amb LLista de LListes I Llista de Codis
		int[] aux1 = {1,1};
		int[][] auxList = {aux,aux1};
		String[] ListOLists = {"Lista1","Lista2"};
		PortableController PC3 = new PortableController(ListOLists, auxList );
		assertEquals(true, PC3.ListMap.containsKey("Lista1"));
		assertEquals(true, PC3.ListMap.containsKey("Lista2"));
		assertEquals(aux, PC3.ListMap.get("Lista1"));
		assertEquals(aux1, PC3.ListMap.get("Lista2"));
		
	}
	
	//SumaCodis
	@Test
	void testSumaCodis() {
		//Suma codis a una llista
		PortableController PC = new PortableController();
		int[] testArr = {0010001,0010002};
		boolean res_SC1 = PC.SumaCodis("Lista1", testArr);
		assertEquals(true, res_SC1);
		assertEquals(2,PC.ListMap.get("Lista1").length);
	}
	
	
	
	//RestaCodis
	@Test
	void testRestaCodis() {
		//Resta codis d'una llista, pero no la buida
		
		//Inicialitzar llista amb 3 elements
		PortableController PC = new PortableController();
		int[] testArr = {0010001,0010002};
		boolean res_RC1 = PC.RestaCodis("Lista1", testArr);
		assertEquals(true, res_RC1);
		assertEquals(1,PC.ListMap.get("Lista1").length);
	}
	
	
	//AddList
	@Test
	void testAddList() {
		//Afegeix una llista nova
		PortableController PC = new PortableController();
		boolean res_XP1 = PC.AddList("Lista1");
		assertEquals(true, res_XP1);
		assertEquals(true, PC.ListMap.containsKey("Lista1"));

		//Intenta afegir una llista que ja existeix
		PC = new PortableController();
		res_XP1 = PC.AddList("Lista1");
		assertEquals(false, res_XP1);
		assertEquals(true, PC.ListMap.containsKey("Lista1"));
	}
	
	
	
	
	
	
	//RemoveList
	@Test
	void testRemoveList_found() {
		//Esborra una llista existent
		PortableController PC = new PortableController();
		
		assertEquals(true, PC.ListMap.containsKey("Lista1"));
		boolean res_XP1 = PC.RemoveList("Lista1");
		assertEquals(true, res_XP1);
		assertEquals(false, PC.ListMap.containsKey("Lista1"));

		//Esborra una llista inexistent
		PC = new PortableController();
		
		assertEquals(true, PC.ListMap.containsKey("Lista1"));
		res_XP1 = PC.RemoveList("Lista1");
		assertEquals(false, res_XP1);
		assertEquals(false, PC.ListMap.containsKey("Lista1"));
	}
	
	
	//CheckListNameFromDatabase
		@Test
		void testCheckListNameFromDatabase() {
			PortableController PC = new PortableController();
			assertEquals(true, PC.CheckListNameFromDatabase(Lista1"));;
		}
	
}