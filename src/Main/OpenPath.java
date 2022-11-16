package Main;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

public class OpenPath {

	private String PATH;

	OpenPath(String PATH) {
		this.PATH = PATH;
	}

	public void OpenPATH() {
		Desktop desktop = null;
		// on Windows, retrieve the path of the "Program Files" folder
		File PATH = new File(this.PATH); // System.getenv()

		try {
			if (Desktop.isDesktopSupported()) {
				desktop = Desktop.getDesktop();
				desktop.open(PATH);
			} else {
				System.out.println("desktop is not supported");
			}
		} catch (IOException e) {
		}
//		    Map<String, String> env = System.getenv();
//		    env.forEach((k, v) -> System.out.println(k + ":" + v));
	}
}
