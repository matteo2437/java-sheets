package components.table;

import javax.swing.table.AbstractTableModel;

import components.cells.Cell;
import components.cells.CellHandler;

/**
 * Modello per la tabella principale
 */
public class MainTableModel extends AbstractTableModel {
  private final int rows;
  private final int cols;
  private Cell[][] cells;

  /**
   * Crea modello tabella
   * @param rows Righe
   * @param cols Colonne
   */
  public MainTableModel(int rows, int cols) {
    this.rows = rows;
    this.cols = cols;

    this.cells = new Cell[rows][cols];
  }

  /**
   * @return Le celle
   */
  public Cell[][] getCells() {
    return cells;
  }

  /**
   * Imposta le celle
   * @param cells Le celle
   */
  public void setCells(Cell[][] cells) {
    this.cells = cells;
  }

  /**
   * @param rowIndex Riga
   * @param columnIndex Colonna
   * @return La cella selezionata
   */
  public Cell getCell(int rowIndex, int columnIndex){
    return cells[rowIndex][columnIndex];
  }

  @Override
  public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
    cells[rowIndex][columnIndex] = CellHandler.getCellType(String.valueOf(aValue), cells);
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
      cells[rowIndex][columnIndex] = CellHandler.getCellType("", cells);

    return cells[rowIndex][columnIndex].getValue();
  }
  
}
