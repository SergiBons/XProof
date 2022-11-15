import java.util.Scanner;

public class MainController {
	Scanner scanner;
	public void main(String[] args) {
		
		MainScreenView MSV = new MainScreenView();
		ModelRegister RDB = new ModelRegister();
		PortableController PC = new PortableController();
		scanner = new Scanner(System.in);
		String err = "DefaultError";
		int selector = 0;
		while(selector!= 10) {
			switch (selector) {
			case 1:
				
				selector = SelectorPick(PC, MSV);
				break;
			case 2:
				//UpdateLists
				PC = TerminalInteract(PC,0);
				selector = 1;
				break;
			default:
				//Login or Register
				MSV = new MainScreenView();
				RDB = new ModelRegister();
				PC = new PortableController();
				err = "DefaultError";
				Log_Reg(MSV,PC,RDB,err);
				selector = 1;
				break;
			}
		}
	scanner.close();
	}
	public PortableController Log_Reg(MainScreenView MSV, PortableController PC,ModelRegister RDB,String err)
	{
		boolean logged = false;
		while (!logged) {
			if(MSV.LoginOrRegister(scanner)){
				String[] UserData = MSV.LoginView(scanner);
				 if (PC.Login(UserData[0],UserData[1]))
				 {
					 logged = true;
				 }
			}
			else {
				String[] UserData = MSV.RegisterView(scanner);			
				RDB = new ModelRegister(UserData[0],UserData[1]);
				err = RDB.CheckNameRestrictions();
				if (err == "CORRECT") {
					err = RDB.CheckPasswdRestrictions();
					if (err  == "CORRECT") {
						if (!RDB.CheckIfNameAlreadyExists()) {
							RDB.RegisterNewUser();
							MSV.PrintAlertMessage("User registered Successfully");
						}
						else
							MSV.PrintAlertMessage("UserName already exists");
					}
					else
						MSV.PrintAlertMessage(err);
				}
				else
					MSV.PrintAlertMessage(err);
			}
		
		}
		PC.InitUserData();
		return PC;

	}
	public  PortableController TerminalInteract(PortableController PC,int s) {

		MockTerminalInput MTI = new MockTerminalInput(s,PC);
		if(MTI.option)
			PC.SumaCodis(MTI.lName, MTI.Codes);
		else
			PC.RestaCodis(MTI.lName, MTI.Codes);
		return PC;
	}
	
	public int SelectorPick(PortableController PC, MainScreenView MSV) {
		int selector;
		selector = 15;
		do{
			MSV.UpdateListView(PC.ListMap);
			MSV.ShowSelectorAlert();
			String PreSelect = scanner.nextLine();
			if(PreSelect.equals("0"))
				selector = 10;
			else {
				if(PreSelect.equals("1"))
					selector = 0;
				else {
					if(PreSelect.equals("2"))
						selector = 2;
					else
						MSV.PrintAlertMessage("Incorrect Input, try again");
				}
			}
		}while (selector==15);
		return selector;
	}
	public void SetScanner() {
		scanner = new Scanner(System.in);
	}
	public void CloseScanner() {
		scanner = new Scanner(System.in);
	}
}



