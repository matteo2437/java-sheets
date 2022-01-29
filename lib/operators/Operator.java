package lib.operators;

public abstract class Operator<T> {
  protected T operatorType;

  public Operator(T operatorType) {
    this.operatorType = operatorType;
  }

  public abstract double get();
}