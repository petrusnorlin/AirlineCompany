package airlinecompany;


/**
 * 
 * @author Joel Delgado, Petrus Norlin, Stanislav Izotov, Stefan Karlsson
 * @version		1.1
 * @since		2016-06-21
 * @see
 * // Uppd v1.1 Lagt till konstant NUMBER_OF_MENUCHOISES. �ndrat text i default str�ng [JD] 
 */
public class Main {

	public static void main(String[] args) {

		int choise;										// anv�ndarens menyval
		boolean exitApp = false;						// m�jligg�r avslut av proram
		final int NUMBER_OF_MENUCHOICES = 2;			// antal menyval exkl 0
		
		do {
			choise = StartMenu.mainMenu();
			System.out.println();
			switch (choise){
			
			case 0:
				exitApp = true;
				break;
			
			case 1: 
				MenuManageEmployee.showManageEmployeeMenu();
				System.out.println();
				break;
			
			case 2: 
				MenuStatistics.showStatisticMenu();
				System.out.println();
				break;
			
			default:
				System.out.println(">>> Fel inmatning! Endast siffrorna 0-" + (NUMBER_OF_MENUCHOICES) + " är giltiga. \nFörsök igen....");
				System.out.println("\n");
				break;
			}
		} while (!exitApp);
		
		
		System.out.println("Adjö! \n .... och tack för fisken.");
	}

}
