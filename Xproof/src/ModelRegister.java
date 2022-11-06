import java.io.File;  // Import the File class
import java.io.IOException;  // Import the IOException class to handle errors

public class ModelRegister {
String UName;
String UPasswd;
	public ModelRegister(String UserName, String UserPasswd) {
		 	UName = UserName;
		 	UPasswd = UserPasswd;
		  }
	
	public boolean CheckIfNameAlreadyExists() {
		File f = new File("C:\\Users\\Usuario\\eclipse-workspace\\Xproof\\Materials\\BD\\Users\\"+UName+".txt");
		if (f.exists())
			return true;
		else
			return false;
	}
	
	public String CheckNameRestrictions() {

		
		return "CORRECT";
	}
	
	
	public String CheckPasswdRestrictions() {

		
		return "CORRECT";
	}
	
	public void RegisterNewUser() {
		
	}
}
