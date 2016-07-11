package airlinecompany;


/**
 * Meny f�r Personalstatistik, med switschsats. Extern metod �beropas f�r anv�ndarens inmatning
 * 
 * @author		Joel Delgado, Stefan Karlsson
 * @version		2.1
 * @since		2016-06-21
 * @see
 * // Uppd v.2.1:	R�ttat numrering i menyn + switch-sats [JD]
 * // Uppd v.2.0:	L�nkat menyval till metoder i Statistiklass [SK]
 * // Uppd v.1.1:	Fixat bugg som orsakade dubbelinmatning	vid start [JD]
 */
public class MenuStatistics {
	public final static int NUMBER_OF_MENUCHOICES = 6;	// antal menyval exkl 0
	public static int userChoice;						// anv�ndarens menyval
	static boolean exitApp = false;						// m�jligg�r avslut av proram

	
	/**
	 * Ritar ut Personalstatistik-meny och anropar extern metod f�r att ta emot inmatning fr�n anv�ndaren 
	 * Endast om anv�ndaren matar in v�rdet 0 som loopen avslutas och �terv�nder till startmeny
	 */
	public static void showStatisticMenu() {
		System.out.println("************************************************************");
		System.out.println("*                    Personalstatistik                     *");
		System.out.println("*                                                          *");
		System.out.println("*   1. Medell�n p� f�retaget                               *");
		System.out.println("*   2. H�gsta l�n p� f�retaget                             *");
		System.out.println("*   3. L�gsta l�n p� f�retaget                             *");
		System.out.println("*   4. Total bonus p� f�retaget                            *");
		System.out.println("*   5. Kvinnor i procent p� f�retaget                      *");
		System.out.println("*   6. M�n i procent i de olika arbetsroll kategorierna    *");
		System.out.println("*                                                          *");
		System.out.println("*   0. �ter Huvudmeny                                      *");
		System.out.println("************************************************************");
		
		do {
			userChoice =  MenuChoice.getUserChoise(NUMBER_OF_MENUCHOICES); //TODO Stefan. Snygga till utskrifter
			System.out.println();
			switch (userChoice){

			case 0:
				exitApp = true;
				break;
			
			case 1: //Average Wage
				String averageWage = String.format("%.2f", Statistic.averageWage(UI_ManageEmployee.empCat));
				System.out.println("Medell�nen p� f�retaget �r " + averageWage + ":- per m�nad ");
			    break;
							
			case 2: // Highest wage
				String highestWage = String.format("%.2f", Statistic.highestWage(UI_ManageEmployee.empCat));
				System.out.println("Den h�gsta l�nen p� f�retaget �r " + highestWage + ":- per m�nad ");
				break;
				
			case 3: //Lowest wage
				String lowestWage = String.format("%.2f", Statistic.lowestWage(UI_ManageEmployee.empCat));
				System.out.println("Den l�gsta l�nen p� f�retaget �r " + lowestWage + ":- per m�nad ");
				break;
				
			case 4: // Total bonus
				String totalBonus = String.format("%.2f", Statistic.totalbonus(UI_ManageEmployee.empCat));
				System.out.println("Den sammanlagda bonusen p� f�retaget �r " + totalBonus + ":- per m�nad ");
				break;
				
			case 5: // % women
				String percentWomen = String.format("%.2f", Statistic.departmentPeoplePercent(UI_ManageEmployee.empCat, GenderType.Female));
				System.out.println(percentWomen + "% av de anst�llda �r kvinnor");
				break;
				
			case 6: // Where do the men work in %.
				for(DepartmentType departmentType : DepartmentType.values() ){
					double percent2 = 100 * Statistic.departmentPeoplePercent(UI_ManageEmployee.empCat, departmentType, GenderType.Male);
					String stringMen = String.format("%.2f", percent2);
					if(percent2 > 0.0){ //Only prints out if bigger than 0
						System.out.println(stringMen + " % av m�nnen �r p� avdelningen " + departmentType);
					}
				}
				break;
				
			default:
				System.out.println(">>> Fel inmatning! Endast siffrorna 0-" + (NUMBER_OF_MENUCHOICES) + " �r giltiga. \nF�rs�k igen....");
				System.out.println("\n");
				break;
			}
		} while (!exitApp);
    
	}
}
