package lib;

/**
 * Classe che ragruppa funzioni di utilities
 */
public class Utilities {

  /**
   * Controlla se una stringa contiene un numero
   * @param value Stringa
   * @return Risultato
   */
  public static boolean isANumber(String value) {
    try {  
      Double.parseDouble(value);  
      return true;
    } catch(NumberFormatException e){  
      return false;  
    }  
  }
}
