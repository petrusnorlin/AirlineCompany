package airlinecompany;


/**
 * Klass som utifr�n str�ngen Personalnummer best�mmer den anst�lldes k�n.
 * 
 * @author		Joel Delgado
 * @version		1.1
 * @since		2016-06-22
 * @see
 * // Uppd v1.1 Fixat bugg som skrev ut secondLastCharacter till konsol [JD]
 */
public class DetermineGender {

		/**
		 *  
		 * @param	personalNumber
		 * @return	
		 */
		public static int setGenderTypeFromPersonalNumber(String personalNumber) {
			int secondLastCharacter = Integer.parseInt(personalNumber.substring((personalNumber.length()-2), personalNumber.length()-1));
			if (secondLastCharacter%2 == 0) 
				return 0; 
			else 
				return 1;
		}
}