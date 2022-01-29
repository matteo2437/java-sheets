package components;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import java.awt.event.*;
import java.awt.*;

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
    textField.getDocument().addDocumentListener(new DocumentListener() {
      public void changedUpdate(DocumentEvent e) {
        warn();
      }
      public void removeUpdate(DocumentEvent e) {
        warn();
      }
      public void insertUpdate(DocumentEvent e) {
        warn();
      }
    
      public void warn() {
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
  
  private void addTextField() {
    JPanel textFieldPanel = new JPanel();
    textFieldPanel.add(textField);
    textFieldPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
    textFieldPanel.setLayout(new GridLayout(0, 1));

    super.add(textFieldPanel);
  }

  private void addComponents() {
    addTextField();
    super.add(table);
  }
}
