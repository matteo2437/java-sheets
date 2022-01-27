package lib;

public class Expression {
  private double firstOperand;
  private double secondOperand;
  private Operation operation;

  public Expression() {}

  public void setFirstOperand(double value) {
    firstOperand = value;
  }

  public void setSecondOperand(double value) {
    secondOperand = value;
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
