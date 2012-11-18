package jacs;

import jacs.controller.MainController;
import jacs.controller.ServerController;
import jacs.gui.MainGUI;

public class Main {

	public static void main(String[] args) {
		MainGUI gui = new MainGUI();
		gui.run();
		ServerController svController = new ServerController(gui.getController());
 	}

}
