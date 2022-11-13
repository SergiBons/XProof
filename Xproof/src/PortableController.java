import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class PortableController {

	
	HashMap<String, String[]> ListMap;
	ModelDB DB;
	public PortableController() {
		ListMap = new HashMap<String, String[]>();
		DB = new ModelDB("unlogged","unlogged");
	}
	
	public PortableController(String ListName)
	{
		ListMap = new HashMap<String, String[]>();
		ListMap.put(ListName, null);
		DB = new ModelDB("unlogged","unlogged");
	}
	
	public PortableController(String ListName, String[] CodeList)
	{
		ListMap = new HashMap<String, String[]>();
		ListMap.put(ListName, CodeList);
		DB = new ModelDB("unlogged","unlogged");
		
	}
	
	public PortableController(String[] ListOLists, String[][] ListOCodeList) {
		ListMap = new HashMap<String, String[]>();
		DB = new ModelDB("unlogged","unlogged");
		for(int i = 0; i < ListOLists.length; i++) 
		{
			ListMap.put(ListOLists[i], ListOCodeList[i]);
		}
	}
	
	public boolean Login(String UName, String UPasswd) {
		File f = new File("C:\\Users\\Usuario\\eclipse-workspace\\Xproof\\Materials\\BD\\Users\\"+UName+".txt");
		if (f.exists()) {
			try {
					Scanner S = new Scanner(f);
					String data = S.nextLine();
					S.close();
					if (data.equals(UPasswd)) {
						DB.UName = UName;
						DB.UPasswd = UPasswd;
						return true;
					}
				}
			catch(FileNotFoundException e) {
				System.out.println("Error amb Login");
			}
		}
		return false;
	}
		
	
	//Funcions principals

	public boolean SumaCodis(String list, String[] CodeList){
		
		
		return true;
	}
	
	public boolean RestaCodis (String list, String[] CodeList) {
		
		
		
		return true;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	//Subfuncions
	
	public boolean CheckListNameFromDatabase(String name) {
		
		
		return true;
	}	
	
	public boolean AddList(String ListName) {
		
		
		return true;
	}
	
	public boolean RemoveList(String ListName) {
		
		
		return true;
	}
	
	public boolean CheckCodesExist(String list, String[] codis ) {
		
		
		
		return true;
	}
	
	public boolean CheckIfUserHasCodes(String[] codis) {
		File f = new File("C:\\Users\\Usuario\\eclipse-workspace\\Xproof\\Materials\\BD\\Users\\"+DB.UName+".txt");
		int coincidenceCounter = 0;
		for (int i = 0; i<codis.length;i++)
		{
			try {
				Scanner S = new Scanner(f);
				String data = S.nextLine();
				while(S.hasNextLine()) {
					data = S.nextLine();
					if (Integer.parseInt(data) == Integer.parseInt(codis[i]))
						{
						coincidenceCounter++;
						break;
						}
				}
				S.close();
			}
			catch(FileNotFoundException e) {
				System.out.println("Error a checkIfUserHasCodes");
			}
		}
		if (coincidenceCounter == codis.length)
			return true;
		else
			return false;
	}
}
