package Main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultEditorKit;
import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;
import javax.swing.text.html.HTMLEditorKit;

public class GUI_Exp extends JFrame {

	String path = "C:\\Users\\baghe\\Desktop";
	OpenPath speicher_unteropenpath = new OpenPath(path);

	private static final long serialVersionUID = 1L;
	private int mainx, mainy;
	private String Title;

	Container content = getContentPane();
	static JTextPane edPane = new JTextPane();

	// JTextPane edPane_design = new JTextPane();
	// JScrollPane sPne = new JScrollPane(edPane);

	public GUI_Exp(String Title, int mainx, int mainy) {

		this.mainx = mainx;
		this.mainy = mainy;
		this.Title = Title;

		// content.setLayout(null);
		content.add(edPane, BorderLayout.NORTH); // sPane durch edPane ersetzt
		edPane.setEditorKit(new HTMLEditorKit()); // Auf HTMLEditorKit stellen ist machbar, aber bei Default
													// speichert er es einfach wie in ein Texteditor
		edPane.setPreferredSize(new Dimension(500, 500)); // Das ist der Textfeld fuer's Schreiben
		// edPane.setBorder(new LineBorder(Color.black,1));

		setTitle(this.Title);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new FlowLayout());
		setSize(this.mainx, this.mainy);
		// setResizable(false);

		initComponent();

		setLocationRelativeTo(null);
		setVisible(true);
		setResizable(false);
		edPane.addKeyListener(new Key_event(edPane));
	}

	private void initComponent() {

		JMenuItem save_as, load, speichern, info, search;
		JMenuBar mb = new JMenuBar();

		JMenu menu = new JMenu("Menu");
		JMenu Hilfe = new JMenu("Hilfe");

		JMenu_look(menu, 50, 20); // (JMenu i, int width, int height)
		JMenu_look(Hilfe, 40, 20);

		save_as = new JMenuItem("Save as..");
		item_look(save_as, 140, 30);
		save_as.addActionListener(new ActionListener() {

			@Override // save
			public void actionPerformed(ActionEvent e) {
				main.Path_current = "";
				save_load save_load = new save_load();
				save_load.Path_option(edPane, true);
			}
		});

		load = new JMenuItem("Open..");
		item_look(load, 140, 30);
		load.addActionListener(new ActionListener() {

			@Override // load
			public void actionPerformed(ActionEvent e) {
				save_load save_load = new save_load();
				save_load.Path_option(edPane, false);
			}
		});

		speichern = new JMenuItem("Save..");
		item_look(speichern, 140, 30);
		speichern.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				try {
					save_load.save(edPane, main.Path_current);
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(GUI_Exp.this, "no file saved so far", "wait",
							JOptionPane.INFORMATION_MESSAGE);

				}
			}
		});

		info = new JMenuItem("Info");
		item_look(info, 120, 30);
		info.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Info_window info_window = new Info_window("Info", 400, 300);
			}
		});

		search = new JMenuItem("Search");
		item_look(search, 120, 30);
		search.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Search_words search_words = new Search_words("Search", 500, 250);
			}
		});

		menu.add(save_as);
		menu.add(load);
		menu.add(speichern);
		Hilfe.add(info);
		Hilfe.add(search);

		mb.add(menu);
		mb.add(Hilfe);

		setJMenuBar(mb);
	}

	private void item_look(JMenuItem i1, int width, int height) { // All unsere items haben die gleiche Eigenschaften
		i1.setPreferredSize(new Dimension(width, height)); // x,y die gr��e des Bereich wo unser Text ist
		i1.setFont(new Font("Aller", 0, 15)); // 15 ist die Gr��e
	}

	private void JMenu_look(JMenu i, int width, int height) {
		i.setPreferredSize(new Dimension(width, height)); // Achtung, nur Labelgr��e
		i.setFont(new Font("Aller", 0, 15)); // 3.Parameter ist unsere Gr��e
	}

}