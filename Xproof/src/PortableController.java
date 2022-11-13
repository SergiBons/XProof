import java.util.HashMap;

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
	
	public void Login(String Uname, String UPasswd) {
		
		
	}
	
	//Funcions principals

	public boolean AddToList(String list, int[] CodeList){
		
		
		return true;
	}
	
	public boolean RemoveFromList (String list, int[] CodeList) {
		
		
		
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
	
	public boolean SumaCodis(String list, String[] codis ) {
		
		
		
		return true;
	}
	
	public boolean RestaCodis(String list, String[] codis ) {
		
		
		
		return true;
	}
	
	public boolean CheckCodesExist(String list, String[] codis ) {
		
		
		
		return true;
	}
	
}
