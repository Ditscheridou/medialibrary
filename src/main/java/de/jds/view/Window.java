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
		GridBagConstraints gridBagConstraints = new GridBagConstraints();
		gridBagConstraints.fill = GridBagConstraints.BOTH;
		gridBagConstraints.weightx = 1.0;
		gridBagConstraints.weighty = 1.0;
		gridBagConstraints.anchor = GridBagConstraints.FIRST_LINE_START;
		getContentPane().add(view, gridBagConstraints);
		revalidate();
		repaint();
	}
}
