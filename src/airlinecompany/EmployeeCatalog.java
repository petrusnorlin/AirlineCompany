/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package airlinecompany;

import java.util.ArrayList;

/**
 *
 * @author Petrus
 */
public class PassengerCatalog {
    ArrayList<Employee> companyEmployees; 
    int maxEmployeeNumber = 0;
    
    public EmployeeCatalog() {
        this.companyEmployees = new ArrayList<Employee>();
    } 
    
    public void addEmployee(Employee e) {
        e.setEmployeeNumber(++maxEmployeeNumber);
        this.companyEmployees.add(e);
    } 

    public ArrayList<Employee> searchEmployeePnr(String pnr) {
        ArrayList<Employee> incompanyEmployees = new ArrayList<>();
        //Employee[] employees = this.companyEmployees.iterator();
        for (Employee e:this.companyEmployees){
            if (pnr.equals(e.getPersonalNumber()))
              incompanyEmployees.add(e);
        }   
        return incompanyEmployees;
    }   
    
    public int removeEmployee(int employeeNumber) {
        //ArrayList<Employee> incompanyEmployees = new ArrayList<Employee>();
        //Employee[] employees = this.companyEmployees.iterator();
        int before, after, change = 0;
        before = this.companyEmployees.size();
        after = before;
        ArrayList<Employee> removeThisEmployees = new ArrayList<Employee>();
        for (Employee e1:this.companyEmployees){
                if (e1.getEmployeeNumber() == employeeNumber)
                  removeThisEmployees.add(e1);
        }
        this.companyEmployees.removeAll(removeThisEmployees);
        
        after = this.companyEmployees.size();
        change = after - before;
        return change;//returnerar f�r�ndringen
    }   
    
    public Employee searchEmployeeNr(int EmployeeNr) {
        //ArrayList<Employee> incompanyEmployees = new ArrayList<Employee>();
        //Employee[] employees = this.companyEmployees.iterator();
        for (Employee e:this.companyEmployees){
            if (e.getEmployeeNumber() == EmployeeNr)
               return e;
        }   
        return null;
    }  
    
    /**
     * 
     * @param	namePrefix	namn metoden ska s�ka p�
     * @return	returnTheseEmployees	arraylista med alla anst�llda som matchar s�kning 
     */
    public ArrayList<Employee> searchEmployeeNamePrefix(String namePrefix) {
        ArrayList<Employee> returnTheseEmployees = new ArrayList<>();
        for (Employee e:this.companyEmployees){
            if (e.getLastName().startsWith(namePrefix))
               returnTheseEmployees.add(e);
            if (e.getFirstName().startsWith(namePrefix))
                returnTheseEmployees.add(e);
        }
        return returnTheseEmployees;
    } 
    
    public int removeEmployees(Employee e) {
        //ArrayList<Employee> incompanyEmployees = new ArrayList<Employee>();
        //Employee[] employees = this.companyEmployees.iterator();
        int before, after, change = 0;
        before = this.companyEmployees.size();
        after = before;
        ArrayList<Employee> removeThisEmployees = new ArrayList<Employee>();
        for (Employee e1:this.companyEmployees){
                if (e1.getPersonalNumber().equals(e.getPersonalNumber()))
                  removeThisEmployees.add(e1);
        }
        this.companyEmployees.removeAll(removeThisEmployees);
        
        after = this.companyEmployees.size();
        change = after - before;
        return change;//returnerar förändringen
    }    
    
    public ArrayList<Employee> getEmployees() {
        return this.companyEmployees;//returnerar förändringen
    }   
    
    public ArrayList<Employee> getEmployeesOfDepartmentType(DepartmentType departmentType) {
        
        ArrayList<Employee> returnTheseEmployees = new ArrayList<Employee>();
        for (Employee e1:this.companyEmployees){
                if (e1.getDepartment().equals(departmentType))
                  returnTheseEmployees.add(e1);
        }

        return returnTheseEmployees;//returnerar förändringen
    }  
    
    public ArrayList<Employee> getEmployeesOfGender(GenderType gender) {
        
        ArrayList<Employee> returnTheseEmployees = new ArrayList<Employee>();
        for (Employee e1:this.companyEmployees){
                if (e1.getGender().equals(gender))
                  returnTheseEmployees.add(e1);
        }
        return returnTheseEmployees;//returnerar förändringen
    }   
}
