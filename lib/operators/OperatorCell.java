package lib.operators;

import components.cells.Cell;

public class OperatorCell extends Operator<Cell> {
  
  public OperatorCell(Cell cell) {
    super(cell);
  }

  @Override
  public double get() {
    String value = operatorType.getValue();

    if(value.isEmpty()) {
      return 0;
    }

    return Double.parseDouble(value); 
  }
}
