import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

class Main {
  public static void main(String[] args){
    JFrame f;
    f = new JFrame();
		f.setTitle("JTable Example");

    JTable table = new JTable(4, 4);
		table.setCellSelectionEnabled(true);
		table.setBounds(30, 40, 200, 300);

    TableRowHeader rowHeader = new TableRowHeader(table);

		JScrollPane sp = new JScrollPane(table);
    sp.setRowHeaderView(rowHeader);

		f.add(sp);
		f.setSize(500, 200);
		f.setVisible(true);
  }
}