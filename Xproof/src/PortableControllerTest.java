import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.Scanner;

import org.junit.jupiter.api.Test;

class PortableControllerTest {
	
	//Constructors
	@Test
	void testConstructors() {
		//Constr per defecte
		PortableController PC = new PortableController();
		assertNotNull(PC.ListMap);
		
		//Constr amb nom de llista
		PortableController PC1 = new PortableController("L1");
		assertEquals(true, PC1.ListMap.containsKey("L1"));
		
		//Constr amb nom de llista i codis
		String[] aux = {"L101","L102"};
		PortableController PC2 = new PortableController("L1", aux );
		assertEquals(true, PC2.ListMap.containsKey("L1"));
		assertEquals(aux, PC2.ListMap.get("L1"));
		
		//Constr amb LLista de LListes I Llista de Codis
		String[] aux1 = {"L101","L102"};
		String[][] auxList = {aux,aux1};
		String[] ListOLists = {"L1","L2"};
		PortableController PC3 = new PortableController(ListOLists, auxList );
		assertEquals(true, PC3.ListMap.containsKey("L1"));
		assertEquals(true, PC3.ListMap.containsKey("L2"));
		assertEquals(aux, PC3.ListMap.get("L1"));
		assertEquals(aux1, PC3.ListMap.get("L2"));
		
	}
	//LowLevelClass
	@Test
	void testLogin() {
		//Equivalent Partitions
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
		
		//Limit Case and equivalent Partition testing:
		//Limit Case
		CE = PC.Login("", "");
		assertEquals(CE, false);
		
	}
	//SumaCodis
	@Test
	void testSumaCodis() {
		//Suma codis a una llista (TOT OK)
		PortableController PC = new PortableController("L1");
		
		PC.Login("User1", "PASSWD1");
		
		String[] testArr = {"L101","L102"};
		boolean res_SC = PC.SumaCodis("L1", testArr);
		assertEquals(true, res_SC);
		assertEquals(Arrays.equals(PC.ListMap.get("L1"),testArr),true);
		
		//Suma codis a una llista nova (TOT OK)
		PC = new PortableController();
		
		PC.Login("User1", "PASSWD1");
		
		res_SC = PC.SumaCodis("L1", testArr);
		assertEquals(true, res_SC);
		assertEquals(Arrays.equals(PC.ListMap.get("L1"),testArr),true);
		
		//(Codis Ja en User) (NOK)
		PC = new PortableController("L1",testArr);
		
		PC.Login("User1", "PASSWD1");
		
		res_SC = PC.SumaCodis("L1", testArr);
		assertEquals(false, res_SC);
		assertEquals(Arrays.equals(PC.ListMap.get("L1"),testArr),true);
		
		//Codis a llista inexistent
		PC = new PortableController();
		
		PC.Login("User1", "PASSWD1");
		
		res_SC = PC.SumaCodis("L7", testArr);
		assertEquals(false, res_SC);

		//codis inexistents a llista existent
		String[] TestWrong = {"1231230","123123120"};
		PC = new PortableController();
		
		PC.Login("User1", "PASSWD1");
		
		res_SC = PC.SumaCodis("L1", TestWrong);
		assertEquals(false, res_SC);

		
		//Usuari sense codis a DB
		String[] TestDiffList = {"L301","L302"};
		PC = new PortableController();
		
		PC.Login("User1", "PASSWD1");
		
		res_SC = PC.SumaCodis("L3", TestDiffList);
		assertEquals(false, res_SC);
	}
	
	
	
	//RestaCodis
	@Test
	void testRestaCodis() {
		//Resta codis a una llista (TOT OK)
		String[] testArr = {"L101","L102","L103"};
		String[] testArrAux = {"L101","L102"};
		String[] testArrRes = {"L103"};
		PortableController PC = new PortableController("L1",testArr);
		
		PC.Login("User1", "PASSWD1");
		
		boolean res_RC = PC.RestaCodis("L1", testArrAux);
		assertEquals(true, res_RC);
		assertEquals(Arrays.equals(PC.ListMap.get("L1"),testArrRes),true);
				
		//Resta codis a una llista i l'esborra (TOT OK)
		PC = new PortableController("L1",testArr);
		
		PC.Login("User1", "PASSWD1");
		
		res_RC = PC.RestaCodis("L1", testArr);
		assertEquals(true, res_RC);
		assertEquals(PC.ListMap.containsKey("L1"),false);
		
		//(User no te codis a la llista) (NOK)
		PC = new PortableController("L1");
		res_RC = PC.RestaCodis("L1", testArr);
		assertEquals(false, res_RC);
		assertEquals(PC.ListMap.containsKey("L1"),true);
	}
	
	
	//AddList
	@Test
	void testAddList() {
		//Afegeix una llista nova
		PortableController PC = new PortableController();
		PC.Login("User1", "PASSWD1");
		boolean res_AL = PC.AddList("L5");
		assertEquals(true, res_AL);
		assertEquals(true, PC.ListMap.containsKey("L5"));
		boolean res_RL = PC.RemoveList("L5");
		assertEquals(true, res_RL);
		assertEquals(false, PC.ListMap.containsKey("L5"));
		
		//Intenta afegir una llista que ja existeix
		PC = new PortableController("L1");
		PC.Login("User1", "PASSWD1");
		res_AL = PC.AddList("L1");
		assertEquals(false, res_AL);
		assertEquals(true, PC.ListMap.containsKey("L1"));
	}
	
	
	
	
	
	
	//RemoveList
	@Test
	void testRemoveList() {
		//Esborra una llista existent
		PortableController PC = new PortableController("L1");
		PC.Login("User1", "PASSWD1");
		
		assertEquals(true, PC.ListMap.containsKey("L1"));
		boolean res_RL = PC.RemoveList("L1");
		assertEquals(true, res_RL);
		assertEquals(false, PC.ListMap.containsKey("L1"));
		boolean res_AL = PC.AddList("L1");
		assertEquals(true, res_AL);
		assertEquals(true, PC.ListMap.containsKey("L1"));
		
		
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
			assertEquals(true, PC.CheckListNameFromDatabase("L1"));
			assertEquals(false, PC.CheckListNameFromDatabase("Listant"));
	}
	
	//CheckCodesExist
	@Test
	void testCheckCodesExist() {
		PortableController PC = new PortableController();
		
		PC.Login("User1","PASSWD1");
		
		String[] auxList = {"L101","L102"};
		assertEquals(PC.CheckCodesExist("L1", auxList) , true);
		String[] auxList1 = {"L1011","L1012"};
		assertEquals(PC.CheckCodesExist("L1", auxList1) , false);
	}
	
	@Test	
	void testCheckUserHasCodes() {
		//user has codes
		String[] aux = {"L101","L102"};
		String[] auxnt = {"L1010","L1010"};
		PortableController PC = new PortableController();
		
		PC.Login("User1","PASSWD1");
		
;		assertEquals(PC.CheckIfUserHasCodes(aux),true);
		
		//user hasnt codes
		PC = new PortableController();
		
		PC.Login("User1","PASSWD1");
		
		assertEquals(PC.CheckIfUserHasCodes(auxnt),false);
	}
	
	@Test
	void testInitUserData() {
		PortableController PC = new PortableController();
		String[] aux1 = {"L101","L102"};
		String[] aux2 = {"L201","L202"};
		
		PC.Login("User2", "PASSWD2");
		
		PC.InitUserData();
		assertEquals(PC.ListMap.containsKey("L1"),true);
		assertEquals(PC.ListMap.containsKey("L2"),true);
		assertEquals(Arrays.equals(PC.ListMap.get("L1"),aux1),true);
		assertEquals(Arrays.equals(PC.ListMap.get("L2"),aux2),true);
		
	}
	
	
	
}