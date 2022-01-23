package lib;

public class ExpressionConverter {
  private final String expression;
  private int nextIndex;

  public ExpressionConverter(String expression) {
    this.nextIndex = 0;
    this.expression = expression
      .substring(1)
      .toUpperCase()
      .replace(" ", "");
  }

  private int getColumn(char c) {
    String rows = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    return rows.indexOf(expression.charAt(0));
  }

  private boolean isANumber(char c) {
    return Utilities.isANumber(Character.toString(c));
  }

  private Double getNumber(int startIndex, boolean includeDots) {
    int index = 0;

    while(
      isANumber(expression.charAt(index)) ||
      (expression.charAt(index) == '.' && includeDots) ||
      index > expression.length()
    ) { 
      index ++;
    }
    
    nextIndex = index + 1;
    return Double.parseDouble(expression.substring(startIndex, index));
  }
  
  public double getOperand() {
    char character = expression.charAt(nextIndex);
    boolean isStartingWithANumber = isANumber(character);
    if(isStartingWithANumber) {
      return getNumber(0, true);
    }
    else {
      int column = getColumn(character);
      int row = (int)Math.round(getNumber(1, false));

      return 0;//importa tabella;
    }
  }

  public void convert() {
    double firstValue;
    double secondValue;
    char operation;

    firstValue = getOperand();

    operation = expression.charAt(nextIndex);
    nextIndex++;

    secondValue = getOperand();
  }
}
