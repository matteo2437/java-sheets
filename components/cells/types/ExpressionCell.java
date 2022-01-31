package components.cells.types;

import components.cells.Cell;
import lib.expressions.ExpressionConverter;

/**
 * Cella di tipo espressione
 */
public class ExpressionCell extends Cell{
  private String expression;

  /**
   * Crea cella di tipo espressione
   * @param value Valore cella
   * @param cells Celle
   */
  public ExpressionCell(String value, Cell[][] cells) {
    super(value, cells);
    this.expression = value;
  }

  @Override
  public void setValue(String value) {
    super.setValue(value);
    this.expression = value;
  }

  @Override
  public String getDisplayValue() {
    return this.expression;
  }

  @Override
  public String getValue() {
    double expressionValue = new ExpressionConverter(this.expression, super.cells)
      .convert()
      .solve();

    return expressionValue + "";
  }
}
