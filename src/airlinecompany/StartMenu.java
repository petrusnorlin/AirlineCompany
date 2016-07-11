package airlinecompany;

/**
 * Meny f�r personalhanteringssystem
 * 
 * @author		Joel Delgado
 * @version		1.1
 * @since		2016-06-21
 * @see
 *	// Uppd v1.1: separerat menyerna + skapat konstant NUMBER_OF_MENUCHOICES [JD]
 */


public class StartMenu {

	public final static int NUMBER_OF_MENUCHOICES = 2;	// antal menyval exkl 0
	public static int userChoice;						// anv�ndarens menyval
		
	
		/**
		 * Ritar ut startmeny och anropar extern metod f�r att ta emot inmatning fr�n anv�ndaren 
		 * @return	userChoice
		 */
	    public static int mainMenu() {
	    	System.out.println("************************************************************");
	        System.out.println("*                 V�lkommen till Dionysos                  *");
	        System.out.println("*                 Personalhateringssystem                  *");
	        System.out.println("*                                                          *");
	        System.out.println("*   1. Personalhantering (registrera, uppdatera, radera)   *");
	        System.out.println("*   2. Personalstatistik                                   *");
	        System.out.println("*                                                          *");
	        System.out.println("*   0. Avsluta Program                                     *");
	        System.out.println("************************************************************");
	        System.out.println();
	        return userChoice =  MenuChoice.getUserChoise(NUMBER_OF_MENUCHOICES);
	    }

}


