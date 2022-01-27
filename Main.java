import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.plaf.TableUI;

import components.table.Table;

class Main {
  public static void main(String[] args){
    try {
      UIManager.setLookAndFeel(
        UIManager.getCrossPlatformLookAndFeelClassName());
    }
    catch(Exception e) {

    }
    JFrame frame = new JFrame();
		frame.setTitle("Foglio elettronico");

    Table table = new Table(80, 20);



		frame.add(table);
		frame.setSize(720, 480);
		frame.setVisible(true);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
}