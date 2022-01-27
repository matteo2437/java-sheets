package components;

import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.event.*;

import components.cells.Cell;
import components.table.Table;

public class SpreadSheet extends JPanel {
  private final Table table;
  private final JTextField textField;

  public SpreadSheet(int rows, int cols) {
    super();
    table = new Table(rows, cols);
    textField = new JTextField();

    listenCellClick();
    listenTextFieldChange();
    addComponents();
  }

  private void listenCellClick() {
    table.getMainTable().addMouseListener(new MouseAdapter() {
      @Override
      public void mouseClicked(final MouseEvent e) {
          if (e.getClickCount() == 1) {
            updateTextField();
          }
      }
    });
  }

  private void listenTextFieldChange() {
    textField.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e){        
        getSelectedCell().setValue(textField.getText());        
     }
    });
  }

  private void updateTextField() {
    Cell selectedCell = getSelectedCell();
    textField.setText(selectedCell.getDisplayValue());
  }

  private Cell getSelectedCell() {
    final int row = table
      .getMainTable()
      .getSelectedRow();  

    final int column = table
      .getMainTable()
      .getSelectedColumn();  

    return table
      .getCell(row, column);
  }
  
  private void addComponents() {
    super.add(textField);
    super.add(table);
  }
}
