/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package airlinecompany;

import dionysos.GenderType;
import java.io.Console;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.regex.PatternSyntaxException;

/**
 *
 * @author User
 */
public class Test4Exceptions {
    
	private GenderType gender;
    
	public static boolean TestIfStringIsDouble(String inputString) {//testar opm en sträng är double
            double parseddouble = 0.0;
            try {
                 parseddouble = Double.parseDouble(inputString.trim());
            }catch (Exception e)
            {
                return false;       
            }
            return true;                
	} 
        
	public static boolean TestIfStringStartIngteger(String inputString, int length)  {//testar om starten av en sträng är int
            int parsedInt = 0;
            try {
                 parsedInt = Integer.parseInt(inputString.trim().substring(0, length)); 
            }catch (Exception e)
            {
                return false;       
            }
            return true;
	} 
        
	public static GenderType getGenderTypeFromPersonalNumber(String PersonalNumber)  { //tar reda på om det är en man eller kvinna från personnumret   
                GenderType Gender;// = ;
                //String PersonalNumber = "62";
                
                char[] ch = PersonalNumber.toCharArray();
                int index = ch.length-2;
                if (ch.length <= 1){
                    return null;//System.out.println("NotValid");//return null;
                }
                else if ((ch[index] == '1')||(ch[index] == '3')||(ch[index] == '5')||(ch[index] == '7')||(ch[index] == '9')){
                    return GenderType.Male;//System.out.println("Male");//
                }
                else if ((ch[index] == '0')||(ch[index] == '2')||(ch[index] == '4')||(ch[index] == '6')||(ch[index] == '8')){
                    return GenderType.Female;//System.out.println("FeMale"+ ch[index]);//return gender.Female;
                } 
                else {
                    return null;
                }
        }
        
	public int setGenderTypeFromPersonalNumber(String PersonalNumber)  {        
                //sätter gender från personalnumber
                // returnerar 1 om allt går bra men 0 om det inte gör det
                
                char[] ch = PersonalNumber.toCharArray();
                int index = ch.length-2;
                if (ch.length <= 1){
                    return 0;//System.out.println("NotValid");//return null;
                }
                else if ((ch[index] == '1')||(ch[index] == '3')||(ch[index] == '5')||(ch[index] == '7')||(ch[index] == '9')){
                    this.gender = GenderType.Male;
                    return 1;
                }
                else if ((ch[index] == '0')||(ch[index] == '2')||(ch[index] == '4')||(ch[index] == '6')||(ch[index] == '8')){
                    this.gender = GenderType.Female;
                    return 1;
                } 
                else {
                    return 0;
                }
        }
        
        
        public static boolean isValidDate(String inDate, String DateFormatString) {
            String LocalDateFormatString = "yyyy-MM-dd";
            SimpleDateFormat dateFormat = new SimpleDateFormat(DateFormatString);
            dateFormat.setLenient(false);
            try {
              dateFormat.parse(inDate.trim());
            } catch (ParseException pe) {
              return false;
            }
            return true;
          }

	public static boolean TestIfStringIsPersonalNumber(String inputString)  {
            inputString = inputString.trim();//ta bort skit i början och slutet
            if (inputString.length()< 10){//pnr måste vara minst 10 tecken annars inget pnr
                return false; 
            }
            else if (inputString.length() == 10){//är det av typen 9005241410
                // lite test
                if (!TestIfStringStartIngteger(inputString,6))//testar om första 6 är int
                    return false;
                if (!TestIfStringStartIngteger(inputString.substring(6),4))
                    return false; 
                if (!isValidDate(inputString.substring(0,6),"yyMMdd"))//testar om första 6 är datum
                    return false;   
            }
            else if (inputString.length() == 11){//är det av typen 900524-1410
                // lite test
                if (!TestIfStringStartIngteger(inputString,6))//testar om första 6 är int
                    return false;
                if (!TestIfStringStartIngteger(inputString.substring(7, 11),4))
                    return false;                    
                if (!(inputString.substring(6, 7).equals("-")))
                    return false; 
                if (!isValidDate(inputString.substring(0,6),"yyMMdd"))//testar om första 6 är datum
                    return false;   
            }  
            else if (inputString.length() == 12){//Om den är 12 tecken är den möjligen av typen 199005241410
                // lite test
                //String Pnr = "7006261234";
                String pattern2 = "[0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9]";
                // Create a Pattern object
                Pattern r2 = Pattern.compile(pattern2);
                Matcher m2 = r2.matcher(inputString);              
                if (!(m2.lookingAt()))
                    return false;      
                if (!isValidDate(inputString.substring(0,6),"yyyyMMdd"))//testar om första 6 är datum
                    return false;                   
            }
            else if (inputString.length() == 13){//är det av typen 19900524-1410
                // lite test
                String pattern3 = "((19|20)([0-9]{6})-[0-9]{4})";
                // Create a Pattern object
                Pattern r3 = Pattern.compile(pattern3);
                Matcher m3 = r3.matcher(inputString);              
                if (!(m3.lookingAt()))
                    return false;   
                if (!isValidDate(inputString.substring(0,8),"yyyyMMdd"))//testar om första 8 är datum
                    return false;                   
            }    
            return true;
	}          


    
}
