package lib.expressions.operators;

import components.cells.Cell;
import lib.Utilities;

public class OperatorCell extends Operator<Cell> {
  
  public OperatorCell(Cell cell) {
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
