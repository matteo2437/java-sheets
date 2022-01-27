import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;

import components.SpreadSheet;
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

    SpreadSheet spreadSheet = new SpreadSheet(80, 20);
    spreadSheet.setLayout(new BoxLayout(spreadSheet, BoxLayout.PAGE_AXIS));		

    frame.add(spreadSheet);
		frame.setSize(720, 480);
		frame.setVisible(true);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
}