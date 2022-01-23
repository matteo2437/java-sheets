package components.cells.types.ExpressionCell;
import javax.swing.JTable;

import components.cells.Cell;
import components.cells.types.Operation;

public class ExpressionCell extends Cell{

  public ExpressionCell(String value, JTable table) {
    super(value, table);
  }

  public String calculateValue(String expression) {
    String errorStr = "#Error"; 

    expression = expression.substring(1).toUpperCase();
    if (expression.length() != 5)
      return errorStr;

    String rows = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    String operands = "+-*/";

    int column1 = rows.indexOf(expression.charAt(0));
    int row1 = expression.charAt(1) - 48;

    Operation operation = Operation
      .values()[operands.indexOf(expression.charAt(2))];

    int column2 = rows.indexOf(expression.charAt(3));
    int row2 = expression.charAt(4) - 48;

    Object firstValueStr = super.table.getValueAt(row1, column1);
    Object secondValueStr = super.table.getValueAt(row2, column2);

    if(firstValueStr == null || secondValueStr == null)
      return errorStr;

    double firstValue = Double.parseDouble(String.valueOf(firstValueStr));
    double secondValue = Double.parseDouble(String.valueOf(secondValueStr));

    double calculatedValue;

    switch(operation){
      case SUM:
        calculatedValue = firstValue + secondValue;
        return calculatedValue + "";
      case SUB:
        calculatedValue = firstValue - secondValue;
        return calculatedValue + "";
      case MUL:
        calculatedValue = firstValue * secondValue;
        return calculatedValue + "";
      case DIV:
        calculatedValue = firstValue / secondValue;
        return calculatedValue + "";
    }

    return errorStr;
  }

  @Override
  public String getValue() {
    return calculateValue(super.value);
  }
}
