import javax.swing.JFrame;

import components.table.Table;

class Main {
  public static void main(String[] args){
    JFrame frame = new JFrame();
		frame.setTitle("Foglio elettronico");

    Table table = new Table(80, 20);

		frame.add(table);
		frame.setSize(720, 480);
		frame.setVisible(true);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
}