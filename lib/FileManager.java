package lib;

import components.SpreadSheet;
import components.cells.Cell;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JOptionPane;

/**
 * Gestore file per lo spreadsheet
 */
public class FileManager {
  private final SpreadSheet spreadSheet;
  private boolean autoSave = false;
  private File autoSaveFile;

  /**
   * Crea gestore file
   * @param spreadSheet
   */
  public FileManager(SpreadSheet spreadSheet) {
    this.spreadSheet = spreadSheet;

    readAutoSaveFilePath();

    Timer timer = new Timer();
    timer.schedule(new TimerTask() {
      @Override
      public void run() {
        if(autoSave) {
          save(autoSaveFile);
        }
      }
    }, 0, 1000 * 3);
  }

  private void readAutoSaveFilePath() {
    try (
      FileReader fw = new FileReader("paths.txt");
      Scanner sc = new Scanner(fw);
    ) {
      autoSaveFile = new File(sc.nextLine());
    } 
    catch(IOException e) {
      saveAutoSaveFilePath();
    }
  }

  private void saveAutoSaveFilePath() {
    try (
      FileWriter fw = new FileWriter("paths.txt");
    ) {
      autoSaveFile = File.createTempFile("autosave", ".tmp");

      fw.write(autoSaveFile.getPath() + "\n");
    }
    catch(IOException e) {
      e.printStackTrace();
    }
  }

  /**
   * Carica file auto salvato
   */
  public void loadAutoSave() {
    boolean canReadFile = autoSaveFile.exists() && autoSaveFile.length() > 0;

    if(canReadFile)
      load(autoSaveFile);
  } 

  /**
   * Imposta la modalità di salvataggio
   * @param autoSave Modalità
   */
  public void setAutoSave(boolean autoSave) {
    this.autoSave = autoSave;
  }

  /**
   * Salva la tabella in un file
   * @param file Il file
   */
  public void save(File file) {
    try (
      FileOutputStream fos = new FileOutputStream(file);
      ObjectOutputStream oos = new ObjectOutputStream(fos);
    ) {
      oos.writeObject(spreadSheet.getCells());
      System.out.println("File salvato");
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  /**
   * Carica la tabella in un file
   * @param file Il file
   */
  public void load(File file) {
    try (
      FileInputStream fis = new FileInputStream(file);
      ObjectInputStream ois = new ObjectInputStream(fis);
    ) {
      spreadSheet.setCells((Cell[][]) ois.readObject());
      spreadSheet.refresh();
      System.out.println("File caricato");
    }
    catch (FileNotFoundException e) {
      JOptionPane.showMessageDialog(
        null, 
        "Errore file non trovato", 
        "Errore", 
        JOptionPane.ERROR_MESSAGE
      );
      e.printStackTrace();
    }
    catch (IOException e) {
      e.printStackTrace();
    }
    catch (ClassNotFoundException e) {
      e.printStackTrace();
    }
  }
}
