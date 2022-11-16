package File_Handling;
 
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.text.JTextComponent;
import javax.swing.text.html.HTMLEditorKit;

import Main.JFileChooser_Handler;
import Main.save_load;


public class Editor {
	
    public static void main(String args[]) {
		
    	//Damit wir nicht ein veraltetes UI haben
    	try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) { }

        SwingUtilities.invokeLater(new Runnable() {

			public void run() {
				new Editor();
			}
		});
 
 
  JFrame jFrame = new JFrame("Load ,Edit and Save file");
  Container content = jFrame.getContentPane();
 
  final JEditorPane edPane = new JEditorPane();
  JScrollPane sPne = new JScrollPane(edPane);

  content.add(sPne, BorderLayout.CENTER);
  edPane.setEditorKit(null);		//Wir könnten das auf HTMLEditorKit stellen, aber bei Default speichert er es einfach wie in ein Texteditor
 
  JPanel jPanel = new JPanel();
 
 //Für ein Button erstellen wir ein Actionhandler, also die Aktion, wenn er gedrückt wird
  
////////////////SAVE////////////////////////
  
  Action absActionSave = new AbstractAction() {
 
@Override
 
public void actionPerformed(ActionEvent event) {
    try {
    	
    	JFileChooser_Handler obj_C = new JFileChooser_Handler();
    	int userSelection = obj_C.getUserSelection();
    	JFileChooser fileChooser = obj_C.getJFileChooser();
    	
		if (userSelection == JFileChooser.APPROVE_OPTION) {					//Will be executed if we save something
			File fileToSave = fileChooser.getSelectedFile();
			
		//
		//save
		save_load.save(edPane, fileToSave.getAbsolutePath());
		
		obj_C.set_Absolut_Path(fileToSave.getAbsolutePath());
		System.out.println(fileToSave.getAbsolutePath());		
		}	
		
    } catch (Exception e1) {
 
  e1.printStackTrace();
    }
}
 
  };

  
  absActionSave.putValue(Action.NAME, "Save");
 
  JButton saveButton = new JButton(absActionSave);
 
  jPanel.add(saveButton);
  
  
///////////////////Clear//////////////////
  
  Action Load = new AbstractAction() {

@Override
 
public void actionPerformed(ActionEvent event) {
 
    try {
    
    //load
   save_load.load(edPane, JFileChooser_Handler.AbsolutPath);
 
    } catch (Exception e1) {
 
  e1.printStackTrace();
    	}
	}
 
};
 
  Load.putValue(Action.NAME, "Load");
  JButton loadButton = new JButton(Load);
  jPanel.add(loadButton);
  
  /////////////////clear///////////////////////////
  
  Action absActionClear = new AbstractAction() {
 
@Override
 
public void actionPerformed(ActionEvent event) {
 
    edPane.setText("");	//Wenn ich auf clear drücke muss der Inhalt gelöscht werden
 
	}
 
 };
  absActionClear.putValue(Action.NAME, "Clear");
 
  JButton clearButton = new JButton(absActionClear);
 
  jPanel.add(clearButton);
  
 ///////////////////////////////////////////////
  
  content.add(jPanel, BorderLayout.WEST);
 
  jFrame.setSize(500, 300);
 
  jFrame.setVisible(true);

}	//Das ist Ende vom main
 
   
}
