import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.UIManager;

import components.MenuBar;
import components.SpreadSheet;

class Main {
  public static void main(String[] args){

    try {
      UIManager.setLookAndFeel(
        UIManager.getCrossPlatformLookAndFeelClassName()
      );
    }
    catch(Exception e) {

    }

    JFrame frame = new JFrame();
    SpreadSheet spreadSheet = new SpreadSheet(80, 20);
    MenuBar menuBar = new MenuBar(spreadSheet);
    

    spreadSheet.setLayout(new BoxLayout(spreadSheet, BoxLayout.PAGE_AXIS));		

		frame.setTitle("Foglio elettronico");
    frame.setJMenuBar(menuBar);
    frame.add(spreadSheet);
		frame.setSize(720, 480);
		frame.setVisible(true);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
}