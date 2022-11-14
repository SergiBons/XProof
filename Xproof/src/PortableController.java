import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
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
		ArrayList<String> aux = new ArrayList<String>();
					if (!Arrays.equals(ListMap.get(list), CodeList)) {
						if(AddList(list))
							ListMap.put(list, CodeList);
						else
						{
								for (int i = 0; i<CodeList.length;i++)
									aux.add(CodeList[i]);
							String[] fin = aux.toArray(new String[0]);
							ListMap.put(list, fin);
						}
					}
					else
						return false;
			ListMap.put(list, CodeList);
		
		return true;
	}
	
	public boolean RestaCodis (String list, String[] CodeList) {
		ArrayList<String> aux = new ArrayList<String>();
		int ret = 0;
		if (ListMap.get(list) == null)
			return false;
		else {
			for(int i = 0;i<ListMap.get(list).length;i++)
			{
				boolean check = false;
				for (int j = 0; j<CodeList.length;j++) {
					if (ListMap.get(list)[i].equals(CodeList[j])) {
						ret++;
						check = true;
						break;
					}
				}
				if (check == false)
					aux.add(ListMap.get(list)[i]);
			}
			if (aux.isEmpty())
			{
				RemoveList(list);
			}
			else {
				String[] fin = aux.toArray(new String[0]);
				ListMap.put(list, fin);
				}
		}
		return true;
	}
	
	
	
	
	
	
	
	
	
	
	
	//Subfuncions
	
	public boolean CheckListNameFromDatabase(String name) {
		File f = new File("C:\\Users\\Usuario\\eclipse-workspace\\Xproof\\Materials\\BD\\Lists\\"+name+".txt");
		if (f.exists()) 
			return true;
		else
			return false;
	}	
	
	public boolean AddList(String ListName) {
		if (ListMap.containsKey(ListName))
			return false;
		else {
			ListMap.put(ListName,null);
			return true;
		}
	}
	
	public boolean RemoveList(String ListName) {
		if (ListMap.containsKey(ListName)) {
			ListMap.remove(ListName);
			return true;
		}
		else
			return false;
	}
	
	public boolean CheckCodesExist(String list, String[] codis ) {
		
		File f = new File("C:\\Users\\Usuario\\eclipse-workspace\\Xproof\\Materials\\BD\\Lists\\"+list+".txt");
		int coincidenceCounter = 0;
		for (int i = 0; i<codis.length;i++)
		{
			try {
				Scanner S = new Scanner(f);
				String data = S.nextLine();
				while(S.hasNextLine()) {					
					if (data.equals(codis[i]))
						{
						coincidenceCounter++;
						break;
						}
					else
						data = S.nextLine();
				}
				S.close();
			}
			catch(FileNotFoundException e) {
				System.out.println("Error a checkCodesExist");
			}
		}
		if (coincidenceCounter == codis.length)
			return true;
		else
			return false;
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
					if (data.equals(codis[i]))
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
	
	public void UpdateUserData() {
		
		
		
	}
	
}
