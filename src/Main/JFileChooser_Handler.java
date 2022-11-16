package Main;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class JFileChooser_Handler {

	private int userSelection; // Ich könnte es auch static machen, dann hätte ich direkten Zugriff
	JFileChooser fileChooser = new JFileChooser();
	public static String AbsolutPath;

	public JFileChooser_Handler() {

		fileChooser.setDialogTitle("Specify a file to save");
		fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY); // Mit DICTIONARY_ONLY nur Dictionary
		fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("*.txt", "txt"));
		fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("*.png", "png"));
		fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("*.jpg", "jpg"));
		fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("*.bat", "bat"));
		userSelection = fileChooser.showSaveDialog(null);
		// FileName = fileChooser.getSelectedFile().getName();
	}

	public int getUserSelection() {
		return userSelection;
	}

	public JFileChooser getJFileChooser() {
		return fileChooser;
	}

	public void set_Absolut_Path(String AbsolutPath) { // nicht static da ich den Wert this.AbsolutWert static setzte,
														// da ich ja hier den Wert nur setzte und es nicht nehme
		JFileChooser_Handler.AbsolutPath = AbsolutPath;
	}

}
