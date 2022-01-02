package table;
import javax.swing.table.DefaultTableModel;

public class TableRowModel extends DefaultTableModel {  

  TableRowModel(int numRows){
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
