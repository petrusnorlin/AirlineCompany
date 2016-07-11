package airlinecompany;

/**
 * Klass vars funktion �r att befolka anst�llningslistan
 * 
 * @author Joel Delgado
 * @version		1.0
 * @since		2016-06-21
 * @see
 * 
 */
public class PopulateEmployeeList {
	
	
	public static EmployeeCatalog populateEmployeeList(){
		
		EmployeeCatalog  empCat = new EmployeeCatalog();
		
		Employee emp1 = new Databaseadministrator("Joel", "Delgado", "197106081832", 32000);
		Employee emp2 = new IT_Technician("Petrus", "Norlin", "196106081832", 27000);
		Employee emp3 = new Webdesigner("Stanis", "Izotov", "198106081832",  35000);
		Employee emp4 = new Developer("Stefan", "Karlsson", "197106081832", 35000);
		Employee emp5 = new Secretary("Anna", "Andersson", "199106081822", 15000);
		Employee emp6 = new Secretary("Matilda", "Klasson", "198106081822", 12000);
		Employee emp7 = new Salesman("Anders", "Johansson", "198106081832", 25000, 12, 1200);
		Employee emp8 = new Salesman("Tanja", "Bergqkvist", "198106081832", 28500, 1000, 5);
		Employee emp9 = new Developer("Mats", "Svensson", "198106081832", 35800);
		Employee emp10 = new Manager("Karl", "�kesson", "195106081832", 65000);
				
			
		empCat.addEmployee(emp1);
		empCat.addEmployee(emp2);
		empCat.addEmployee(emp3);
		empCat.addEmployee(emp4);
		empCat.addEmployee(emp5);
		empCat.addEmployee(emp6);
		empCat.addEmployee(emp7);
		empCat.addEmployee(emp8);
		empCat.addEmployee(emp9);
		empCat.addEmployee(emp10);
		
		return empCat;
	}
}
