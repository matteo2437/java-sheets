package lib.expressions.operators;

/**
 * Operando di tipo cella
 */
public class OperandNumber extends Operand<Double> {
  
  /**
   * Crea operando di tipo cella
   * @param value Valore numerico
   */
  public OperandNumber(Double value) {
    super(value);
  }

  @Override
  public double get() {
    return operatorType; 
  }
}