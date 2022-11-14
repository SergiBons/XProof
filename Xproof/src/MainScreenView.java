import java.util.HashMap;
import java.util.Scanner;

public class MainScreenView {
	public void UpdateListView(HashMap<String, String[]> ListMap) {
		clearScreen();
		System.out.print("------Welcome-------\n");
		for (String NomLlista :ListMap.keySet()) {
			System.out.print("--------------------\n");
			System.out.print(NomLlista);
			System.out.print("\nPoints: ");
			System.out.print(ListMap.get(NomLlista).length);
			System.out.print("\n--------------------\n");
		}
	}
	
	
	public void PrintAlertMessage(String Message) {
		System.out.print("\n------------------------\n");
		System.out.print("--------");
		System.out.print(Message);
		System.out.print("--------");
		System.out.print("\n------------------------\n");
	}
	public String[] LoginView(){
		Scanner scanner = new Scanner(System.in);
		clearScreen();
		System.out.print("\n----PLEASE LOG IN-------\n");
		System.out.print("\nUserName:");
		String UserName = scanner.nextLine();
		System.out.print("\nPassword:");
		String Passwd = scanner.nextLine();
		scanner.close();
		System.out.print("\nAttempting log in\n");
		System.out.print(".\n");
		System.out.print(".\n");
		System.out.print(".\n");
		String[] aux = {UserName,Passwd};
		return  aux;
	}
	
	public String[] RegisterView(){
		Scanner scanner = new Scanner(System.in);
		clearScreen();
		System.out.print("\n----PLEASE ENTER YOUR DATA-------\n");
		System.out.print("\n UserName:");
		String UserName = scanner.nextLine();
		System.out.print("\n Password:");
		String Passwd = scanner.nextLine();
		scanner.close();
		System.out.print("\nRegistering\n");
		System.out.print(".\n");
		System.out.print(".\n");
		System.out.print(".\n");
		String[] aux = {UserName,Passwd};
		return  aux;
	}
	
	public boolean LoginOrRegister(){
		Scanner scanner = new Scanner(System.in);
		clearScreen();
		System.out.print("----Log in or Register as user? (L/*)-------\n");
		String LR = scanner.nextLine();
		scanner.close();
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
