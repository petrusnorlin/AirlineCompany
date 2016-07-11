package airlinecompany;


/**
 * Klassen Databaseadministrator �rver fr�n Super-klassen, l�gger till avdelning samt ber�knar bonus 
 * 
 * @author		Joel Delgado
 * @version		1.1
 * @since		2016-06-21
 * @see
 *  // Uppd v.1.1	Tagit bort on�diga parametrar fr�n konstruktor [JD] 
 */
public class Databaseadministrator extends Employee {

	public Databaseadministrator(String fName, String lName, String pNum, int salary) {
		super(fName, lName, pNum, salary);
		setDepartment(DepartmentType.Databaseadministrator);
	}

}
