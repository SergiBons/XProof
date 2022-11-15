import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
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
		try {
			if (f.exists()) {
				BufferedReader brTest = new BufferedReader(new FileReader("C:\\Users\\Usuario\\eclipse-workspace\\Xproof\\Materials\\BD\\Users\\"+UName+".txt"));
			    String data = brTest.readLine();
			    brTest.close();
					if (data.equals(UPasswd)) {
						DB.UName = UName;
						DB.UPasswd = UPasswd;
						return true;
					}
			}
			}catch(Exception e) {}
		
		return false;
	}
		
	
	//Funcions principals

	public boolean SumaCodis(String list, String[] CodeList){
		ArrayList<String> aux = new ArrayList<String>();
		if(CheckListNameFromDatabase(list)) {
			if(CheckCodesExist(list, CodeList))
			{
				if(CheckIfUserHasCodes(CodeList))
				{
					if (!Arrays.equals(ListMap.get(list), CodeList)) {
						if(AddList(list))
							ListMap.put(list, CodeList);
						else
						{
						if(ListMap.get(list) != null)
						{
							for (int i = 0; i<ListMap.get(list).length;i++) 
								aux.add(ListMap.get(list)[i]);
							for (int i = 0; i<CodeList.length;i++)
								aux.add(CodeList[i]);
						}
						else
						
								for (int i = 0; i<CodeList.length;i++)
									aux.add(CodeList[i]);
							String[] fin = aux.toArray(new String[0]);
							ListMap.put(list, fin);
							}
						return true;
					}
					else
						return false;
				}
				else
					return false;
			}
			else
				return false;
		}
		else
			return false;
	}
	
	public boolean RestaCodis (String list, String[] CodeList) {
		ArrayList<String> aux = new ArrayList<String>();
		int ret = 0;
		if (ListMap.get(list) == null)
			return false;
		else
		for(int i = 0;i<ListMap.get(list).length;i++){
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
			RemoveList(list);
		else {
			String[] fin = aux.toArray(new String[0]);
			ListMap.put(list, fin);
		}
		if (ret == CodeList.length)
			return true;
		else 
			return false;
	}

	
	
	
	
	
	
	
	
	
	
	
	//Subfuncions (lowLevelClasses)
	
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
	
	public void InitUserData() {
			try {
			BufferedReader brTest = new BufferedReader(new FileReader("C:\\Users\\Usuario\\eclipse-workspace\\Xproof\\Materials\\BD\\Users\\"+DB.UName+".txt"));
		    	String data = brTest.readLine();
		    	while(data != null) {
		    		data = brTest.readLine();
			    	if(data == null)
			    		break;
					int EndOfName = data.indexOf("0");
					String LName = data.substring(0, EndOfName);
					String[] aux = {data};
				
				SumaCodis(LName,aux);
					}
		    	brTest.close();
		    }catch(Exception e) {};
		}
		
	}
	
