package de.jds;

import com.formdev.flatlaf.FlatDarculaLaf;
import de.jds.controller.HomeController;

import javax.swing.*;

public class Main {

	public static void main(String[] args) {
		FlatDarculaLaf.setup();
		SwingUtilities.invokeLater(HomeController::new);
	}
}
