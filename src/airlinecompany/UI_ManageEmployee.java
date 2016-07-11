package airlinecompany;


/**
 * UI-klass f�r att testa funktioner i Personalhantering
 * 
 * @author		Joel Delgado
 * @version		2.2
 * @since		2016-06-22
 * @see
 * // Uppd v.2.2	M�jligt att s�ka anst�lld p� b�de f�r och efternamn [JD]
 * // Uppd v.2.1	Vid start fylls ArrayList med ans�llda genom metoden populateEmployeeList() [JD]
 * // Uppd v.2.0	G�tt �ver fr�n f�rdefinerade till inmatningsbara variabler [JD]
 */
public class UI_ManageEmployee {
	
	static EmployeeCatalog empCat = PopulateEmployeeList.populateEmployeeList();
	
	/**
	 * Metod f�r att l�gga till anst�llda i EmployeeCatalog.
	 * Anv�ndaren matar via konsoln in f�rnamn, efternamn, personnummer, l�n, avdelning. beroende p� 
	 * vald avdelning skapas objektet anst�lld.
	 */
	public static void addEmployee(){
		System.out.println("REGISTRERA ANST�LLD...\nAnge f�rnamn: ");
		String regFirstName = UserInput.userInputString();
		System.out.println("Ange efternamn: ");
		String regLastName = UserInput.userInputString();
		System.out.println("Ange personnummer: ");
		String regPersNumber = UserInput.userInputString();
		System.out.println("Ange l�n: ");
		int regSalary = UserInput.userInputInt();
		System.out.println("Ange avdelning (1=DBAdmin, 2=Developer, 3=Tekniker, 4=S�ljare, 5=Sekreterare, 6=Webbdesigner, 7=Chef: ");
		int regDep = UserInput.userInputInt();
		
		switch (regDep) {
			case 1:
				empCat.addEmployee(new Databaseadministrator(regFirstName, regLastName, regPersNumber, regSalary));
				break;
				
			case 2:
				empCat.addEmployee(new Developer(regFirstName, regLastName, regPersNumber, regSalary));
				break;
				
			case 3:
				empCat.addEmployee(new IT_Technician(regFirstName, regLastName, regPersNumber, regSalary));
				break;
				
			case 4:
				empCat.addEmployee(new Webdesigner(regFirstName, regLastName, regPersNumber, regSalary));
				break;
				
			case 5:
				empCat.addEmployee(new Salesman(regFirstName, regLastName, regPersNumber, regSalary));
				break;
				
			case 6:
				empCat.addEmployee(new Secretary(regFirstName, regLastName, regPersNumber, regSalary));
				break;
				
			case 7:
				empCat.addEmployee(new Manager(regFirstName, regLastName, regPersNumber, regSalary));
				break;
				
			default:
				System.out.println(">>> N�got gick fel! Ingen anv�ndare tillagd");
				break;
		}
		System.out.println(">>> Lagt till anst�lld");
	}
	
	/**
	 * Metod f�r att radera en anst�lld fr�n EmployeeCatalog.
	 * Anv�ndaren matar via konsoln in anst�llningsnummer p� person som ska raderas. Systemet visar vem som blir raderad
	 */
	public static void removeEmployee(){
		System.out.println("RADERA PERSONAL...\nAnge anst�llningsnummer p� personal du vill radera: ");
		int eraseEmpNr  = UserInput.userInputInt();
		System.out.println(">>> Raderar en anst�lld: " + empCat.searchEmployeeNr(eraseEmpNr).getFullName());
		empCat.removeEmployee(eraseEmpNr);
	}
	
	
	public static void updateEmployeeDepartment(){
		System.out.println("�NDRA AVDELNING...\nAnge anst�llningsnummer p� personal du vill byta avdelning p�: ");
		int changeEmpNr  = UserInput.userInputInt();
		System.out.println("Anst�lld " + changeEmpNr + " " + empCat.searchEmployeeNr(changeEmpNr).getFullName() + "tillh�r avdelning=" +
				empCat.searchEmployeeNr(changeEmpNr).getDepartment());
		System.out.println("Ange ny avdelning (1=DBAdmin, 2=Developer, 3=Tekniker, 4=S�ljare, 5=Sekreterare, 6=Webbdesigner, 7=Chef: ");
		int newDep = UserInput.userInputInt();
		System.out.println(">>> �ndrar avdelning....");
		switch (newDep) {
		case 1:
			empCat.searchEmployeeNr(changeEmpNr).setDepartment(DepartmentType.Databaseadministrator);
			break;
			
		case 2:
			empCat.searchEmployeeNr(changeEmpNr).setDepartment(DepartmentType.Developer);
			break;
			
		case 3:
			empCat.searchEmployeeNr(changeEmpNr).setDepartment(DepartmentType.IT_Technician);
			break;
			
		case 4:
			empCat.searchEmployeeNr(changeEmpNr).setDepartment(DepartmentType.Salesman);
			break;
			
		case 5:
			empCat.searchEmployeeNr(changeEmpNr).setDepartment(DepartmentType.Secretary);
			break;
			
		case 6:
			empCat.searchEmployeeNr(changeEmpNr).setDepartment(DepartmentType.Webdesigner);
			break;
			
		case 7:
			empCat.searchEmployeeNr(changeEmpNr).setDepartment(DepartmentType.Manager);
			break;
			
		default:
			System.out.println(">>> N�got gick fel! Ingen avdelning �ndrad");
			break;
	}
		empCat.searchEmployeeNr(changeEmpNr).setDepartment(DepartmentType.Manager);
		System.out.println("Anst�lld " + changeEmpNr + " " + empCat.searchEmployeeNr(changeEmpNr).getFullName() + "tillh�r nu avdelning=" +
				empCat.searchEmployeeNr(changeEmpNr).getDepartment());
	}
	
	/**
	 * Uppadterar namn p� anst�lld.
	 * Anv�ndaren anger anst�llningsnummer p� den vars namn ska �ndras. Inmatning g�rs av b�de nytt f�rnamn 
	 * och nytt efternamn. D�refter anropas metoderna setFirstName och setLastName genom att s�ka efter r�tt person
	 * via anst�llningsnummer i EmployeeCatalog. Slutligen visas genomf�rd �ndring i konsoln. 
	 */
	public static void updateEmployeeName(){
		System.out.println("�NDRA NAMN...\nAnge anst�llningsnummer p� personal du vill byta namn p�: ");
		int changeEmpNr  = UserInput.userInputInt();
		System.out.println("Anst�lld " + changeEmpNr + " heter nu " + empCat.searchEmployeeNr(changeEmpNr).getFullName());
		System.out.println("Ange nytt f�rnamn: ");
		String newFirstName = UserInput.userInputString();
		System.out.println("Ange nytt efternamn: ");
		String newLastName = UserInput.userInputString();
		System.out.println(">>> �ndrar namn....");
		empCat.searchEmployeeNr(changeEmpNr).setFirstName(newFirstName);
		empCat.searchEmployeeNr(changeEmpNr).setLastName(newLastName);
		System.out.println("Anst�lld " + changeEmpNr + " heter nu " + empCat.searchEmployeeNr(changeEmpNr).getFullName());
	}
	
	/**
	 * Uppadterar l�n p� anst�lld.
	 * Anv�ndaren anger anst�llningsnummer p� den vars namn l�n �ndras. Inmatning g�rs av nytt l�nebelopp. D�refter anropas 
	 * metoderna setSalary genom att s�ka efter r�tt person via anst�llningsnummer i EmployeeCatalog. Slutligen
	 * visas genomf�rd �ndring i konsoln. 
	 */
	public static void updateEmployeeSalary(){
		System.out.println("�NDRA L�N...\nAnge anst�llningsnummer p� personal du vill �ndra l�n p�: ");
		int changeEmpNr  = UserInput.userInputInt();
		System.out.println("Anst�lld " + changeEmpNr + " har en l�n p� " + empCat.searchEmployeeNr(changeEmpNr).getSalary());
		System.out.println("Ange ny l�n: ");
		int newSalary = UserInput.userInputInt();
		System.out.println(">>> �ndrar l�n....");
		empCat.searchEmployeeNr(changeEmpNr).setSalary(newSalary);
		System.out.println("Anst�lld " + changeEmpNr + " har nu en l�n p�" + empCat.searchEmployeeNr(changeEmpNr).getSalary());
	}
	
	/**
	 * Uppadterar personnummer p� anst�lld.
	 * Anv�ndaren anger anst�llningsnummer p� den vars personnummer ska �ndras. Inmatning g�rs av nytt personnummer. D�refter 
	 * anropas metoderna setPersonalNumber genom att s�ka efter r�tt person via anst�llningsnummer i EmployeeCatalog. Slutligen
	 * visas genomf�rd �ndring i konsoln. 
	 */
	public static void updateEmployeePersonalNumber(){
		System.out.println("�NDRA PERSONNUMMER...\nAnge anst�llningsnummer p� personal du vill byta personnummer p�: ");
		int changeEmpNr  = UserInput.userInputInt();
		System.out.println("Anst�lld " + changeEmpNr + ", " + empCat.searchEmployeeNr(changeEmpNr).getFullName()
				+ " har personnummer " + empCat.searchEmployeeNr(changeEmpNr).getPersonalNumber());
		System.out.println("Ange nytt personnummer: ");
		String newPersNumb = UserInput.userInputString();
		System.out.println(">>> �ndrar personnummer....");
		empCat.searchEmployeeNr(changeEmpNr).setPersonalNumber(newPersNumb);;
		System.out.println("Anst�lld " + changeEmpNr + ", " + empCat.searchEmployeeNr(changeEmpNr).getFullName()
				+ " har  nu personnummer " + empCat.searchEmployeeNr(changeEmpNr).getPersonalNumber());
	}

	/**
	 * Skapar en output som outputtar ett felmeddelande om str�ngen �r tom
	 * Petrus Norlin
	 * 160622-kl1515
	 */        
        public static void outPutMessage(String inputString){
            inputString = inputString.trim();
            inputString = inputString.replace('[',' ');
            inputString = inputString.replace(']',' ');
            inputString = inputString.trim();
            if (inputString.isEmpty())
                System.out.println(" Finns ingen data att visa!");
            else 
                System.out.println(inputString);        
	} 
	
	public static void updateEmployeeBonus(){
		System.out.println("Funktionen �r inte klar �nnu...");
	}
	
	/**
	 * S�k anst�lld p� namn.
	 * Anv�ndaren anger namn p� den anst�lld som ska s�kas. Begynnelsebokstav i inmatningen omvandlas alltid toUppercase
	 * innan s�kning f�r att minimera felsvar. Alla anst�llda som matchar s�kterm listas i konsoln. 
	 */
	public static void searchEmployeeByName(){
		System.out.println("S�K P� NAMN...\nAnge namn p� personal du vill s�ka p�: ");
		String searchEmpName  = UserInput.userInputString();
		// ta ut f�rsta bokstav i s�kord och f�rvandla toUppercase
		String firstLetter = searchEmpName.substring(0, 1);
		firstLetter = firstLetter.toUpperCase();
		// skapa Stringbuilder-objekt f�r att kunna manipulera s�kord
		StringBuilder sb = new StringBuilder(searchEmpName);
		sb.replace(0, 1, firstLetter);
		searchEmpName = sb.toString();
		System.out.println("Anst�llda vars namn b�rjar p�: " + searchEmpName + " �r: "); 
		outPutMessage(empCat.searchEmployeeNamePrefix(searchEmpName).toString());
	}
	
	/**
	 * S�k anst�lld p� personnummer.
	 * Anv�ndaren anger personnummer p� den anst�lld som ska s�kas. Alla anst�llda som matchar s�kterm listas i konsoln. 
	 */
	public static void searchEmployeeByPersonalNumber(){
		System.out.println("S�K VIA PERSONNUMMER...\nAnge personnummer p� personal du vill s�ka: ");
		String searchPersNumb  = UserInput.userInputString();
		outPutMessage(empCat.searchEmployeePnr(searchPersNumb).toString());
	}

	/**
	 * S�k anst�lld p� anst�llningsnummer.
	 * Anv�ndaren anger anst�llningsnummer p� den anst�lld som ska s�kas. Alla anst�llda som matchar s�kterm listas i konsoln. 
	 */
	public static void searchEmployeeByEmployeeNumber(){
		System.out.println("S�K VIA ANST�LLNINGSNUMMER...\nAnge anst�llningsnummer p� personal du vill s�ka: ");
		int searchEmpNumb  = UserInput.userInputInt();
		outPutMessage(empCat.searchEmployeeNr(searchEmpNumb).toString());
	}

	/**
	 * S�k anst�lld p� avdelning.
	 * Anv�ndaren anger avdelning p� den anst�lld som ska s�kas. Alla anst�llda som matchar s�kterm listas i konsoln. 
	 */
	public static void searchEmployeeNameByDepartment(){
		System.out.println("Ange avdelning du vill s�ka p� (1=DBAdmin, 2=Developer, 3=Tekniker, 4=S�ljare, 5=Sekreterare, 6=Webbdesigner, 7=Chef: ");
		int searchDep = UserInput.userInputInt();
		switch (searchDep) {
		case 1:
			outPutMessage(empCat.getEmployeesOfDepartmentType(DepartmentType.Databaseadministrator).toString());
			break;
			
		case 2:
			outPutMessage(empCat.getEmployeesOfDepartmentType(DepartmentType.Developer).toString());
			break;
			
		case 3:
			outPutMessage(empCat.getEmployeesOfDepartmentType(DepartmentType.IT_Technician).toString());
			break;
			
		case 4:
			outPutMessage(empCat.getEmployeesOfDepartmentType(DepartmentType.Salesman).toString());
			break;
			
		case 5:
			outPutMessage(empCat.getEmployeesOfDepartmentType(DepartmentType.Secretary).toString());
			break;
			
		case 6:
			outPutMessage(empCat.getEmployeesOfDepartmentType(DepartmentType.Webdesigner).toString());
			break;
			
		case 7:
			outPutMessage(empCat.getEmployeesOfDepartmentType(DepartmentType.Manager).toString());
			break;
			
		default:
			System.out.println(">>> N�got gick fel! Ingen s�dan avdelning");
			break;
		}
	}
	
	/**
	 * Listar alla anst�llda.
	 * Alla anst�llda som finns i EmployeeCatalog skrivs ut i konsoln. 
	 */
	public static void listAllEmployees(){
		System.out.println(">>> Listar alla anst�llda");
		for(int i = 1; i <=empCat.getEmployees().size(); i++)
			System.out.println(empCat.searchEmployeeNr(i));
	}
}