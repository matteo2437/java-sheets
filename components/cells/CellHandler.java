package components.cells;

import components.cells.types.ExpressionCell;
import components.cells.types.LabelCell;
import components.cells.types.NumberCell;
import lib.Utilities;

/**
 * Gestore di celle
 */
public class CellHandler {

  /**
   * Restituisce il tipo di cella in base al valore
   * @param value Valore
   * @param cells Celle
   * @return Tipo cella
   */
  public static Cell getCellType(String value, Cell[][] cells) {
    if(isAnExpression(value))
      return new ExpressionCell(value, cells);

    if(Utilities.isANumber(value))
      return new NumberCell(value, cells);

    return new LabelCell(value, cells);
  }

  private static boolean isAnExpression(String string) {
    if(string.length() == 0)
      return false;

    return string.charAt(0) == '=';
  }
}
