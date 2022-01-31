package components;

import javax.swing.AbstractAction;
import javax.swing.JFileChooser;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JRadioButtonMenuItem;

import java.awt.event.*;
import java.io.File;

import lib.FileManager;

/**
 * MenuBar per gestire il caricamento e salvataggio del foglio elettronico
 */
public class MenuBar extends JMenuBar{
  private final FileManager fileManager;
  private final JFileChooser fileChooser;
  private final JMenu menu;
  private final JMenuItem saveMenuItem;
  private final JMenuItem loadMenuItem;
  private final JRadioButtonMenuItem autoSaveMenuItem;

  /**
   * Creo la menubar
   * @param spreadSheet Il foglio elettronico
   */
  public MenuBar(SpreadSheet spreadSheet) {
    super();

    fileChooser = new JFileChooser();
    fileManager = new FileManager(spreadSheet);
    fileManager.loadAutoSave();

    menu = new JMenu("File");
    saveMenuItem = getSaveMenuItem();
    loadMenuItem = getLoadMenuItem();
    autoSaveMenuItem = new JRadioButtonMenuItem("Salvataggio automatico");

    listenForAutoSaveChange();

    menu.add(saveMenuItem);
    menu.add(loadMenuItem);
    menu.add(autoSaveMenuItem);

    super.add(menu);
  }

  private JMenuItem getSaveMenuItem() {
    return new JMenuItem(new AbstractAction("Salva") {
      public void actionPerformed(ActionEvent e) {
        int resultFileChooser = fileChooser.showSaveDialog(null);

        if(resultFileChooser != JFileChooser.APPROVE_OPTION)
          return;

        File saveFile = fileChooser.getSelectedFile();
        if(saveFile.exists()) {
          rewriteFile(saveFile);
        }
        else {
          fileManager.save(saveFile);
        }
      }
    });
  } 
  
  private void rewriteFile(File saveFile) {
    int result = JOptionPane.showConfirmDialog(
      null, 
      "Vuoi sovrascivere il file?", 
      "Salva", 
      JOptionPane.WARNING_MESSAGE
    );

    if(result == JOptionPane.YES_OPTION) {
      fileManager.save(saveFile);
    }
  }

  private JMenuItem getLoadMenuItem() {
    return new JMenuItem(new AbstractAction("Carica") {
      public void actionPerformed(ActionEvent e) {
        int resultFileChooser = fileChooser.showOpenDialog(null);
        
        if(resultFileChooser != JFileChooser.APPROVE_OPTION)
          return;
        
        fileManager.load(fileChooser.getSelectedFile());
      }
    });
  }

  private void listenForAutoSaveChange() {
    autoSaveMenuItem.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        boolean autoSave = autoSaveMenuItem.isSelected();
        
        saveMenuItem.setEnabled(!autoSave);
        fileManager.setAutoSave(autoSave);
      } 
    });
  } 
}
