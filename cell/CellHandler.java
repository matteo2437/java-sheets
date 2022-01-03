package cell;

import javax.swing.JTable;

public class CellHandler {

  public static Cell getCellType(String value, JTable table) {
    if(isAnExpression(value))
      return new ExpressionCell(value, table);

    if(isANumber(value))
      return new NumberCell(value, table);

    return new LabelCell(value, table);
  }

  private static boolean isAnExpression(String value) {
    return value.charAt(0) == '=';
  }

  private static boolean isANumber(String value) {
    try {  
      Double.parseDouble(value);  
      return true;
    } catch(NumberFormatException e){  
      return false;  
    }  
  }
}
