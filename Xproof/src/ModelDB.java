import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;  // Import the File class
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.List;


public class ModelDB {
	String UName;
	String UPasswd;
	
	
	public ModelDB(String UserName, String UserPasswd) {
		UName = UserName;
		UPasswd = UserPasswd;	}
	
	public boolean CheckListName(String ListName){
		File f = new File("C:\\Users\\Usuario\\eclipse-workspace\\Xproof\\Materials\\BD\\Lists\\"+ListName+".txt");
		return f.exists();
	  }
	
	public boolean DeleteCodes(String[] ListOCodes) {
		boolean ret = true;
		try {
		
		for (int i = 0; i<ListOCodes.length;i++) {
			File inputFile = new File("C:\\Users\\Usuario\\eclipse-workspace\\Xproof\\Materials\\BD\\Users\\"+UName+".txt");
			File tempFile = new File("C:\\Users\\Usuario\\eclipse-workspace\\Xproof\\Materials\\BD\\Users\\TF.txt");
			BufferedReader reader = new BufferedReader(new FileReader(inputFile));
			BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));
			String lineToRemove = ListOCodes[i];
			String currentLine;
			while((currentLine = reader.readLine()) != null) {
			    String trimmedLine = currentLine.trim();
			    if(trimmedLine.equals(lineToRemove)) continue;
				    writer.write(currentLine + System.getProperty("line.separator"));
				}
				writer.close(); 
				reader.close(); 
				if (Files.mismatch(inputFile.toPath(), tempFile.toPath()) == -1)
					ret = false;
				inputFile.delete();
				tempFile.renameTo(inputFile);
		}
		
		
		}
		catch (Exception e)
		{
			return false;
		}
		
		return ret;
	}
	
	public boolean AddCodes( String[] ListOCodes) {
		boolean repeated = false, nROnce = true;
		try {
			for (int i = 0; i<ListOCodes.length;i++)
			{
				repeated = false;
				File inputFile = new File("C:\\Users\\Usuario\\eclipse-workspace\\Xproof\\Materials\\BD\\Users\\"+UName+".txt");
				BufferedReader reader = new BufferedReader(new FileReader(inputFile));
				String lineToFind = ListOCodes[i];
				String currentLine;
				while((currentLine = reader.readLine()) != null) {
					 String trimmedLine = currentLine.trim();
					 if(trimmedLine.equals(lineToFind)) {
						 repeated = true;
						 nROnce = false;
					 } 
				}
				reader.close();
				if (!repeated) {
					 FileWriter myWriter = new FileWriter("C:\\Users\\Usuario\\eclipse-workspace\\Xproof\\Materials\\BD\\Users\\"+UName+".txt",true);
				     myWriter.write(ListOCodes[i]+System.getProperty("line.separator"));
				     myWriter.close();
				}
					
			}
		    } catch (IOException e) {
		      return false;
		    }
		return nROnce;
	}
	
	public boolean CheckUserName(){
		
		return true;
	  }
	
	public boolean CheckUserPassword() {
		
		return true;
	}
	
}



