import java.io.File;  // Import the File class
import java.io.IOException;  // Import the IOException class to handle errors
import java.io.FileWriter;   // Import the FileWriter class


public class ModelRegister {
String UName = "unlogged";
String UPasswd = "unlogged";

	public ModelRegister() {
	  }
	
	public ModelRegister(String UserName, String UserPasswd) {
		 	UName = UserName;
		 	UPasswd = UserPasswd;
		  }
	
	public boolean CheckIfNameAlreadyExists() {
		File f = new File("C:\\Users\\Usuario\\eclipse-workspace\\Xproof\\Materials\\BD\\Users\\"+UName+".txt");
		if (f.exists()) {
			return true;
		}
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
		if (UPasswd.length() >= 5)
			return "CORRECT";
		else 
			return "PASSWD TOO SHORT";
	}
	
	
	public String RegisterNewUser() {
		String CE = "CORRECT";
		File f = new File("C:\\Users\\Usuario\\eclipse-workspace\\Xproof\\Materials\\BD\\Users\\"+UName+".txt");
	    try {
		f.createNewFile();
	    }
	    catch(IOException e) {
	    	CE = "CAN NOT CREATE FILE";
	    }
	    try {
	        FileWriter myWriter = new FileWriter("C:\\Users\\Usuario\\eclipse-workspace\\Xproof\\Materials\\BD\\Users\\"+UName+".txt");
	        myWriter.write(UPasswd);
	        myWriter.close();
	      } catch (IOException e) {
	        CE = "CAN NOT WRITE TO FILE";
	      }
		return CE;

	}
	
	public Boolean DeleteRegisteredUser() {
		File f = new File("C:\\Users\\Usuario\\eclipse-workspace\\Xproof\\Materials\\BD\\Users\\"+UName+".txt");
		if (f.exists()) {
			System.gc();
			if (f.delete())
				return true;
			else
				//not permission to delete file
				return false;
		}
		return false;
	}
	
}
