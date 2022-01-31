package lib.expressions;

import lib.expressions.operators.Operand;

/**
 * Rappresenta un'espressione
 */
public class Expression {
  private double firstOperand;
  private double secondOperand;
  private Operation operation;

  /**
   * Imposta il primo operando
   * @param operator Operando
   */
  public void setFirstOperand(Operand<?> operator) {
    firstOperand = operator.get();
  }

  /**
   * Imposta il seconda operando
   * @param operator Operando
   */
  public void setSecondOperand(Operand<?> operator) {
    secondOperand = operator.get();;
  }

  /**
   * Imposta il tipo di operazione
   * @param operation Operazione
   * @return Ritorna se la funzione è andata a buon fine
   */
  public boolean setOperation(char operation) {
    String operantions = "+-*/";
    int index = operantions.indexOf(operation);

    if(index < 0) 
      return false;

    this.operation = Operation.values()[index];

    return true;
  }

  /**
   * Risolve l'espressione
   * @return Valore espressione
   */
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
