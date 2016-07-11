package airlinecompany;

import java.util.ArrayList;

/**
 * @author Stefan Elmgren
 * Version 1.09 2016-06-22 13:00
 * Version 1.08 2016-06-22 11:42
 * Version 1.07 2016-06-21 17:55
 * Version 1.06 2016-06-21 14:32
 * Version 1.05 2016-06-21 12:35
 * Version 1.04 2016-06-21 11:11
 * Version 1.03 2016-06-21 10:59
 * Version 1.02 2016-06-21 08:54
 * Version 1.01 2016-06-20 20:24
 * Version 1.01 2016-06-20 16:30
 */
public class Statistic {

   //**************************************************************************
    /**
   * Calculates average wage 
   * @param employeeCatalog A ArrayList of type EmployeeCatalog 
   * @return double
   * @throws java.lang.Exception
   */  
    public static double averageWage(EmployeeCatalog employeeCatalog){
        double averageWage = 0;
        double sumWages = 0;
             
        ArrayList<Employee> employees = employeeCatalog.companyEmployees;
        int nrOfEmployees = employees.size();
        
        // loopa genom alla employees och lägg till wage i sumWages
        for(Employee employee : employees){
            sumWages += employee.getSalary();
        }
        
        try{
            if(nrOfEmployees == 0){
                throw new ArithmeticException("Nolldivision. Antal anställda är noll");
            }
            
            if(sumWages == 0){
                throw new ArgFailureException("Sammanlagd lön är noll");
            }
                        
        averageWage = sumWages / nrOfEmployees;
        }
        catch(ArithmeticException e){
            System.out.print(e.getMessage() + ". ");
        }
        catch(ArgFailureException e){
            
        }

        return averageWage;
    }
    
    //**************************************************************************
     /**
   * Calculates the highest wage 
   * @param employeeCatalog A ArrayList of type EmployeeCatalog 
   * @return double
   */  
    public static double highestWage(EmployeeCatalog employeeCatalog){
        double highestSalary = 0;
        ArrayList<Employee> employees = employeeCatalog.companyEmployees;
        
        try{
            for(Employee employee : employees){
                if(employee.getSalary()> highestSalary){
                    highestSalary = employee.getSalary();
                } 
            }

            if(highestSalary == 0 || employees.isEmpty() ){
                throw new ArgFailureException("Något gick fel. Högsta lön och/eller antal anställda är noll");
            }
        }
        catch(ArgFailureException e){
            
        }
            
        return highestSalary;
    }
    
    //**************************************************************************
     /**
   * Calculates the lowestSalary wage 
   * @param employeeCatalog A ArrayList of type EmployeeCatalog 
   * @return double
   */  
    public static double lowestWage(EmployeeCatalog employeeCatalog){
        double salaryStartLevel = 10000000;
        double lowestSalary = salaryStartLevel;
        
        ArrayList<Employee> employees = employeeCatalog.companyEmployees;
                
        try{
            for(Employee employee : employees){
                if(employee.getSalary()< lowestSalary){
                    lowestSalary = employee.getSalary();
                } 
            }
            
            if(lowestSalary == salaryStartLevel || employees.isEmpty() ){
                throw new ArgFailureException("Något gick fel. Lägsta lön blev ej satt, och/eller antal anställda är noll");
            }
        }
        catch(ArgFailureException e){
            
        }
                
        return lowestSalary;
    }
    
    //**************************************************************************
     /**
   * Calculates the total bonus
   * @param employeeCatalog A ArrayList of type EmployeeCatalog
   * @return double
   */  
    public static double totalbonus(EmployeeCatalog employeeCatalog){
        double totBonus = 0;
        
        ArrayList<Employee> employees = employeeCatalog.companyEmployees;
        int nrOfEmployees = employees.size();
        
        for(Employee employee : employees){
            totBonus += employee.getBonus();
        }
        
        return totBonus;
    } 
    
   //*************************************************************************** 
     /**
   * Calculates the percentage of people in the company working in a certain 
   * department For example how many employees working as developer in 
   * percent in comparison to total employees in the company
   * @param employeeCatalog A ArrayList of type EmployeeCatalog 
   * @param departmentType enum DepartmentType, for example Developer,
   * Webdesigner, Databaseadministrator, Receptionist, Manager...
   * @return double
   */  
   public static double departmentPeoplePercent(EmployeeCatalog employeeCatalog, DepartmentType departmentType){
        double percentage = 0;
        int peopleInThisDepartment = 0;
        
        try{
            ArrayList<Employee> employees = employeeCatalog.companyEmployees;
            int nrOfEmployees = employees.size();

            for(Employee employee : employees){
                if(employee.getDepartment() == departmentType){
                    peopleInThisDepartment++;
                }
            }
            
            if(nrOfEmployees == 0){
                throw new ArithmeticException("Nolldivision. Antal anställda är noll");
            }
            
            percentage = (double)peopleInThisDepartment / (double)nrOfEmployees;
        }
        catch(ArithmeticException e){
            System.out.print(e.getMessage() + ". ");
        }
        
        return percentage;
    }
   
   //***************************************************************************
    /**
   * Calculates the percentage of people in the company of a certain gender 
   * @param employeeList ArrayList of type EmployeeCatalog 
   * @param genderType enum of GenderType
   * @return double
   */  
   public static double departmentPeoplePercent(EmployeeCatalog employeeList, GenderType genderType){
        System.out.println("Hejs 5");////////////////////////////////////////////////////
        double percentage = 0;
        int peopleOfCorrectGender = 0;
        
        ArrayList<Employee> employees = employeeList.companyEmployees;
        
        
        try{
            int nrOfEmployees = employees.size();
            
            if(nrOfEmployees == 0){
                throw new ArithmeticException("Nolldivision. Antal anställda är noll");
            }
            
            for(Employee employee : employees){
                if(employee.getGender() == genderType){
                    peopleOfCorrectGender++;
                }
            }
            
            percentage = 100 * (double)peopleOfCorrectGender / (double)nrOfEmployees;
        }
        catch(ArithmeticException e){
            System.out.print(e.getMessage() + ". ");
        }
        
        return percentage;
    }
   
   //***************************************************************************
    /**
   * Calculates the percentage of people in the company of a certain gender 
   * working in a certain department. 
   * For example how many men employees working as developer in 
   * percent in comparison to total employees in the company
   * @param employeeList ArrayList of type EmployeeCatalog 
   * @param departmentType enum DepartmentType, for example Developer,
   * Webdesigner, Databaseadministrator, Receptionist, Manager...
   * @param genderType enum of GenderType
   * @return double
   */  
   public static double departmentPeoplePercent(EmployeeCatalog employeeList, DepartmentType departmentType, GenderType genderType){
        double percentage = 0;
        ArrayList<Employee> employees = employeeList.companyEmployees;
        int peopleInThisDepartmentOfCorrectGender = 0;
        
        try{
            int nrOfEmployees = employees.size();
            
            if(nrOfEmployees == 0){
                throw new ArithmeticException("Nolldivision. Antal anställda är noll \n");
            }

            for(Employee employee : employees){
                if(employee.getDepartment() == departmentType && employee.getGender() == genderType){
                    peopleInThisDepartmentOfCorrectGender++;
                }
            }

            percentage = (double)peopleInThisDepartmentOfCorrectGender / (double)nrOfEmployees;
        }
        catch(ArithmeticException e){
            System.out.print(e.getMessage() + ". ");
        }
            
        return percentage;
    }
      
   /**
   * Calculates the percentage of women
   * @author Petrus
   * @param employeeList A ArrayList of type EmployeeList 
   * @return double
   */  
    public static double percentGender(GenderType gender, boolean genderIrrelevant, DepartmentType employeeType, boolean employeeTypeIrrelevant, ArrayList<Employee> employeeList){
        double perc = 0.0;
        int nrOfEmployeesOfType = 0;
        int nrOfGenderType = 0;

        for(Employee employee : employeeList){
            if(employeeTypeIrrelevant){                
                nrOfEmployeesOfType++;
                if(genderIrrelevant){                
                    nrOfGenderType++;
                }
                else if(employee.getGender() == gender){                
                    nrOfGenderType++;
                }                
            }
            else if(employee.getDepartment() == employeeType){                
                nrOfEmployeesOfType++;
                if(genderIrrelevant){                
                    nrOfGenderType++;
                }
                else if(employee.getGender() == gender){                
                    nrOfGenderType++;
                }                 
            }
        }
        
        perc = (double)nrOfGenderType/(double)nrOfEmployeesOfType;
        
        return perc;
    }

    private static class ArgFailureException extends Exception{

        public ArgFailureException(String str) {
            System.out.print(str + ". ");
        }
    }
}
    
