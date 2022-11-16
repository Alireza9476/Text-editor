package Main;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

import javax.swing.JEditorPane;
import javax.swing.JFileChooser;
import javax.swing.text.JTextComponent;

import Main.JFileChooser_Handler;


public class save_load {

	JFileChooser_Handler obj_C = new JFileChooser_Handler(); // File Chooser appears by button (save_as or open)
	int userSelection = obj_C.getUserSelection(); // show the Dialog with (*.txt *.jpg) in FileChooser
													// window
	JFileChooser fileChooser = obj_C.getJFileChooser(); // Take the value -> (*.txt *.jpg)
	File fileToSave = fileChooser.getSelectedFile(); // initialise selected File

	public void Path_option(JEditorPane edPane, boolean save) { // true=save, false=load

		if (userSelection == JFileChooser.APPROVE_OPTION) { // Will be executed if we save something
			// !File fileToSave = fileChooser.getSelectedFile();
			// fileChooser.setCurrentDirectory(new File(fileToSave.getAbsolutePath()));
			if (save) {
				try {
					String contain = fileToSave.getAbsoluteFile() + "";
					if (contain.contains(".txt")) { 						// For avoiding .txt duplicate (Test.txt.txt)
						save(edPane, fileToSave.getAbsolutePath());
						main.Path_current = fileToSave.getAbsolutePath(); 	// not paste .txt at the end
					} else {
						save(edPane, fileToSave.getAbsolutePath() + ".txt");
						main.Path_current = fileToSave.getAbsolutePath() + ".txt";
					}
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			} else {
				try {
					load(edPane, fileToSave.getAbsolutePath());
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
			obj_C.set_Absolut_Path(fileToSave.getAbsolutePath());
		}
	}

	public static void save(JTextComponent text, String inputFile) throws Exception {
		FileWriter writer = new FileWriter(inputFile);
		text.write(writer);
		writer.close();
	}

	public static void load(JTextComponent text, String inputFile) throws Exception {
		FileReader inputReader = new FileReader(inputFile);
		text.read(inputReader, inputFile);
		inputReader.close();
	}

}
