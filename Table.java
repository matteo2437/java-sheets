import javax.swing.JScrollPane;
import javax.swing.JTable;


public class Table extends JTable{
  //private JScrollPane scrollPane;

	Table(int rows, int cols)
	{
    super(rows, cols);
		//TableRowHeader rowHeader = new TableRowHeader(rows);

		super.setCellSelectionEnabled(true);
		super.setBounds(30, 40, 200, 300);

    //scrollPane = new JScrollPane(mainTable);
    //scrollPane.setRowHeaderView(rowHeader);
	}
}