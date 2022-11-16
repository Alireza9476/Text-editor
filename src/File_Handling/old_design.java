package File_Handling;

import java.io.File;
import java.io.FileWriter;

import javax.swing.JFileChooser;

public class old_design {

	public static void main(String args[]) {
		
		saveMap();
	}
	
	
	public static void saveMap() {
	    String sb = "TEST CONTENT";
	    JFileChooser chooser = new JFileChooser();
	    chooser.setCurrentDirectory(new File("/home/me/Documents"));
	    int retrival = chooser.showSaveDialog(null);
	    if (retrival == JFileChooser.APPROVE_OPTION) {
	        try {
	            FileWriter fw = new FileWriter(chooser.getSelectedFile()+".txt");
	            fw.write(sb.toString());
	        } catch (Exception ex) {
	            ex.printStackTrace();
	        }
	    }
	}


}
