package components.table.tableRowHeader;
import java.awt.*;
import javax.swing.*;
import javax.swing.table.*;

public class TableRowCell implements TableCellRenderer {
  @Override
  public Component getTableCellRendererComponent(
    JTable x, 
    Object value, 
    boolean isSelected, 
    boolean hasFocus, 
    int row, 
    int column
  ){
    Component component = new JTable()
      .getTableHeader()
      .getDefaultRenderer()
      .getTableCellRendererComponent(new JTable(), value, false, false, -1, -2);
      
    return component;
  }
}  
