import java.util.HashMap;

public class PortableController {

	
	HashMap<String, int[]> ListMap;
	
	public PortableController() {
		ListMap = new HashMap<String, int[]>();
		
	}
	
	public PortableController(String ListName)
	{
		ListMap = new HashMap<String, int[]>();
		ListMap.put(ListName, null);
		
	}
	
	public PortableController(String ListName, int[] CodeList)
	{
		ListMap = new HashMap<String, int[]>();
		ListMap.put(ListName, CodeList);
		
		
	}
	
	public PortableController(String[] ListOLists, int[][] ListOCodeList) {
		ListMap = new HashMap<String, int[]>();
		for(int i = 0; i < ListOLists.length; i++) 
		{
			ListMap.put(ListOLists[i], ListOCodeList[i]);
		}
		
		
		
		
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
	
	public boolean SumaCodis(String list, int[] codis ) {
		
		
		
		return true;
	}
	
	public boolean RestaCodis(String list, int[] codis ) {
		
		
		
		return true;
	}
	
	
}
