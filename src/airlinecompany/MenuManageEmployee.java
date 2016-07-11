package airlinecompany;


/**
 * Meny f�r Personalhantering, med switschsats. Extern metod �beropas f�r anv�ndarens inmatning
 * 
 * @author		Joel Delgado
 * @version		1.2
 * @since		2016-06-21
 * @see
 * // Uppd v.1.2:	NY Personalhanteringsmeny [JD]
 * // Uppd v.1.1:	Lagt till metodanrop till samtliga menyval [JD]
 */
public class MenuManageEmployee {
	
	public final static int NUMBER_OF_MENUCHOISES = 11;	// antal menyval exkl 0
	public static int userChoise;						// anv�ndarens menyval
	static boolean exitApp = false;						// m�jligg�r avslut av proram
	
	
	/**
	 * Ritar ut Personalhanterings-meny och anropar extern metod f�r att ta emot inmatning fr�n anv�ndaren 
	 * Endast om anv�ndaren matar in v�rdet 0 som loopen avslutas och �terv�nder till startmeny
	 */
	public static void showManageEmployeeMenu() {
    	System.out.println("************************************************************");
        System.out.println("*                    Personalhantering                     *");
        System.out.println("*                                                          *");
        System.out.println("*   1. Registrera anst�lld                                 *");
        System.out.println("*   2. Radera anst�lld                                     *");
        System.out.println("*   3. Uppdatera Namn p� anst�lld                          *");
        System.out.println("*   4. Uppdatera Personnummer p� anst�lld                  *");
        System.out.println("*   5. Uppdatera Avdelning p� anst�lld                     *");
        System.out.println("*   6. Uppdatera L�n p� anst�lld                           *");
        System.out.println("*   7. S�k anst�lld p� Namn                                *");
        System.out.println("*   8. S�k anst�lld p� Personnummer                        *");
        System.out.println("*   9. S�k anst�lld p� Anst�llningsID                      *");
        System.out.println("*  10. S�k anst�lld p� Avdelning                           *");
        System.out.println("*                                                          *");
        System.out.println("*   0. �ter till huvudmenyn                                *");
        System.out.println("************************************************************");        
        System.out.println();
        
        do {
            userChoise =  MenuChoice.getUserChoise(NUMBER_OF_MENUCHOISES);
			System.out.println();
			switch (userChoise){
			
			case 0:
				exitApp = true;
				break;
			
			case 1:
				UI_ManageEmployee.addEmployee();
				break;
							
			case 2: 
				UI_ManageEmployee.removeEmployee();
				break;
				
			case 3: 
				UI_ManageEmployee.updateEmployeeName();
				break;
				
			case 4:
				UI_ManageEmployee.updateEmployeePersonalNumber();
				break;
				
			case 5: 
				UI_ManageEmployee.updateEmployeeDepartment();
				break;
				
			case 6: 
				UI_ManageEmployee.updateEmployeeSalary();
				break;
				
			case 7: 
				UI_ManageEmployee.searchEmployeeByName();
				break;
				
			case 8: 
				UI_ManageEmployee.searchEmployeeByPersonalNumber();
				break;
				
			case 9: 
				UI_ManageEmployee.searchEmployeeByEmployeeNumber();
				break;
				
			case 10: 
				UI_ManageEmployee.searchEmployeeNameByDepartment();
				break;
				
			case 11: 
				UI_ManageEmployee.listAllEmployees();
				break;
			
			default:
				System.out.println(">>> Fel inmatning! Endast siffrorna 0-" + (NUMBER_OF_MENUCHOISES) + " �r giltiga. \nF�rs�k igen....");
				System.out.println("\n");
				break;
			}
		} while (!exitApp);

    }
	
//	public static void showManageEmployeeMenu() {
//    	System.out.println("************************************************************");
//        System.out.println("*                    Personalhantering                     *");
//        System.out.println("*                                                          *");
//        System.out.println("*   1. Registrera anst�lld                                 *");
//        System.out.println("*   2. Radera anst�lld                                     *");
//        System.out.println("*   3. Uppdatera anst�lld                                  *");
//        System.out.println("*   4. Visa information om specifik anst�lld               *");
//        System.out.println("*   5. Lista samtliga anst�llda                            *");
//        System.out.println("*   6. Lista samtliga tekniker                             *");
//        System.out.println("*   7. Lista samtliga receptionister                       *");
//        System.out.println("*   8. Lista samtliga programmerare                        *");
//        System.out.println("*   9. Lista samtliga kvinnor                              *");
//        System.out.println("*  10. Lista samtliga m�n                                  *");
//        System.out.println("*                                                          *");
//        System.out.println("*   0. �ter till huvudmenyn                                *");
//        System.out.println("************************************************************");        
//        System.out.println();
//	
//	
//case 4:
//	UI_ManageEmployee.listEmployee();
//	break;
//	
//case 5: 
//	UI_ManageEmployee.listEmployees();
//	break;
//	
//case 6: 
//	UI_ManageEmployee.listAllOfDepartment("Technician");
//	break;
//	
//case 7: 
//	UI_ManageEmployee.listAllOfDepartment("Secretary");
//	break;
//	
//case 8: 
//	UI_ManageEmployee.listAllOfDepartment("Developer");
//	break;
//	
//case 9: 
//	UI_ManageEmployee.listAllOfGender("Female");
//	break;
//	
//case 10: 
//	UI_ManageEmployee.listAllOfGender("Male");
//	break;
}
