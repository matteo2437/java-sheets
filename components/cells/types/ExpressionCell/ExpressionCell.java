package components.cells.types.ExpressionCell;
import javax.swing.JTable;

import components.cells.Cell;
import lib.ExpressionConverter;
import lib.ExpressionSolver;
import lib.Utilities;

public class ExpressionCell extends Cell{

  public ExpressionCell(String value, Cell[][] cells) {
    super(value, cells);
  }

  @Override
  public String getValue() {
    return new ExpressionConverter(super.getValue(), super.cells).convert().solve() + "";
  }
}
