package components.cells;

import components.cells.types.LabelCell;
import components.cells.types.NumberCell;
import components.cells.types.ExpressionCell.ExpressionCell;
import lib.Utilities;

public class CellHandler {

  public static Cell getCellType(String value) {
    if(isAnExpression(value))
      return new ExpressionCell(value);

    if(Utilities.isANumber(value))
      return new NumberCell(value);

    return new LabelCell(value);
  }

  private static boolean isAnExpression(String string) {
    if(string.length() == 0)
      return false;

    return string.charAt(0) == '=';
  }
}
