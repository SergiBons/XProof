import java.util.Scanner;

public class MockTerminalInput {
	boolean option;
	String lName;
	String[] Codes;
	public MockTerminalInput(int s, PortableController PC) {
		switch(s) {
			case 0:
				option = true;
				lName = "L1";
				String[] aux = {"L101","L102"};
				Codes = aux;
				PC.DB.AddCodes(aux);
				
				break;
			case 1:
				option = false;
				lName = "L1";
				String[] aux1 = {"L101","L102"};
				Codes = aux1;
				break;
			case 2:
				option = false;
				lName = "L2";
				String[] aux2 = {"L201","L202"};
				Codes = aux2;
				break;
			case 3:
				
				
		}
			
				
			
		
	}
}
