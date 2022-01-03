package cell;

import javax.swing.JTable;

public class Cell {
  private int row;
  private int column;
  protected String value;
  protected JTable table;

  public Cell(String value, JTable table) {
    this.value = value;
    this.table = table;
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
