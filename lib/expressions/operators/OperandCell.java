package lib.expressions.operators;

import components.cells.Cell;
import lib.Utilities;

/**
 * Operando di tipo cella
 */
public class OperandCell extends Operand<Cell> {
  
  /**
   * Crea operando di tipo cella
   * @param cell Cella
   */
  public OperandCell(Cell cell) {
    super(cell);
  }

  @Override
  public double get() {
    String value = operatorType.getValue();

    if(!Utilities.isANumber(value))
      return 0;

    if(value.isEmpty())
      return 0;

    return Double.parseDouble(value); 
  }
}
