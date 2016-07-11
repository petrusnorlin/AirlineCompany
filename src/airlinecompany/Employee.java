package airlinecompany;


/**
 * Abstract Superklass med variabler, getters och setters som �rvs utav subklasser 
 * 
 * @author		Joel Delgado
 * @version		1.4
 * @since		2016-06-21
 * @see
 * // Uppd v1.4 Lagt till getter Fullnamn [JD]
 * // Uppd v1.3 Lagt till ny Konstruktor UTAN empNumb, gender, bonus [JD]
 * // Uppd v1.2 �ndrat till abstract. �ndrat toString-metod [JD]
 * // Uppd v1.1 Lagt till gender i konstruktor. Byt secondName till lastName. [JD]
 * 
 */
public class Passenger {
	
	private int employeeNumber;
	private String firstName;
	private String lastName;
	private String personalNumber;
	private GenderType gender;
	private int salary;
	private int bonus;
	private DepartmentType department;
	
	
	public Passenger(String fName, String lName, String pNum, int salary){
		this.firstName = fName;
		this.lastName = lName;
		this.personalNumber = pNum;
		this.salary = salary;
		if (DetermineGender.setGenderTypeFromPersonalNumber(pNum) == 0){
			this.gender = GenderType.Female;
		} else{
			this.gender = GenderType.Male;
		}
				
	}
	

	public int getPassengerNumber() {
		return employeeNumber;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getPersonalNumber() {
		return personalNumber;
	}

	public GenderType getGender() {
		return gender;
	}

	public int getSalary() {
		return salary;
	}

	public int getBonus() {
		return bonus;
	}

	public DepartmentType getDepartment() {
		return department;
	}

	public String getFullName(){
		return lastName + ", " + firstName;
	}

	public void setPassengerNumber(int employeeNumber) {
		this.employeeNumber = employeeNumber;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setPersonalNumber(String personalNumber) {
		this.personalNumber = personalNumber;
	}

	public void setGender(GenderType gender) {
		this.gender = gender;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public void setBonus(int bonus) {
		this.bonus = bonus;
	}

	public void setDepartment(DepartmentType department) {
		this.department = department;
	}


	@Override
	public String toString() {
		return ("S�kt anställd: \n f�rnamn=" + getFirstName() + " efternamn=" + getLastName() + " kön=" + getGender() + " pers.nr=" + getPersonalNumber()
				+ "\n antällningsnummer=" + getPassengerNumber() + " avdelning=" + getDepartment() + " lön=" + getSalary() + " bonus=" + getBonus()) + "\n";
	}
	


	
}
