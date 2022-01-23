package components.cells;

import javax.swing.JTable;

public class Cell {
  private int row;
  private int column;
  protected String value;

  public Cell(String value) {
    this.value = value;
  }

  public void setValue(String value) {
    this.value = value;
  }
    
  public String getValue() {
    return value;
  }

  public void setColumn(int column) {
    this.column = column;
  }

  public void setRow(int row) {
    this.row = row;
  }
}
