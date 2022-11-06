import java.io.File;  // Import the File class
import java.util.HashMap;


public class ModelDB {
	String UName = "Unlogged";
	String UPasswd = "Unlogged";
	
	
	public ModelDB(String UserName, String UserPasswd) {
		UName = UserName;
		UPasswd = UserPasswd;
	}
	
	public boolean CheckListName(String ListName){

		return true;
	  }
	
	
	public boolean DeleteCodes(String ListName, int[] ListOCodes) {
		
		return true;
	}
	
	public boolean AddCodes(String ListName, int[] ListOCodes) {
		
		return true;
	}
	
	public boolean CheckUserName(String UserName){

		return true;
	  }
	
	public boolean CheckUserPassword(String UserPasswd) {
		
		return true;
	}
	
}
