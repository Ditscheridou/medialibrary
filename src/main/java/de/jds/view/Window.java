package de.jds.view;

import javax.swing.*;
import java.awt.*;

public class Window extends JFrame {

	private static Window instance = null;

	private Window () {
		super("Media Library");
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setSize(800, 600);
		setLocationRelativeTo(null);
		setVisible(true);
		setLayout(new BorderLayout());
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
		getContentPane().add(view, BorderLayout.CENTER);
		revalidate();
		repaint();
	}
}
