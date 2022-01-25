package lib;

import javax.swing.JTable;

import components.cells.Cell;

public class ExpressionConverter {
  private final String expression;
  private final Cell[][] cells;
  private int nextIndex;

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
  
  public double getOperand() {
    char character = expression.charAt(nextIndex);
    boolean isStartingWithANumber = isANumber(character);
    System.out.println(character);

    if(isStartingWithANumber) {
      return getNumber(nextIndex, true);
    }
    else {
      int column = getColumn(character);
      nextIndex++;

      double val = getNumber(nextIndex, false);
      int row = (int)Math.round(val);

      return Double.parseDouble(cells[row][column].getValue().toString());
    }
  }

  public ExpressionSolver convert() {
    double firstValue;
    double secondValue;
    char operation;

    firstValue = getOperand();
    System.out.println(firstValue);

    operation = expression.charAt(nextIndex);
    nextIndex++;

    secondValue = getOperand();
    System.out.println(secondValue);
    
    ExpressionSolver expressionSolver = new ExpressionSolver();
    expressionSolver.setFirstOperand(firstValue);
    expressionSolver.setSecondOperand(secondValue);;
    expressionSolver.setOperation(operation);

    return expressionSolver;
  }
}
