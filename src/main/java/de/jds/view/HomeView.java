package de.jds.view;

import javax.swing.*;
import java.awt.*;

public class HomeView extends AbstractView {

	@Override
	public void onCreate() {
		setLayout(new GridBagLayout());
		add(new JButton("Video!"));
		add(new JButton("Music!"));
	}

	@Override
	public void onStop() {

	}
}
