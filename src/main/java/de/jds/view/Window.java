package de.jds.view;

import javax.swing.*;
import java.awt.*;

public class Window extends JFrame {

	private static Window instance = null;

	private Window () {
		super("Media Library");
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		getContentPane().setLayout(new GridBagLayout());
		setLocationRelativeTo(null);
		setVisible(true);

	}
	public static synchronized Window getInstance() {
		if (instance == null) {
			synchronized (Window.class) {
				if (instance == null) {
					instance = new Window();
				}
			}
		}
		return instance;
	}

	public void replaceView(AbstractView view) {
		getContentPane().removeAll();
		getContentPane().add(view, new GridBagConstraints());
		revalidate();
		repaint();
	}
}
