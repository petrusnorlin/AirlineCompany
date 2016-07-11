/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package airlinecompany;

/**
 *
 * @author User
 */
public class Salesman extends Employee{
        int numberOfObjectsSold = 0;

    Salesman(String fName, String lName, String pNum, int salary) {
		super(fName, lName, pNum, salary);
		setDepartment(DepartmentType.Salesman);
    }
    
    Salesman(String fName, String lName, String pNum, int salary, int numberOfObjectsSold, int comissionsalary) {
		super(fName, lName, pNum, salary);
		super.setDepartment(DepartmentType.Salesman);
                this.comissionsalary = comissionsalary;
                this.numberOfObjectsSold = numberOfObjectsSold;
    }    


    public int getNumberOfObjectsSold() {
        return numberOfObjectsSold;
    }

    public void setNumberOfObjectsSold(int numberOfObjectsSold) {
        this.numberOfObjectsSold = numberOfObjectsSold;
    }

    public int getComissionsalary() {
        return comissionsalary;
    }

    public void setComissionsalary(int comissionsalary) {
        this.comissionsalary = comissionsalary;
    }
        int comissionsalary = 0;
/*    
    	public Salesman(String fName, String lName, String pNum, GenderType gend, int empID, DepartmentType dep, int salary, int bonus){
                super(fName, lName, pNum, gend, empID, DepartmentType.Salesman, salary, bonus);
                this.comissionsalary = 0;
                this.numberOfObjectsSold = 0;
	}
        
    	public Salesman(String fName, String lName, String pNum, GenderType gend, int empID, DepartmentType dep, int salary, int bonus, int comissionsalary, int numberOfObjectsSold){
                super(fName, lName, pNum, gend, empID, DepartmentType.Salesman, salary, bonus);
                this.comissionsalary = comissionsalary;
                this.numberOfObjectsSold = numberOfObjectsSold;
	}        
*/        
        @Override
	public int getBonus() {
                //updaterar varenda gång man hämtar bonus
                int bonus = comissionsalary *  numberOfObjectsSold;
                super.setBonus(bonus);
		return super.getBonus();
	}
	
        @Override
	public void setBonus(int bonus) {
		//super.setBonus(bonus);
                System.out.println("Du kan inte sätta denna parameter i Salesmanklassen den sätts av comissionsalary *  numberOfObjectsSold");
	}
    
}
