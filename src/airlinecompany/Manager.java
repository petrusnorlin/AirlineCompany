package airlinecompany;


	/**
	 * Klassen Manager �rver fr�n Super-klassen, l�gger till avdelning samt ber�knar bonus 
	 * 
	 * @author		Joel Delgado
	 * @version		1.1
	 * @since		2016-06-21
	 * @see
	 */
public class Manager extends Employee {

	public Manager(String fName, String lName, String pNum, int salary) {
		super(fName, lName, pNum,salary);
		setDepartment(DepartmentType.Manager);
	}

}
