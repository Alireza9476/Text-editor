package Main;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;

public class main {

	public static String Path_current;

	public static void main(String[] args) {

		// Veraltetes UI
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
		}

		SwingUtilities.invokeLater(new Runnable() {

			public void run() {
				new main();
			}
		});

		GUI_Exp window = new GUI_Exp("NoteKit", 540, 585);
		// window.addKeyListener(new Key_event());
	}
}
