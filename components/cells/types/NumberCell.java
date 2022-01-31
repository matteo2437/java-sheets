package components.cells.types;

import components.cells.Cell;

/**
 * Cella di tipo numero
 */
public class NumberCell extends Cell {

  /**
   * Crea cella di tipo numero
   * @param value Valore cella
   * @param cells Celle
   */
  public NumberCell(String value, Cell[][] cells) {
    super(value, cells);
  }
}
