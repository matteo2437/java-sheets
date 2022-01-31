package components.cells.types;

import components.cells.Cell;

/**
 * Cella di tipo label
 */
public class LabelCell extends Cell {

  /**
   * Crea cella di tipo label
   * @param value Valore cella
   * @param cells Celle
   */
  public LabelCell(String value, Cell[][] cells) {
    super(value, cells);
  }
}
