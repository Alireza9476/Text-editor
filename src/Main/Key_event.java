package Main;

import java.awt.Desktop.Action;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JEditorPane;
import javax.swing.JOptionPane;

public class Key_event implements KeyListener { // tryied to extends GUI_Exp, than parameter GUI has to be given

	JEditorPane edPane;
	GUI_Exp Gui;

	public Key_event(JEditorPane edPane) {
		this.edPane = edPane;
	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (((e.getModifiers() & ActionEvent.CTRL_MASK) == ActionEvent.CTRL_MASK)
				&& (e.getKeyCode() == KeyEvent.VK_S)) { // ctrl + S (save)
			try {
				save_load.save(edPane, main.Path_current);
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(Gui, "no file saved so far", "wait", JOptionPane.INFORMATION_MESSAGE);
			}
		}

		else if (((e.getModifiers() & ActionEvent.CTRL_MASK) == ActionEvent.CTRL_MASK)
				&& (e.getKeyCode() == KeyEvent.VK_A)) { // ctrl + A (load)
			try {
				save_load.load(edPane, main.Path_current);
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(Gui, "can't load non existing File", "wait",
						JOptionPane.INFORMATION_MESSAGE); // Gui has a datatyp oc lass Gui_Exp
			}
		}

		else if (((e.getModifiers() & ActionEvent.CTRL_MASK) == ActionEvent.CTRL_MASK)
				&& (e.getKeyCode() == KeyEvent.VK_F)) {
			Search_words search_words = new Search_words("Search", 500, 250);
		}

		else if (((e.getModifiers() & ActionEvent.CTRL_MASK) == ActionEvent.CTRL_MASK)
				&& (e.getKeyCode() == KeyEvent.VK_D)) {
			edPane.setText("");
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {

	}

}
