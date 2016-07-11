package airlinecompany;
import java.util.InputMismatchException;
import java.util.Scanner;


/**
 * Klass f�r att motta anv�ndarens menyval 
 * 
 * @author		Joel Delgado
 * @version		1.0
 * @since		2016-06-20
 * @see
 */
public class MenuChoice {
		
	static Scanner in = new Scanner(System.in);
	static int userChoise;
	
	public static int getUserChoise(int numbChoices){
		while (true){
			try {
				System.out.printf("V�lj ett av alternativen 0-%d: ", numbChoices);
				userChoise = in.nextInt();
				in.nextLine();
				break;
			} catch (InputMismatchException e){
				System.out.println(">>> Endast heltal accepteras, f�rs�k igen <<<");
				in.nextLine();
			}
		}
		return userChoise;
	}
		                           
}

