package lib.operators;

public class OperatorNumber extends Operator<Double> {
  
  public OperatorNumber(Double value) {
    super(value);
  }

  @Override
  public double get() {
    return operatorType; 
  }
}