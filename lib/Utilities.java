package lib;

public class Utilities {
  public static boolean isANumber(String value) {
    try {  
      Double.parseDouble(value);  
      return true;
    } catch(NumberFormatException e){  
      return false;  
    }  
  }
}
