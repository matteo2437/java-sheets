import javax.swing.JFrame;

import table.Table;

class Main {
  public static void main(String[] args){
    JFrame f;
    f = new JFrame();
		f.setTitle("JTable Example");

    Table table = new Table(4, 4);

		f.add(table);
		f.setSize(500, 200);
		f.setVisible(true);
  }
}