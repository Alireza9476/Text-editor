package Main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;

import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.html.HTMLDocument;
import javax.swing.text.html.HTMLEditorKit;

public class Info_window extends JFrame {

	private static final long serialVersionUID = 1L;

	Info_window(String Title, int width, int height) {
		setSize(width, height);
		Container bg = getContentPane();
		createJEditorPane(bg, bg.getSize());
		setVisible(true);
		setTitle(Title);
		setResizable(false);
		setLocationRelativeTo(null);
	}

	public void createJEditorPane(Container bg, Dimension size) {

		JTextPane pane = new JTextPane();
		Color gray = new Color(238, 226, 224);
		Color turquoise = new Color(82, 204, 215);

		pane.setBackground(gray);
		SimpleAttributeSet attributeSet = new SimpleAttributeSet();
		StyleConstants.setItalic(attributeSet, true);
		StyleConstants.setForeground(attributeSet, Color.blue);
		StyleConstants.setBackground(attributeSet, Color.white);
		pane.setCharacterAttributes(attributeSet, true);
		pane.setText("Updated the background color of the text pane.");
		// JScrollPane scrollPane = new JScrollPane(pane);

		pane.setEditable(false);
		// HTMLDocument htmlDoc = new HTMLDocument();
		HTMLEditorKit editorKit = new HTMLEditorKit();
		pane.setEditorKit(editorKit);
		pane.setSize(size);
		pane.setMinimumSize(size);
		pane.setMaximumSize(size);
		pane.setOpaque(true);
		// pane.setText("<b><font face=\"Arial\" size=\"5\" align=\"center\" >
		// Unfortunately when I display this string it is too long and doesn't wrap to
		// new line!</font></b>");
		pane.setText(
				"<br><dl><dd><font face=\"Arial\" size=\"3\" align=\"center\" > Title<br>Version 1 (Beta)<br><br>This software doesn't have any license stuff, so if you<br>wanna use the code for your purposes, do it<br><br>The Code is avaiable on GitHubY<br><br>STRG+A --- Load saved file<br>STRG+S --- Save saved file<br>STRG+D --- Clear content on textfield<br>STRG+F --- Search for words<p></font><dl>");
		bg.add(pane, BorderLayout.CENTER);

		pane.setSelectionColor(turquoise);
		bg.setBackground(Color.green);

	}
}