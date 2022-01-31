package lib.expressions;
import components.cells.Cell;
import lib.Utilities;
import lib.expressions.operators.Operand;
import lib.expressions.operators.OperandCell;
import lib.expressions.operators.OperandNumber;

/**
 * Convertitore di stringhe a espressioni
 */
public class ExpressionConverter {
  private final String expression;
  private final Cell[][] cells;
  private int nextIndex;

  /**
   * Crea il convertitore di espressioni
   * @param expression Espressione
   * @param cells Celle
   */
  public ExpressionConverter(String expression, Cell[][] cells) {
    this.nextIndex = 0;
    this.cells = cells;
    this.expression = expression
      .substring(1)
      .toUpperCase()
      .replace(" ", "");
  }

  private int getColumn(char c) {
    String rows = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    return rows.indexOf(expression.charAt(nextIndex));
  }

  private boolean isANumber(char c) {
    return Utilities.isANumber(Character.toString(c));
  }

  private double getNumber(int startIndex, boolean includeDots) {
    if(!isANumber(expression.charAt(startIndex))){
      return 0;
    }
      
    int index = startIndex;

    while(
      isANumber(expression.charAt(index)) ||
      (includeDots && expression.charAt(index) == '.')      
    ) { 
      index ++;

      if(index >= expression.length())
        break;
    }

    nextIndex = index;
    return Double.parseDouble(expression.substring(startIndex, index));
  }
  
  private Operand<?> getOperand() {
    char character = expression.charAt(nextIndex);
    boolean isStartingWithANumber = isANumber(character);

    if(isStartingWithANumber) {
      return new OperandNumber(getNumber(nextIndex, true));
    }
    else {
      int column = getColumn(character);
      nextIndex++;

      double val = getNumber(nextIndex, false);
      int row = (int)Math.round(val);

      return new OperandCell(cells[row][column]);
    }
  }

  /**
   * Converte l'espressione
   * @return Espressione
   */
  public Expression convert() {
    Operand<?> firstValue;
    Operand<?> secondValue;
    char operation;

    firstValue = getOperand();

    operation = expression.charAt(nextIndex);
    nextIndex++;

    secondValue = getOperand();
    
    Expression expressionSolver = new Expression();
    expressionSolver.setFirstOperand(firstValue);
    expressionSolver.setSecondOperand(secondValue);;
    expressionSolver.setOperation(operation);

    return expressionSolver;
  }
}
