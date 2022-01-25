package components.cells;

import javax.swing.JTable;

public class Cell {
  private int row;
  private int column;
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

  public void setColumn(int column) {
    this.column = column;
  }

  public void setRow(int row) {
    this.row = row;
  }
}
