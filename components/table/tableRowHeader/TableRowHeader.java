package components.table.tableRowHeader;
import java.awt.*;
import javax.swing.*;

public class TableRowHeader extends JTable {  
  private JTable mainTable;
  private TableRowModel model;
  private int numRows;

  public TableRowHeader(JTable mainTable){
    super();
    this.mainTable = mainTable;

    initTableModel();
    fillRowHeader();
    configureRowHeader();
  }

  private void initTableModel() {
    numRows = mainTable.getRowCount();
    model = new TableRowModel(numRows);
    
    super.setModel(model);
  }

  private void fillRowHeader() {
    for (int i = 0; i < numRows; i++) {
      super.setValueAt(i, i, 0);
    }
  }

  private void configureRowHeader() {
    super.setShowGrid(false);
    super.setPreferredScrollableViewportSize(new Dimension(50, 0));

    super.getColumnModel()
      .getColumn(0)
      .setCellRenderer(new TableRowCell());
  }
}
