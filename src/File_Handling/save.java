package File_Handling;
/**
 * @(#)SaveFileDialogExample.java 1.0
 * This code is written by www.codejava.net
 *
 */

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.sound.sampled.ReverbType;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.filechooser.FileNameExtensionFilter;

public class save extends JFrame {

	private JButton buttonBrowse;

	public save() {
		super("Save File Dialog Example");
		setLayout(new FlowLayout());
		buttonBrowse = new JButton("Save...");
		buttonBrowse.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				showSaveFileDialog();
			}
		});
		getContentPane().add(buttonBrowse);
		setSize(300, 200);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) { }

        SwingUtilities.invokeLater(new Runnable() {

			public void run() {
				new save();
			}
		});
	}

	
	public void showSaveFileDialog() {
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setDialogTitle("Specify a file to save");
		
		//
		fileChooser.setCurrentDirectory(new File("c:\\users\\baghe\\desktop"));
		fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);				//Mit DICTIONARY_ONLY nur Dictionary
		
		FileNameExtensionFilter filter = new FileNameExtensionFilter("TEXT FILES", "txt", "text");
		fileChooser.setFileFilter(filter);
		fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("Images", "jpg", "png", "gif", "bmp"));
		fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("*.pdf", "pdf"));
		fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("*.txt", "txt"));
		//
		
		  Container content = getContentPane();
		  
		  final JEditorPane edPane = new JEditorPane();
		 
		  JScrollPane sPne = new JScrollPane(edPane);
		 
		  content.add(sPne, BorderLayout.CENTER);
		  
		//

		int userSelection = fileChooser.showSaveDialog(this);
		if (userSelection == JFileChooser.APPROVE_OPTION) {					//Will be executed if we save something
			File fileToSave = fileChooser.getSelectedFile();
			System.out.println("Save as file: " + fileToSave.getAbsolutePath());
		}
	}
	
	private String neuepath(String a) {
			
			String result = a.substring(a.length(), a.indexOf("\\"));
		
		return result;
	}
}

