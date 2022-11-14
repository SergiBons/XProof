import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

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
		String[] aux = {"01001","01002"};
		PortableController PC2 = new PortableController("Lista1", aux );
		assertEquals(true, PC2.ListMap.containsKey("Lista1"));
		assertEquals(aux, PC2.ListMap.get("Lista1"));
		
		//Constr amb LLista de LListes I Llista de Codis
		String[] aux1 = {"01001","01002"};
		String[][] auxList = {aux,aux1};
		String[] ListOLists = {"Lista1","Lista2"};
		PortableController PC3 = new PortableController(ListOLists, auxList );
		assertEquals(true, PC3.ListMap.containsKey("Lista1"));
		assertEquals(true, PC3.ListMap.containsKey("Lista2"));
		assertEquals(aux, PC3.ListMap.get("Lista1"));
		assertEquals(aux1, PC3.ListMap.get("Lista2"));
		
	}
	@Test
	void testLogin() {
		//Correct Login
		PortableController PC = new PortableController();
		boolean CE = PC.Login("User1", "PASSWD1");
		assertEquals(CE, true);
		assertEquals(PC.DB.UName, "User1");
		assertEquals(PC.DB.UPasswd, "PASSWD1");

		//Wrong Login
		PC = new PortableController();
		CE = PC.Login("User100", "PASSWD1");
		assertEquals(CE, false);
		assertEquals(PC.DB.UName, "unlogged");
		assertEquals(PC.DB.UPasswd, "unlogged");
	}
	//SumaCodis
	@Test
	void testSumaCodis() {
		//Suma codis a una llista (TOT OK)
		PortableController PC = new PortableController("Lista1");
		PC.Login("User1", "PASSWD1");
		String[] testArr = {"01001","01002"};
		boolean res_SC = PC.SumaCodis("Lista1", testArr);
		assertEquals(true, res_SC);
		assertEquals(PC.ListMap.get("Lista1"),testArr);
		
		//Suma codis a una llista nova (TOT OK)
		PC = new PortableController();
		PC.Login("User1", "PASSWD1");
		res_SC = PC.SumaCodis("Lista1", testArr);
		assertEquals(true, res_SC);
		assertEquals(PC.ListMap.get("Lista1"),testArr);
		
		//(Codis Ja en User) (NOK)
		PC = new PortableController("Lista1",testArr);
		PC.Login("User1", "PASSWD1");
		res_SC = PC.SumaCodis("Lista1", testArr);
		assertEquals(false, res_SC);
		assertEquals(PC.ListMap.get("Lista1"),testArr);
	}
	
	
	
	//RestaCodis
	@Test
	void testRestaCodis() {
		//Resta codis a una llista (TOT OK)
		String[] testArr = {"01001","01002","01003"};
		String[] testArrAux = {"01001","01002"};
		String[] testArrRes = {"01003"};
		PortableController PC = new PortableController("Lista1",testArr);
		PC.Login("User1", "PASSWD1");
		boolean res_RC = PC.RestaCodis("Lista1", testArrAux);
		assertEquals(true, res_RC);
		assertEquals(Arrays.equals(PC.ListMap.get("Lista1"),testArrRes),true);
				
		//Resta codis a una llista i l'esborra (TOT OK)
		PC = new PortableController("Lista1",testArr);
		PC.Login("User1", "PASSWD1");
		res_RC = PC.RestaCodis("Lista1", testArr);
		assertEquals(true, res_RC);
		assertEquals(PC.ListMap.containsKey("Lista1"),false);
		
		//(User no te codis a la llista) (NOK)
		PC = new PortableController("Lista1");
		res_RC = PC.RestaCodis("Lista1", testArr);
		assertEquals(false, res_RC);
		assertEquals(PC.ListMap.containsKey("Lista1"),true);
	}
	
	
	//AddList
	@Test
	void testAddList() {
		//Afegeix una llista nova
		PortableController PC = new PortableController();
		PC.Login("User1", "PASSWD1");
		boolean res_AL = PC.AddList("Lista5");
		assertEquals(true, res_AL);
		assertEquals(true, PC.ListMap.containsKey("Lista5"));
		boolean res_RL = PC.RemoveList("Lista5");
		assertEquals(true, res_RL);
		assertEquals(false, PC.ListMap.containsKey("Lista5"));
		
		//Intenta afegir una llista que ja existeix
		PC = new PortableController("Lista1");
		PC.Login("User1", "PASSWD1");
		res_AL = PC.AddList("Lista1");
		assertEquals(false, res_AL);
		assertEquals(true, PC.ListMap.containsKey("Lista1"));
	}
	
	
	
	
	
	
	//RemoveList
	@Test
	void testRemoveList() {
		//Esborra una llista existent
		PortableController PC = new PortableController("Lista1");
		PC.Login("User1", "PASSWD1");
		
		assertEquals(true, PC.ListMap.containsKey("Lista1"));
		boolean res_RL = PC.RemoveList("Lista1");
		assertEquals(true, res_RL);
		assertEquals(false, PC.ListMap.containsKey("Lista1"));
		boolean res_AL = PC.AddList("Lista1");
		assertEquals(true, res_AL);
		assertEquals(true, PC.ListMap.containsKey("Lista1"));
		
		
		//Esborra una llista inexistent
		PC = new PortableController();
		assertEquals(false, PC.ListMap.containsKey("Listant"));
		res_RL = PC.RemoveList("Listant");
		assertEquals(false, res_RL);
	}
	
	
	//CheckListNameFromDatabase
	@Test
	void testCheckListNameFromDatabase() {
			PortableController PC = new PortableController();
			assertEquals(true, PC.CheckListNameFromDatabase("Lista1"));
			assertEquals(false, PC.CheckListNameFromDatabase("Listant"));
	}
	
	//CheckCodesExist
	@Test
	void testCheckCodesExist() {
		PortableController PC = new PortableController();
		PC.Login("User1","PASSWD1");
		String[] auxList = {"01001","01002"};
		assertEquals(PC.CheckCodesExist("Lista1", auxList) , true);
		String[] auxList1 = {"01011","01012"};
		assertEquals(PC.CheckCodesExist("Lista1", auxList1) , false);
	}
	
	@Test	
	void testCheckUserHasCodes() {
		//user has codes
		String[] aux = {"01001","01002"};
		String[] auxnt = {"01010","01020"};
		PortableController PC = new PortableController();
		PC.Login("User1","PASSWD1");
		assertEquals(PC.CheckIfUserHasCodes(aux),true);
		
		//user hasnt codes
		PC = new PortableController();
		PC.Login("User1","PASSWD1");
		assertEquals(PC.CheckIfUserHasCodes(auxnt),false);
	}
}