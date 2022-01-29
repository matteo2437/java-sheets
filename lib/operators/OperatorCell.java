package lib.operators;

import components.cells.Cell;

public class OperatorCell extends Operator<Cell> {
  
  public OperatorCell(Cell cell) {
    super(cell);
  }

  @Override
  public double get() {
    return Double.parseDouble(operatorType.getValue()); 
  }
}
