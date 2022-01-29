package components.table;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import components.cells.Cell;
import components.table.tableRowHeader.TableRowHeader;

public class Table extends JScrollPane {
	private final JTable mainTable;
	private final MainTableModel tableModel;
	private final TableRowHeader rowHeader;
	
	private int rows;	
	private int cols;

	public Table(int rows, int cols)	{
		super();
		this.rows = rows;
		this.cols = cols;

		tableModel = new MainTableModel(this.rows, this.cols);
		mainTable = new JTable(tableModel);
		rowHeader = new TableRowHeader(mainTable);

		initMainTable();
		initRowHeader();
	}

	private void initMainTable() {
		mainTable.setCellSelectionEnabled(true);
		mainTable.getTableHeader().setReorderingAllowed(false);
		mainTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
	}



	private void initRowHeader() {
		super.setViewportView(mainTable);
    super.setRowHeaderView(rowHeader);
	}

	public JTable getMainTable() {
		return mainTable;
	}

	public TableRowHeader getTableRowHeader() {
		return rowHeader;
	}

	public Cell getCell(int rowIndex, int columnIndex) {
		return tableModel.getCell(rowIndex, columnIndex);
	}

	public Cell[][] getCells() {
		return tableModel.getCells();
	}

	public void setCells(Cell[][] cells) {
		tableModel.setCells(cells);
	}

	public void refresh() {
		tableModel.fireTableStructureChanged();
	}
}