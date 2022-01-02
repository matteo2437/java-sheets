package table;
import javax.swing.JScrollPane;
import javax.swing.JTable;

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
		mainTable.setBounds(30, 40, 200, 300);
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