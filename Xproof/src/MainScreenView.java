import java.util.HashMap;
import java.util.Scanner;

public class MainScreenView {
	public void UpdateListView(HashMap<String, String[]> ListMap) {
		clearScreen();
		for (String NomLlista :ListMap.keySet()) {
			System.out.print("--------------------");
			System.out.print(NomLlista);
			System.out.print(ListMap.get(NomLlista).length);
			System.out.print("--------------------");
		}
	}
	public String[] LoginView(){
		String[] def = {"",""};
		return def;
	}
	
	public String[] ReisterView(){
		String[] def = {"",""};
		return def;
	}
	
	public boolean LoginOrRegister(){
		return true;
	}
	
	public static void clearScreen() {  
	    System.out.print("\033[H\033[2J");  
	    System.out.flush();  
	}  
}
