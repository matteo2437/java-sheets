package components.table;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;

import components.cells.Cell;
import components.cells.CellHandler;
import components.table.tableRowHeader.TableRowHeader;

import java.awt.*;
import java.awt.event.*;

public class Table extends JScrollPane {
	private JTable mainTable;
	private TableRowHeader rowHeader;
	
	private int rows;	
	private int cols;

	public Table(int rows, int cols)	{
		super();
		this.rows = rows;
		this.cols = cols;

		initMainTable();
		initRowHeader();
	}

	private void initMainTable() {

		mainTable = new JTable(this.rows, this.cols);

		mainTable.setCellSelectionEnabled(true);
		mainTable.getTableHeader().setReorderingAllowed(false);
		mainTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

		mainTable.getModel().addTableModelListener(
			new TableModelListener() {
				public void tableChanged(TableModelEvent evt) 
				{
					int column = evt.getColumn();
					int row = evt.getFirstRow();

					String value = mainTable.getValueAt(row, column).toString();

					Cell cell = CellHandler.getCellType(value, mainTable);
					cell.setRow(row);
					cell.setColumn(column);
					System.out.println(cell.getValue());

					if(cell.getValue() != value)
						mainTable.setValueAt(cell.getValue(), row, column);
				}
			}
		);


	}

	private void initRowHeader() {
		rowHeader = new TableRowHeader(mainTable);
		super.setViewportView(mainTable);
    super.setRowHeaderView(rowHeader);
	}

	public JTable getMainTable() {
		return mainTable;
	}

	public TableRowHeader getTableRowHeader() {
		return rowHeader;
	}
}