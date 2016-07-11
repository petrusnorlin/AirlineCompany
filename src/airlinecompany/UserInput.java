package airlinecompany;

import java.util.Scanner;

/**
 * Klass som m�jligg�r anvndarens inmatning
 * 
 * @author		Joel Delgado
 * @version		1.0
 * @since		2016-06-21
 * @see
 */
public class UserInput {

	public static String userInputString(){
		String input="";
		Scanner in = new Scanner(System.in);
		input = in.nextLine();
		return input;
	}
	
	public static int userInputInt(){
            Integer input=0;
            Scanner in = new Scanner(System.in);
            if (in.hasNextInt()) {// kontrollerar att inputen är en integer
                input = in.nextInt();
                in.nextLine();
                //System.out.println("resultat:"+input);
                return input;
            }
            else {
                System.out.println("inputen var inte en integer");
                return (Integer) null;
            }
	}
}
