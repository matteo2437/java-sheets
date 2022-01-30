package lib.expressions;

import lib.expressions.operators.Operator;

public class Expression {
  private double firstOperand;
  private double secondOperand;
  private Operation operation;

  public Expression() {}

  public void setFirstOperand(Operator<?> operator) {
    firstOperand = operator.get();
  }

  public void setSecondOperand(Operator<?> operator) {
    secondOperand = operator.get();;
  }

  public boolean setOperation(char operation) {
    String operantions = "+-*/";
    int index = operantions.indexOf(operation);

    if(index < 0) 
      return false;

    this.operation = Operation.values()[index];

    return true;
  }

  public double solve() {
    switch(operation){
      case SUM:
        return firstOperand + secondOperand;
      case SUB:
        return firstOperand - secondOperand;
      case MUL:
        return firstOperand * secondOperand;
      case DIV:
        return firstOperand / secondOperand;
    }

    return 0;
  }

}
