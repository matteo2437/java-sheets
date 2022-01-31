package components.table;

import components.cells.Cell;
import lib.Utilities;

/**
 * Classe per gestire il sorting di un colonna specifica della tabella
 */
public class TableSorter {
  private double unknownValue;

  private double getCellValue(Cell cell) {
    if(cell == null)
      return unknownValue;

    String cellValue = cell.getValue();
    boolean isANumber = Utilities.isANumber(cellValue);

    if(isANumber)
      return Double.parseDouble(cellValue);

    if(!cellValue.isEmpty())
      return -unknownValue;

    return unknownValue;
  }

  private Cell[][] selectionSort(Cell[][] cells, int col) {
    for(int i = 0; i < cells.length - 1; i++) {
      int min = i;
      for(int j = i + 1; j < cells.length; j++) {
        if(getCellValue(cells[min][col]) > getCellValue(cells[j][col])) {
          min = j;
        }
      }

      if(min != i) { 
        Cell k = cells[min][col];
        cells[min][col] = cells[i][col];
        cells[i][col] = k;
      }
    }

    return cells;
  } 

  private Cell[][] invert(Cell[][] cells, int col) {
    int length = cells.length;

    for (int i = 0; i < length / 2; i++) {
      Cell temp = cells[i][col];
      cells[i][col] = cells[length - 1 - i][col];
      cells[length - 1 - i][col] = temp;
    }

    return cells;
  }

  /**
   * Ordinamento crescente
   * @param cells Celle
   * @param col Colonna delle celle da ordinare
   * @return Celle con colonna ordinata
   */
  public Cell[][] sortGrowing(Cell[][] cells, int col) {
    unknownValue = Double.POSITIVE_INFINITY;
    return selectionSort(cells, col);
  }

 /**
   * Ordinamento decrescente
   * @param cells Celle
   * @param col Colonna delle celle da ordinare
   * @return Celle con colonna ordinata
   */
  public Cell[][] sortDecreasing(Cell[][] cells, int col) {
    unknownValue = -Double.POSITIVE_INFINITY;

    cells = selectionSort(cells, col);
    return invert(cells, col);
  }
}
