import java.util.HashMap;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class MainScreenView {
	public void UpdateListView(HashMap<String, String[]> ListMap) {
		try{TimeUnit.SECONDS.sleep(1);
		}catch(Exception e) {}
		clearScreen();
		System.out.print("------Welcome-------\n");
		int i = 0;
		for (String NomLlista :ListMap.keySet()) {
			System.out.print("--------------------\n");
			System.out.print(NomLlista);
			System.out.print("\nPoints: ");
			System.out.print(ListMap.get(NomLlista).length);
			System.out.print("\n--------------------\n");
			i++;
			if(i==10) {
				break;
				}
			}
		}
	
	
	public void PrintAlertMessage(String Message) {
		try{TimeUnit.SECONDS.sleep(1);
		}catch(Exception e) {}
		System.out.print("\n------------------------\n");
		System.out.print("--------");
		System.out.print(Message);
		System.out.print("--------");
		System.out.print("\n------------------------\n");

	}
	public String[] LoginView(Scanner scanner){
		try{TimeUnit.SECONDS.sleep(1);
		}catch(Exception e) {}
		clearScreen();
		System.out.print("\n----PLEASE LOG IN-------\n");
		System.out.print("\nUserName:");
		String UserName = scanner.nextLine();
		System.out.print("\nPassword:");
		String Passwd = scanner.nextLine();
		System.out.print("\nAttempting log in\n");
		System.out.print(".\n");
		System.out.print(".\n");
		System.out.print(".\n");
		String[] aux = {UserName,Passwd};
		
		return  aux;
	}
	
	public String[] RegisterView(Scanner scanner){
		try{TimeUnit.SECONDS.sleep(1);
		}catch(Exception e) {}
		clearScreen();
		System.out.print("\n----PLEASE ENTER YOUR DATA-------\n");
		System.out.print("\n UserName:");
		String UserName = scanner.nextLine();
		System.out.print("\n Password:");
		String Passwd = scanner.nextLine();
		System.out.print("\nRegistering\n");
		System.out.print(".\n");
		System.out.print(".\n");
		System.out.print(".\n");
		String[] aux = {UserName,Passwd};
		return  aux;
	}
	
	public boolean LoginOrRegister(Scanner scanner){
		clearScreen();
		System.out.print("----Log in or Register as user? (L/*)-------\n");
		String LR = scanner.nextLine();
		if(LR.startsWith("L"))
			return  true;
		else
			if(LR.startsWith("l"))
				return  true;
			return false;
	}
	
	public static void clearScreen() {  
	    System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n");  
	    System.out.flush();  
	}  
	
	public void ShowSelectorAlert() {
		PrintAlertMessage("What would you like to do next?\n");
		PrintAlertMessage("Insert Number:");
		PrintAlertMessage("0:Exit Program\n");
		PrintAlertMessage("1:Log Out\n");
		PrintAlertMessage("2:Interact With Terminal\n");
		
		
		
	}
	
}
