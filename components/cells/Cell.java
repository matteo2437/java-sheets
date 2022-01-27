package components.cells;

public class Cell {
  protected String value;
  protected Cell[][] cells;

  public Cell(String value, Cell[][] cells) {
    this.value = value;
    this.cells = cells;
  }

  public void setValue(String value) {
    this.value = value;
  }
    
  public String getValue() {
    return value;
  }

  public String getDisplayValue() {
    return value;
  }
}
