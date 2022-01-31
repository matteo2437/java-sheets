package components.table;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.JTableHeader;

import java.awt.event.*;
import java.util.Arrays;

import components.cells.Cell;
import components.table.tableRowHeader.TableRowHeader;

/**
 * Tabella principale
 */
public class Table extends JScrollPane {
	private final JTable mainTable;
	private final MainTableModel tableModel;
	private final TableRowHeader rowHeader;
	private final String[] columnSorts;

	private int rows;	
	private int cols;

	/**
	 * Crea la tabella
	 * @param rows Righe tabella
	 * @param cols Colonne tabella
	 */
	public Table(int rows, int cols)	{
		super();
		this.rows = rows;
		this.cols = cols;
		columnSorts = new String[cols];
		Arrays.fill(columnSorts, "");

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
		listenTableSortChange();
	}

	private void listenTableSortChange() {
		JTableHeader tableHeader = mainTable.getTableHeader(); 
		tableHeader.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int columnClicked = mainTable.columnAtPoint(e.getPoint());
				sortColumn(getSortType(columnClicked), columnClicked);

				String newColumnName = mainTable.getColumnName(columnClicked) + " " + columnSorts[columnClicked];

				tableHeader
					.getColumnModel()
					.getColumn(columnClicked)
					.setHeaderValue(newColumnName);
			}
		});
	}

	private boolean getSortType(int col) {
		if(columnSorts[col] == "" || columnSorts[col] == "v") {
			columnSorts[col] = "^";
			return true;
		}

		if(columnSorts[col] == "^") {
			columnSorts[col] = "v";
			return false;
		}

		return false;
	}

	private void sortColumn(boolean growing, int col) {
		TableSorter ts = new TableSorter();
		Cell[][] cells = getCells();
		Cell[][] sortedCells = growing 
			? ts.sortGrowing(cells, col)
			: ts.sortDecreasing(cells, col);

		setCells(sortedCells);
		refresh();
	}

	private void initRowHeader() {
		super.setViewportView(mainTable);
    super.setRowHeaderView(rowHeader);
	}

	/**
	 * @return La tabella principale
	 */
	public JTable getMainTable() {
		return mainTable;
	}

	/**
	 * @return L'header della tabella
	 */
	public TableRowHeader getTableRowHeader() {
		return rowHeader;
	}

	/**
	 * @param rowIndex Riga cella
	 * @param columnIndex Colonna cella
	 * @return La cella selezionata
	 */
	public Cell getCell(int rowIndex, int columnIndex) {
		return tableModel.getCell(rowIndex, columnIndex);
	}

	/**
	 * @return La matrice di celle
	 */
	public Cell[][] getCells() {
		return tableModel.getCells();
	}

	/**
	 * Imposta un valore a tutte le celle
	 * @param cells Le celle
	 */
	public void setCells(Cell[][] cells) {
		tableModel.setCells(cells);
	}

	/**
	 * Aggiorna la tabella
	 */
	public void refresh() {
		tableModel.fireTableStructureChanged();
	}
}