package components.table;

import javax.swing.table.AbstractTableModel;

import components.cells.Cell;
import components.cells.CellHandler;

public class MainTableModel extends AbstractTableModel {
  private final int rows;
  private final int cols;
  private final Cell[][] cells;

  public MainTableModel(int rows, int cols) {
    this.rows = rows;
    this.cols = cols;

    this.cells = new Cell[rows][cols];
  }

  @Override
  public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
    cells[rowIndex][columnIndex] = CellHandler.getCellType(String.valueOf(aValue));
  }

  @Override
  public boolean isCellEditable(int rowIndex, int columnIndex) {
    return true;
  }

  @Override
  public int getRowCount() {
    return rows;
  }

  @Override
  public int getColumnCount() {
    return cols;
  }

  @Override
  public Object getValueAt(int rowIndex, int columnIndex) {
    if(cells[rowIndex][columnIndex] == null)
      cells[rowIndex][columnIndex] = CellHandler.getCellType("");

    return cells[rowIndex][columnIndex].getValue();
  }
  
}