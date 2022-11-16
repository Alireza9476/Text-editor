package Main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Highlighter;

public class Search_words extends JFrame{

	private static final long serialVersionUID = 1L;

	private JLabel label_suche;
	private static JTextField text_suche;
	private JButton button_search;
	private static String searchText;

	Container mainContainer = getContentPane();
	JPanel topPanel = new JPanel();

	Search_words(String Title, int width, int height) {
		super(Title);
		setSize(width, height);
		setVisible(true);

		setResizable(false);
		setLocationRelativeTo(null);
		setLayout(new FlowLayout());

		this.addWindowListener(new WindowAdapter() // Listener for closing the Frame
		{
			@Override
			public void windowClosing(WindowEvent e) {
				GUI_Exp.edPane.getHighlighter().removeAllHighlights();
				e.getWindow().dispose();
			}
		});

		initComponent();

		topPanel.add(label_suche);
		topPanel.add(text_suche);
		topPanel.add(button_search); // Wenn dies nicht zur panel hinzugef�gt w�re, h�tte es alle Bereiche der
										// restlichen Platz eingenommmen, da es ja nicht zu ein Panel geh�rt und somit
										// kein Layout
	}

	private void initComponent() {

		mainContainer.setLayout(new BorderLayout());
		//topPanel.setBorder(new LineBorder(Color.BLACK, 1));
		topPanel.setLayout(new FlowLayout(5));
		mainContainer.add(topPanel, BorderLayout.NORTH);

		label_suche = new JLabel("Suche nach: ");
		text_suche = new JTextField(25);
		button_search = new JButton("Search");
		
		button_search.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				initialise_search();
			}
		});
		
		text_suche.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				if ((e.getKeyCode() == KeyEvent.VK_ENTER)) {
					initialise_search();
				}
			}
		});
	}
	
	public void search_word(String searchText) {
		String Satz = "";
		int indexStart = 0;

		Highlighter.HighlightPainter bluePointer = new DefaultHighlighter.DefaultHighlightPainter(Color.cyan);

		try {
			//print out content without html content
			Satz = GUI_Exp.edPane.getDocument().getText(0, GUI_Exp.edPane.getDocument().getLength()).toLowerCase(); 
			indexStart = Satz.indexOf(searchText, 0);
			GUI_Exp.edPane.getHighlighter().removeAllHighlights();
		} catch (BadLocationException e) {
			e.printStackTrace();
		}
		
		if (searchText.isEmpty()) JOptionPane.showMessageDialog(Search_words.this, "Empty content", "ErrorMessage", JOptionPane.INFORMATION_MESSAGE);
		if (Satz.contains(searchText)) {
			try {
				GUI_Exp.edPane.getHighlighter().addHighlight(indexStart, indexStart + searchText.length(), bluePointer);
			} catch (BadLocationException e) {
				e.printStackTrace();
			}
		}
		else JOptionPane.showMessageDialog(Search_words.this, "[ " + searchText + " ]" + " not Found", "ErrorMessage", JOptionPane.INFORMATION_MESSAGE);
		//System.out.println(searchText.getClass().getName());
	}
	
	public void initialise_search() {
		searchText = text_suche.getText().trim().toLowerCase();
		search_word(searchText);
	}

}
