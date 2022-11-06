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
		if (UName.length() > 1)
			if (UName.length() < 20)
				return "CORRECT";
			else
				return "NAME TOO LONG";
		else 
			return "NAME TOO SHORT";
	}
	
	
	public String CheckPasswdRestrictions() {
		if (UPasswd.length() > 5)
			return "CORRECT";
		else 
			return "PASSWD TOO SHORT";
	}
	
	
	public void RegisterNewUser() {
		
	}
}
