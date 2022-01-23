package components.cells.types.ExpressionCell;
import javax.swing.JTable;

import components.cells.Cell;
import lib.ExpressionSolver;
import lib.Utilities;

public class ExpressionCell extends Cell{
  private String expression;

  public ExpressionCell(String value) {
    super(value);
  }

  public void setExpression(String expression) {
    this.expression = expression.substring(1).toUpperCase();
  }

  private boolean isANumber(char c) {
    return Utilities.isANumber(Character.toString(c));
  }

  private String getNumber(int startIndex) {
    int index = 0;

    while(
      isANumber(expression.charAt(index)) ||
      index > expression.length()
    ) { 
      index ++;
    }
    
    return expression.substring(startIndex, index);
  }

  public String calculateValue() {
    String errorStr = "#Error"; 

    String rows = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    boolean isStartingWithANumber = isANumber(expression.charAt(0));

    if(isStartingWithANumber) {
      int i = 0;
      for(i = 0; i < expression.length(); i++){
        if(!Utilities.isANumber(Character.toString(expression.charAt(i))))
          break;
      }   
      
      System.out.println(expression.substring(0, i));
    }

/*
    int column1 = rows.indexOf(expression.charAt(0));
    int row1 = expression.charAt(1) - 48;

    int column2 = rows.indexOf(expression.charAt(3));
    int row2 = expression.charAt(4) - 48;

    Object firstValueStr = super.table.getValueAt(row1, column1);
    Object secondValueStr = super.table.getValueAt(row2, column2);

    if(firstValueStr == null || secondValueStr == null)
      return errorStr;

    double firstValue = Double.parseDouble(String.valueOf(firstValueStr));
    double secondValue = Double.parseDouble(String.valueOf(secondValueStr));


    ExpressionSolver expressionSolver = new ExpressionSolver();
    expressionSolver.firstOperand(firstValue);
    expressionSolver.secondOperand(secondValue);
    boolean areErrors = expressionSolver.setOperation(expression.charAt(2));
*/
    //if(areErrors)
      return errorStr;

    //return expressionSolver.solve() + "";
  }

  @Override
  public String getValue() {
    setExpression(super.value);
    return calculateValue();
  }
}
