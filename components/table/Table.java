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

		MainTableModel model = new MainTableModel(this.rows, this.cols);
		mainTable = new JTable(model);

		mainTable.setCellSelectionEnabled(true);
		mainTable.getTableHeader().setReorderingAllowed(false);
		mainTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
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