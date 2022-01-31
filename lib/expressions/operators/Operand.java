package lib.expressions.operators;

/**
 * Un'operando
 * @param <T> Tipo operando
 */
public abstract class Operand<T> {
  protected T operatorType;

  /**
   * Crea operando
   * @param operatorType Tipo operando
   */
  public Operand(T operatorType) {
    this.operatorType = operatorType;
  }

  /**
   * @return Valore operando
   */
  public abstract double get();
}