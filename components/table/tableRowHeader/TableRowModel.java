package components.table.tableRowHeader;
import javax.swing.table.DefaultTableModel;

/**
 * Modello tabella per il row header
 */
public class TableRowModel extends DefaultTableModel {  

  /**
   * Crea il modello per il row header
   * @param numRows Numero righe
   */
  public TableRowModel(int numRows){
    super();
    super.setRowCount(numRows);
  }

  @Override
  public int getColumnCount() {
      return 1;
  }

  @Override
  public boolean isCellEditable(int row, int col) {
      return false;
  }
}
