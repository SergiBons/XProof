import java.util.HashMap;
import java.util.Scanner;

public class MainScreenView {
	public void UpdateListView(HashMap<String, String[]> ListMap) {
		clearScreen();
		for (String NomLlista :ListMap.keySet()) {
			System.out.print("--------------------\n");
			System.out.print(NomLlista);
			System.out.print(ListMap.get(NomLlista).length);
			System.out.print("--------------------\n");
		}
	}
	public String[] LoginView(){
		Scanner scanner = new Scanner(System.in);
		clearScreen();
		System.out.print("----PLEASE LOG IN-------\n");
		System.out.print("\nUserName:");
		String UserName = scanner.nextLine();
		System.out.print("\nPassword:");
		String Passwd = scanner.nextLine();
		scanner.close();
		System.out.print("Attempting log in\n");
		System.out.print(".\n");
		System.out.print(".\n");
		System.out.print(".\n");
		String[] aux = {UserName,Passwd};
		return  aux;
	}
	
	public String[] RegisterView(){
		Scanner scanner = new Scanner(System.in);
		clearScreen();
		System.out.print("----PLEASE ENTER YOUR DATA-------\n");
		System.out.print("\n UserName:");
		String UserName = scanner.nextLine();
		System.out.print("\n Password:");
		String Passwd = scanner.nextLine();
		scanner.close();
		System.out.print("Registering\n");
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
	    System.out.print("\033[H\033[2J");  
	    System.out.flush();  
	}  
}
