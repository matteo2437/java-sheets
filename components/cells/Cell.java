package components.cells;

import java.io.Serializable;

/**
 * Rappresenta una cella all'interno della tabella
 */
public class Cell implements Serializable{
  protected String value;
  protected Cell[][] cells;

  /**
   * Crea celle
   * @param value Valore cella
   * @param cells Celle
   */
  public Cell(String value, Cell[][] cells) {
    this.value = value;
    this.cells = cells;
  }

  /**
   * Imposta valore cella
   * @param value Valore cella
   */
  public void setValue(String value) {
    this.value = value;
  }
    
  /**
   * @return Il valore cella
   */
  public String getValue() {
    return value;
  }

  /**
   * @return Valore da mostrare nel textfield
   */
  public String getDisplayValue() {
    return value;
  }
}
