import java.awt.*;
import javax.swing.*;
import javax.swing.table.*;

public class TableRowHeader extends JTable{  
  private TableRowModel model;
  private int numRows;

  TableRowHeader(JTable mainTable){
    super();
    numRows = mainTable.getRowCount();
    model = new TableRowModel(numRows);
    
    super.setModel(model);

    for (int i = 0; i < numRows; i++) {
      super.setValueAt("Row " + (i + 1), i, 0);
    }

    super.setShowGrid(false);
    super.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
    super.setPreferredScrollableViewportSize(new Dimension(50, 0));
    super.getColumnModel().getColumn(0).setPreferredWidth(50);
    super.getColumnModel().getColumn(0).setCellRenderer(new TableCellRenderer() {

      @Override
      public Component getTableCellRendererComponent(JTable x, Object value, boolean isSelected, boolean hasFocus, int row, int column) {

          Component component = mainTable
            .getTableHeader()
            .getDefaultRenderer()
            .getTableCellRendererComponent(mainTable, value, false, false, -1, -2);
            
          ((JLabel) component).setHorizontalAlignment(SwingConstants.CENTER);

          return component;
      }
  });
  }
}
